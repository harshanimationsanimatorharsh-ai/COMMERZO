package com.commerzo.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.study.StudySession
import com.commerzo.app.ui.theme.CommerzoDimensions
import com.commerzo.app.ui.viewmodel.StudyTrackerUiState
import com.commerzo.app.ui.viewmodel.StudyTrackerViewModel
import kotlinx.coroutines.delay
import java.util.Locale

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
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = if (hasStudyContext) {
                                "Start Study"
                            } else {
                                "Study Tracker"
                            },
                            style = MaterialTheme.typography.titleLarge
                        )

                        if (!hasStudyContext) {
                            Text(
                                text = "Track your learning progress",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
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
                LoadingTrackerState(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }

            !uiState.isSignedIn -> {
                EmptyTrackerState(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    title = "Sign in to track your study",
                    message = "Your study sessions and progress will appear here after you sign in."
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
        contentPadding = PaddingValues(
            horizontal = CommerzoDimensions.ScreenHorizontal,
            vertical = CommerzoDimensions.ScreenVertical
        ),
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.CardSpacing
        )
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
        contentPadding = PaddingValues(
            horizontal = CommerzoDimensions.ScreenHorizontal,
            vertical = CommerzoDimensions.ScreenVertical
        ),
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.CardSpacing
        )
    ) {
        item {
            ActiveSessionCard(
                session = uiState.activeSession,
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
            SectionHeader(
                title = "Recent Sessions"
            )
        }

        if (uiState.recentSessions.isEmpty()) {
            item {
                EmptyTrackerState(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp),
                    title = "No study sessions yet",
                    message = "Complete your first study session and it will appear here."
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
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(
                CommerzoDimensions.CardPaddingLarge
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space8
            )
        ) {
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(44.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Box(
                        contentAlignment = androidx.compose.ui.Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.size(
                        CommerzoDimensions.Space12
                    )
                )

                Column {
                    Text(
                        text = "Ready to study?",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                    )

                    Text(
                        text = "Start a focused study session",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            Text(
                text = subjectId,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold
            )

            Text(
                text = chapterId,
                style = MaterialTheme.typography.bodyLarge
            )

            Surface(
                shape = RoundedCornerShape(10.dp),
                color = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.65f
                )
            ) {
                Text(
                    text = "$board • $classLevel",
                    modifier = Modifier.padding(
                        horizontal = CommerzoDimensions.Space12,
                        vertical = CommerzoDimensions.Space8
                    ),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Composable
private fun ActiveSessionCard(
    session: StudySession?,
    onStart: (() -> Unit)?,
    onStop: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (session == null) {
                MaterialTheme.colorScheme.surface
            } else {
                MaterialTheme.colorScheme.tertiaryContainer
            }
        )
    ) {
        Column(
            modifier = Modifier.padding(
                CommerzoDimensions.CardPaddingLarge
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space12
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
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
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space4
                        )
                    )

                    Text(
                        text = if (session == null) {
                            if (onStart != null) {
                                "Start now and track your focused study time."
                            } else {
                                "Open a chapter to start a study session."
                            }
                        } else {
                            buildSessionLabel(session)
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Surface(
                    modifier = Modifier.size(48.dp),
                    shape = CircleShape,
                    color = if (session == null) {
                        MaterialTheme.colorScheme.primaryContainer
                    } else {
                        MaterialTheme.colorScheme.tertiary
                    }
                ) {
                    Box(
                        contentAlignment = androidx.compose.ui.Alignment.Center
                    ) {
                        Icon(
                            imageVector = if (session == null) {
                                Icons.Default.PlayArrow
                            } else {
                                Icons.Default.AccessTime
                            },
                            contentDescription = null,
                            tint = if (session == null) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.onTertiary
                            }
                        )
                    }
                }
            }

            if (session != null) {
                ActiveTimer(
                    startedAt = session.startedAt
                )

                Button(
                    onClick = onStop,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Stop,
                        contentDescription = null
                    )

                    Spacer(
                        modifier = Modifier.size(
                            CommerzoDimensions.Space8
                        )
                    )

                    Text("Stop Study Session")
                }
            } else if (onStart != null) {
                Button(
                    onClick = onStart,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null
                    )

                    Spacer(
                        modifier = Modifier.size(
                            CommerzoDimensions.Space8
                        )
                    )

                    Text("Start Study Session")
                }
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

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(
            text = formatDuration(elapsedSeconds),
            style = MaterialTheme.typography.displaySmall,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Live study time",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
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
            modifier = Modifier.padding(
                CommerzoDimensions.CardPaddingLarge
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space16
            )
        ) {
            Text(
                text = "Your Progress",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )

            Text(
                text = formatDuration(
                    uiState.totalStudySeconds
                ),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )

            Text(
                text = "Total completed study time",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space8
                )
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
            modifier = Modifier.padding(
                CommerzoDimensions.CardPaddingLarge
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space12
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Flag,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )

                Spacer(
                    modifier = Modifier.size(
                        CommerzoDimensions.Space8
                    )
                )

                Text(
                    text = "Daily Goal",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold
                )

                Text(
                    text = "${(progress * 100).toInt()}%",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )

            Text(
                text = if (remainingSeconds > 0L) {
                    "${formatDuration(remainingSeconds)} remaining"
                } else {
                    "Daily goal completed 🎉"
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
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
        shape = RoundedCornerShape(18.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPadding
                ),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(46.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Box(
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }

            Spacer(
                modifier = Modifier.size(
                    CommerzoDimensions.Space12
                )
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold
                )

                Text(
                    text = formatDuration(seconds),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )

                sessions?.let {
                    Text(
                        text = "$it completed sessions",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
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
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(52.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Whatshot,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(
                modifier = Modifier.size(
                    CommerzoDimensions.Space12
                )
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "$currentStreak day streak",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )

                Text(
                    text = "Longest: $longestStreak days",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
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
                .padding(
                    CommerzoDimensions.CardPadding
                ),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(42.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(
                modifier = Modifier.size(
                    CommerzoDimensions.Space12
                )
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = session.subjectId,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold
                )

                Text(
                    text = session.chapterId
                        ?.takeIf { it.isNotBlank() }
                        ?: "Unknown chapter",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text = formatDuration(
                    session.durationSeconds
                ),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
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
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(14.dp)
            )
            .padding(
                CommerzoDimensions.Space12
            )
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
        )

        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun SectionHeader(
    title: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        modifier = Modifier.padding(
            top = CommerzoDimensions.Space8
        )
    )
}

@Composable
private fun LoadingTrackerState(
    modifier: Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun EmptyTrackerState(
    modifier: Modifier,
    title: String,
    message: String
) {
    Column(
        modifier = modifier.padding(
            CommerzoDimensions.ScreenHorizontal
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier.size(72.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Box(
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AccessTime,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space16
            )
        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
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
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = message,
            modifier = Modifier.padding(
                CommerzoDimensions.CardPadding
            ),
            color = MaterialTheme.colorScheme.onErrorContainer,
            style = MaterialTheme.typography.bodyMedium
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
