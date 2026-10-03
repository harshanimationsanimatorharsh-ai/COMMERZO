package com.commerzo.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.verticalScroll
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.repository.TestHistoryRepository
import com.commerzo.app.ui.components.TestQuestionOption
import com.commerzo.app.ui.theme.CommerzoDimensions
import com.commerzo.app.ui.viewmodel.TestViewModel
import kotlinx.coroutines.delay

@Composable
fun TestScreen(
    subjectId: String,
    chapterId: String,
    board: Board = Board.MP_BOARD,
    classLevel: ClassLevel = ClassLevel.CLASS_12,
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
    val context = androidx.compose.ui.platform.LocalContext.current
    val viewModel: TestViewModel = viewModel()

    val questions by viewModel.questions.collectAsState()
    val currentIndex by viewModel.currentIndex.collectAsState()
    val timeRemaining by viewModel.timeRemaining.collectAsState()
    val isFinished by viewModel.isFinished.collectAsState()

    var showSubmitDialog by remember {
        mutableStateOf(false)
    }

    val currentState = questions.getOrNull(currentIndex)
    val currentQuestion = currentState?.question

    LaunchedEffect(Unit) {
        TestHistoryRepository.initialize(context)
    }

    LaunchedEffect(
        subjectId,
        chapterId,
        board,
        classLevel
    ) {
        viewModel.loadTest(
            subjectId = subjectId,
            chapterId = chapterId,
            board = board,
            classLevel = classLevel
        )
    }

    LaunchedEffect(isFinished) {
        if (!isFinished) {
            while (true) {
                delay(1000)

                if (viewModel.isFinished.value) {
                    break
                }

                viewModel.decreaseTimer()
            }
        }
    }

    LaunchedEffect(isFinished) {
        if (isFinished && questions.isNotEmpty()) {
            val total = viewModel.getTotalQuestions()
            val answered = viewModel.getAnsweredCount()
            val correct = viewModel.getCorrectCount()
            val wrong = viewModel.getWrongCount()
            val unattempted = viewModel.getUnattemptedCount()
            val marked = viewModel.getMarkedCount()

            TestHistoryRepository.saveTest(
                context = context,
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                totalQuestions = total,
                answered = answered,
                correct = correct,
                wrong = wrong,
                unattempted = unattempted,
                marked = marked
            )

            onTestFinished(
                total,
                answered,
                correct,
                wrong,
                unattempted,
                marked
            )
        }
    }

    if (questions.isEmpty() && !isFinished) {
        TestEmptyState(
            onBack = onBack
        )
        return
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
                Text(
                    text = "Submit Test?",
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = "Your current answers will be evaluated and the test will be completed."
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
                TextButton(
                    onClick = {
                        showSubmitDialog = false
                    }
                ) {
                    Text("Continue")
                }
            }
        )
    }

    val minutes = timeRemaining / 60
    val seconds = timeRemaining % 60

    val answeredCount = viewModel.getAnsweredCount()
    val markedCount = viewModel.getMarkedCount()

    val progress = if (questions.isNotEmpty()) {
        ((currentIndex + 1).toFloat() / questions.size.toFloat())
            .coerceIn(0f, 1f)
    } else {
        0f
    }

    val isMarked = viewModel.isCurrentQuestionMarked()
    val selectedAnswer = viewModel.getSelectedAnswer(currentIndex)

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            CommerzoDimensions.Space2
                        )
                    ) {
                        Text(
                            text = "Test",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )

                        Text(
                            text = "Question ${currentIndex + 1} of ${questions.size}",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1
                        )
                    }
                },
                actions = {
                    TestTimerBadge(
                        timeRemaining = timeRemaining,
                        minutes = minutes,
                        seconds = seconds
                    )

                    TextButton(
                        onClick = {
                            showSubmitDialog = true
                        }
                    ) {
                        Text(
                            text = "Submit",
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
                .navigationBarsPadding()
        ) {
            LinearProgressIndicator(
                progress = {
                    progress
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(
                        rememberScrollState()
                    )
                    .padding(
                        horizontal = CommerzoDimensions.ScreenHorizontal,
                        vertical = CommerzoDimensions.Space16
                    )
            ) {
                TestProgressSummary(
                    answeredCount = answeredCount,
                    totalQuestions = questions.size,
                    marked = markedCount
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space16
                    )
                )

                TestQuestionCard(
                    questionNumber = currentIndex + 1,
                    questionText = currentQuestion.question,
                    isMarked = isMarked,
                    onToggleMark = {
                        viewModel.toggleMarkForReview()
                    }
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space16
                    )
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        CommerzoDimensions.Space10
                    )
                ) {
                    currentQuestion.options.forEachIndexed { index, option ->
                        TestQuestionOption(
                            index = index,
                            text = option,
                            selected = selectedAnswer == index,
                            onClick = {
                                viewModel.selectAnswer(index)
                            }
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space20
                    )
                )

                TestNavigationActions(
                    currentIndex = currentIndex,
                    totalQuestions = questions.size,
                    onPrevious = {
                        viewModel.previousQuestion()
                    },
                    onNext = {
                        if (currentIndex < questions.lastIndex) {
                            viewModel.nextQuestion()
                        } else {
                            showSubmitDialog = true
                        }
                    }
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space8
                    )
                )

                Text(
                    text = if (isMarked) {
                        "Marked for review"
                    } else {
                        "You can mark this question for review"
                    },
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space12
                    )
                )
            }
        }
    }
}

