
package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.random.Random

private data class PuzzleQuestion(
    val sequence: String,
    val answer: Int,
    val options: List<Int>,
    val explanation: String
)

private const val PUZZLE_COUNT = 10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PuzzleZoneScreen(onBack: () -> Unit) {
    var questions by remember { mutableStateOf(createPuzzleRound()) }
    var index by remember { mutableIntStateOf(0) }
    var score by remember { mutableIntStateOf(0) }
    var selected by remember { mutableStateOf<Int?>(null) }
    var submitted by remember { mutableStateOf(false) }
    var finished by remember { mutableStateOf(false) }

    val current = questions[index]

    fun restart() {
        questions = createPuzzleRound()
        index = 0
        score = 0
        selected = null
        submitted = false
        finished = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Puzzle Zone 🧩", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("Back") }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding).padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            if (finished) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        ),
                        shape = RoundedCornerShape(22.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("PUZZLE COMPLETED 🎉", fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(12.dp))
                            Text(
                                "$score / $PUZZLE_COUNT",
                                style = MaterialTheme.typography.displayMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text("Accuracy: ${score * 10}%")
                        }
                    }
                }
                item {
                    Button(
                        onClick = { restart() },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("Play New Round") }
                }
            } else {
                item {
                    Text(
                        "Puzzle ${index + 1} of $PUZZLE_COUNT",
                        fontWeight = FontWeight.Bold
                    )
                    Text("Score: $score")
                }

                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(22.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "FIND THE MISSING NUMBER",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.height(20.dp))
                            Text(
                                current.sequence,
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.height(10.dp))
                            Text("What comes next?")
                        }
                    }
                }

                item {
                    Text(
                        "Choose your answer",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

                items(current.options) { option ->
                    OutlinedButton(
                        onClick = { if (!submitted) selected = option },
                        enabled = !submitted,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text(
                            option.toString(),
                            fontWeight = if (selected == option) {
                                FontWeight.Bold
                            } else FontWeight.Normal
                        )
                    }
                }

                if (!submitted) {
                    item {
                        Button(
                            onClick = {
                                selected?.let {
                                    if (it == current.answer) score++
                                    submitted = true
                                }
                            },
                            enabled = selected != null,
                            modifier = Modifier.fillMaxWidth()
                        ) { Text("Submit Answer") }
                    }
                } else {
                    item {
                        Text(
                            if (selected == current.answer) {
                                "Correct answer! ✅"
                            } else {
                                "Correct answer: ${current.answer}"
                            },
                            fontWeight = FontWeight.Bold,
                            color = if (selected == current.answer) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.error
                            }
                        )
                        Text(current.explanation)
                    }
                    item {
                        Button(
                            onClick = {
                                if (index == questions.lastIndex) {
                                    finished = true
                                } else {
                                    index++
                                    selected = null
                                    submitted = false
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(if (index == questions.lastIndex) "See Result" else "Next Puzzle")
                        }
                    }
                }
            }

            item {
                OutlinedButton(
                    onClick = onBack,
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Exit Puzzle Zone") }
            }
        }
    }
}

private fun createPuzzleRound(): List<PuzzleQuestion> {
    val result = mutableListOf<PuzzleQuestion>()
    val used = mutableSetOf<String>()

    while (result.size < PUZZLE_COUNT) {
        val type = Random.nextInt(4)
        val start = Random.nextInt(2, 15)

        val values: List<Int>
        val explanation: String

        when (type) {
            0 -> {
                val step = Random.nextInt(2, 10)
                values = (0..4).map { start + it * step }
                explanation = "Each number increases by $step."
            }
            1 -> {
                val base = Random.nextInt(2, 8)
                values = (1..5).map { base * it }
                explanation = "Each number is a multiple of $base."
            }
            2 -> {
                val base = Random.nextInt(2, 8)
                values = (1..5).map { (base + it - 1) * (base + it - 1) }
                explanation = "These are consecutive square numbers."
            }
            else -> {
                val a = Random.nextInt(2, 8)
                val b = Random.nextInt(3, 9)
                values = listOf(a, b, a + b, a + 2 * b, 2 * a + 3 * b)
                explanation = "Each new number is the sum of the previous two."
            }
        }

        val key = values.joinToString(",")
        if (!used.add(key)) continue

        val answer = values.last()
        val options = mutableSetOf(answer)

        while (options.size < 4) {
            val candidate = answer + Random.nextInt(-12, 13)
            if (candidate > 0) options.add(candidate)
        }

        result.add(
            PuzzleQuestion(
                sequence = values.dropLast(1).joinToString("   ") + "   ?",
                answer = answer,
                options = options.shuffled(),
                explanation = explanation
            )
        )
    }

    return result.shuffled()
}
