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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.commerzo.app.ui.theme.CommerzoDimensions

@Composable
fun TestResultScreen(
    total: Int,
    answered: Int,
    correct: Int,
    wrong: Int,
    unattempted: Int,
    marked: Int,
    onRestart: () -> Unit,
    onBackToTests: () -> Unit
) {
    val percentage = if (total > 0) {
        (correct * 100) / total
    } else {
        0
    }

    val accuracy = if (answered > 0) {
        (correct * 100) / answered
    } else {
        0
    }

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
                            text = "Test Result",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Your performance summary",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(innerPadding)
                .padding(
                    horizontal = CommerzoDimensions.ScreenHorizontal,
                    vertical = CommerzoDimensions.Space16
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ResultHeroCard(
                percentage = percentage,
                correct = correct,
                total = total
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space20
                )
            )

            SectionTitle(
                title = "Performance"
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space10
                )
            )

            PerformanceCard(
                answered = answered,
                correct = correct,
                wrong = wrong,
                unattempted = unattempted,
                marked = marked,
                accuracy = accuracy
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space20
                )
            )

            SectionTitle(
                title = "Continue Learning"
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space10
                )
            )

            Button(
                onClick = onRestart,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        CommerzoDimensions.ButtonHeight
                    ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Practice Again",
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            OutlinedButton(
                onClick = onBackToTests,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        CommerzoDimensions.ButtonHeight
                    ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Back to Tests",
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )
        }
    }
}

@Composable
private fun ResultHeroCard(
    percentage: Int,
    correct: Int,
    total: Int
) {
    val message = when {
        percentage >= 90 -> "Excellent work!"
        percentage >= 75 -> "Great progress!"
        percentage >= 50 -> "Good effort!"
        else -> "Keep practicing!"
    }

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
                    vertical = CommerzoDimensions.CardPaddingLarge,
                    horizontal = CommerzoDimensions.CardPaddingLarge
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "TEST COMPLETED",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space16
                )
            )

            androidx.compose.foundation.layout.Box(
                modifier = Modifier.size(116.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    progress = {
                        (percentage / 100f).coerceIn(
                            0f,
                            1f
                        )
                    },
                    modifier = Modifier.fillMaxSize(),
                    strokeWidth = 9.dp,
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.surface.copy(
                        alpha = 0.55f
                    )
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "$percentage%",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                    Text(
                        text = "Score",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space16
                )
            )

            Text(
                text = "$correct / $total correct",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space6
                )
            )

            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun PerformanceCard(
    answered: Int,
    correct: Int,
    wrong: Int,
    unattempted: Int,
    marked: Int,
    accuracy: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
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
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Accuracy",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "$accuracy%",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space10
                )
            )

            LinearProgressIndicator(
                progress = {
                    (accuracy / 100f).coerceIn(
                        0f,
                        1f
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(7.dp)
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            Text(
                text = "$correct correct out of $answered answered",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space16
                )
            )

            PerformanceRow(
                leftTitle = "Correct",
                leftValue = correct,
                rightTitle = "Wrong",
                rightValue = wrong
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            PerformanceRow(
                leftTitle = "Unattempted",
                leftValue = unattempted,
                rightTitle = "Marked",
                rightValue = marked
            )
        }
    }
}

@Composable
private fun PerformanceRow(
    leftTitle: String,
    leftValue: Int,
    rightTitle: String,
    rightValue: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space8
        )
    ) {
        PerformanceStat(
            modifier = Modifier.weight(1f),
            title = leftTitle,
            value = leftValue
        )

        PerformanceStat(
            modifier = Modifier.weight(1f),
            title = rightTitle,
            value = rightValue
        )
    }
}

@Composable
private fun PerformanceStat(
    modifier: Modifier,
    title: String,
    value: Int
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.Space12
                )
        ) {
            Text(
                text = value.toString(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space2
                )
            )

            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun SectionTitle(
    title: String
) {
    Text(
        text = title,
        modifier = Modifier.fillMaxWidth(),
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onBackground
    )
}