@Composable
private fun TestTimerBadge(
    timeRemaining: Int,
    minutes: Int,
    seconds: Int
) {
    val timerColor = if (timeRemaining <= 60) {
        MaterialTheme.colorScheme.error
    } else {
        MaterialTheme.colorScheme.primary
    }

    Surface(
        shape = RoundedCornerShape(12.dp),
        color = timerColor.copy(alpha = 0.10f),
        contentColor = timerColor
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = CommerzoDimensions.Space10,
                vertical = CommerzoDimensions.Space8
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Timer,
                contentDescription = "Time remaining",
                modifier = Modifier.size(18.dp)
            )

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space6
                )
            )

            Text(
                text = "%02d:%02d".format(
                    minutes,
                    seconds
                ),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun TestQuestionCard(
    questionNumber: Int,
    questionText: String,
    isMarked: Boolean,
    onToggleMark: () -> Unit
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
                CommerzoDimensions.Space14
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        text = "QUESTION $questionNumber",
                        modifier = Modifier.padding(
                            horizontal = CommerzoDimensions.Space10,
                            vertical = CommerzoDimensions.Space6
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }

                IconButton(
                    onClick = onToggleMark
                ) {
                    Icon(
                        imageVector = Icons.Default.Flag,
                        contentDescription = if (isMarked) {
                            "Remove review mark"
                        } else {
                            "Mark for review"
                        },
                        tint = if (isMarked) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        }
                    )
                }
            }

            Text(
                text = questionText,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            if (isMarked) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Row(
                        modifier = Modifier.padding(
                            horizontal = CommerzoDimensions.Space10,
                            vertical = CommerzoDimensions.Space6
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Flag,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )

                        Spacer(
                            modifier = Modifier.width(
                                CommerzoDimensions.Space6
                            )
                        )

                        Text(
                            text = "Marked for review",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TestProgressSummary(
    answeredCount: Int,
    totalQuestions: Int,
    marked: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.CardSpacing
        )
    ) {
        TestStatCard(
            modifier = Modifier.weight(1f),
            value = "$answeredCount/$totalQuestions",
            label = "Answered",
            icon = Icons.Default.CheckCircle
        )

        TestStatCard(
            modifier = Modifier.weight(1f),
            value = marked.toString(),
            label = "Review",
            icon = Icons.Default.Flag
        )
    }
}

@Composable
private fun TestStatCard(
    modifier: Modifier,
    value: String,
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = CommerzoDimensions.Space12,
                    vertical = CommerzoDimensions.Space12
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.primary
            )

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space8
                )
            )

            Column {
                Text(
                    text = value,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun TestNavigationActions(
    currentIndex: Int,
    totalQuestions: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space10
        )
    ) {
        OutlinedButton(
            onClick = onPrevious,
            enabled = currentIndex > 0,
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(
                horizontal = CommerzoDimensions.Space8
            )
        ) {
            Text(
                text = "Previous",
                maxLines = 1
            )
        }

        Button(
            onClick = onNext,
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(
                horizontal = CommerzoDimensions.Space8
            )
        ) {
            Text(
                text = if (currentIndex < totalQuestions - 1) {
                    "Next"
                } else {
                    "Finish"
                },
                maxLines = 1
            )
        }
    }
}

@Composable
private fun TestEmptyState(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                CommerzoDimensions.ScreenHorizontal
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier.size(72.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Timer,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space20
            )
        )

        Text(
            text = "No Questions Available",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        Text(
            text = "This chapter does not have enough valid questions yet.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space24
            )
        )

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go Back")
        }
    }
}
