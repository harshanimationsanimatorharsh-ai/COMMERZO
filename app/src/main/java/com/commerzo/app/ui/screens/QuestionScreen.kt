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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.ui.components.AnswerOption
import com.commerzo.app.ui.viewmodel.QuestionViewModel

@Composable
fun QuestionScreen(
    subjectId: String,
    chapterId: String,
    onBack: () -> Unit,
    questionViewModel: QuestionViewModel = viewModel()
) {

    val questions by questionViewModel.questions.collectAsState()
    val currentIndex by questionViewModel.currentQuestionIndex.collectAsState()
    val selectedAnswer by questionViewModel.selectedAnswer.collectAsState()
    val isSubmitted by questionViewModel.isSubmitted.collectAsState()
    val score by questionViewModel.score.collectAsState()

    LaunchedEffect(subjectId, chapterId) {

        questionViewModel.loadQuestions(
            subjectId = subjectId,
            chapterId = chapterId
        )
    }

    if (questions.isEmpty()) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Practice")
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(20.dp)
            ) {

                Text(
                    text = "No questions available yet.",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        return
    }

    val currentQuestion = questions[currentIndex]

    val progress =
        (currentIndex + 1).toFloat() / questions.size.toFloat()

    val isLastQuestion =
        currentIndex == questions.lastIndex

    Scaffold(
        topBar = {

            TopAppBar(

                title = {
                    Text("Practice")
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
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Question ${currentIndex + 1}/${questions.size}",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "Score: $score",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(18.dp)
                )

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor =
                            MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {

                    Text(
                        text = currentQuestion.question,
                        modifier = Modifier.padding(18.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                Spacer(
                    modifier = Modifier.height(8.dp)
                )
            }

            itemsIndexed(
                items = currentQuestion.options
            ) { index, option ->

                AnswerOption(
                    index = index,
                    text = option,
                    isSelected = selectedAnswer == index,
                    isCorrect =
                        isSubmitted &&
                        index == currentQuestion.correctAnswer,
                    isWrong =
                        isSubmitted &&
                        selectedAnswer == index &&
                        index != currentQuestion.correctAnswer,
                    enabled = !isSubmitted,
                    onClick = {
                        questionViewModel.selectAnswer(index)
                    }
                )
            }

            item {

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                if (!isSubmitted) {

                    Button(
                        onClick = {
                            questionViewModel.submitAnswer()
                        },
                        enabled = selectedAnswer != null,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text("Submit Answer")
                    }

                } else {

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor =
                                if (
                                    selectedAnswer ==
                                    currentQuestion.correctAnswer
                                ) {
                                    MaterialTheme.colorScheme
                                        .primaryContainer
                                } else {
                                    MaterialTheme.colorScheme
                                        .errorContainer
                                }
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text =
                                    if (
                                        selectedAnswer ==
                                        currentQuestion.correctAnswer
                                    ) {
                                        "✓ Correct Answer"
                                    } else {
                                        "✗ Wrong Answer"
                                    },
                                style =
                                    MaterialTheme.typography.titleMedium
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text =
                                    "Explanation: ${currentQuestion.explanation}",
                                style =
                                    MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Button(
                        onClick = {

                            if (isLastQuestion) {
                                questionViewModel.restart()
                            } else {
                                questionViewModel.nextQuestion()
                            }

                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text(
                            text =
                                if (isLastQuestion) {
                                    "Restart Practice"
                                } else {
                                    "Next Question"
                                }
                        )
                    }

                    if (isLastQuestion) {

                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )

                        Text(
                            text = "Final Score: $score/${questions.size}",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(24.dp)
                )
            }
        }
    }
}
