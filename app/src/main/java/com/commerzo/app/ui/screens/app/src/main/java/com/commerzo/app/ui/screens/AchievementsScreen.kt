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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AchievementsScreen(
    onBack: () -> Unit
) {

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
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement =
                Arrangement.spacedBy(12.dp)
        ) {

            item {
                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                AchievementHeader()
            }

            item {
                AchievementCard(
                    icon = Icons.Default.EmojiEvents,
                    title = "First Practice",
                    description =
                        "Complete your first practice question.",
                    unlocked = false
                )
            }

            item {
                AchievementCard(
                    icon = Icons.Default.EmojiEvents,
                    title = "Practice Starter",
                    description =
                        "Complete 10 practice questions.",
                    unlocked = false
                )
            }

            item {
                AchievementCard(
                    icon = Icons.Default.EmojiEvents,
                    title = "Test Taker",
                    description =
                        "Complete your first test.",
                    unlocked = false
                )
            }

            item {
                AchievementCard(
                    icon = Icons.Default.EmojiEvents,
                    title = "Perfect Score",
                    description =
                        "Score 100% in a test.",
                    unlocked = false
                )
            }

            item {
                AchievementCard(
                    icon = Icons.Default.EmojiEvents,
                    title = "Question Collector",
                    description =
                        "Save your first question.",
                    unlocked = false
                )
            }

            item {
                AchievementCard(
                    icon = Icons.Default.EmojiEvents,
                    title = "Consistent Learner",
                    description =
                        "Build a learning streak.",
                    unlocked = false
                )
            }

            item {
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }
        }
    }
}

@Composable
private fun AchievementHeader() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.primaryContainer
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.EmojiEvents,
                contentDescription = null
            )

            Spacer(
                modifier = Modifier.width(14.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Your Achievements",
                    style =
                        MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text =
                        "Complete learning milestones to unlock achievements.",
                    style =
                        MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun AchievementCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String,
    unlocked: Boolean
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surface
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Icon(
                imageVector =
                    if (unlocked) {
                        icon
                    } else {
                        Icons.Default.Lock
                    },
                contentDescription = null
            )

            Spacer(
                modifier = Modifier.width(14.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    style =
                        MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = description,
                    style =
                        MaterialTheme.typography.bodySmall,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text =
                    if (unlocked) {
                        "Unlocked"
                    } else {
                        "Locked"
                    },
                style =
                    MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Medium,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
