package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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

    val percentage =
        if (total > 0) {
            (correct * 100) / total
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
            text = "Test Completed 🎉",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "$correct / $total",
            style = MaterialTheme.typography.displaySmall
        )

        Text(
            text = "$percentage% Score",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                Text("Answered: $answered")

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text("Correct: $correct")

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text("Wrong: $wrong")

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text("Unattempted: $unattempted")

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text("Marked for Review: $marked")
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = onRestart,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Restart Test")
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Button(
            onClick = onBackToTests,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Tests")
        }
    }
}
