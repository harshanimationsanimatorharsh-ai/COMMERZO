package com.commerzo.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.study.StudySession
import com.commerzo.app.ui.viewmodel.StudyTrackerUiState
import com.commerzo.app.ui.viewmodel.StudyTrackerViewModel
import kotlinx.coroutines.delay
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudyTrackerScreen(
    onBack: () -> Unit,
    subjectId: String? = null,
    chapterId: String? = null,
    board: String? = null,
    classLevel: String? = null,
    viewModel: StudyTrackerViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val hasStudyContext =
        !subjectId.isNullOrBlank() &&
            !chapterId.isNullOrBlank() &&
            !board.isNullOrBlank() &&
            !classLevel.isNullOrBlank()

    LaunchedEffect(Unit) {
        viewModel.refresh()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        if (hasStudyContext) {
                            "Start Study"
                        } else {
                            "Study Tracker"
                        }
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            !uiState.isSignedIn -> {
                EmptyTrackerState(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    message = "Sign in to start tracking your study time."
                )
            }

            hasStudyContext -> {
                StudyTrackerSessionContent(
                    uiState = uiState,
                    board = board.orEmpty(),
                    classLevel = classLevel.orEmpty(),
                    subjectId = subjectId.orEmpty(),
                    chapterId = chapterId.orEmpty(),
                    onStart = {
                        viewModel.startSession(
                            board = board.orEmpty(),
                            classLevel = classLevel.orEmpty(),
                            subjectId = subjectId.orEmpty(),
                            chapterId = chapterId.orEmpty()
                        )
                    },
                    onStop = {
                        viewModel.stopActiveSession()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }

            else -> {
                StudyTrackerDashboardContent(
                    uiState = uiState,
                    onStop = {
                        viewModel.stopActiveSession()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }
        }
    }
}

@Composable
private fun StudyTrackerSessionContent(
    uiState: StudyTrackerUiState,
    board: String,
    classLevel: String,
    subjectId: String,
    chapterId: String,
    onStart: () -> Unit,
    onStop: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            horizontal = 16.dp,
            vertical = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            StudyContextCard(
                board = board,
                classLevel = classLevel,
                subjectId = subjectId,
                chapterId = chapterId
            )
        }

        item {
            ActiveSessionCard(
                session = uiState.activeSession,
                requestedSubjectId = subjectId,
                requestedChapterId = chapterId,
                onStart = onStart,
                onStop = onStop
            )
        }

        uiState.errorMessage?.let { message ->
            item {
                ErrorCard(message)
            }
        }
    }
}

@Composable
private fun StudyTrackerDashboardContent(
    uiState: StudyTrackerUiState,
    onStop: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            horizontal = 16.dp,
            vertical = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ActiveSessionCard(
                session = uiState.activeSession,
                requestedSubjectId = null,
                requestedChapterId = null,
                onStart = null,
                onStop = onStop
            )
        }

        item {
            StudyOverviewCard(uiState)
        }

        item {
            TodayGoalCard(
                todaySeconds = uiState.todayStudySeconds
            )
        }

        item {
            StudyPeriodCard(
                title = "This Week",
                icon = Icons.Default.CalendarMonth,
                seconds = uiState.weekStudySeconds,
                sessions = uiState.weekSessionCount
            )
        }

        item {
            StudyPeriodCard(
                title = "This Month",
                icon = Icons.Default.AccessTime,
                seconds = uiState.monthStudySeconds,
                sessions = null
            )
        }

        item {
            StreakCard(
                currentStreak = uiState.currentStreak,
                longestStreak = uiState.longestStreak
            )
        }

        item {
            Text(
                text = "Recent Sessions",
                style = MaterialTheme.typography.titleLarge
            )
        }

        if (uiState.recentSessions.isEmpty()) {
            item {
                EmptyTrackerState(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    message = "Your completed study sessions will appear here."
                )
            }
        } else {
            items(
                items = uiState.recentSessions,
                key = { it.sessionId }
            ) { session ->
                RecentSessionCard(session)
            }
        }

        uiState.errorMessage?.let { message ->
            item {
                ErrorCard(message)
            }
        }
    }
}

