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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
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
    val questions by
        viewModel.questions.collectAsState()

    val currentIndex by
        viewModel.currentIndex.collectAsState()

    val selectedAnswer by
        viewModel.selectedAnswer.collectAsState()

    val submitted by
        viewModel.submitted.collectAsState()

    val correctAnswers by
        viewModel.correctAnswers.collectAsState()

    val wrongAnswers by
        viewModel.wrongAnswers.collectAsState()

    val answeredQuestions by
        viewModel.answeredQuestions.collectAsState()

    val isFinished by
        viewModel.isFinished.collectAsState()

    val progressPercent by
        viewModel.progressPercent.collectAsState()

    LaunchedEffect(
        subjectId,
        chapterId,
        board,
        classLevel
    ) {
        viewModel.loadQuestions(
            subjectId = subjectId,
            chapterId = chapterId,
            board = board,
            classLevel = classLevel
        )
    }

    val currentQuestion =
        questions.getOrNull(currentIndex)

    val totalQuestions =
        questions.size

    val isCurrentBookmarked =
        viewModel.isCurrentQuestionBookmarked()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Practice",
                        fontWeight = FontWeight.Bold
                    )
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
                    if (currentQuestion != null) {
                        IconButton(
                            onClick = {
                                viewModel.toggleBookmark()
                            }
                        ) {
                            Icon(
                                imageVector =
                                    if (isCurrentBookmarked) {
                                        Icons.Default.Bookmark
                                    } else {
                                        Icons.Default.BookmarkBorder
                                    },
                                contentDescription =
                                    if (isCurrentBookmarked) {
                                        "Remove bookmark"
                                    } else {
                                        "Bookmark question"
                                    }
                            )
                        }
                    }
                },
                colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor =
                            MaterialTheme.colorScheme.surface
                    )
            )
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(
                    MaterialTheme.colorScheme.background
                )
        ) {

            when {

                isFinished -> {

                    PracticeResultContent(
                        totalQuestions =
                            totalQuestions,
                        answeredQuestions =
                            answeredQuestions.size,
                        correctAnswers =
                            correctAnswers,
                        wrongAnswers =
                            wrongAnswers,
                        progressPercent =
                            progressPercent,
                        onRestart = {
                            viewModel.restart()
                        },
                        onBack = onBack
                    )
                }

                currentQuestion == null -> {

                    Column(
                        modifier =
                            Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                        horizontalAlignment =
                            Alignment.CenterHorizontally,
                        verticalArrangement =
                            Arrangement.Center
                    ) {

                        Text(
                            text =
                                "No questions available",
                            style =
                                MaterialTheme
                                    .typography
                                    .titleLarge,
                            fontWeight =
                                FontWeight.Bold
                        )

                        Spacer(
                            modifier =
                                Modifier.height(8.dp)
                        )

                        Text(
                            text =
                                "This chapter does not have a valid question bank yet.",
                            style =
                                MaterialTheme
                                    .typography
                                    .bodyMedium,
                            color =
                                MaterialTheme
                                    .colorScheme
                                    .onSurfaceVariant
                        )

                        Spacer(
                            modifier =
                                Modifier.height(24.dp)
                        )

                        Button(
                            onClick = onBack
                        ) {
                            Text("Go Back")
                        }
                    }
                }

                else -> {

                    Column(
                        modifier =
                            Modifier
                                .fillMaxSize()
                                .padding(
                                    horizontal = 16.dp
                                )
                    ) {

                        Spacer(
                            modifier =
                                Modifier.height(10.dp)
                        )

                        Row(
                            modifier =
                                Modifier.fillMaxWidth(),
                            horizontalArrangement =
                                Arrangement.SpaceBetween,
                            verticalAlignment =
                                Alignment.CenterVertically
                        ) {

                            Text(
                                text =
                                    "Question ${currentIndex + 1} of $totalQuestions",
                                style =
                                    MaterialTheme
                                        .typography
                                        .titleMedium,
                                fontWeight =
                                    FontWeight.Bold
                            )

                            Text(
                                text =
                                    "${answeredQuestions.size} answered",
                                style =
                                    MaterialTheme
                                        .typography
                                        .bodySmall,
                                color =
                                    MaterialTheme
                                        .colorScheme
                                        .onSurfaceVariant
                            )
                        }

                        Spacer(
                            modifier =
                                Modifier.height(8.dp)
                        )

                        LinearProgressIndicator(
                            progress = {
                                if (totalQuestions > 0) {
                                    progressPercent / 100f
                                } else {
                                    0f
                                }
                            },
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .height(6.dp)
                        )

                        Spacer(
                            modifier =
                                Modifier.height(6.dp)
                        )

                        Text(
                            text =
                                "$progressPercent% completed • " +
                                    "${totalQuestions - answeredQuestions.size} remaining",
                            style =
                                MaterialTheme
                                    .typography
                                    .labelSmall,
                            color =
                                MaterialTheme
                                    .colorScheme
                                    .onSurfaceVariant
                        )

                        Spacer(
                            modifier =
                                Modifier.height(16.dp)
                        )

                        Card(
                            modifier =
                                Modifier.fillMaxWidth(),
                            shape =
                                RoundedCornerShape(18.dp),
                            colors =
                                CardDefaults.cardColors(
                                    containerColor =
                                        MaterialTheme
                                            .colorScheme
                                            .surface
                                )
                        ) {

                            Column(
                                modifier =
                                    Modifier.padding(18.dp)
                            ) {

                                Row(
                                    modifier =
                                        Modifier.fillMaxWidth(),
                                    horizontalArrangement =
                                        Arrangement.SpaceBetween,
                                    verticalAlignment =
                                        Alignment.Top
                                ) {

                                    Text(
                                        text =
                                            currentQuestion.question,
                                        modifier =
                                            Modifier.weight(1f),
                                        style =
                                            MaterialTheme
                                                .typography
                                                .titleMedium,
                                        fontWeight =
                                            FontWeight.SemiBold
                                    )

                                    if (
                                        isCurrentBookmarked
                                    ) {

                                        Spacer(
                                            modifier =
                                                Modifier.width(8.dp)
                                        )

                                        Icon(
                                            imageVector =
                                                Icons.Default.Bookmark,
                                            contentDescription =
                                                "Bookmarked",
                                            tint =
                                                MaterialTheme
                                                    .colorScheme
                                                    .primary
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(
                            modifier =
                                Modifier.height(16.dp)
                        )

                        currentQuestion.options
                            .forEachIndexed {
                                    index,
                                    option ->

                                val isSelected =
                                    selectedAnswer == index

                                val isCorrect =
                                    submitted &&
                                        index ==
                                        currentQuestion
                                            .correctAnswer

                                val isWrong =
                                    submitted &&
                                        isSelected &&
                                        index !=
                                        currentQuestion
                                            .correctAnswer

                                OptionCard(
                                    optionIndex =
                                        index,
                                    optionText =
                                        option,
                                    isSelected =
                                        isSelected,
                                    isCorrect =
                                        isCorrect,
                                    isWrong =
                                        isWrong,
                                    enabled =
                                        !submitted,
                                    onClick = {
                                        viewModel
                                            .selectAnswer(
                                                index
                                            )
                                    }
                                )

                                Spacer(
                                    modifier =
                                        Modifier.height(10.dp)
                                )
                            }

                        if (submitted) {

                            Card(
                                modifier =
                                    Modifier.fillMaxWidth(),
                                shape =
                                    RoundedCornerShape(16.dp),
                                colors =
                                    CardDefaults.cardColors(
                                        containerColor =
                                            MaterialTheme
                                                .colorScheme
                                                .surfaceVariant
                                    )
                            ) {

                                Column(
                                    modifier =
                                        Modifier.padding(16.dp)
                                ) {

                                    Row(
                                        verticalAlignment =
                                            Alignment.CenterVertically
                                    ) {

                                        Icon(
                                            imageVector =
                                                if (
                                                    selectedAnswer ==
                                                    currentQuestion
                                                        .correctAnswer
                                                ) {
                                                    Icons.Default.Check
                                                } else {
                                                    Icons.Default
                                                        .Lightbulb
                                                },
                                            contentDescription =
                                                null
                                        )

                                        Spacer(
                                            modifier =
                                                Modifier.width(8.dp)
                                        )

                                        Text(
                                            text =
                                                if (
                                                    selectedAnswer ==
                                                    currentQuestion
                                                        .correctAnswer
                                                ) {
                                                    "Correct!"
                                                } else {
                                                    "Correct answer: ${
                                                        optionLetter(
                                                            currentQuestion
                                                                .correctAnswer
                                                        )
                                                    }"
                                                },
                                            fontWeight =
                                                FontWeight.Bold
                                        )
                                    }

                                    Spacer(
                                        modifier =
                                            Modifier.height(8.dp)
                                    )

                                    Text(
                                        text =
                                            currentQuestion
                                                .explanation,
                                        style =
                                            MaterialTheme
                                                .typography
                                                .bodyMedium
                                    )
                                }
                            }
                        }

                        Spacer(
                            modifier =
                                Modifier.weight(1f)
                        )

                        Row(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        vertical = 12.dp
                                    ),
                            horizontalArrangement =
                                Arrangement.spacedBy(10.dp)
                        ) {

                            OutlinedButton(
                                onClick = {
                                    viewModel
                                        .previousQuestion()
                                },
                                enabled =
                                    currentIndex > 0,
                                modifier =
                                    Modifier.weight(1f)
                            ) {

                                Icon(
                                    imageVector =
                                        Icons.Default
                                            .NavigateBefore,
                                    contentDescription =
                                        null
                                )

                                Spacer(
                                    modifier =
                                        Modifier.width(4.dp)
                                )

                                Text("Previous")
                            }

                            Button(
                                onClick = {
                                    if (!submitted) {
                                        viewModel
                                            .submitAnswer()
                                    } else {
                                        viewModel
                                            .nextQuestion()
                                    }
                                },
                                enabled =
                                    if (submitted) {
                                        true
                                    } else {
                                        selectedAnswer != null
                                    },
                                modifier =
                                    Modifier.weight(1f)
                            ) {

                                Text(
                                    if (!submitted) {
                                        "Submit"
                                    } else if (
                                        currentIndex ==
                                        questions.lastIndex
                                    ) {
                                        "Finish"
                                    } else {
                                        "Next"
                                    }
                                )

                                if (submitted) {

                                    Spacer(
                                        modifier =
                                            Modifier.width(4.dp)
                                    )

                                    Icon(
                                        imageVector =
                                            Icons.Default
                                                .NavigateNext,
                                        contentDescription =
                                            null
                                    )
                                }
                            }
                        }
                    }
                }
            }
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

    val containerColor =
        when {
            isCorrect ->
                Color(0xFF1B5E20)

            isWrong ->
                Color(0xFFB71C1C)

            isSelected ->
                MaterialTheme
                    .colorScheme
                    .primaryContainer

            else ->
                MaterialTheme
                    .colorScheme
                    .surface
        }

    val contentColor =
        when {
            isCorrect || isWrong ->
                Color.White

            else ->
                MaterialTheme
                    .colorScheme
                    .onSurface
        }

    Card(
        modifier =
            Modifier.fillMaxWidth(),
        onClick =
            onClick,
        enabled =
            enabled,
        shape =
            RoundedCornerShape(14.dp),
        colors =
            CardDefaults.cardColors(
                containerColor =
                    containerColor,
                contentColor =
                    contentColor
            ),
        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 1.dp
            )
    ) {

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Text(
                text =
                    optionLetter(optionIndex),
                fontWeight =
                    FontWeight.Bold,
                modifier =
                    Modifier.width(32.dp)
            )

            Text(
                text =
                    optionText,
                modifier =
                    Modifier.weight(1f),
                style =
                    MaterialTheme
                        .typography
                        .bodyLarge
            )

            if (isCorrect) {

                Icon(
                    imageVector =
                        Icons.Default.Check,
                    contentDescription =
                        "Correct"
                )
            }

            if (isWrong) {

                Icon(
                    imageVector =
                        Icons.Default.Close,
                    contentDescription =
                        "Wrong"
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

    val percentage =
        if (totalQuestions > 0) {
            (correctAnswers * 100) /
                totalQuestions
        } else {
            0
        }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(24.dp),
        horizontalAlignment =
            Alignment.CenterHorizontally,
        verticalArrangement =
            Arrangement.Center
    ) {

        CircularProgressIndicator(
            progress = {
                percentage / 100f
            },
            modifier =
                Modifier.height(90.dp),
            strokeWidth = 8.dp
        )

        Spacer(
            modifier =
                Modifier.height(20.dp)
        )

        Text(
            text =
                "Practice Complete",
            style =
                MaterialTheme
                    .typography
                    .headlineSmall,
            fontWeight =
                FontWeight.Bold
        )

        Spacer(
            modifier =
                Modifier.height(8.dp)
        )

        Text(
            text =
                "$percentage%",
            style =
                MaterialTheme
                    .typography
                    .displaySmall,
            fontWeight =
                FontWeight.Bold
        )

        Spacer(
            modifier =
                Modifier.height(6.dp)
        )

        Text(
            text =
                "$progressPercent% questions attempted",
            style =
                MaterialTheme
                    .typography
                    .bodyMedium,
            color =
                MaterialTheme
                    .colorScheme
                    .onSurfaceVariant
        )

        Spacer(
            modifier =
                Modifier.height(20.dp)
        )

        Card(
            modifier =
                Modifier.fillMaxWidth(),
            shape =
                RoundedCornerShape(16.dp)
        ) {

            Column(
                modifier =
                    Modifier.padding(18.dp)
            ) {

                Text(
                    text =
                        "Practice Summary",
                    style =
                        MaterialTheme
                            .typography
                            .titleMedium,
                    fontWeight =
                        FontWeight.Bold
                )

                Spacer(
                    modifier =
                        Modifier.height(10.dp)
                )

                Text(
                    text =
                        "Total questions: $totalQuestions"
                )

                Spacer(
                    modifier =
                        Modifier.height(6.dp)
                )

                Text(
                    text =
                        "Answered: $answeredQuestions"
                )

                Spacer(
                    modifier =
                        Modifier.height(6.dp)
                )

                Text(
                    text =
                        "Correct: $correctAnswers"
                )

                Spacer(
                    modifier =
                        Modifier.height(6.dp)
                )

                Text(
                    text =
                        "Wrong: $wrongAnswers"
                )

                Spacer(
                    modifier =
                        Modifier.height(6.dp)
                )

                Text(
                    text =
                        "Unattempted: ${
                            totalQuestions -
                                answeredQuestions
                        }"
                )
            }
        }

        Spacer(
            modifier =
                Modifier.height(24.dp)
        )

        Button(
            onClick =
                onRestart,
            modifier =
                Modifier.fillMaxWidth()
        ) {
            Text("Practice Again")
        }

        Spacer(
            modifier =
                Modifier.height(10.dp)
        )

        OutlinedButton(
            onClick =
                onBack,
            modifier =
                Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

private fun optionLetter(
    index: Int
): String {
    return when (index) {
        0 -> "A"
        1 -> "B"
        2 -> "C"
        3 -> "D"
        else -> "?"
    }
}
