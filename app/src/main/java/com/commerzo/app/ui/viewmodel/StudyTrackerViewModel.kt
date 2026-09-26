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
     * Starts a real study session.
     */
    fun startSession(
        board: String,
        classLevel: String,
        subjectId: String,
        chapterId: String? = null
    ) {
        viewModelScope.launch {
            val result = manager.startSession(
                board = board,
                classLevel = classLevel,
                subjectId = subjectId,
                chapterId = chapterId
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
     * completed study session on that calendar day.
     */
    private fun calculateStreaks(
        sessions: List<StudySession>
    ): Pair<Int, Int> {

        if (sessions.isEmpty()) {
            return 0 to 0
        }

        val calendar = Calendar.getInstance()

        val qualifyingDays = sessions
            .filter {
                it.status == StudySession.STATUS_COMPLETED &&
                    it.startedAt > 0L &&
                    it.durationSeconds > 0L
            }
            .map {
                calendar.apply {
                    timeInMillis = it.startedAt
                }

                dayKey(
                    calendar.get(
                        Calendar.YEAR
                    ),
                    calendar.get(
                        Calendar.DAY_OF_YEAR
                    )
                )
            }
            .toSet()

        if (qualifyingDays.isEmpty()) {
            return 0 to 0
        }

        val sortedDays = qualifyingDays
            .sortedDescending()

        val todayCalendar = Calendar.getInstance()

        val todayKey = dayKey(
            todayCalendar.get(Calendar.YEAR),
            todayCalendar.get(Calendar.DAY_OF_YEAR)
        )

        val yesterdayCalendar =
            Calendar.getInstance().apply {
                add(
                    Calendar.DAY_OF_YEAR,
                    -1
                )
            }

        val yesterdayKey = dayKey(
            yesterdayCalendar.get(Calendar.YEAR),
            yesterdayCalendar.get(Calendar.DAY_OF_YEAR)
        )

        var currentStreak = 0

        var cursor = when {
            todayKey in qualifyingDays -> todayCalendar
            yesterdayKey in qualifyingDays -> yesterdayCalendar
            else -> null
        }

        while (cursor != null) {
            val key = dayKey(
                cursor.get(Calendar.YEAR),
                cursor.get(Calendar.DAY_OF_YEAR)
            )

            if (key !in qualifyingDays) {
                break
            }

            currentStreak++

            cursor = cursor.clone() as Calendar
            cursor.add(
                Calendar.DAY_OF_YEAR,
                -1
            )
        }

        var longestStreak = 1
        var runningStreak = 1

        for (index in 1 until sortedDays.size) {
            val previous = dayKeyToCalendar(
                sortedDays[index - 1]
            )

            val current = dayKeyToCalendar(
                sortedDays[index]
            )

            val difference =
                dayDifference(
                    current,
                    previous
                )

            if (difference == 1) {
                runningStreak++
                longestStreak =
                    maxOf(
                        longestStreak,
                        runningStreak
                    )
            } else {
                runningStreak = 1
            }
        }

        return currentStreak to longestStreak
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

    private fun dayDifference(
        first: Calendar,
        second: Calendar
    ): Int {
        val firstDay = first.timeInMillis
        val secondDay = second.timeInMillis

        val difference =
            firstDay - secondDay

        return (
            difference /
                (24L * 60L * 60L * 1000L)
            ).toInt()
    }
}
