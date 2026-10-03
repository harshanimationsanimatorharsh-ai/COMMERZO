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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            CommerzoDimensions.Space2
                        )
                    ) {
                        Text(
                            text = if (hasStudyContext) {
                                "Start Study"
                            } else {
                                "Study Tracker"
                            },
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        if (!hasStudyContext) {
                            Text(
                                text = "Build a consistent study habit",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
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
            vertical = CommerzoDimensions.Space16
        ),
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space16
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
            vertical = CommerzoDimensions.Space16
        ),
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space16
        )
    ) {
        item {
            StudyDashboardHero(
                todaySeconds = uiState.todayStudySeconds,
                currentStreak = uiState.currentStreak
            )
        }

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
            WeeklyOverviewCard(
                weekSeconds = uiState.weekStudySeconds,
                weekSessions = uiState.weekSessionCount,
                monthSeconds = uiState.monthStudySeconds
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
                title = "Recent Sessions",
                subtitle = "Your latest focused study sessions"
            )
        }

        if (uiState.recentSessions.isEmpty()) {
            item {
                EmptyTrackerState(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    title = "No sessions yet",
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

        item {
            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space4
                )
            )
        }
    }
}

@Composable
private fun StudyDashboardHero(
    todaySeconds: Long,
    currentStreak: Int
) {
    val goalSeconds = 45L * 60L
    val progress =
        (todaySeconds.toFloat() / goalSeconds.toFloat())
            .coerceIn(0f, 1f)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space12
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Keep going",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space4
                        )
                    )

                    Text(
                        text = "Stay consistent and make progress every day.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }

                Surface(
                    modifier = Modifier.size(50.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.surface.copy(
                        alpha = 0.7f
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier.padding(13.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = formatDuration(todaySeconds),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Spacer(
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "$currentStreak day streak",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(7.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.65f
                )
            )

            Text(
                text = "Daily target: 45 minutes",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
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
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space8
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space12
                )
            ) {
                Surface(
                    modifier = Modifier.size(46.dp),
                    shape = RoundedCornerShape(14.dp),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier.padding(12.dp),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Ready to study?",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
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
                    CommerzoDimensions.Space4
                )
            )

            Text(
                text = subjectId,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
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
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold
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
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if (session == null) {
                    MaterialTheme.colorScheme.surface
                } else {
                    MaterialTheme.colorScheme.tertiaryContainer
                }
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space12
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = if (session == null) {
                            "Start studying"
                        } else {
                            "Study session active"
                        },
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space4
                        )
                    )

                    Text(
                        text = if (session == null) {
                            if (onStart != null) {
                                "Track your focused study time from here."
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
                    color =
                        if (session == null) {
                            MaterialTheme.colorScheme.primaryContainer
                        } else {
                            MaterialTheme.colorScheme.tertiary
                        }
                ) {
                    Icon(
                        imageVector =
                            if (session == null) {
                                Icons.Default.PlayArrow
                            } else {
                                Icons.Default.AccessTime
                            },
                        contentDescription = null,
                        modifier = Modifier.padding(12.dp),
                        tint =
                            if (session == null) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.onTertiary
                            }
                    )
                }
            }

            if (session != null) {
                ActiveTimer(
                    startedAt = session.startedAt
                )

                Button(
                    onClick = onStop,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp)
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

                    Text(
                        text = "Stop Study Session",
                        fontWeight = FontWeight.Bold
                    )
                }
            } else if (onStart != null) {
                Button(
                    onClick = onStart,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp)
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

                    Text(
                        text = "Start Study Session",
                        fontWeight = FontWeight.Bold
                    )
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatDuration(elapsedSeconds),
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.ExtraBold,
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
        shape = RoundedCornerShape(21.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space12
            )
        ) {
            Text(
                text = "Your Progress",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = formatDuration(
                    uiState.totalStudySeconds
                ),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "Total completed study time",
                style = MaterialTheme.typography.bodySmall,
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
                    label = "Streak"
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space10
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
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
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "${(progress * 100).toInt()}%",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
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
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun WeeklyOverviewCard(
    weekSeconds: Long,
    weekSessions: Int,
    monthSeconds: Long
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space12
            )
        ) {
            Text(
                text = "Study Overview",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space8
                )
            ) {
                OverviewStat(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.CalendarMonth,
                    value = formatDuration(weekSeconds),
                    label = "This week"
                )

                OverviewStat(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.AccessTime,
                    value = formatDuration(monthSeconds),
                    label = "This month"
                )
            }

            Text(
                text = "$weekSessions completed sessions this week",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun OverviewStat(
    modifier: Modifier,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    value: String,
    label: String
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(15.dp)
            )
            .padding(
                CommerzoDimensions.Space12
            ),
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space6
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(19.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
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
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(
                    imageVector = Icons.Default.Whatshot,
                    contentDescription = null,
                    modifier = Modifier.padding(13.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
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
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = "Longest streak: $longestStreak days",
                    style = MaterialTheme.typography.bodySmall,
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
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPadding
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(42.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    modifier = Modifier.padding(11.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
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
                    fontWeight = FontWeight.SemiBold
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
                fontWeight = FontWeight.Bold
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
            ),
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space2
        )
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun SectionHeader(
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = CommerzoDimensions.Space4
            ),
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space2
        )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun LoadingTrackerState(
    modifier: Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier.size(72.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Icon(
                imageVector = Icons.Default.AccessTime,
                contentDescription = null,
                modifier = Modifier.padding(20.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space16
            )
        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
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
