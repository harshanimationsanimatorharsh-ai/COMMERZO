package com.commerzo.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.content.CurriculumContentIds
import com.commerzo.app.ui.theme.CommerzoDimensions
import com.commerzo.app.ui.viewmodel.PracticeSessionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionScreen(
    subjectId: String,
    chapterId: String,
    board: Board = Board.MP_BOARD,
    classLevel: ClassLevel = ClassLevel.CLASS_12,
    onBack: () -> Unit,
    viewModel: PracticeSessionViewModel = viewModel()
) {
    val questions by viewModel.questions.collectAsState()
    val currentIndex by viewModel.currentIndex.collectAsState()
    val selectedAnswer by viewModel.selectedAnswer.collectAsState()
    val submitted by viewModel.submitted.collectAsState()
    val correctAnswers by viewModel.correctAnswers.collectAsState()
    val wrongAnswers by viewModel.wrongAnswers.collectAsState()
    val answeredQuestions by viewModel.answeredQuestions.collectAsState()
    val isFinished by viewModel.isFinished.collectAsState()
    val progressPercent by viewModel.progressPercent.collectAsState()

    /*
     * Content architecture uses stable Economics IDs.
     * The existing question system still uses the legacy
     * "economics" subject ID.
     */
    val questionSubjectId = remember(subjectId) {
        when (subjectId) {
            CurriculumContentIds.MP_BOARD_CLASS_12_ECONOMICS_MICRO,
            CurriculumContentIds.MP_BOARD_CLASS_12_ECONOMICS_MACRO,
            CurriculumContentIds.CBSE_CLASS_12_ECONOMICS_INDIAN,
            CurriculumContentIds.CBSE_CLASS_12_ECONOMICS_MACRO -> {
                "economics"
            }

            else -> subjectId
        }
    }

    LaunchedEffect(
        questionSubjectId,
        chapterId,
        board,
        classLevel
    ) {
        viewModel.loadQuestions(
            subjectId = questionSubjectId,
            chapterId = chapterId,
            board = board,
            classLevel = classLevel
        )
    }

    val currentQuestion = questions.getOrNull(currentIndex)
    val totalQuestions = questions.size
    val isCurrentBookmarked = viewModel.isCurrentQuestionBookmarked()

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
                            text = "Practice",
                            fontWeight = FontWeight.ExtraBold
                        )

                        if (currentQuestion != null) {
                            Text(
                                text = "Question ${currentIndex + 1} of $totalQuestions",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    if (currentQuestion != null) {
                        IconButton(
                            onClick = {
                                viewModel.toggleBookmark()
                            }
                        ) {
                            Icon(
                                imageVector = if (isCurrentBookmarked) {
                                    Icons.Default.Bookmark
                                } else {
                                    Icons.Default.BookmarkBorder
                                },
                                contentDescription = if (isCurrentBookmarked) {
                                    "Remove bookmark"
                                } else {
                                    "Bookmark question"
                                }
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            when {
                isFinished -> {
                    PracticeResultContent(
                        totalQuestions = totalQuestions,
                        answeredQuestions = answeredQuestions.size,
                        correctAnswers = correctAnswers,
                        wrongAnswers = wrongAnswers,
                        progressPercent = progressPercent,
                        onRestart = viewModel::restart,
                        onBack = onBack
                    )
                }

                currentQuestion == null -> {
                    EmptyQuestionState(
                        onBack = onBack
                    )
                }

                else -> {
                    QuestionContent(
                        currentIndex = currentIndex,
                        totalQuestions = totalQuestions,
                        selectedAnswer = selectedAnswer,
                        submitted = submitted,
                        answeredCount = answeredQuestions.size,
                        progressPercent = progressPercent,
                        isCurrentBookmarked = isCurrentBookmarked,
                        currentQuestion = currentQuestion,
                        onSelectAnswer = viewModel::selectAnswer,
                        onPrevious = viewModel::previousQuestion,
                        onSkip = viewModel::skipQuestion,
                        onSubmit = viewModel::submitAnswer,
                        onNext = viewModel::nextQuestion
                    )
                }
            }
        }
    }
}

@Composable
private fun QuestionContent(
    currentIndex: Int,
    totalQuestions: Int,
    selectedAnswer: Int?,
    submitted: Boolean,
    answeredCount: Int,
    progressPercent: Int,
    isCurrentBookmarked: Boolean,
    currentQuestion: com.commerzo.app.data.model.Question,
    onSelectAnswer: (Int) -> Unit,
    onPrevious: () -> Unit,
    onSkip: () -> Unit,
    onSubmit: () -> Unit,
    onNext: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = CommerzoDimensions.ScreenHorizontal
            )
    ) {
        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space12
            )
        )

        QuestionProgressHeader(
            currentIndex = currentIndex,
            totalQuestions = totalQuestions,
            answeredCount = answeredCount,
            progressPercent = progressPercent
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space16
            )
        )

        QuestionCard(
            questionText = currentQuestion.question,
            isBookmarked = isCurrentBookmarked
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space16
            )
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space8
            )
        ) {
            currentQuestion.options.forEachIndexed { index, option ->
                val isSelected = selectedAnswer == index
                val isCorrect = submitted &&
                    index == currentQuestion.correctAnswer

                val isWrong = submitted &&
                    isSelected &&
                    index != currentQuestion.correctAnswer

                OptionCard(
                    optionIndex = index,
                    optionText = option,
                    isSelected = isSelected,
                    isCorrect = isCorrect,
                    isWrong = isWrong,
                    enabled = !submitted,
                    onClick = {
                        onSelectAnswer(index)
                    }
                )
            }

            if (submitted) {
                AnswerExplanationCard(
                    selectedAnswer = selectedAnswer,
                    correctAnswer = currentQuestion.correctAnswer,
                    explanation = currentQuestion.explanation
                )
            }
        }

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        QuestionBottomActions(
            currentIndex = currentIndex,
            totalQuestions = totalQuestions,
            submitted = submitted,
            selectedAnswer = selectedAnswer,
            onPrevious = onPrevious,
            onSkip = onSkip,
            onSubmit = onSubmit,
            onNext = onNext
        )
    }
}

