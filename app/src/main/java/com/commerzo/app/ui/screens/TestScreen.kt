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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.ui.components.TestQuestionOption
import com.commerzo.app.ui.viewmodel.TestViewModel
import kotlinx.coroutines.delay

@Composable
fun TestScreen(
    subjectId: String,
    chapterId: String,
    onTestFinished: (
        total: Int,
        answered: Int,
        correct: Int,
        wrong: Int,
        unattempted: Int,
        marked: Int
    ) -> Unit,
    onBack: () -> Unit
) {

    val viewModel: TestViewModel = viewModel()

    val questions by viewModel.questions.collectAsState()
    val currentIndex by viewModel.currentIndex.collectAsState()
    val timeRemaining by viewModel.timeRemaining.collectAsState()
    val isFinished by viewModel.isFinished.collectAsState()

    val currentQuestion = questions.getOrNull(currentIndex)

    var showSubmitDialog by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(subjectId, chapterId) {
        viewModel.loadTest(
            subjectId = subjectId,
            chapterId = chapterId
        )
    }

    LaunchedEffect(isFinished) {

        if (!isFinished) {

            while (true) {

                delay(1000)

                viewModel.decreaseTimer()

                if (viewModel.isFinished.value) {
                    break
                }
            }
        }
    }

    LaunchedEffect(isFinished) {

        if (isFinished && questions.isNotEmpty()) {

            onTestFinished(
                questions.size,
                viewModel.getAnsweredCount(),
                viewModel.getCorrectCount(),
                viewModel.getWrongCount(),
                viewModel.getUnattemptedCount(),
                viewModel.getMarkedCount()
            )
        }
    }

    if (currentQuestion == null || isFinished) {
        return
    }

    if (showSubmitDialog) {

        AlertDialog(
            onDismissRequest = {
                showSubmitDialog = false
            },
            title = {
                Text("Submit Test?")
            },
            text = {
                Text(
                    "Are you sure you want to submit this test?"
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        showSubmitDialog = false
                        viewModel.finishTest()
                    }
                ) {
                    Text("Submit")
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = {
                        showSubmitDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }

    val minutes = timeRemaining / 60
    val seconds = timeRemaining % 60

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Question ${currentIndex + 1}/${questions.size}",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "%02d:%02d".format(
                    minutes,
                    seconds
                ),
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Answered: ${viewModel.getAnsweredCount()}",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                Text(
                    text = currentQuestion.question,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                currentQuestion.options.forEachIndexed { index, option ->

                    TestQuestionOption(
                        text = option,
                        selected =
                            viewModel.getSelectedAnswer(
                                currentIndex
                            ) == index,
                        onClick = {
                            viewModel.selectAnswer(index)
                        }
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            OutlinedButton(
                onClick = {
                    viewModel.previousQuestion()
                },
                enabled = currentIndex > 0,
                modifier = Modifier.weight(1f)
            ) {
                Text("Previous")
            }

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            OutlinedButton(
                onClick = {
                    viewModel.toggleMarkForReview()
                },
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    if (viewModel.isCurrentQuestionMarked()) {
                        "Unmark"
                    } else {
                        "Mark Review"
                    }
                )
            }
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Button(
                onClick = {
                    viewModel.nextQuestion()
                },
                enabled = currentIndex < questions.lastIndex,
                modifier = Modifier.weight(1f)
            ) {
                Text("Next")
            }

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Button(
                onClick = {
                    showSubmitDialog = true
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Submit")
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Exit Test")
        }
    }
}
