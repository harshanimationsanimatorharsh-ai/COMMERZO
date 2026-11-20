
package com.commerzo.app.data.repository.progress

import com.commerzo.app.data.model.progress.StudentProgress
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.TemporalAdjusters
import java.time.DayOfWeek
import java.time.format.DateTimeFormatter
import java.util.UUID

class StudentProgressRepository(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance(),
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
) {

    private val zoneId = ZoneId.of("Asia/Kolkata")
    private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE

    private fun progressRef(uid: String) =
        firestore.collection("student_progress").document(uid)

    private fun currentUid(): String =
        auth.currentUser?.uid
            ?: throw IllegalStateException("User is not logged in")

    private fun today(): LocalDate =
        LocalDate.now(zoneId)

    private fun currentSeasonId(): String {
        val monday = today().with(
            TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)
        )
        return monday.format(dateFormatter)
    }

    private fun snapshotToProgress(
        uid: String,
        data: Map<String, Any>?
    ): StudentProgress {
        val values = data ?: emptyMap()

        return StudentProgress(
            userId = uid,
            lifetimeXpUnits = (values["lifetimeXpUnits"] as? Number)?.toLong() ?: 0L,
            weeklyXpUnits = (values["weeklyXpUnits"] as? Number)?.toLong() ?: 0L,
            currentStreak = (values["currentStreak"] as? Number)?.toInt() ?: 0,
            longestStreak = (values["longestStreak"] as? Number)?.toInt() ?: 0,
            lastActiveDate = values["lastActiveDate"] as? String ?: "",
            seasonId = values["seasonId"] as? String ?: "",
            totalActiveSeconds = (values["totalActiveSeconds"] as? Number)?.toLong() ?: 0L,
            totalCorrectAnswers = (values["totalCorrectAnswers"] as? Number)?.toLong() ?: 0L,
            updatedAt = (values["updatedAt"] as? Number)?.toLong() ?: 0L
        )
    }

    suspend fun getMyProgress(): StudentProgress {
        val uid = currentUid()
        val snapshot = progressRef(uid).get().await()
        val progress = snapshotToProgress(uid, snapshot.data)

        return if (progress.seasonId == currentSeasonId()) {
            progress
        } else {
            progress.copy(
                weeklyXpUnits = 0L,
                seasonId = currentSeasonId()
            )
        }
    }

    /**
     * 1 correct answer = 2.5 XP.
     * XP is stored in half-point units to avoid rounding errors.
     */
    suspend fun awardCorrectAnswers(
        correctAnswers: Int,
        eventId: String = UUID.randomUUID().toString()
    ): StudentProgress {
        require(correctAnswers in 1..500) {
            "Correct answer count must be between 1 and 500"
        }

        return addActivity(
            eventId = eventId,
            xpUnits = correctAnswers.toLong() * 5L,
            correctAnswers = correctAnswers.toLong()
        )
    }

    /**
     * Active learning: 3 XP per completed minute.
     * Seconds accumulate across calls; incomplete minutes carry forward.
     */
    suspend fun recordActiveLearningSeconds(
        seconds: Int,
        eventId: String = UUID.randomUUID().toString()
    ): StudentProgress {
        require(seconds in 1..3600) {
            "Seconds must be between 1 and 3600"
        }

        return addActivity(
            eventId = eventId,
            activeSeconds = seconds.toLong()
        )
    }

    /**
     * Reserved for later games integration.
     * 1 game score point = 2 XP.
     * This method does not modify any game screen by itself.
     */
    suspend fun recordGameScore(
        score: Int,
        eventId: String = UUID.randomUUID().toString()
    ): StudentProgress {
        require(score in 1..100000) {
            "Game score must be between 1 and 100000"
        }

        return addActivity(
            eventId = eventId,
            xpUnits = score.toLong() * 4L
        )
    }

    private suspend fun addActivity(
        eventId: String,
        xpUnits: Long = 0L,
        correctAnswers: Long = 0L,
        activeSeconds: Long = 0L
    ): StudentProgress {
        require(eventId.isNotBlank() && eventId.length <= 128) {
            "Invalid event ID"
        }

        val uid = currentUid()
        val profile = progressRef(uid)
        val event = profile.collection("events").document(eventId)

        val now = System.currentTimeMillis()
        val todayDate = today()
        val todayString = todayDate.format(dateFormatter)
        val season = currentSeasonId()

        return firestore.runTransaction { transaction ->

            val eventSnapshot = transaction.get(event)
            val profileSnapshot = transaction.get(profile)

            val old = snapshotToProgress(uid, profileSnapshot.data)

            // Prevent duplicate XP from the same event.
            if (eventSnapshot.exists()) {
                return@runTransaction old.copy(
                    weeklyXpUnits = if (old.seasonId == season) {
                        old.weeklyXpUnits
                    } else {
                        0L
                    },
                    seasonId = season
                )
            }

            val previousSeconds = old.totalActiveSeconds
            val newTotalSeconds = previousSeconds + activeSeconds

            val oldCompletedMinutes = previousSeconds / 60L
            val newCompletedMinutes = newTotalSeconds / 60L
            val earnedTimeXpUnits =
                (newCompletedMinutes - oldCompletedMinutes) * 6L

            val totalEarnedUnits = xpUnits + earnedTimeXpUnits

            val sameSeason = old.seasonId == season
            val baseWeeklyXp = if (sameSeason) {
                old.weeklyXpUnits
            } else {
                0L
            }

            val previousDate = runCatching {
                LocalDate.parse(old.lastActiveDate, dateFormatter)
            }.getOrNull()

            val newStreak = when {
                previousDate == todayDate -> old.currentStreak
                previousDate == todayDate.minusDays(1) ->
                    old.currentStreak + 1
                else -> 1
            }

            val updated = old.copy(
                userId = uid,
                lifetimeXpUnits = old.lifetimeXpUnits + totalEarnedUnits,
                weeklyXpUnits = baseWeeklyXp + totalEarnedUnits,
                currentStreak = newStreak,
                longestStreak = maxOf(old.longestStreak, newStreak),
                lastActiveDate = todayString,
                seasonId = season,
                totalActiveSeconds = newTotalSeconds,
                totalCorrectAnswers = old.totalCorrectAnswers + correctAnswers,
                updatedAt = now
            )

            transaction.set(profile, mapOf(
                "userId" to updated.userId,
                "lifetimeXpUnits" to updated.lifetimeXpUnits,
                "weeklyXpUnits" to updated.weeklyXpUnits,
                "currentStreak" to updated.currentStreak,
                "longestStreak" to updated.longestStreak,
                "lastActiveDate" to updated.lastActiveDate,
                "seasonId" to updated.seasonId,
                "totalActiveSeconds" to updated.totalActiveSeconds,
                "totalCorrectAnswers" to updated.totalCorrectAnswers,
                "updatedAt" to updated.updatedAt
            ))

            transaction.set(event, mapOf(
                "eventId" to eventId,
                "xpUnits" to totalEarnedUnits,
                "correctAnswers" to correctAnswers,
                "activeSeconds" to activeSeconds,
                "createdAt" to now
            ))

            updated
        }.await()
    }
}