@Composable
private fun StudyContextCard(
    board: String,
    classLevel: String,
    subjectId: String,
    chapterId: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Study Context",
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = subjectId,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = chapterId,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "$board • $classLevel",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun ActiveSessionCard(
    session: StudySession?,
    requestedSubjectId: String?,
    requestedChapterId: String?,
    onStart: (() -> Unit)?,
    onStop: () -> Unit
) {
    val activeSessionMatchesRequestedContext =
        session != null &&
            !requestedSubjectId.isNullOrBlank() &&
            !requestedChapterId.isNullOrBlank() &&
            session.subjectId == requestedSubjectId &&
            session.chapterId == requestedChapterId

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = if (session == null) {
                            "Ready to study?"
                        } else {
                            "Study session active"
                        },
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = when {
                            session != null -> {
                                buildSessionLabel(session)
                            }

                            onStart != null -> {
                                "Start this chapter to track your study time."
                            }

                            else -> {
                                "Open a chapter and start a study session."
                            }
                        },
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Icon(
                    imageVector = if (session == null) {
                        Icons.Default.PlayArrow
                    } else {
                        Icons.Default.AccessTime
                    },
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }

            if (session != null) {
                ActiveTimer(
                    startedAt = session.startedAt
                )

                Button(
                    onClick = onStop,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Stop,
                        contentDescription = null
                    )

                    Spacer(
                        modifier = Modifier.size(8.dp)
                    )

                    Text("Stop Study Session")
                }
            } else if (onStart != null) {
                Button(
                    onClick = onStart,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null
                    )

                    Spacer(
                        modifier = Modifier.size(8.dp)
                    )

                    Text("Start Study Session")
                }
            } else if (!activeSessionMatchesRequestedContext) {
                Text(
                    text = "Study sessions are started from a specific chapter.",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
private fun ActiveTimer(
    startedAt: Long
) {
    var now by remember {
        mutableLongStateOf(
            System.currentTimeMillis()
        )
    }

    LaunchedEffect(startedAt) {
        while (true) {
            now = System.currentTimeMillis()
            delay(1000L)
        }
    }

    val elapsedSeconds =
        ((now - startedAt) / 1000L)
            .coerceAtLeast(0L)

    Text(
        text = formatDuration(elapsedSeconds),
        style = MaterialTheme.typography.displaySmall
    )

    Text(
        text = "Live study time",
        style = MaterialTheme.typography.bodySmall
    )
}

@Composable
private fun StudyOverviewCard(
    uiState: StudyTrackerUiState
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Your Progress",
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = formatDuration(
                    uiState.totalStudySeconds
                ),
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Total completed study time",
                style = MaterialTheme.typography.bodyMedium
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                StatItem(
                    modifier = Modifier.weight(1f),
                    value = formatDuration(
                        uiState.todayStudySeconds
                    ),
                    label = "Today"
                )

                StatItem(
                    modifier = Modifier.weight(1f),
                    value = uiState.todaySessionCount.toString(),
                    label = "Sessions"
                )

                StatItem(
                    modifier = Modifier.weight(1f),
                    value = uiState.currentStreak.toString(),
                    label = "Day streak"
                )
            }
        }
    }
}

@Composable
private fun TodayGoalCard(
    todaySeconds: Long
) {
    val goalSeconds = 45L * 60L

    val progress =
        (todaySeconds.toFloat() / goalSeconds.toFloat())
            .coerceIn(0f, 1f)

    val remainingSeconds =
        (goalSeconds - todaySeconds)
            .coerceAtLeast(0L)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Daily Goal",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "${(progress * 100).toInt()}%"
                )
            }

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = if (remainingSeconds > 0L) {
                    "${formatDuration(remainingSeconds)} remaining"
                } else {
                    "Daily goal completed 🎉"
                },
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun StudyPeriodCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    seconds: Long,
    sessions: Int?
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )

            Spacer(
                modifier = Modifier.size(14.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = formatDuration(seconds),
                    style = MaterialTheme.typography.titleLarge
                )

                sessions?.let {
                    Text(
                        text = "$it completed sessions",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Composable
private fun StreakCard(
    currentStreak: Int,
    longestStreak: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Whatshot,
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )

            Spacer(
                modifier = Modifier.size(16.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "$currentStreak day streak",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = "Longest: $longestStreak days",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun RecentSessionCard(
    session: StudySession
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                modifier = Modifier.size(28.dp)
            )

            Spacer(
                modifier = Modifier.size(12.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = session.subjectId,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = session.chapterId
                        ?: "Unknown chapter",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Text(
                text = formatDuration(
                    session.durationSeconds
                ),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
private fun StatItem(
    modifier: Modifier,
    value: String,
    label: String
) {
    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(14.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun EmptyTrackerState(
    modifier: Modifier,
    message: String
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            modifier = Modifier.padding(24.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun ErrorCard(
    message: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        )
    ) {
        Text(
            text = message,
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.onErrorContainer
        )
    }
}

private fun buildSessionLabel(
    session: StudySession
): String {
    val subject = session.subjectId
        .takeIf { it.isNotBlank() }
        ?: "Subject"

    val chapter = session.chapterId
        ?.takeIf { it.isNotBlank() }

    return if (chapter != null) {
        "$subject • $chapter"
    } else {
        "$subject • ${session.classLevel}"
    }
}

private fun formatDuration(
    totalSeconds: Long
): String {
    val safeSeconds = totalSeconds.coerceAtLeast(0L)

    val hours = safeSeconds / 3600L
    val minutes = (safeSeconds % 3600L) / 60L
    val seconds = safeSeconds % 60L

    return when {
        hours > 0L ->
            String.format(
                Locale.getDefault(),
                "%dh %02dm",
                hours,
                minutes
            )

        minutes > 0L ->
            String.format(
                Locale.getDefault(),
                "%dm %02ds",
                minutes,
                seconds
            )

        else ->
            String.format(
                Locale.getDefault(),
                "%ds",
                seconds
            )
    }
}
