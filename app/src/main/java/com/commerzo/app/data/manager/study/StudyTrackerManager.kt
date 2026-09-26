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

    fun getCurrentUser(): AuthUser? {
        return authRepository.getCurrentUser()
    }

    fun getCurrentUserId(): String? {
        return getCurrentUser()
            ?.userId
            ?.takeIf { it.isNotBlank() }
    }

    /**
     * Starts a new chapter-specific study session.
     *
     * New sessions require:
     * - authenticated user
     * - board
     * - class level
     * - subject
     * - chapter
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
                    "You must be signed in to start a study session."
                )
            )

        val cleanBoard = board.trim()
        val cleanClassLevel = classLevel.trim()
        val cleanSubjectId = subjectId.trim()
        val cleanChapterId = chapterId?.trim()

        if (cleanBoard.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Board information is required."
                )
            )
        }

        if (cleanClassLevel.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Class information is required."
                )
            )
        }

        if (cleanSubjectId.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Subject information is required."
                )
            )
        }

        if (cleanChapterId.isNullOrBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Chapter information is required."
                )
            )
        }

        val existingActiveSession =
            studyTrackerRepository.getActiveSession(userId)

        if (existingActiveSession != null) {
            return Result.failure(
                IllegalStateException(
                    "A study session is already active."
                )
            )
        }

        val now = System.currentTimeMillis()

        val session = StudySession(
            sessionId = UUID.randomUUID().toString(),
            userId = userId,
            board = cleanBoard,
            classLevel = cleanClassLevel,
            subjectId = cleanSubjectId,
            chapterId = cleanChapterId,
            startedAt = now,
            endedAt = null,
            durationSeconds = 0L,
            status = StudySession.STATUS_ACTIVE,
            createdAt = now,
            updatedAt = now
        )

        return studyTrackerRepository.startSession(
            session
        )
    }

    fun getActiveSession(): StudySession? {
        val userId = getCurrentUserId()
            ?: return null

        return studyTrackerRepository.getActiveSession(
            userId
        )
    }

    fun getSessions(): List<StudySession> {
        val userId = getCurrentUserId()
            ?: return emptyList()

        return studyTrackerRepository.getSessions(
            userId
        )
    }

    fun completeSession(
        sessionId: String,
        endedAt: Long = System.currentTimeMillis()
    ): Result<StudySession> {

        val userId = getCurrentUserId()
            ?: return Result.failure(
                IllegalStateException(
                    "You must be signed in to complete a study session."
                )
            )

        if (sessionId.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Session ID is required."
                )
            )
        }

        return studyTrackerRepository.completeSession(
            userId = userId,
            sessionId = sessionId,
            endedAt = endedAt
        )
    }

    fun completeActiveSession(
        endedAt: Long = System.currentTimeMillis()
    ): Result<StudySession?> {

        val userId = getCurrentUserId()
            ?: return Result.failure(
                IllegalStateException(
                    "You must be signed in to complete a study session."
                )
            )

        val activeSession =
            studyTrackerRepository.getActiveSession(userId)
                ?: return Result.success(null)

        return studyTrackerRepository.completeSession(
            userId = userId,
            sessionId = activeSession.sessionId,
            endedAt = endedAt
        )
    }

    fun getSessionsBetween(
        startInclusive: Long,
        endExclusive: Long
    ): List<StudySession> {

        if (startInclusive >= endExclusive) {
            return emptyList()
        }

        return getSessions()
            .filter { session ->
                session.startedAt >= startInclusive &&
                    session.startedAt < endExclusive
            }
    }

    fun getRecentCompletedSessions(
        limit: Int = 10
    ): List<StudySession> {

        if (limit <= 0) {
            return emptyList()
        }

        return getSessions()
            .asSequence()
            .filter {
                it.status == StudySession.STATUS_COMPLETED
            }
            .sortedByDescending {
                it.startedAt
            }
            .take(limit)
            .toList()
    }

    fun getTotalStudySeconds(): Long {
        return getSessions()
            .asSequence()
            .filter {
                it.status == StudySession.STATUS_COMPLETED
            }
            .sumOf {
                it.durationSeconds.coerceAtLeast(0L)
            }
    }

    fun getSubjectStudySeconds(
        subjectId: String
    ): Long {

        val cleanSubjectId = subjectId.trim()

        if (cleanSubjectId.isBlank()) {
            return 0L
        }

        return getSessions()
            .asSequence()
            .filter {
                it.status == StudySession.STATUS_COMPLETED &&
                    it.subjectId == cleanSubjectId
            }
            .sumOf {
                it.durationSeconds.coerceAtLeast(0L)
            }
    }

    fun getStudySecondsBetween(
        startInclusive: Long,
        endExclusive: Long
    ): Long {

        if (startInclusive >= endExclusive) {
            return 0L
        }

        return getSessionsBetween(
            startInclusive = startInclusive,
            endExclusive = endExclusive
        )
            .asSequence()
            .filter {
                it.status == StudySession.STATUS_COMPLETED
            }
            .sumOf {
                it.durationSeconds.coerceAtLeast(0L)
            }
    }

    fun updateSession(
        session: StudySession
    ): Result<StudySession> {

        val userId = getCurrentUserId()
            ?: return Result.failure(
                IllegalStateException(
                    "You must be signed in to update a study session."
                )
            )

        if (session.sessionId.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Session ID is required."
                )
            )
        }

        if (session.userId != userId) {
            return Result.failure(
                SecurityException(
                    "Study session does not belong to the current user."
                )
            )
        }

        return studyTrackerRepository.updateSession(
            session
        )
    }

    fun clearCurrentUserData(): Result<Unit> {

        val userId = getCurrentUserId()
            ?: return Result.failure(
                IllegalStateException(
                    "You must be signed in to clear study tracker data."
                )
            )

        return studyTrackerRepository.clearUserData(
            userId
        )
    }
}
