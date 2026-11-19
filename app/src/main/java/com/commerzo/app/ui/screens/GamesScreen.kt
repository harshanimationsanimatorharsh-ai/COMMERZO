
package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.random.Random

private enum class MathOperation(
    val title: String,
    val symbol: String
) {
    ADDITION("Addition", "+"),
    SUBTRACTION("Subtraction", "−"),
    MULTIPLICATION("Multiplication", "×"),
    DIVISION("Division", "÷")
}

private data class MathQuestion(
    val first: Int,
    val second: Int,
    val operation: MathOperation,
    val answer: Int,
    val options: List<Int>
) {
    val expression: String
        get() = "$first ${operation.symbol} $second"
}

private const val ROUND_SIZE = 10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamesScreen() {
    var selectedOperation by remember {
        mutableStateOf<MathOperation?>(null)
    }

    var showQuizArena by remember { mutableStateOf(false) }
    var showPuzzleZone by remember { mutableStateOf(false) }

    when {
        showQuizArena -> {
            QuizArenaScreen(
                onBack = { showQuizArena = false }
            )
        }

        showPuzzleZone -> {
            PuzzleZoneScreen(
                onBack = { showPuzzleZone = false }
            )
        }

        else -> {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = if (selectedOperation == null) {
                                    "Games 🎮"
                                } else {
                                    "Quick Math"
                                },
                                fontWeight = FontWeight.Bold
                            )
                        },
                        navigationIcon = {
                            if (selectedOperation != null) {
                                TextButton(
                                    onClick = { selectedOperation = null }
                                ) {
                                    Icon(
                                        Icons.Default.ArrowBack,
                                        contentDescription = "Back"
                                    )
                                    Text("Back")
                                }
                            }
                        }
                    )
                }
            ) { padding ->
                if (selectedOperation == null) {
                    GamesHome(
                        modifier = Modifier.padding(padding),
                        onMathClick = {
                            selectedOperation = MathOperation.ADDITION
                        },
                        onQuizClick = {
                            showQuizArena = true
                        },
                        onPuzzleClick = {
                            showPuzzleZone = true
                        }
                    )
                } else {
                    QuickMathGame(
                        operation = selectedOperation!!,
                        modifier = Modifier.padding(padding),
                        onExit = { selectedOperation = null }
                    )
                }
            }
        }
    }
}

