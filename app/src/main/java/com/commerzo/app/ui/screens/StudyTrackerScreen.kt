package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun StudyTrackerScreen() {

    val subjects = listOf(
        StudySubject(
            name = "Accountancy",
            progress = 0.72f,
            studied = "18h 30m",
            icon = Icons.Default.MenuBook
        ),
        StudySubject(
            name = "Business Studies",
            progress = 0.64f,
            studied = "15h 20m",
            icon = Icons.Default.MenuBook
        ),
        StudySubject(
            name = "Economics",
            progress = 0.58f,
            studied = "13h 45m",
            icon = Icons.Default.MenuBook
        ),
        StudySubject(
            name = "Mathematics",
            progress = 0.46f,
            studied = "10h 15m",
            icon = Icons.Default.MenuBook
        ),
        StudySubject(
            name = "English",
            progress = 0.38f,
            studied = "8h 40m",
            icon = Icons.Default.MenuBook
        ),
        StudySubject(
            name = "Hindi",
            progress = 0.32f,
            studied = "7h 10m",
            icon = Icons.Default.MenuBook
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Study Tracker",
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = "Track your learning journey",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 10.dp,
                bottom = 28.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                StudyOverviewCard()
            }

            item {
                DailyGoalCard()
            }

            item {
                WeeklyActivityCard()
            }

            item {
                SectionTitle(
                    title = "Subject Progress",
                    subtitle = "Your learning progress by subject"
                )
            }

            items(
                items = subjects,
                key = { it.name }
            ) { subject ->

                SubjectProgressCard(subject = subject)
            }

            item {
                StudyAchievementCard()
            }
        }
    }
}

private data class StudySubject(
    val name: String,
    val progress: Float,
    val studied: String,
    val icon: ImageVector
)

@Composable
private fun StudyOverviewCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    modifier = Modifier.size(54.dp),
                    shape = RoundedCornerShape(17.dp),
                    color = MaterialTheme.colorScheme.surface.copy(
                        alpha = 0.85f
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = "Study time",
                        modifier = Modifier.padding(13.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(modifier = Modifier.size(14.dp))

                Column {
                    Text(
                        text = "TOTAL STUDY TIME",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "73h 40m",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Keep building your consistency. Every study session counts.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                TrackerStat(
                    modifier = Modifier.weight(1f),
                    value = "6",
                    label = "Subjects"
                )

                TrackerStat(
                    modifier = Modifier.weight(1f),
                    value = "21",
                    label = "Sessions"
                )

                TrackerStat(
                    modifier = Modifier.weight(1f),
                    value = "7",
                    label = "Day Streak"
                )
            }
        }
    }
}

@Composable
private fun TrackerStat(
    modifier: Modifier,
    value: String,
    label: String
) {

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = 11.dp,
                horizontal = 6.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun DailyGoalCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp)
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Whatshot,
                    contentDescription = "Daily goal",
                    tint = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.size(9.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Today's Goal",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        text = "45 min of focused study",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Text(
                    text = "27 / 45 min",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(13.dp))

            LinearProgressIndicator(
                progress = { 0.60f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "18 minutes remaining",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun WeeklyActivityCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp)
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Text(
                text = "Weekly Activity",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Your study consistency this week",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(18.dp))

            val days = listOf(
                "M" to 0.75f,
                "T" to 0.55f,
                "W" to 0.90f,
                "T" to 0.65f,
                "F" to 0.45f,
                "S" to 0.80f,
                "S" to 0.35f
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {

                days.forEach { (day, progress) ->

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Surface(
                            modifier = Modifier
                                .size(
                                    width = 24.dp,
                                    height = 70.dp
                                ),
                            shape = RoundedCornerShape(10.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Bottom
                            ) {

                                Surface(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(
                                            (70 * progress)
                                                .dp
                                    ),
                                    shape = RoundedCornerShape(10.dp),
                                    color = MaterialTheme.colorScheme.primary
                                ) {}
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = day,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SubjectProgressCard(
    subject: StudySubject
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    modifier = Modifier.size(46.dp),
                    shape = RoundedCornerShape(14.dp),
                    color = MaterialTheme.colorScheme.secondaryContainer
                ) {
                    Icon(
                        imageVector = subject.icon,
                        contentDescription = subject.name,
                        modifier = Modifier.padding(11.dp),
                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = subject.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = subject.studied,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Text(
                    text = "${(subject.progress * 100).toInt()}%",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            LinearProgressIndicator(
                progress = { subject.progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(7.dp)
            )
        }
    }
}

@Composable
private fun StudyAchievementCard() {

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {

        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier.size(48.dp),
                shape = RoundedCornerShape(15.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(
                    imageVector = Icons.Default.EmojiEvents,
                    contentDescription = "Achievement",
                    modifier = Modifier.padding(12.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.width(13.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Keep your streak alive!",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Study every day to unlock XP, achievements and higher levels.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun SectionTitle(
    title: String,
    subtitle: String
) {

    Column {

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(3.dp))

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