@Composable
private fun QuestionProgressHeader(
    currentIndex: Int,
    totalQuestions: Int,
    answeredCount: Int,
    progressPercent: Int
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space8
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Text(
                    text = "${currentIndex + 1} / $totalQuestions",
                    modifier = Modifier.padding(
                        horizontal = CommerzoDimensions.Space12,
                        vertical = CommerzoDimensions.Space6
                    ),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Text(
                text = "$answeredCount answered",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        LinearProgressIndicator(
            progress = {
                if (totalQuestions > 0) {
                    progressPercent / 100f
                } else {
                    0f
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
        )

        Text(
            text = "$progressPercent% completed",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun QuestionCard(
    questionText: String,
    isBookmarked: Boolean
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
            modifier = Modifier.padding(
                CommerzoDimensions.CardPaddingLarge
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space12
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "Question",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )

                if (isBookmarked) {
                    Icon(
                        imageVector = Icons.Default.Bookmark,
                        contentDescription = "Bookmarked",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(
                            CommerzoDimensions.IconMedium
                        )
                    )
                }
            }

            Text(
                text = questionText,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun AnswerExplanationCard(
    selectedAnswer: Int?,
    correctAnswer: Int,
    explanation: String
) {
    val isCorrect = selectedAnswer == correctAnswer

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isCorrect) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.errorContainer
            }
        )
    ) {
        Column(
            modifier = Modifier.padding(
                CommerzoDimensions.CardPadding
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space8
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = if (isCorrect) {
                        Icons.Default.Check
                    } else {
                        Icons.Default.Lightbulb
                    },
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.width(
                        CommerzoDimensions.Space8
                    )
                )

                Text(
                    text = if (isCorrect) {
                        "Correct answer!"
                    } else {
                        "Correct answer: ${optionLetter(correctAnswer)}"
                    },
                    fontWeight = FontWeight.ExtraBold
                )
            }

            if (explanation.isNotBlank()) {
                Text(
                    text = explanation,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun QuestionBottomActions(
    currentIndex: Int,
    totalQuestions: Int,
    submitted: Boolean,
    selectedAnswer: Int?,
    onPrevious: () -> Unit,
    onSkip: () -> Unit,
    onSubmit: () -> Unit,
    onNext: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = CommerzoDimensions.Space8
            ),
        horizontalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space8
        )
    ) {
        OutlinedButton(
            onClick = onPrevious,
            enabled = currentIndex > 0,
            modifier = Modifier.weight(1f),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                horizontal = CommerzoDimensions.Space8
            )
        ) {
            Icon(
                imageVector = Icons.Default.NavigateBefore,
                contentDescription = "Previous"
            )

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space4
                )
            )

            Text("Previous")
        }

        OutlinedButton(
            onClick = onSkip,
            enabled = !submitted,
            modifier = Modifier.weight(1f),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                horizontal = CommerzoDimensions.Space8
            )
        ) {
            Text("Skip")
        }

        Button(
            onClick = {
                if (!submitted) {
                    onSubmit()
                } else {
                    onNext()
                }
            },
            enabled = if (submitted) {
                true
            } else {
                selectedAnswer != null
            },
            modifier = Modifier.weight(1f),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                horizontal = CommerzoDimensions.Space8
            )
        ) {
            Text(
                text = when {
                    !submitted -> "Check Answer"
                    currentIndex == totalQuestions - 1 -> "Finish"
                    else -> "Next"
                }
            )

            if (submitted) {
                Spacer(
                    modifier = Modifier.width(
                        CommerzoDimensions.Space4
                    )
                )

                Icon(
                    imageVector = Icons.Default.NavigateNext,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
private fun EmptyQuestionState(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                CommerzoDimensions.ScreenHorizontal
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "No questions available",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        Text(
            text = "This chapter does not have a valid question bank yet.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space24
            )
        )

        Button(onClick = onBack) {
            Text("Go Back")
        }
    }
}

@Composable
private fun OptionCard(
    optionIndex: Int,
    optionText: String,
    isSelected: Boolean,
    isCorrect: Boolean,
    isWrong: Boolean,
    enabled: Boolean,
    onClick: () -> Unit
) {
    val containerColor = when {
        isCorrect -> Color(0xFF1B5E20)
        isWrong -> Color(0xFFB71C1C)
        isSelected -> MaterialTheme.colorScheme.primaryContainer
        else -> MaterialTheme.colorScheme.surface
    }

    val contentColor = when {
        isCorrect || isWrong -> Color.White
        else -> MaterialTheme.colorScheme.onSurface
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isSelected) 3.dp else 1.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = CommerzoDimensions.CardPadding,
                    vertical = CommerzoDimensions.Space12
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(40.dp),
                shape = RoundedCornerShape(12.dp),
                color = if (isCorrect || isWrong) {
                    Color.White.copy(alpha = 0.16f)
                } else {
                    MaterialTheme.colorScheme.primaryContainer
                }
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = optionLetter(optionIndex),
                        fontWeight = FontWeight.ExtraBold,
                        color = if (isCorrect || isWrong) {
                            Color.White
                        } else {
                            MaterialTheme.colorScheme.primary
                        }
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space12
                )
            )

            Text(
                text = optionText,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge
            )

            if (isCorrect) {
                Spacer(
                    modifier = Modifier.width(
                        CommerzoDimensions.Space8
                    )
                )

                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Correct"
                )
            }

            if (isWrong) {
                Spacer(
                    modifier = Modifier.width(
                        CommerzoDimensions.Space8
                    )
                )

                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Wrong"
                )
            }
        }
    }
}