@Composable
private fun GamesHome(
    modifier: Modifier = Modifier,
    onMathClick: () -> Unit,
    onQuizClick: () -> Unit,
    onPuzzleClick: () -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                Column(Modifier.padding(22.dp)) {
                    Text(
                        "PLAY. LEARN. IMPROVE.",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Welcome to Game Zone 🎮",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Challenge your maths, memory and logical thinking.",
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }

        item {
            Text(
                "Quick Math",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            GameMenuCard(
                title = "Quick Math Challenge",
                subtitle = "Addition, subtraction, multiplication and division",
                icon = {
                    Icon(
                        Icons.Default.Calculate,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                },
                onClick = onMathClick
            )
        }

        item {
            Text(
                "More Games",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            GameMenuCard(
                title = "Quiz Arena",
                subtitle = "Educational quizzes with changing questions",
                icon = {
                    Icon(Icons.Default.Quiz, contentDescription = null)
                },
                onClick = onQuizClick
            )
        }

        item {
            GameMenuCard(
                title = "Puzzle Zone",
                subtitle = "Number patterns and logic challenges",
                icon = {
                    Icon(Icons.Default.Extension, contentDescription = null)
                },
                onClick = onPuzzleClick
            )
        }

        item {
            GameMenuCard(
                title = "Brain Games",
                subtitle = "Memory and concentration challenges",
                icon = {
                    Icon(Icons.Default.Psychology, contentDescription = null)
                },
                enabled = false
            )
        }
    }
}

@Composable
private fun GameMenuCard(
    title: String,
    subtitle: String,
    icon: @Composable () -> Unit,
    onClick: () -> Unit = {},
    enabled: Boolean = true
) {
    Card(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.secondaryContainer,
                modifier = Modifier.size(54.dp)
            ) {
                androidx.compose.foundation.layout.Box(
                    contentAlignment = Alignment.Center
                ) {
                    icon()
                }
            }

            Column(Modifier.weight(1f)) {
                Text(
                    title,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                if (!enabled) {
                    Spacer(Modifier.height(6.dp))
                    Text(
                        "Coming in next update",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
private fun QuickMathGame(
    operation: MathOperation,
    modifier: Modifier = Modifier,
    onExit: () -> Unit
) {
    var currentOperation by remember(operation) {
        mutableStateOf(operation)
    }

    val seenQuestions = remember(operation) {
        mutableSetOf<String>()
    }

    var question by remember(operation) {
        mutableStateOf(generateQuestion(operation, seenQuestions))
    }
    var questionNumber by remember(operation) { mutableStateOf(1) }
    var score by remember(operation) { mutableStateOf(0) }
    var selectedAnswer by remember(operation) { mutableStateOf<Int?>(null) }
    var finished by remember(operation) { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                "Choose operation",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    MathOperation.entries.take(2).forEach {
                        OperationButton(
                            operation = it,
                            selected = currentOperation == it,
                            modifier = Modifier.weight(1f),
                            onClick = {
                                currentOperation = it
                                seenQuestions.clear()
                                question = generateQuestion(it, seenQuestions)
                                questionNumber = 1
                                score = 0
                                selectedAnswer = null
                                finished = false
                            }
                        )
                    }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    MathOperation.entries.drop(2).forEach {
                        OperationButton(
                            operation = it,
                            selected = currentOperation == it,
                            modifier = Modifier.weight(1f),
                            onClick = {
                                currentOperation = it
                                seenQuestions.clear()
                                question = generateQuestion(it, seenQuestions)
                                questionNumber = 1
                                score = 0
                                selectedAnswer = null
                                finished = false
                            }
                        )
                    }
                }
            }
        }

        if (finished) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("ROUND COMPLETED 🎉")
                        Spacer(Modifier.height(12.dp))
                        Text(
                            "$score / $ROUND_SIZE",
                            style = MaterialTheme.typography.displayMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text("Your final score")
                        Spacer(Modifier.height(18.dp))
                        Button(
                            onClick = {
                                seenQuestions.clear()
                                question = generateQuestion(currentOperation, seenQuestions)
                                questionNumber = 1
                                score = 0
                                selectedAnswer = null
                                finished = false
                            }
                        ) { Text("Play Again") }
                    }
                }
            }
        } else {
            item {
                Text("Question $questionNumber of $ROUND_SIZE", fontWeight = FontWeight.Bold)
                Text(
                    "Score: $score",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 34.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            currentOperation.title.uppercase(),
                            style = MaterialTheme.typography.labelMedium
                        )
                        Spacer(Modifier.height(12.dp))
                        Text(
                            question.expression,
                            style = MaterialTheme.typography.displaySmall,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(8.dp))
                        Text("= ?", style = MaterialTheme.typography.titleLarge)
                    }
                }
            }

            item {
                Text(
                    "Select your answer",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    question.options.chunked(2).forEach { pair ->
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            pair.forEach { option ->
                                val isSelected = selectedAnswer == option
                                val isCorrect = option == question.answer
                                val containerColor = when {
                                    selectedAnswer == null ->
                                        MaterialTheme.colorScheme.surfaceVariant
                                    isSelected && isCorrect ->
                                        MaterialTheme.colorScheme.primaryContainer
                                    isSelected ->
                                        MaterialTheme.colorScheme.errorContainer
                                    else ->
                                        MaterialTheme.colorScheme.surfaceVariant
                                }

                                Button(
                                    onClick = {
                                        if (selectedAnswer == null) {
                                            selectedAnswer = option
                                            if (isCorrect) score++
                                        }
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(58.dp),
                                    enabled = selectedAnswer == null,
                                    shape = RoundedCornerShape(14.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = containerColor,
                                        contentColor = MaterialTheme.colorScheme.onSurface
                                    )
                                ) {
                                    Text(
                                        option.toString(),
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            if (pair.size == 1) Spacer(Modifier.weight(1f))
                        }
                    }
                }
            }

            if (selectedAnswer != null) {
                item {
                    Text(
                        if (selectedAnswer == question.answer) {
                            "Correct answer! ✅"
                        } else {
                            "Correct answer: ${question.answer}"
                        },
                        fontWeight = FontWeight.Bold,
                        color = if (selectedAnswer == question.answer) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.error
                        }
                    )
                }

                item {
                    Button(
                        onClick = {
                            if (questionNumber == ROUND_SIZE) {
                                finished = true
                            } else {
                                questionNumber++
                                question = generateQuestion(currentOperation, seenQuestions)
                                selectedAnswer = null
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            if (questionNumber == ROUND_SIZE) "See Result"
                            else "Next Question"
                        )
                    }
                }
            }
        }

        item {
            OutlinedButton(
                onClick = onExit,
                modifier = Modifier.fillMaxWidth()
            ) { Text("Exit Game") }
        }
    }
}

@Composable
private fun OperationButton(
    operation: MathOperation,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    if (selected) {
        Button(onClick = onClick, modifier = modifier.height(52.dp)) {
            Text("${operation.symbol} ${operation.title}")
        }
    } else {
        OutlinedButton(onClick = onClick, modifier = modifier.height(52.dp)) {
            Text("${operation.symbol} ${operation.title}")
        }
    }
}

private fun generateQuestion(
    operation: MathOperation,
    seen: MutableSet<String>
): MathQuestion {
    repeat(1000) {
        val first: Int
        val second: Int
        val answer: Int

        when (operation) {
            MathOperation.ADDITION -> {
                first = Random.nextInt(1, 501)
                second = Random.nextInt(1, 501)
                answer = first + second
            }
            MathOperation.SUBTRACTION -> {
                first = Random.nextInt(10, 501)
                second = Random.nextInt(1, first + 1)
                answer = first - second
            }
            MathOperation.MULTIPLICATION -> {
                first = Random.nextInt(2, 21)
                second = Random.nextInt(2, 21)
                answer = first * second
            }
            MathOperation.DIVISION -> {
                second = Random.nextInt(2, 13)
                answer = Random.nextInt(2, 21)
                first = second * answer
            }
        }

        val key = "$first:${operation.name}:$second"
        if (!seen.add(key)) return@repeat

        val options = mutableSetOf(answer)
        while (options.size < 4) {
            val candidate = answer + Random.nextInt(-15, 16)
            if (candidate >= 0 && candidate != answer) options.add(candidate)
        }

        return MathQuestion(
            first,
            second,
            operation,
            answer,
            options.shuffled()
        )
    }

    val first = Random.nextInt(1, 501)
    val second = Random.nextInt(1, 501)
    val answer = first + second
    return MathQuestion(
        first,
        second,
        MathOperation.ADDITION,
        answer,
        listOf(answer, answer + 1, answer + 2, answer + 3).shuffled()
    )
}
