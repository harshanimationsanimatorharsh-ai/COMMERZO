
package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.random.Random

private const val MEMORY_ROUNDS = 10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrainGamesScreen(onBack: () -> Unit) {
    var round by remember { mutableIntStateOf(1) }
    var score by remember { mutableIntStateOf(0) }
    var sequence by remember { mutableStateOf(generateMemorySequence(3)) }
    var entered by remember { mutableStateOf("") }
    var showing by remember { mutableStateOf(true) }
    var answered by remember { mutableStateOf(false) }
    var finished by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    LaunchedEffect(round, sequence) {
        showing = true
        delay(2500)
        showing = false
    }

    fun restart() {
        round = 1
        score = 0
        sequence = generateMemorySequence(3)
        entered = ""
        showing = true
        answered = false
        finished = false
        message = ""
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Brain Games 🧠", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (finished) {
                Spacer(Modifier.height(20.dp))
                Text(
                    "MEMORY CHALLENGE COMPLETE 🎉",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    "$score / $MEMORY_ROUNDS",
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold
                )
                Text("Your final score")
                Button(
                    onClick = { restart() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Play Again")
                }
            } else {
                Text(
                    "Round $round of $MEMORY_ROUNDS",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    "Score: $score",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(28.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            if (showing) "MEMORIZE THESE NUMBERS" else "REPEAT THE SEQUENCE",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelLarge
                        )
                        Spacer(Modifier.height(18.dp))
                        Text(
                            if (showing) sequence else "●  ●  ●  ●",
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(
                            if (showing) "Remember the order!" else "Enter the numbers in the same order."
                        )
                    }
                }

                Text(
                    "Your answer: ${if (entered.isEmpty()) "—" else entered}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                if (!showing && !answered) {
                    (0..9).toList().chunked(3).forEach { rowDigits ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            rowDigits.forEach { digit ->
                                OutlinedButton(
                                    onClick = {
                                        if (entered.length < sequence.length) {
                                            entered += digit.toString()
                                        }
                                    },
                                    modifier = Modifier.weight(1f),
                                    enabled = entered.length < sequence.length
                                ) {
                                    Text(
                                        digit.toString(),
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                }
                            }
                            if (rowDigits.size < 3) {
                                repeat(3 - rowDigits.size) {
                                    Spacer(Modifier.weight(1f))
                                }
                            }
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = {
                                if (entered.isNotEmpty()) {
                                    entered = entered.dropLast(1)
                                }
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Delete")
                        }

                        Button(
                            onClick = {
                                if (entered.length == sequence.length) {
                                    answered = true
                                    if (entered == sequence) {
                                        score++
                                        message = "Perfect memory! ✅"
                                    } else {
                                        message = "Not quite! Correct sequence: $sequence"
                                    }
                                }
                            },
                            modifier = Modifier.weight(1f),
                            enabled = entered.length == sequence.length
                        ) {
                            Text("Submit")
                        }
                    }
                }

                if (answered) {
                    Text(
                        message,
                        fontWeight = FontWeight.Bold,
                        color = if (entered == sequence) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.error
                        }
                    )

                    Button(
                        onClick = {
                            if (round == MEMORY_ROUNDS) {
                                finished = true
                            } else {
                                round++
                                sequence = generateMemorySequence(
                                    (3 + (round - 1) / 2).coerceAtMost(8)
                                )
                                entered = ""
                                answered = false
                                message = ""
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            if (round == MEMORY_ROUNDS) "See Final Result"
                            else "Next Round"
                        )
                    }
                }
            }

            Spacer(Modifier.weight(1f))

            OutlinedButton(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Exit Brain Games")
            }
        }
    }
}

private fun generateMemorySequence(length: Int): String {
    return buildString {
        repeat(length) {
            append(Random.nextInt(0, 10))
        }
    }
}
