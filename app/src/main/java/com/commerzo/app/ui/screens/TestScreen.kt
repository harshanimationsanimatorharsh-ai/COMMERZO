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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.repository.TestHistoryRepository
import com.commerzo.app.ui.components.TestQuestionOption
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
                    text = "Are you sure you want to submit this test? Your current answers will be evaluated."
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
                    Text("Continue")
                }
            }
        )
    }

    val minutes = timeRemaining / 60
    val seconds = timeRemaining % 60

    val answeredCount = viewModel.getAnsweredCount()
    val progress = if (questions.isNotEmpty()) {
        (currentIndex + 1).toFloat() / questions.size.toFloat()
    } else {
        0f
    }

    val isMarked = viewModel.isCurrentQuestionMarked()
    val selectedAnswer = viewModel.getSelectedAnswer(currentIndex)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .navigationBarsPadding()
    ) {

        TestTopBar(
            currentIndex = currentIndex,
            totalQuestions = questions.size,
            timeRemaining = timeRemaining,
            minutes = minutes,
            seconds = seconds,
            onBack = onBack
        )

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 20.dp,
                    vertical = 16.dp
                )
        ) {

            TestProgressSummary(
                answeredCount = answeredCount,
                totalQuestions = questions.size,
                marked = viewModel.getMarkedCount()
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Surface(
                            modifier = Modifier.size(36.dp),
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            Box(
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${currentIndex + 1}",
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.width(10.dp)
                        )

                        Text(
                            text = "Question ${currentIndex + 1}",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )

                    Text(
                        text = currentQuestion.question,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    currentQuestion.options.forEachIndexed { index, option ->

                        TestQuestionOption(
                            index = index,
                            text = option,
                            selected = selectedAnswer == index,
                            onClick = {
                                viewModel.selectAnswer(index)
                            }
                        )

                        if (index != currentQuestion.options.lastIndex) {
                            Spacer(
                                modifier = Modifier.height(10.dp)
                            )
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            OutlinedButton(
                onClick = {
                    viewModel.toggleMarkForReview()
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Flag,
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(
                    text = if (isMarked) {
                        "Remove Review Mark"
                    } else {
                        "Mark for Review"
                    }
                )
            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                OutlinedButton(
                    onClick = {
                        viewModel.previousQuestion()
                    },
                    enabled = currentIndex > 0,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text("Previous")
                }

                Button(
                    onClick = {
                        if (currentIndex < questions.lastIndex) {
                            viewModel.nextQuestion()
                        } else {
                            showSubmitDialog = true
                        }
                    },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = if (currentIndex < questions.lastIndex) {
                            "Next"
                        } else {
                            "Finish"
                        }
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            OutlinedButton(
                onClick = {
                    showSubmitDialog = true
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Submit Test")
            }
        }
    }
}

@Composable
private fun TestTopBar(
    currentIndex: Int,
    totalQuestions: Int,
    timeRemaining: Int,
    minutes: Int,
    seconds: Int,
    onBack: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 12.dp,
                vertical = 10.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(
            onClick = onBack
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Test",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Question ${currentIndex + 1} of $totalQuestions",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        val timerColor = if (timeRemaining <= 60) {
            MaterialTheme.colorScheme.error
        } else {
            MaterialTheme.colorScheme.primary
        }

        Surface(
            shape = RoundedCornerShape(14.dp),
            color = timerColor.copy(alpha = 0.10f)
        ) {
            Row(
                modifier = Modifier.padding(
                    horizontal = 12.dp,
                    vertical = 8.dp
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Timer,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    tint = timerColor
                )

                Spacer(
                    modifier = Modifier.width(6.dp)
                )

                Text(
                    text = "%02d:%02d".format(
                        minutes,
                        seconds
                    ),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = timerColor
                )
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
        horizontalArrangement = Arrangement.spacedBy(10.dp)
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
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.primary
            )

            Spacer(
                modifier = Modifier.width(8.dp)
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
private fun TestEmptyState(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
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
            modifier = Modifier.height(18.dp)
        )

        Text(
            text = "No Questions Available",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "This chapter does not have enough valid questions yet.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(22.dp)
        )

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text("Go Back")
        }
    }
}
