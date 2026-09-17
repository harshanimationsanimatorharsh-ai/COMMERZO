package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.repository.TestHistoryRepository

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

    val history by
        TestHistoryRepository.history.collectAsState()

    val totalTests =
        history.size

    val totalCorrect =
        history.sumOf {
            it.correct
        }

    val perfectTests =
        history.count {
            it.totalQuestions > 0 &&
                it.correct == it.totalQuestions
        }

    val achievements = listOf(

        Achievement(
            id = "first_test",
            title = "First Test",
            description =
                "Complete your first test.",
            requirement =
                "Complete 1 test",
            progress =
                totalTests,
            target = 1
        ),

        Achievement(
            id = "test_taker",
            title = "Test Taker",
            description =
                "Complete five tests.",
            requirement =
                "Complete 5 tests",
            progress =
                totalTests,
            target = 5
        ),

        Achievement(
            id = "test_master",
            title = "Test Master",
            description =
                "Complete ten tests.",
            requirement =
                "Complete 10 tests",
            progress =
                totalTests,
            target = 10
        ),

        Achievement(
            id = "perfect_score",
            title = "Perfect Score",
            description =
                "Finish a test with every question correct.",
            requirement =
                "Get 100% in 1 test",
            progress =
                perfectTests,
            target = 1
        ),

        Achievement(
            id = "knowledge_builder",
            title = "Knowledge Builder",
            description =
                "Answer fifty questions correctly.",
            requirement =
                "50 correct answers",
            progress =
                totalCorrect,
            target = 50
        ),

        Achievement(
            id = "question_champion",
            title = "Question Champion",
            description =
                "Answer one hundred questions correctly.",
            requirement =
                "100 correct answers",
            progress =
                totalCorrect,
            target = 100
        )
    )

    val unlockedCount =
        achievements.count {
            it.unlocked
        }

    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    Text(
                        text = "Achievements",
                        fontWeight =
                            FontWeight.Bold
                    )
                },

                navigationIcon = {

                    IconButton(
                        onClick = onBack
                    ) {

                        Icon(
                            imageVector =
                                Icons.Default.ArrowBack,
                            contentDescription =
                                "Back"
                        )
                    }
                },

                colors =
                    TopAppBarDefaults
                        .topAppBarColors(
                            containerColor =
                                MaterialTheme
                                    .colorScheme
                                    .surface
                        )
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(
                        paddingValues
                    )
                    .padding(
                        horizontal = 16.dp
                    ),

            verticalArrangement =
                Arrangement.spacedBy(12.dp)
        ) {

            item {

                Spacer(
                    modifier =
                        Modifier.height(
                            8.dp
                        )
                )

                AchievementSummaryCard(
                    unlockedCount =
                        unlockedCount,
                    totalCount =
                        achievements.size
                )
            }

            item {

                Text(
                    text =
                        "Your Achievements",

                    style =
                        MaterialTheme
                            .typography
                            .titleLarge,

                    fontWeight =
                        FontWeight.Bold
                )
            }

            items(
                items = achievements,
                key = {
                    it.id
                }
            ) { achievement ->

                AchievementCard(
                    achievement =
                        achievement
                )
            }

            item {

                Spacer(
                    modifier =
                        Modifier.height(
                            16.dp
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

    val progress =
        if (totalCount > 0) {
            unlockedCount.toFloat() /
                totalCount.toFloat()
        } else {
            0f
        }

    Card(
        modifier =
            Modifier.fillMaxWidth(),

        shape =
            RoundedCornerShape(
                20.dp
            ),

        colors =
            CardDefaults.cardColors(
                containerColor =
                    MaterialTheme
                        .colorScheme
                        .primaryContainer
            )
    ) {

        Column(
            modifier =
                Modifier.padding(
                    18.dp
                )
        ) {

            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Icon(
                    imageVector =
                        Icons.Default.EmojiEvents,

                    contentDescription =
                        null,

                    modifier =
                        Modifier.height(
                            42.dp
                        )
                )

                Spacer(
                    modifier =
                        Modifier.width(
                            12.dp
                        )
                )

                Column {

                    Text(
                        text =
                            "$unlockedCount / $totalCount Unlocked",

                        style =
                            MaterialTheme
                                .typography
                                .titleMedium,

                        fontWeight =
                            FontWeight.Bold
                    )

                    Spacer(
                        modifier =
                            Modifier.height(
                                3.dp
                            )
                    )

                    Text(
                        text =
                            if (
                                unlockedCount == 0
                            ) {
                                "Start practicing to earn achievements."
                            } else {
                                "Keep learning to unlock more."
                            },

                        style =
                            MaterialTheme
                                .typography
                                .bodySmall
                    )
                }
            }

            Spacer(
                modifier =
                    Modifier.height(
                        14.dp
                    )
            )

            LinearProgressIndicator(
                progress = {
                    progress
                },

                modifier =
                    Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun AchievementCard(
    achievement: Achievement
) {

    val progress =
        achievement.progress
            .coerceIn(
                0,
                achievement.target
            )

    val progressFraction =
        if (achievement.target > 0) {
            progress.toFloat() /
                achievement.target.toFloat()
        } else {
            0f
        }

    Card(
        modifier =
            Modifier.fillMaxWidth(),

        shape =
            RoundedCornerShape(
                16.dp
            ),

        colors =
            CardDefaults.cardColors(
                containerColor =
                    if (
                        achievement.unlocked
                    ) {
                        MaterialTheme
                            .colorScheme
                            .surface
                    } else {
                        MaterialTheme
                            .colorScheme
                            .surfaceVariant
                    }
            )
    ) {

        Column(
            modifier =
                Modifier.padding(
                    16.dp
                )
        ) {

            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Icon(
                    imageVector =
                        if (
                            achievement.unlocked
                        ) {
                            Icons.Default.EmojiEvents
                        } else {
                            Icons.Default.Lock
                        },

                    contentDescription =
                        if (
                            achievement.unlocked
                        ) {
                            "Unlocked"
                        } else {
                            "Locked"
                        },

                    modifier =
                        Modifier.height(
                            38.dp
                        )
                )

                Spacer(
                    modifier =
                        Modifier.width(
                            12.dp
                        )
                )

                Column(
                    modifier =
                        Modifier.weight(
                            1f
                        )
                ) {

                    Text(
                        text =
                            achievement.title,

                        style =
                            MaterialTheme
                                .typography
                                .titleMedium,

                        fontWeight =
                            FontWeight.Bold
                    )

                    Spacer(
                        modifier =
                            Modifier.height(
                                3.dp
                            )
                    )

                    Text(
                        text =
                            achievement.description,

                        style =
                            MaterialTheme
                                .typography
                                .bodySmall,

                        color =
                            MaterialTheme
                                .colorScheme
                                .onSurfaceVariant
                    )
                }

                Text(
                    text =
                        if (
                            achievement.unlocked
                        ) {
                            "Unlocked"
                        } else {
                            "$progress/${achievement.target}"
                        },

                    style =
                        MaterialTheme
                            .typography
                            .labelMedium,

                    fontWeight =
                        FontWeight.Bold,

                    color =
                        if (
                            achievement.unlocked
                        ) {
                            MaterialTheme
                                .colorScheme
                                .primary
                        } else {
                            MaterialTheme
                                .colorScheme
                                .onSurfaceVariant
                        }
                )
            }

            if (!achievement.unlocked) {

                Spacer(
                    modifier =
                        Modifier.height(
                            12.dp
                        )
                )

                LinearProgressIndicator(
                    progress = {
                        progressFraction
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(
                            6.dp
                        )
                )

                Text(
                    text =
                        achievement.requirement,

                    style =
                        MaterialTheme
                            .typography
                            .labelSmall,

                    color =
                        MaterialTheme
                            .colorScheme
                            .onSurfaceVariant
                )
            }
        }
    }
}
