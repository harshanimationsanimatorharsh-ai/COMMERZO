
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.model.QuestionDifficulty
import com.commerzo.app.data.repository.QuestionRepository

private enum class QuizDifficulty(val label: String) {
    ALL("All"),
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard")
}

private data class QuizOption(
    val text: String,
    val isCorrect: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizArenaScreen(
    onBack: () -> Unit
) {
    val repository = remember { QuestionRepository() }
    val allQuestions = remember { repository.getAllQuestions() }

    var difficulty by remember { mutableStateOf(QuizDifficulty.ALL) }
    var questions by remember { mutableStateOf<List<Question>>(emptyList()) }
    var options by remember { mutableStateOf<List<QuizOption>>(emptyList()) }
    var questionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    var submitted by remember { mutableStateOf(false) }
    var finished by remember { mutableStateOf(false) }

    fun startRound() {
        val pool = when (difficulty) {
            QuizDifficulty.ALL -> allQuestions
            QuizDifficulty.EASY -> allQuestions.filter {
                it.difficulty == QuestionDifficulty.EASY
            }
            QuizDifficulty.MEDIUM -> allQuestions.filter {
                it.difficulty == QuestionDifficulty.MEDIUM
            }
            QuizDifficulty.HARD -> allQuestions.filter {
                it.difficulty == QuestionDifficulty.HARD
            }
        }

        questions = pool.distinctBy { it.id }.shuffled().take(10)
        questionIndex = 0
        score = 0
        selectedOption = null
        submitted = false
        finished = false

        if (questions.isNotEmpty()) {
            prepareOptions(questions.first()) { options = it }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Quiz Arena 🧠", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            if (questions.isEmpty() && !finished) {
                item {
                    Text(
                        "Choose your difficulty",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }

                item {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        QuizDifficulty.values().forEach { item ->
                            FilterChip(
                                selected = difficulty == item,
                                onClick = { difficulty = item },
                                label = { Text(item.label) }
                            )
                        }
                    }
                }

                item {
                    Text(
                        "10 questions per round. Questions and answer options are shuffled.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                item {
                    Button(
                        onClick = { startRound() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Start Quiz")
                    }
                }

                if (allQuestions.isEmpty()) {
                    item {
                        Text(
                            "Question bank is currently unavailable.",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            } else if (finished) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(22.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Column(Modifier.padding(22.dp)) {
                            Text(
                                "ROUND COMPLETED 🎉",
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.height(12.dp))
                            Text(
                                "$score / ${questions.size}",
                                style = MaterialTheme.typography.displayMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text("Correct answers")
                            Spacer(Modifier.height(8.dp))
                            Text(
                                "Accuracy: ${
                                    if (questions.isEmpty()) 0
                                    else score * 100 / questions.size
                                }%"
                            )
                        }
                    }
                }

                item {
                    Button(
                        onClick = { startRound() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Play Again")
                    }
                }

                item {
                    OutlinedButton(
                        onClick = {
                            questions = emptyList()
                            finished = false
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Change Difficulty")
                    }
                }
            } else {
                val current = questions[questionIndex]

                item {
                    Text(
                        "Question ${questionIndex + 1} of ${questions.size}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text("Score: $score")
                }

                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Column(Modifier.padding(20.dp)) {
                            Text(
                                current.subjectId.replaceFirstChar { it.uppercase() },
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(Modifier.height(10.dp))
                            Text(
                                current.question,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }

                items(options.size) { index ->
                    val option = options[index]
                    val isSelected = selectedOption == index

                    OutlinedButton(
                        onClick = {
                            if (!submitted) selectedOption = index
                        },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = !submitted,
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text(
                            "${'A' + index}. ${option.text}",
                            modifier = Modifier.padding(vertical = 5.dp)
                        )
                    }
                }

                if (!submitted) {
                    item {
                        Button(
                            onClick = {
                                val selected = selectedOption
                                if (selected != null) {
                                    if (options[selected].isCorrect) score++
                                    submitted = true
                                }
                            },
                            enabled = selectedOption != null,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Submit Answer")
                        }
                    }
                } else {
                    item {
                        val correct = options.indexOfFirst { it.isCorrect }
                        Text(
                            if (selectedOption == correct) "Correct answer! ✅"
                            else "Correct answer: ${options[correct].text}",
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(current.explanation)
                    }

                    item {
                        Button(
                            onClick = {
                                if (questionIndex + 1 >= questions.size) {
                                    finished = true
                                } else {
                                    questionIndex++
                                    selectedOption = null
                                    submitted = false
                                    prepareOptions(questions[questionIndex]) {
                                        options = it
                                    }
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                if (questionIndex + 1 >= questions.size) {
                                    "Finish Quiz"
                                } else {
                                    "Next Question"
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun prepareOptions(
    question: Question,
    onReady: (List<QuizOption>) -> Unit
) {
    onReady(
        question.options.mapIndexed { index, text ->
            QuizOption(
                text = text,
                isCorrect = index == question.correctAnswer
            )
        }.shuffled()
    )
}
