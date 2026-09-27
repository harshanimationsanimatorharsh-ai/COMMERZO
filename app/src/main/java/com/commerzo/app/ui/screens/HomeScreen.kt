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
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
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
                            text = "COMMERZO",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = "Learn. Practice. Score.",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                actions = {
                    Surface(
                        modifier = Modifier
                            .padding(end = CommerzoDimensions.Space12)
                            .size(44.dp),
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

            item {
                WelcomeHeader(
                    onProfileClick = onProfileClick
                )
            }

            item {
                ProgressOverview(
                    onAchievementsClick = onAchievementsClick
                )
            }

            item {
                DailyStreakCard()
            }

            item {
                CurriculumCard(
                    onChangeClick = onSubjectsClick
                )
            }

            item {
                SectionHeader(
                    title = "Continue Learning",
                    subtitle = "Keep building your Commerce skills"
                )
            }

            item {
                ContinueLearningCard(
                    onClick = onPracticeClick
                )
            }

            item {
                SectionHeader(
                    title = "Quick Actions",
                    subtitle = "Jump into your favourite activities"
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
                            subtitle = "MCQs",
                            icon = Icons.Default.MenuBook,
                            onClick = onPracticeClick
                        )
                    }

                    item {
                        QuickActionTile(
                            title = "Tests",
                            subtitle = "Full tests",
                            icon = Icons.Default.Assessment,
                            onClick = onTestsClick
                        )
                    }

                    item {
                        QuickActionTile(
                            title = "Games",
                            subtitle = "Mind games",
                            icon = Icons.Default.SportsEsports,
                            onClick = onGamesClick
                        )
                    }
                }
            }

            item {
                SectionHeader(
                    title = "Your Learning",
                    subtitle = "Track and manage your progress"
                )
            }

            item {
                LearningToolsGrid(
                    onBookmarksClick = onBookmarksClick,
                    onTestHistoryClick = onTestHistoryClick,
                    onAchievementsClick = onAchievementsClick,
                    onSettingsClick = onSettingsClick
                )
            }

            item {
                SectionHeader(
                    title = "Subjects",
                    subtitle = "Choose a subject to continue"
                )
            }

            items(
                items = subjects,
                key = { it.id }
            ) { subject ->
                HomeSubjectCard(
                    subject = subject,
                    onClick = {
                        onSubjectClick(subject.id)
                    }
                )
            }

            item {
                BrandFooter()
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
private fun WelcomeHeader(
    onProfileClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space4
            )
        ) {
            Text(
                text = "Welcome back 👋",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = "Let's make today a productive study day.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Surface(
            modifier = Modifier.size(48.dp),
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
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Composable
private fun ProgressOverview(
    onAchievementsClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        onClick = onAchievementsClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CommerzoDimensions.CardPaddingLarge),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space16
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(
                        CommerzoDimensions.Space4
                    )
                ) {
                    Text(
                        text = "YOUR PROGRESS",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                    Text(
                        text = "Level 1 • Beginner",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                    Text(
                        text = "Keep learning to unlock more XP",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                            .copy(alpha = 0.75f)
                    )
                }

                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.surface.copy(
                        alpha = 0.85f
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.EmojiEvents,
                        contentDescription = "Achievements",
                        modifier = Modifier
                            .padding(CommerzoDimensions.Space12)
                            .size(CommerzoDimensions.IconMedium),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space8
                )
            ) {
                ProgressStat(
                    modifier = Modifier.weight(1f),
                    value = "0",
                    label = "XP"
                )

                ProgressStat(
                    modifier = Modifier.weight(1f),
                    value = "0",
                    label = "Tests"
                )

                ProgressStat(
                    modifier = Modifier.weight(1f),
                    value = "0",
                    label = "Days"
                )
            }
        }
    }
}

@Composable
private fun ProgressStat(
    modifier: Modifier,
    value: String,
    label: String
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surface.copy(
            alpha = 0.7f
        )
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = CommerzoDimensions.Space12,
                horizontal = CommerzoDimensions.Space8
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
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
}

@Composable
private fun DailyStreakCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CommerzoDimensions.CardPaddingLarge),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(48.dp),
                shape = RoundedCornerShape(15.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Whatshot,
                        contentDescription = "Study streak",
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
                    text = "Study Streak",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = "Start today and build your streak.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text = "0 days",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun CurriculumCard(
    onChangeClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CommerzoDimensions.CardPaddingLarge),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space4
                )
            ) {
                Text(
                    text = "CURRENT CURRICULUM",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = "MP Board • Class 12",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = "Your selected learning path",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space12
                )
            )

            OutlinedButton(
                onClick = onChangeClick
            ) {
                Text("Change")
            }
        }
    }
}

@Composable
private fun ContinueLearningCard(
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = CommerzoDimensions.CardPaddingLarge,
                    vertical = CommerzoDimensions.CardPadding
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(54.dp),
                shape = RoundedCornerShape(17.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.MenuBook,
                        contentDescription = "Continue learning",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
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
                    text = "Start Practice",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = "Practice chapter-wise MCQs and improve your score.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open practice",
                tint = MaterialTheme.colorScheme.primary
            )
        }
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
        modifier = Modifier.width(148.dp),
        onClick = onClick,
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                CommerzoDimensions.CardPadding
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space4
            )
        ) {
            Surface(
                modifier = Modifier.size(46.dp),
                shape = RoundedCornerShape(15.dp),
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
                    CommerzoDimensions.Space8
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
private fun LearningToolsGrid(
    onBookmarksClick: () -> Unit,
    onTestHistoryClick: () -> Unit,
    onAchievementsClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space10
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space10
            )
        ) {
            LearningToolCard(
                modifier = Modifier.weight(1f),
                title = "Bookmarks",
                icon = Icons.Default.Bookmark,
                onClick = onBookmarksClick
            )

            LearningToolCard(
                modifier = Modifier.weight(1f),
                title = "History",
                icon = Icons.Default.History,
                onClick = onTestHistoryClick
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space10
            )
        ) {
            LearningToolCard(
                modifier = Modifier.weight(1f),
                title = "Achievements",
                icon = Icons.Default.EmojiEvents,
                onClick = onAchievementsClick
            )

            LearningToolCard(
                modifier = Modifier.weight(1f),
                title = "Settings",
                icon = Icons.Default.Settings,
                onClick = onSettingsClick
            )
        }
    }
}

@Composable
private fun LearningToolCard(
    modifier: Modifier,
    title: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(19.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = CommerzoDimensions.Space12,
                    vertical = CommerzoDimensions.Space16
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space10
            )
        ) {
            Surface(
                modifier = Modifier.size(40.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.surfaceVariant
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        modifier = Modifier.size(
                            CommerzoDimensions.IconSmall
                        ),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
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

@Composable
private fun HomeSubjectCard(
    subject: HomeSubject,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(21.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CommerzoDimensions.CardPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        MaterialTheme.colorScheme.primaryContainer
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = subject.emoji,
                    style = MaterialTheme.typography.titleLarge
                )
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
                    text = subject.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = "Chapters • Practice • Tests",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open ${subject.name}",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun BrandFooter() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(
            modifier = Modifier.padding(
                CommerzoDimensions.CardPaddingLarge
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space4
            )
        ) {
            Text(
                text = "COMMERZO",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = "Learn. Practice. Score.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "A focused learning space for Commerce students.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
