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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    onBack: () -> Unit,
    testViewModel: TestViewModel =
        viewModel()
) {

    val questions by
        testViewModel.questions.collectAsState()

    val currentIndex by
        testViewModel.currentIndex.collectAsState()

    val remainingSeconds by
        testViewModel.remainingSeconds.collectAsState()

    val isFinished by
        testViewModel.isFinished.collectAsState()

    LaunchedEffect(subjectId, chapterId) {

        testViewModel.loadTest(
            subjectId = subjectId,
            chapterId = chapterId
        )
    }

    LaunchedEffect(isFinished) {

        while (!isFinished) {

            delay(1000)

            testViewModel.decreaseTimer()
        }
    }

    if (questions.isEmpty()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text(
                text = "No questions available."
            )
        }

        return
    }

    if (isFinished) {

        TestFinishedView(
            total = questions.size,
            answered =
                testViewModel.getAnsweredCount(),
            correct =
                testViewModel.getCorrectCount(),
            wrong =
                testViewModel.getWrongCount(),
            unattempted =
                testViewModel.getUnattemptedCount(),
            marked =
                testViewModel.getMarkedCount(),
            onRestart = {
                testViewModel.restartTest()
            },
            onBack = onBack
        )

        return
    }

    val current =
        questions[currentIndex]

    val minutes =
        remainingSeconds / 60

    val seconds =
        remainingSeconds % 60

    val timerText =
        String.format(
            "%02d:%02d",
            minutes,
            seconds
        )

    val progress =
        (currentIndex + 1).toFloat() /
            questions.size.toFloat()

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text("Test")
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

                actions = {

                    Text(
                        text = timerText,
                        style =
                            MaterialTheme
                                .typography
                                .titleMedium,

                        modifier =
                            Modifier.padding(
                                end = 16.dp
                            )
                    )
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
                    modifier =
                        Modifier.height(8.dp)
                )

                Row(
                    modifier =
                        Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceBetween
                ) {

                    Text(
                        text =
                            "Question ${currentIndex + 1}/50",
                        style =
                            MaterialTheme
                                .typography
                                .titleMedium
                    )

                    Text(
                        text =
                            "Answered ${
                                testViewModel
                                    .getAnsweredCount()
                            }",
                        style =
                            MaterialTheme
                                .typography
                                .bodyMedium
                    )
                }

                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )

                LinearProgressIndicator(
                    progress = {
                        progress
                    },
                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(16.dp)
                )

                Card(
                    modifier =
                        Modifier.fillMaxWidth(),

                    colors =
                        CardDefaults.cardColors(
                            containerColor =
                                MaterialTheme
                                    .colorScheme
                                    .surfaceVariant
                        )
                ) {

                    Text(
                        text =
                            current.question.question,

                        modifier =
                            Modifier.padding(18.dp),

                        style =
                            MaterialTheme
                                .typography
                                .titleLarge
                    )
                }

                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )
            }

            itemsIndexed(
                items =
                    current.question.options
            ) { index, option ->

                TestQuestionOption(

                    index = index,

                    text = option,

                    selected =
                        current.selectedAnswer ==
                            index,

                    onClick = {

                        testViewModel
                            .selectAnswer(index)
                    }
                )
            }

            item {

                Row(
                    modifier =
                        Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceBetween
                ) {

                    TextButton(
                        onClick = {
                            testViewModel
                                .previousQuestion()
                        },
                        enabled =
                            currentIndex > 0
                    ) {

                        Text("Previous")
                    }

                    TextButton(
                        onClick = {
                            testViewModel
                                .toggleMarkForReview()
                        }
                    ) {

                        Icon(
                            imageVector =
                                Icons.Default.Flag,
                            contentDescription =
                                "Mark for review"
                        )

                        Text(
                            text =
                                if (
                                    current.markedForReview
                                ) {
                                    "Marked"
                                } else {
                                    " Review"
                                }
                        )
                    }

                    TextButton(
                        onClick = {
                            testViewModel
                                .nextQuestion()
                        },
                        enabled =
                            currentIndex <
                                questions.lastIndex
                    ) {

                        Text("Next")
                    }
                }

                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )

                Button(
                    onClick = {
                        testViewModel.finishTest()
                    },
                    modifier =
                        Modifier.fillMaxWidth()
                ) {

                    Text("Submit Test")
                }

                Spacer(
                    modifier =
                        Modifier.height(24.dp)
                )
            }
        }
    }
}

@Composable
private fun TestFinishedView(
    total: Int,
    answered: Int,
    correct: Int,
    wrong: Int,
    unattempted: Int,
    marked: Int,
    onRestart: () -> Unit,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement =
            Arrangement.Center
    ) {

        Text(
            text = "Test Submitted 🎉",
            style =
                MaterialTheme.typography
                    .headlineMedium
        )

        Spacer(
            modifier =
                Modifier.height(20.dp)
        )

        Card(
            modifier =
                Modifier.fillMaxWidth(),

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
                    Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Total Questions: $total"
                )

                Text(
                    text = "Answered: $answered"
                )

                Text(
                    text = "Correct: $correct"
                )

                Text(
                    text = "Wrong: $wrong"
                )

                Text(
                    text = "Unattempted: $unattempted"
                )

                Text(
                    text = "Marked for Review: $marked"
                )
            }
        }

        Spacer(
            modifier =
                Modifier.height(20.dp)
        )

        Button(
            onClick = onRestart,
            modifier =
                Modifier.fillMaxWidth()
        ) {

            Text("Restart Test")
        }

        Spacer(
            modifier =
                Modifier.height(10.dp)
        )

        Button(
            onClick = onBack,
            modifier =
                Modifier.fillMaxWidth()
        ) {

            Text("Back")
        }
    }
}