@Composable
private fun PracticeResultContent(
    totalQuestions: Int,
    answeredQuestions: Int,
    correctAnswers: Int,
    wrongAnswers: Int,
    progressPercent: Int,
    onRestart: () -> Unit,
    onBack: () -> Unit
) {
    val percentage = if (totalQuestions > 0) {
        (correctAnswers * 100) / totalQuestions
    } else {
        0
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                CommerzoDimensions.ScreenHorizontal
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            progress = {
                percentage / 100f
            },
            modifier = Modifier.size(96.dp),
            strokeWidth = 8.dp
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space20
            )
        )

        Text(
            text = "Practice Complete",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        Text(
            text = "$percentage%",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space4
            )
        )

        Text(
            text = "$progressPercent% questions attempted",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space20
            )
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier.padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space8
                )
            ) {
                Text(
                    text = "Practice Summary",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                SummaryRow("Total questions", totalQuestions.toString())
                SummaryRow("Answered", answeredQuestions.toString())
                SummaryRow("Correct", correctAnswers.toString())
                SummaryRow("Wrong", wrongAnswers.toString())
                SummaryRow(
                    "Unattempted",
                    (totalQuestions - answeredQuestions).toString()
                )
            }
        }

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space24
            )
        )

        Button(
            onClick = onRestart,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Practice Again")
        }

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

@Composable
private fun SummaryRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = value,
            fontWeight = FontWeight.Bold
        )
    }
}

private fun optionLetter(index: Int): String {
    return when (index) {
        0 -> "A"
        1 -> "B"
        2 -> "C"
        3 -> "D"
        else -> "?"
    }
}
