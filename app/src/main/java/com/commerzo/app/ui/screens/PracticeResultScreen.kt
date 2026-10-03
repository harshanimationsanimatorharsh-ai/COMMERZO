package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.dp
import com.commerzo.app.ui.theme.CommerzoDimensions

@Composable
fun PracticeResultScreen(
    totalQuestions: Int,
    correctAnswers: Int,
    wrongAnswers: Int,
    unattemptedAnswers: Int,
    onRestart: () -> Unit,
    onBackToChapters: () -> Unit
) {

    val percentage =
        if (totalQuestions > 0) {
            (correctAnswers * 100) / totalQuestions
        } else {
            0
        }

    val answeredQuestions =
        correctAnswers + wrongAnswers

    val accuracy =
        if (answeredQuestions > 0) {
            (correctAnswers * 100) / answeredQuestions
        } else {
            0
        }

    val resultMessage = when {
        percentage >= 90 -> "Excellent practice session!"
        percentage >= 75 -> "Great work! Keep it going."
        percentage >= 50 -> "Good effort. Keep practicing."
        else -> "Keep practicing. Improvement comes with consistency."
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Practice Result",
                        style = MaterialTheme.typography.titleLarge
                    )
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
                    vertical = CommerzoDimensions.ScreenVertical
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ResultHeroCard(
                percentage = percentage,
                correctAnswers = correctAnswers,
                totalQuestions = totalQuestions,
                message = resultMessage
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.SectionSpacing
                )
            )

            SectionTitle(
                title = "Performance"
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )

            PerformanceCard(
                answeredQuestions = answeredQuestions,
                accuracy = accuracy,
                correctAnswers = correctAnswers,
                wrongAnswers = wrongAnswers,
                unattemptedAnswers = unattemptedAnswers
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.SectionSpacing
                )
            )

            SectionTitle(
                title = "Continue Learning"
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )

            Button(
                onClick = onRestart,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        CommerzoDimensions.ButtonHeight
                    )
            ) {
                Text("Restart Practice")
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            OutlinedButton(
                onClick = onBackToChapters,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        CommerzoDimensions.ButtonHeight
                    )
            ) {
                Text("Back to Chapters")
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space16
                )
            )
        }
    }
}

@Composable
private fun ResultHeroCard(
    percentage: Int,
    correctAnswers: Int,
    totalQuestions: Int,
    message: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.primaryContainer
        ),
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Practice Complete",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            Text(
                text = "$percentage%",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space4
                )
            )

            Text(
                text = "$correctAnswers / $totalQuestions correct",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
private fun PerformanceCard(
    answeredQuestions: Int,
    accuracy: Int,
    correctAnswers: Int,
    wrongAnswers: Int,
    unattemptedAnswers: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPadding
                )
        ) {

            Text(
                text = "Accuracy",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            LinearProgressIndicator(
                progress = {
                    (accuracy / 100f).coerceIn(0f, 1f)
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            Text(
                text =
                    "$accuracy% accuracy across " +
                        "$answeredQuestions answered questions",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space16
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.spacedBy(
                        CommerzoDimensions.Space8
                    )
            ) {
                ResultStat(
                    modifier = Modifier.weight(1f),
                    title = "Correct",
                    value = correctAnswers
                )

                ResultStat(
                    modifier = Modifier.weight(1f),
                    title = "Wrong",
                    value = wrongAnswers
                )
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            ResultStat(
                modifier = Modifier.fillMaxWidth(),
                title = "Skipped",
                value = unattemptedAnswers
            )
        }
    }
}

@Composable
private fun ResultStat(
    modifier: Modifier,
    title: String,
    value: Int
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surfaceVariant
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
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space2
                )
            )

            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
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
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.onBackground
    )
}
