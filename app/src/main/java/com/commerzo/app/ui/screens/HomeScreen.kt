package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commerzo.app.ui.theme.CommerzoDimensions

@Composable
fun HomeScreen(
    onSubjectClick: (String) -> Unit = {},
    onSubjectsClick: () -> Unit = {},
    onPracticeClick: () -> Unit = {},
    onTestsClick: () -> Unit = {},
    onGamesClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onBookmarksClick: () -> Unit = {},
    onTestHistoryClick: () -> Unit = {},
    onAchievementsClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {
    val subjects = listOf(
        HomeSubject("accountancy", "Accountancy", "📊"),
        HomeSubject("business_studies", "Business Studies", "💼"),
        HomeSubject("economics", "Economics", "📈"),
        HomeSubject("mathematics", "Mathematics", "🧮"),
        HomeSubject("english", "English", "📖"),
        HomeSubject("hindi", "Hindi", "📝")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            CommerzoDimensions.Space2
                        )
                    ) {
                        Text(
                            text = "Good Morning 👋",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = "Ready to learn today?",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                actions = {
                    Surface(
                        modifier = Modifier
                            .padding(end = CommerzoDimensions.Space12)
                            .size(42.dp),
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        onClick = onProfileClick
                    ) {
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Profile",
                                modifier = Modifier.size(
                                    CommerzoDimensions.IconMedium
                                ),
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(
                horizontal = CommerzoDimensions.ScreenHorizontal,
                vertical = CommerzoDimensions.Space12
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.SectionSpacing
            )
        ) {

            /*
             * 1. CONTINUE LEARNING
             *
             * Primary Home action.
             */
            item {
                ContinueLearningCard(
                    onClick = onPracticeClick
                )
            }

            /*
             * 2. TODAY'S PROGRESS
             */
            item {
                SectionHeader(
                    title = "Today's Progress",
                    subtitle = "Keep your study momentum going"
                )
            }

            item {
                TodayProgressCard()
            }

            /*
             * 3. QUICK ACTIONS
             *
             * Only the most important actions stay here.
             */
            item {
                SectionHeader(
                    title = "Quick Actions",
                    subtitle = "Start exactly what you need"
                )
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(
                        CommerzoDimensions.CardSpacing
                    ),
                    contentPadding = PaddingValues(
                        end = CommerzoDimensions.Space4
                    )
                ) {
                    item {
                        QuickActionTile(
                            title = "Practice",
                            subtitle = "Chapter MCQs",
                            icon = Icons.Default.MenuBook,
                            onClick = onPracticeClick
                        )
                    }

                    item {
                        QuickActionTile(
                            title = "Test",
                            subtitle = "Check your score",
                            icon = Icons.Default.Assessment,
                            onClick = onTestsClick
                        )
                    }

                    item {
                        QuickActionTile(
                            title = "PYQ",
                            subtitle = "Previous papers",
                            icon = Icons.Default.School,
                            onClick = onTestsClick
                        )
                    }

                    item {
                        QuickActionTile(
                            title = "Subjects",
                            subtitle = "Explore chapters",
                            icon = Icons.Default.MenuBook,
                            onClick = onSubjectsClick
                        )
                    }
                }
            }

            /*
             * 4. SUBJECTS
             *
             * Compact horizontal list instead of six large cards.
             */
            item {
                SectionHeader(
                    title = "Subjects",
                    subtitle = "Choose a subject to continue"
                )
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(
                        CommerzoDimensions.CardSpacing
                    ),
                    contentPadding = PaddingValues(
                        end = CommerzoDimensions.Space4
                    )
                ) {
                    items(
                        items = subjects,
                        key = { it.id }
                    ) { subject ->

                        CompactSubjectCard(
                            subject = subject,
                            onClick = {
                                onSubjectClick(subject.id)
                            }
                        )
                    }
                }
            }

            /*
             * 5. DAILY GOAL
             */
            item {
                DailyGoalCard()
            }

            /*
             * 6. RECOMMENDATION
             *
             * Later this will become dynamic based on weak topics.
             */
            item {
                RecommendationCard(
                    onClick = onPracticeClick
                )
            }

            item {
                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space8
                    )
                )
            }
        }
    }
}

private data class HomeSubject(
    val id: String,
    val name: String,
    val emoji: String
)

@Composable
private fun ContinueLearningCard(
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = CommerzoDimensions.CardPaddingLarge,
                    vertical = CommerzoDimensions.Space20
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(58.dp),
                shape = RoundedCornerShape(18.dp),
                color = MaterialTheme.colorScheme.onPrimary.copy(
                    alpha = 0.14f
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Continue learning",
                        modifier = Modifier.size(
                            CommerzoDimensions.IconLarge
                        ),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space16
                )
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space4
                )
            ) {
                Text(
                    text = "Continue Learning",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Text(
                    text = "Pick up your practice from where you left off.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimary.copy(
                        alpha = 0.82f
                    )
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Continue",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
private fun TodayProgressCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space16
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
                        text = "0 min",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        text = "Studied today",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                ProgressMiniStat(
                    value = "0",
                    label = "Questions"
                )

                Spacer(
                    modifier = Modifier.width(
                        CommerzoDimensions.Space12
                    )
                )

                ProgressMiniStat(
                    value = "0",
                    label = "Tests"
                )
            }

            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(100.dp),
                color = MaterialTheme.colorScheme.surfaceVariant
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                )
            }
        }
    }
}

@Composable
private fun ProgressMiniStat(
    value: String,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.End,
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
private fun QuickActionTile(
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.width(142.dp),
        onClick = onClick,
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                CommerzoDimensions.CardPadding
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space6
            )
        ) {
            Surface(
                modifier = Modifier.size(44.dp),
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space4
                )
            )

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun CompactSubjectCard(
    subject: HomeSubject,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.width(142.dp),
        onClick = onClick,
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                CommerzoDimensions.CardPadding
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space8
            )
        ) {
            Box(
                modifier = Modifier.size(46.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = subject.emoji,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Text(
                text = subject.name,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.ExtraBold,
                maxLines = 2
            )

            Text(
                text = "Open subject",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun DailyGoalCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
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
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Timer,
                        contentDescription = "Daily goal",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space12
                )
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space4
                )
            ) {
                Text(
                    text = "Daily Goal",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = "Complete 30 minutes of focused study.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text = "0 / 30 min",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun RecommendationCard(
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(24.dp)
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
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.MenuBook,
                        contentDescription = "Recommended practice",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space12
                )
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space4
                )
            ) {
                Text(
                    text = "Recommended for You",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = "Practice a topic and strengthen your concepts.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open recommendation",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun SectionHeader(
    title: String,
    subtitle: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space4
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
