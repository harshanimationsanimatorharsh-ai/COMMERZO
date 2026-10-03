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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.ui.theme.CommerzoDimensions

@Composable
fun GamesScreen() {

    val games = listOf(
        GameItem(
            title = "Math Challenge",
            subtitle = "Fast mathematical problem solving.",
            icon = Icons.Default.Quiz,
            category = "QUICK PLAY"
        ),
        GameItem(
            title = "Equation Game",
            subtitle = "Practice mathematical thinking.",
            icon = Icons.Default.Psychology,
            category = "LOGIC"
        ),
        GameItem(
            title = "Mind Sharp",
            subtitle = "Memory, logic and quick thinking.",
            icon = Icons.Default.Psychology,
            category = "BRAIN"
        ),
        GameItem(
            title = "Puzzle Challenge",
            subtitle = "Solve educational puzzles.",
            icon = Icons.Default.EmojiEvents,
            category = "PUZZLE"
        ),
        GameItem(
            title = "Speed Challenge",
            subtitle = "Answer questions against the clock.",
            icon = Icons.Default.Timer,
            category = "SPEED"
        ),
        GameItem(
            title = "Daily Challenge",
            subtitle = "A new challenge designed for daily practice.",
            icon = Icons.Default.FlashOn,
            category = "DAILY"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Games",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Learn through challenges",
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
            contentPadding = PaddingValues(
                horizontal = CommerzoDimensions.ScreenHorizontal,
                vertical = CommerzoDimensions.ScreenVertical
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.CardSpacing
            )
        ) {

            item {
                GamesHeroCard()
            }

            item {
                SectionHeader(
                    title = "Game Zone",
                    subtitle = "Educational games are being prepared"
                )
            }

            items(
                items = games,
                key = { it.title }
            ) { game ->
                GameCard(
                    game = game
                )
            }

            item {
                GamesComingSoonCard()
            }
        }
    }
}

private data class GameItem(
    val title: String,
    val subtitle: String,
    val icon: ImageVector,
    val category: String
)

@Composable
private fun GamesHeroCard() {
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
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.surface.copy(
                        alpha = 0.78f
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.FlashOn,
                        contentDescription = null,
                        modifier = Modifier.padding(
                            CommerzoDimensions.Space12
                        ),
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
                        text = "GAME ZONE",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space4
                        )
                    )

                    Text(
                        text = "Play. Learn. Improve.",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )

            Text(
                text = "COMMERZO games will turn practice into short, engaging learning challenges.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )

            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.72f
                )
            ) {
                Row(
                    modifier = Modifier.padding(
                        horizontal = CommerzoDimensions.Space12,
                        vertical = CommerzoDimensions.Space10
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Whatshot,
                        contentDescription = null,
                        modifier = Modifier.size(
                            CommerzoDimensions.IconSmall
                        ),
                        tint = MaterialTheme.colorScheme.primary
                    )

                    Spacer(
                        modifier = Modifier.size(
                            CommerzoDimensions.Space8
                        )
                    )

                    Text(
                        text = "Gamification will arrive with the real game engine.",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
private fun GameCard(
    game: GameItem
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
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
                modifier = Modifier.size(50.dp),
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Icon(
                    imageVector = game.icon,
                    contentDescription = null,
                    modifier = Modifier.padding(
                        CommerzoDimensions.Space12
                    ),
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
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
                    text = game.category,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space4
                    )
                )

                Text(
                    text = game.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space4
                    )
                )

                Text(
                    text = game.subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space8
                    )
                )

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Text(
                        text = "Coming soon",
                        modifier = Modifier.padding(
                            horizontal = CommerzoDimensions.Space8,
                            vertical = CommerzoDimensions.Space4
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space8
                )
            )

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun GamesComingSoonCard() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(52.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Psychology,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )

            Text(
                text = "Real Game Engine Coming Soon",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space4
                )
            )

            Text(
                text = "Timed challenges, scores, results, XP and achievements will be connected in the dedicated Games phase.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
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
        modifier = Modifier.padding(
            top = CommerzoDimensions.Space8
        )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space4
            )
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
