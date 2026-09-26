package com.commerzo.app.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.commerzo.app.data.manager.study.StudyTrackerManager
import com.commerzo.app.data.model.study.StudySession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar

data class StudyTrackerUiState(
    val isLoading: Boolean = true,
    val isSignedIn: Boolean = false,
    val activeSession: StudySession? = null,
    val totalStudySeconds: Long = 0L,
    val todayStudySeconds: Long = 0L,
    val weekStudySeconds: Long = 0L,
    val monthStudySeconds: Long = 0L,
    val todaySessionCount: Int = 0,
    val weekSessionCount: Int = 0,
    val currentStreak: Int = 0,
    val longestStreak: Int = 0,
    val recentSessions: List<StudySession> = emptyList(),
    val errorMessage: String? = null
)

class StudyTrackerViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val manager = StudyTrackerManager(
        application.applicationContext
    )

    private val _uiState = MutableStateFlow(
        StudyTrackerUiState()
    )

    val uiState: StateFlow<StudyTrackerUiState> =
        _uiState.asStateFlow()

    init {
        refresh()
    }

    /**
     * Starts a real chapter-specific study session.
     *
     * New sessions require all curriculum context values.
     * In particular, chapterId must never be blank.
     */
    fun startSession(
        board: String,
        classLevel: String,
        subjectId: String,
        chapterId: String? = null
    ) {
        val cleanBoard = board.trim()
        val cleanClassLevel = classLevel.trim()
        val cleanSubjectId = subjectId.trim()
        val cleanChapterId = chapterId?.trim()

        if (cleanBoard.isBlank()) {
            updateError("Board information is required to start a study session.")
            return
        }

        if (cleanClassLevel.isBlank()) {
            updateError("Class information is required to start a study session.")
            return
        }

        if (cleanSubjectId.isBlank()) {
            updateError("Subject information is required to start a study session.")
            return
        }

        if (cleanChapterId.isNullOrBlank()) {
            updateError("Chapter information is required to start a study session.")
            return
        }

        viewModelScope.launch {
            val result = manager.startSession(
                board = cleanBoard,
                classLevel = cleanClassLevel,
                subjectId = cleanSubjectId,
                chapterId = cleanChapterId
            )

            result
                .onSuccess {
                    refresh()
                }
                .onFailure { error ->
                    updateError(
                        error.message
                            ?: "Unable to start study session."
                    )
                }
        }
    }

    /**
     * Stops the currently active study session.
     */
    fun stopActiveSession() {
        viewModelScope.launch {
            val result = manager.completeActiveSession()

            result
                .onSuccess {
                    refresh()
                }
                .onFailure { error ->
                    updateError(
                        error.message
                            ?: "Unable to complete study session."
                    )
                }
        }
    }

    /**
     * Refreshes all tracker information from local storage.
     */
    fun refresh() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                isLoading = true,
                errorMessage = null
            )

            val user = manager.getCurrentUser()

            if (user == null) {
                _uiState.value = StudyTrackerUiState(
                    isLoading = false,
                    isSignedIn = false
                )
                return@launch
            }

            val sessions = manager.getSessions()

            val now = System.currentTimeMillis()

            val todayStart = startOfToday(now)
            val tomorrowStart = startOfNextDay(todayStart)

            val weekStart = startOfWeek(now)
            val nextWeekStart = addDays(
                weekStart,
                7
            )

            val monthStart = startOfMonth(now)
            val nextMonthStart = startOfNextMonth(monthStart)

            val todaySessions = sessions.filter {
                it.status == StudySession.STATUS_COMPLETED &&
                    it.startedAt >= todayStart &&
                    it.startedAt < tomorrowStart
            }

            val weekSessions = sessions.filter {
                it.status == StudySession.STATUS_COMPLETED &&
                    it.startedAt >= weekStart &&
                    it.startedAt < nextWeekStart
            }

            val monthSessions = sessions.filter {
                it.status == StudySession.STATUS_COMPLETED &&
                    it.startedAt >= monthStart &&
                    it.startedAt < nextMonthStart
            }

            val completedSessions = sessions.filter {
                it.status == StudySession.STATUS_COMPLETED
            }

            val totalSeconds = completedSessions.sumOf {
                it.durationSeconds.coerceAtLeast(0L)
            }

            val todaySeconds = todaySessions.sumOf {
                it.durationSeconds.coerceAtLeast(0L)
            }

            val weekSeconds = weekSessions.sumOf {
                it.durationSeconds.coerceAtLeast(0L)
            }

            val monthSeconds = monthSessions.sumOf {
                it.durationSeconds.coerceAtLeast(0L)
            }

            val streaks = calculateStreaks(
                completedSessions
            )

            _uiState.value = StudyTrackerUiState(
                isLoading = false,
                isSignedIn = true,
                activeSession = manager.getActiveSession(),
                totalStudySeconds = totalSeconds,
                todayStudySeconds = todaySeconds,
                weekStudySeconds = weekSeconds,
                monthStudySeconds = monthSeconds,
                todaySessionCount = todaySessions.size,
                weekSessionCount = weekSessions.size,
                currentStreak = streaks.first,
                longestStreak = streaks.second,
                recentSessions = completedSessions
                    .sortedByDescending { it.startedAt }
                    .take(10)
            )
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(
            errorMessage = null
        )
    }

    private fun updateError(message: String) {
        _uiState.value = _uiState.value.copy(
            isLoading = false,
            errorMessage = message
        )
    }

    /**
     * Calculates current and longest qualifying-day streak.
     *
     * A day qualifies when the user has at least one
     * completed study session on that calendar day
     * with a duration greater than zero.
     */
    private fun calculateStreaks(
        sessions: List<StudySession>
    ): Pair<Int, Int> {

        if (sessions.isEmpty()) {
            return 0 to 0
        }

        val qualifyingDays = sessions
            .asSequence()
            .filter {
                it.status == StudySession.STATUS_COMPLETED &&
                    it.startedAt > 0L &&
                    it.durationSeconds > 0L
            }
            .map {
                calendarDayKey(it.startedAt)
            }
            .toSet()

        if (qualifyingDays.isEmpty()) {
            return 0 to 0
        }

        val today = Calendar.getInstance()

        val todayKey = calendarDayKey(
            today.timeInMillis
        )

        val yesterday = today.clone() as Calendar
        yesterday.add(
            Calendar.DAY_OF_YEAR,
            -1
        )

        val yesterdayKey = calendarDayKey(
            yesterday.timeInMillis
        )

        var currentStreak = 0

        var cursor: Calendar? = when {
            todayKey in qualifyingDays -> today
            yesterdayKey in qualifyingDays -> yesterday
            else -> null
        }

        while (cursor != null) {
            val key = calendarDayKey(
                cursor.timeInMillis
            )

            if (key !in qualifyingDays) {
                break
            }

            currentStreak++

            cursor = (
                cursor.clone() as Calendar
            ).apply {
                add(
                    Calendar.DAY_OF_YEAR,
                    -1
                )
            }
        }

        /**
         * Longest streak:
         *
         * Sort unique calendar days chronologically.
         * Consecutive dates differ by exactly one calendar day.
         *
         * This intentionally uses Calendar date fields instead
         * of raw 24-hour milliseconds so daylight-saving changes
         * cannot create an incorrect streak gap.
         */
        val sortedDayCalendars = qualifyingDays
            .map { key ->
                dayKeyToCalendar(key)
            }
            .sortedBy {
                calendarDayNumber(it)
            }

        var longestStreak = 1
        var runningStreak = 1

        for (index in 1 until sortedDayCalendars.size) {
            val previous = sortedDayCalendars[index - 1]
            val current = sortedDayCalendars[index]

            val expectedNextDay =
                previous.clone() as Calendar

            expectedNextDay.add(
                Calendar.DAY_OF_YEAR,
                1
            )

            if (sameCalendarDate(
                    expectedNextDay,
                    current
                )
            ) {
                runningStreak++

                longestStreak = maxOf(
                    longestStreak,
                    runningStreak
                )
            } else {
                runningStreak = 1
            }
        }

        return currentStreak to longestStreak
    }

    private fun calendarDayKey(
        timestamp: Long
    ): String {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = timestamp
        }

        return dayKey(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.DAY_OF_YEAR)
        )
    }

    private fun startOfToday(
        timestamp: Long
    ): Long {
        return Calendar.getInstance().apply {
            timeInMillis = timestamp
            set(
                Calendar.HOUR_OF_DAY,
                0
            )
            set(
                Calendar.MINUTE,
                0
            )
            set(
                Calendar.SECOND,
                0
            )
            set(
                Calendar.MILLISECOND,
                0
            )
        }.timeInMillis
    }

    private fun startOfNextDay(
        todayStart: Long
    ): Long {
        return Calendar.getInstance().apply {
            timeInMillis = todayStart
            add(
                Calendar.DAY_OF_YEAR,
                1
            )
        }.timeInMillis
    }

    /**
     * Monday is treated as the first day of the week.
     */
    private fun startOfWeek(
        timestamp: Long
    ): Long {
        return Calendar.getInstance().apply {
            timeInMillis = timestamp
            firstDayOfWeek = Calendar.MONDAY

            set(
                Calendar.HOUR_OF_DAY,
                0
            )
            set(
                Calendar.MINUTE,
                0
            )
            set(
                Calendar.SECOND,
                0
            )
            set(
                Calendar.MILLISECOND,
                0
            )

            val dayOfWeek = get(
                Calendar.DAY_OF_WEEK
            )

            val daysFromMonday =
                when (dayOfWeek) {
                    Calendar.SUNDAY -> 6
                    else -> dayOfWeek -
                        Calendar.MONDAY
                }

            add(
                Calendar.DAY_OF_YEAR,
                -daysFromMonday
            )
        }.timeInMillis
    }

    private fun startOfMonth(
        timestamp: Long
    ): Long {
        return Calendar.getInstance().apply {
            timeInMillis = timestamp

            set(
                Calendar.DAY_OF_MONTH,
                1
            )
            set(
                Calendar.HOUR_OF_DAY,
                0
            )
            set(
                Calendar.MINUTE,
                0
            )
            set(
                Calendar.SECOND,
                0
            )
            set(
                Calendar.MILLISECOND,
                0
            )
        }.timeInMillis
    }

    private fun startOfNextMonth(
        monthStart: Long
    ): Long {
        return Calendar.getInstance().apply {
            timeInMillis = monthStart
            add(
                Calendar.MONTH,
                1
            )
        }.timeInMillis
    }

    private fun addDays(
        timestamp: Long,
        days: Int
    ): Long {
        return Calendar.getInstance().apply {
            timeInMillis = timestamp
            add(
                Calendar.DAY_OF_YEAR,
                days
            )
        }.timeInMillis
    }

    private fun dayKey(
        year: Int,
        dayOfYear: Int
    ): String {
        return "$year-$dayOfYear"
    }

    private fun dayKeyToCalendar(
        key: String
    ): Calendar {
        val parts = key.split("-")

        require(parts.size == 2) {
            "Invalid study tracker day key: $key"
        }

        return Calendar.getInstance().apply {
            clear()

            set(
                Calendar.YEAR,
                parts[0].toInt()
            )

            set(
                Calendar.DAY_OF_YEAR,
                parts[1].toInt()
            )
        }
    }

    private fun calendarDayNumber(
        calendar: Calendar
    ): Long {
        return calendar.get(
            Calendar.YEAR
        ).toLong() * 1000L +
            calendar.get(
                Calendar.DAY_OF_YEAR
            ).toLong()
    }

    private fun sameCalendarDate(
        first: Calendar,
        second: Calendar
    ): Boolean {
        return first.get(Calendar.YEAR) ==
            second.get(Calendar.YEAR) &&
            first.get(Calendar.DAY_OF_YEAR) ==
            second.get(Calendar.DAY_OF_YEAR)
    }
}
