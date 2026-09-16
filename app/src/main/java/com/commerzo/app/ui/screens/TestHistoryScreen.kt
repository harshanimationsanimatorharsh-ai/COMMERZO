package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.ui.viewmodel.TestHistoryViewModel

@Composable
fun TestHistoryScreen(
    viewModel: TestHistoryViewModel = viewModel()
) {

    val history by viewModel.history.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Test History",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =
                Arrangement.SpaceBetween
        ) {

            HistoryStat(
                title = "Tests",
                value =
                    viewModel.getTotalTests().toString()
            )

            HistoryStat(
                title = "Best",
                value =
                    "${viewModel.getBestScore()}%"
            )

            HistoryStat(
                title = "Average",
                value =
                    "${viewModel.getAverageScore()}%"
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        if (history.isEmpty()) {

            Text(
                text =
                    "No tests attempted yet.",
                style =
                    MaterialTheme.typography.bodyLarge
            )

        } else {

            LazyColumn(
                verticalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {

                items(history) { test ->

                    Card(
                        modifier =
                            Modifier.fillMaxWidth()
                    ) {

                        Column(
                            modifier =
                                Modifier.padding(16.dp)
                        ) {

                            Text(
                                text =
                                    test.subjectId
                                        .replaceFirstChar {
                                            it.uppercase()
                                        },

                                style =
                                    MaterialTheme
                                        .typography
                                        .titleMedium
                            )

                            Spacer(
                                modifier =
                                    Modifier.height(6.dp)
                            )

                            Text(
                                text =
                                    "Score: ${test.correct}/${test.totalQuestions}"
                            )

                            Text(
                                text =
                                    "Percentage: ${test.percentage}%"
                            )

                            Text(
                                text =
                                    "Answered: ${test.answered}"
                            )

                            Text(
                                text =
                                    "Wrong: ${test.wrong}"
                            )

                            Text(
                                text =
                                    "Unattempted: ${test.unattempted}"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun HistoryStat(
    title: String,
    value: String
) {

    Column {

        Text(
            text = value,
            style =
                MaterialTheme.typography.titleLarge
        )

        Text(
            text = title,
            style =
                MaterialTheme.typography.bodySmall
        )
    }
}
