package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Practice Complete 🎉",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Your final result",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme.primaryContainer
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "$correctAnswers / $totalQuestions",
                    style = MaterialTheme.typography.displaySmall
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "$percentage%",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            ResultStat(
                modifier = Modifier.weight(1f),
                title = "Correct",
                value = correctAnswers.toString()
            )

            ResultStat(
                modifier = Modifier.weight(1f),
                title = "Wrong",
                value = wrongAnswers.toString()
            )

            ResultStat(
                modifier = Modifier.weight(1f),
                title = "Skipped",
                value = unattemptedAnswers.toString()
            )
        }

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        Button(
            onClick = onRestart,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Restart Practice")
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Button(
            onClick = onBackToChapters,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Chapters")
        }
    }
}

@Composable
private fun ResultStat(
    modifier: Modifier,
    title: String,
    value: String
) {

    Card(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
