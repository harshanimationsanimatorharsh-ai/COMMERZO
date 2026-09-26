package com.commerzo.app.data.repository.study

import android.content.Context
import com.commerzo.app.data.model.study.StudySession
import org.json.JSONArray
import org.json.JSONObject

class StudyTrackerRepository(
    context: Context
) {

    private val appContext = context.applicationContext

    companion object {
        private const val PREF_PREFIX = "commerzo_study_tracker_"
        private const val SESSIONS_KEY = "study_sessions"
    }

    /**
     * Returns all study sessions belonging only to the supplied Firebase UID.
     */
    fun getSessions(userId: String): List<StudySession> {
        if (userId.isBlank()) return emptyList()

        return try {
            val preferences = getUserPreferences(userId)
            val json = preferences.getString(SESSIONS_KEY, null)
                ?: return emptyList()

            jsonToSessions(json)
                .sortedByDescending { it.startedAt }
        } catch (_: Exception) {
            emptyList()
        }
    }

    /**
     * Returns the currently active session for this user, if one exists.
     */
    fun getActiveSession(userId: String): StudySession? {
        if (userId.isBlank()) return null

        return getSessions(userId)
            .firstOrNull { it.status == StudySession.STATUS_ACTIVE }
    }

    /**
     * Creates a new active study session.
     *
     * Only one active session is allowed per user.
     */
    fun startSession(session: StudySession): Result<StudySession> {
        return try {
            validateSessionUser(session)

            if (session.status != StudySession.STATUS_ACTIVE) {
                return Result.failure(
                    IllegalArgumentException("A new study session must have ACTIVE status.")
                )
            }

            val existingActiveSession = getActiveSession(session.userId)

            if (existingActiveSession != null) {
                return Result.failure(
                    IllegalStateException("An active study session already exists.")
                )
            }

            val now = System.currentTimeMillis()

            val activeSession = session.copy(
                startedAt = if (session.startedAt > 0L) session.startedAt else now,
                endedAt = null,
                durationSeconds = 0L,
                status = StudySession.STATUS_ACTIVE,
                createdAt = if (session.createdAt > 0L) session.createdAt else now,
                updatedAt = now
            )

            val sessions = getSessions(session.userId).toMutableList()
            sessions.add(activeSession)

            saveSessions(session.userId, sessions)

            Result.success(activeSession)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /**
     * Updates an existing study session belonging to the same user.
     */
    fun updateSession(session: StudySession): Result<StudySession> {
        return try {
            validateSessionUser(session)

            val sessions = getSessions(session.userId).toMutableList()
            val index = sessions.indexOfFirst {
                it.sessionId == session.sessionId
            }

            if (index == -1) {
                return Result.failure(
                    IllegalArgumentException("Study session not found.")
                )
            }

            val updatedSession = session.copy(
                updatedAt = System.currentTimeMillis()
            )

            sessions[index] = updatedSession
            saveSessions(session.userId, sessions)

            Result.success(updatedSession)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /**
     * Completes an active study session.
     *
     * Duration is calculated from persisted timestamps.
     */
    fun completeSession(
        userId: String,
        sessionId: String,
        endedAt: Long = System.currentTimeMillis()
    ): Result<StudySession> {
        return try {
            if (userId.isBlank()) {
                return Result.failure(
                    IllegalArgumentException("User ID cannot be empty.")
                )
            }

            val sessions = getSessions(userId).toMutableList()

            val index = sessions.indexOfFirst {
                it.sessionId == sessionId
            }

            if (index == -1) {
                return Result.failure(
                    IllegalArgumentException("Study session not found.")
                )
            }

            val existingSession = sessions[index]

            if (existingSession.userId != userId) {
                return Result.failure(
                    SecurityException("Study session does not belong to this user.")
                )
            }

            if (existingSession.status == StudySession.STATUS_COMPLETED) {
                return Result.success(existingSession)
            }

            if (existingSession.startedAt <= 0L) {
                return Result.failure(
                    IllegalStateException("Study session has an invalid start time.")
                )
            }

            val safeEndedAt = maxOf(
                endedAt,
                existingSession.startedAt
            )

            val durationSeconds =
                (safeEndedAt - existingSession.startedAt) / 1000L

            val completedSession = existingSession.copy(
                endedAt = safeEndedAt,
                durationSeconds = durationSeconds.coerceAtLeast(0L),
                status = StudySession.STATUS_COMPLETED,
                updatedAt = System.currentTimeMillis()
            )

            sessions[index] = completedSession
            saveSessions(userId, sessions)

            Result.success(completedSession)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /**
     * Deletes all locally stored study sessions for this user.
     *
     * This is intentionally scoped to the supplied Firebase UID.
     */
    fun clearUserData(userId: String): Result<Unit> {
        return try {
            if (userId.isBlank()) {
                return Result.failure(
                    IllegalArgumentException("User ID cannot be empty.")
                )
            }

            getUserPreferences(userId)
                .edit()
                .remove(SESSIONS_KEY)
                .apply()

            Result.success(Unit)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    private fun saveSessions(
        userId: String,
        sessions: List<StudySession>
    ) {
        val json = sessionsToJson(sessions)

        getUserPreferences(userId)
            .edit()
            .putString(SESSIONS_KEY, json)
            .apply()
    }

    private fun getUserPreferences(userId: String) =
        appContext.getSharedPreferences(
            buildPreferenceName(userId),
            Context.MODE_PRIVATE
        )

    /**
     * Firebase UIDs normally contain safe characters.
     * Sanitizing additionally prevents accidental invalid preference names.
     */
    private fun buildPreferenceName(userId: String): String {
        val safeUserId = userId.filter {
            it.isLetterOrDigit() || it == '_' || it == '-'
        }

        if (safeUserId.isBlank()) {
            throw IllegalArgumentException("Invalid user ID.")
        }

        return PREF_PREFIX + safeUserId
    }

    private fun validateSessionUser(session: StudySession) {
        if (session.userId.isBlank()) {
            throw IllegalArgumentException(
                "Study session must contain a Firebase user ID."
            )
        }

        if (session.sessionId.isBlank()) {
            throw IllegalArgumentException(
                "Study session must contain a session ID."
            )
        }

        if (session.subjectId.isBlank()) {
            throw IllegalArgumentException(
                "Study session must contain a subject ID."
            )
        }
    }

    private fun sessionsToJson(
        sessions: List<StudySession>
    ): String {
        val array = JSONArray()

        sessions.forEach { session ->
            array.put(
                JSONObject().apply {
                    put("sessionId", session.sessionId)
                    put("userId", session.userId)
                    put("board", session.board)
                    put("classLevel", session.classLevel)
                    put("subjectId", session.subjectId)
                    put(
                        "chapterId",
                        session.chapterId ?: JSONObject.NULL
                    )
                    put("startedAt", session.startedAt)
                    put(
                        "endedAt",
                        session.endedAt ?: JSONObject.NULL
                    )
                    put("durationSeconds", session.durationSeconds)
                    put("status", session.status)
                    put("createdAt", session.createdAt)
                    put("updatedAt", session.updatedAt)
                }
            )
        }

        return array.toString()
    }

    private fun jsonToSessions(
        json: String
    ): List<StudySession> {
        val array = JSONArray(json)
        val sessions = mutableListOf<StudySession>()

        for (index in 0 until array.length()) {
            val item = array.optJSONObject(index)
                ?: continue

            sessions.add(
                StudySession(
                    sessionId = item.optString("sessionId"),
                    userId = item.optString("userId"),
                    board = item.optString("board"),
                    classLevel = item.optString("classLevel"),
                    subjectId = item.optString("subjectId"),
                    chapterId = item.optStringOrNull("chapterId"),
                    startedAt = item.optLong("startedAt", 0L),
                    endedAt = item.optLongOrNull("endedAt"),
                    durationSeconds = item.optLong(
                        "durationSeconds",
                        0L
                    ),
                    status = item.optString(
                        "status",
                        StudySession.STATUS_COMPLETED
                    ),
                    createdAt = item.optLong(
                        "createdAt",
                        0L
                    ),
                    updatedAt = item.optLong(
                        "updatedAt",
                        0L
                    )
                )
            )
        }

        return sessions
    }

    private fun JSONObject.optStringOrNull(
        key: String
    ): String? {
        if (!has(key) || isNull(key)) return null

        return optString(key)
            .takeIf { it.isNotBlank() }
    }

    private fun JSONObject.optLongOrNull(
        key: String
    ): Long? {
        if (!has(key) || isNull(key)) return null

        return optLong(key)
    }
}
