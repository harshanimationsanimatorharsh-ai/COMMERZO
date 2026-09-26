package com.commerzo.app.data.manager.study

import android.content.Context
import com.commerzo.app.data.model.auth.AuthUser
import com.commerzo.app.data.model.study.StudySession
import com.commerzo.app.data.repository.auth.AuthRepositoryProvider
import com.commerzo.app.data.repository.study.StudyTrackerRepository
import java.util.UUID

class StudyTrackerManager(
    context: Context
) {

    private val appContext = context.applicationContext

    private val authRepository =
        AuthRepositoryProvider.getRepository(appContext)

    private val studyTrackerRepository =
        StudyTrackerRepository(appContext)

    /**
     * Returns the currently authenticated Firebase user.
     */
    fun getCurrentUser(): AuthUser? {
        return authRepository.getCurrentUser()
    }

    /**
     * Returns the Firebase UID of the currently authenticated user.
     */
    fun getCurrentUserId(): String? {
        return getCurrentUser()?.userId
            ?.takeIf { it.isNotBlank() }
    }

    /**
     * Starts a new study session for the authenticated user.
     *
     * The session remains ACTIVE until explicitly completed.
     */
    fun startSession(
        board: String,
        classLevel: String,
        subjectId: String,
        chapterId: String? = null
    ): Result<StudySession> {

        val userId = getCurrentUserId()
            ?: return Result.failure(
                IllegalStateException(
                    "No signed-in user found."
                )
            )

        if (board.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Board cannot be empty."
                )
            )
        }

        if (classLevel.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Class level cannot be empty."
                )
            )
        }

        if (subjectId.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Subject ID cannot be empty."
                )
            )
        }

        val now = System.currentTimeMillis()

        val session = StudySession(
            sessionId = UUID.randomUUID().toString(),
            userId = userId,
            board = board.trim(),
            classLevel = classLevel.trim(),
            subjectId = subjectId.trim(),
            chapterId = chapterId
                ?.trim()
                ?.takeIf { it.isNotBlank() },
            startedAt = now,
            endedAt = null,
            durationSeconds = 0L,
            status = StudySession.STATUS_ACTIVE,
            createdAt = now,
            updatedAt = now
        )

        return studyTrackerRepository.startSession(session)
    }

    /**
     * Returns the current active session for the authenticated user.
     */
    fun getActiveSession(): StudySession? {
        val userId = getCurrentUserId()
            ?: return null

        return studyTrackerRepository.getActiveSession(userId)
    }

    /**
     * Returns all saved sessions for the authenticated user.
     */
    fun getSessions(): List<StudySession> {
        val userId = getCurrentUserId()
            ?: return emptyList()

        return studyTrackerRepository.getSessions(userId)
    }

    /**
     * Completes the supplied active session.
     */
    fun completeSession(
        sessionId: String,
        endedAt: Long = System.currentTimeMillis()
    ): Result<StudySession> {

        val userId = getCurrentUserId()
            ?: return Result.failure(
                IllegalStateException(
                    "No signed-in user found."
                )
            )

        if (sessionId.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Session ID cannot be empty."
                )
            )
        }

        return studyTrackerRepository.completeSession(
            userId = userId,
            sessionId = sessionId,
            endedAt = endedAt
        )
    }

    /**
     * Completes the currently active session.
     *
     * Returns null when no active session exists.
     */
    fun completeActiveSession(
        endedAt: Long = System.currentTimeMillis()
    ): Result<StudySession?> {

        val activeSession = getActiveSession()
            ?: return Result.success(null)

        return completeSession(
            sessionId = activeSession.sessionId,
            endedAt = endedAt
        ).map { completedSession ->
            completedSession
        }
    }

    /**
     * Returns sessions that started within the supplied timestamp range.
     *
     * startInclusive <= startedAt < endExclusive
     */
    fun getSessionsBetween(
        startInclusive: Long,
        endExclusive: Long
    ): List<StudySession> {

        if (startInclusive >= endExclusive) {
            return emptyList()
        }

        return getSessions().filter { session ->
            session.startedAt >= startInclusive &&
                session.startedAt < endExclusive
        }
    }

    /**
     * Returns recently completed sessions.
     */
    fun getRecentCompletedSessions(
        limit: Int = 10
    ): List<StudySession> {

        if (limit <= 0) return emptyList()

        return getSessions()
            .filter {
                it.status == StudySession.STATUS_COMPLETED
            }
            .sortedByDescending {
                it.startedAt
            }
            .take(limit)
    }

    /**
     * Returns total completed study duration in seconds.
     */
    fun getTotalStudySeconds(): Long {
        return getSessions()
            .filter {
                it.status == StudySession.STATUS_COMPLETED
            }
            .sumOf {
                it.durationSeconds.coerceAtLeast(0L)
            }
    }

    /**
     * Returns total completed study duration for
     * sessions belonging to a specific subject.
     */
    fun getSubjectStudySeconds(
        subjectId: String
    ): Long {

        if (subjectId.isBlank()) return 0L

        return getSessions()
            .filter {
                it.status == StudySession.STATUS_COMPLETED &&
                    it.subjectId == subjectId
            }
            .sumOf {
                it.durationSeconds.coerceAtLeast(0L)
            }
    }

    /**
     * Returns completed study duration for a timestamp range.
     */
    fun getStudySecondsBetween(
        startInclusive: Long,
        endExclusive: Long
    ): Long {

        return getSessionsBetween(
            startInclusive = startInclusive,
            endExclusive = endExclusive
        )
            .filter {
                it.status == StudySession.STATUS_COMPLETED
            }
            .sumOf {
                it.durationSeconds.coerceAtLeast(0L)
            }
    }

    /**
     * Updates an existing session.
     *
     * User ID is always taken from the authenticated account.
     */
    fun updateSession(
        session: StudySession
    ): Result<StudySession> {

        val userId = getCurrentUserId()
            ?: return Result.failure(
                IllegalStateException(
                    "No signed-in user found."
                )
            )

        if (session.userId != userId) {
            return Result.failure(
                SecurityException(
                    "Study session does not belong to the signed-in user."
                )
            )
        }

        return studyTrackerRepository.updateSession(
            session
        )
    }

    /**
     * Clears locally stored tracker data for the
     * currently authenticated user only.
     */
    fun clearCurrentUserData(): Result<Unit> {

        val userId = getCurrentUserId()
            ?: return Result.failure(
                IllegalStateException(
                    "No signed-in user found."
                )
            )

        return studyTrackerRepository.clearUserData(
            userId
        )
    }
}
