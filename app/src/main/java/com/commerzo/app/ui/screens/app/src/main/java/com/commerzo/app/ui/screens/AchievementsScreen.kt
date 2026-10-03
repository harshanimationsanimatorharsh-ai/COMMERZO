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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.commerzo.app.data.repository.TestHistoryRepository
import com.commerzo.app.ui.theme.CommerzoDimensions

private data class Achievement(
    val id: String,
    val title: String,
    val description: String,
    val requirement: String,
    val progress: Int,
    val target: Int
) {
    val unlocked: Boolean
        get() = progress >= target
}

@Composable
fun AchievementsScreen(
    onBack: () -> Unit
) {
    val history by TestHistoryRepository.history.collectAsState()

    val totalTests = history.size

    val totalCorrect = history.sumOf {
        it.correct
    }

    val perfectTests = history.count {
        it.totalQuestions > 0 &&
            it.correct == it.totalQuestions
    }

    val achievements = listOf(
        Achievement(
            id = "first_test",
            title = "First Test",
            description = "Complete your first test.",
            requirement = "Complete 1 test",
            progress = totalTests,
            target = 1
        ),
        Achievement(
            id = "test_taker",
            title = "Test Taker",
            description = "Complete five tests.",
            requirement = "Complete 5 tests",
            progress = totalTests,
            target = 5
        ),
        Achievement(
            id = "test_master",
            title = "Test Master",
            description = "Complete ten tests.",
            requirement = "Complete 10 tests",
            progress = totalTests,
            target = 10
        ),
        Achievement(
            id = "perfect_score",
            title = "Perfect Score",
            description = "Finish a test with every question correct.",
            requirement = "Get 100% in 1 test",
            progress = perfectTests,
            target = 1
        ),
        Achievement(
            id = "knowledge_builder",
            title = "Knowledge Builder",
            description = "Answer fifty questions correctly.",
            requirement = "50 correct answers",
            progress = totalCorrect,
            target = 50
        ),
        Achievement(
            id = "question_champion",
            title = "Question Champion",
            description = "Answer one hundred questions correctly.",
            requirement = "100 correct answers",
            progress = totalCorrect,
            target = 100
        )
    )

    val unlockedCount = achievements.count {
        it.unlocked
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Achievements",
                        fontWeight = FontWeight.Bold
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

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                horizontal = CommerzoDimensions.ScreenHorizontal,
                vertical = CommerzoDimensions.Space16
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.CardSpacing
            )
        ) {
            item {
                AchievementSummaryCard(
                    unlockedCount = unlockedCount,
                    totalCount = achievements.size
                )
            }

            item {
                Column {
                    Text(
                        text = "Your Achievements",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space4
                        )
                    )

                    Text(
                        text = "Milestones you unlock as you keep learning.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            items(
                items = achievements,
                key = { it.id }
            ) { achievement ->
                AchievementCard(
                    achievement = achievement
                )
            }

            item {
                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space16
                    )
                )
            }
        }
    }
}

@Composable
private fun AchievementSummaryCard(
    unlockedCount: Int,
    totalCount: Int
) {
    val progress = if (totalCount > 0) {
        unlockedCount.toFloat() / totalCount.toFloat()
    } else {
        0f
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(
            CommerzoDimensions.Space20
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(
                CommerzoDimensions.CardPaddingLarge
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(
                        CommerzoDimensions.Space12
                    ),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Icon(
                        imageVector = Icons.Default.EmojiEvents,
                        contentDescription = null,
                        modifier = Modifier
                            .size(
                                CommerzoDimensions.IconLarge
                            )
                            .padding(
                                CommerzoDimensions.Space4
                            ),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Spacer(
                    modifier = Modifier.width(
                        CommerzoDimensions.Space12
                    )
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "$unlockedCount / $totalCount Unlocked",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space4
                        )
                    )

                    Text(
                        text = if (unlockedCount == 0) {
                            "Start practicing to earn achievements."
                        } else {
                            "Keep learning to unlock more."
                        },
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space16
                )
            )

            LinearProgressIndicator(
                progress = {
                    progress
                },
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.primary.copy(
                    alpha = 0.18f
                )
            )
        }
    }
}

@Composable
private fun AchievementCard(
    achievement: Achievement
) {
    val progress = achievement.progress.coerceIn(
        0,
        achievement.target
    )

    val progressFraction = if (achievement.target > 0) {
        progress.toFloat() / achievement.target.toFloat()
    } else {
        0f
    }

    val containerColor = if (achievement.unlocked) {
        MaterialTheme.colorScheme.surface
    } else {
        MaterialTheme.colorScheme.surfaceVariant
    }

    val iconContainerColor = if (achievement.unlocked) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.surface
    }

    val iconColor = if (achievement.unlocked) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(
            CommerzoDimensions.Space16
        ),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        )
    ) {
        Column(
            modifier = Modifier.padding(
                CommerzoDimensions.CardPadding
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(
                        CommerzoDimensions.Space12
                    ),
                    color = iconContainerColor
                ) {
                    Icon(
                        imageVector = if (achievement.unlocked) {
                            Icons.Default.EmojiEvents
                        } else {
                            Icons.Default.Lock
                        },
                        contentDescription = if (achievement.unlocked) {
                            "Unlocked"
                        } else {
                            "Locked"
                        },
                        modifier = Modifier
                            .size(
                                CommerzoDimensions.IconLarge
                            )
                            .padding(
                                CommerzoDimensions.Space4
                            ),
                        tint = iconColor
                    )
                }

                Spacer(
                    modifier = Modifier.width(
                        CommerzoDimensions.Space12
                    )
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = achievement.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space4
                        )
                    )

                    Text(
                        text = achievement.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Spacer(
                    modifier = Modifier.width(
                        CommerzoDimensions.Space8
                    )
                )

                Surface(
                    shape = RoundedCornerShape(
                        CommerzoDimensions.Space10
                    ),
                    color = if (achievement.unlocked) {
                        MaterialTheme.colorScheme.primaryContainer
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
                ) {
                    Text(
                        text = if (achievement.unlocked) {
                            "Unlocked"
                        } else {
                            "$progress/${achievement.target}"
                        },
                        modifier = Modifier.padding(
                            horizontal = CommerzoDimensions.Space10,
                            vertical = CommerzoDimensions.Space6
                        ),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (achievement.unlocked) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        }
                    )
                }
            }

            if (!achievement.unlocked) {
                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space16
                    )
                )

                LinearProgressIndicator(
                    progress = {
                        progressFraction
                    },
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.outlineVariant
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space6
                    )
                )

                Text(
                    text = achievement.requirement,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
