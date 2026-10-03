package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DeleteSweep
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.TrendingUp
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
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.repository.TestHistoryItem
import com.commerzo.app.data.repository.TestHistoryRepository
import com.commerzo.app.ui.theme.CommerzoDimensions
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TestHistoryScreen(
    onBack: () -> Unit
) {
    val context = androidx.compose.ui.platform.LocalContext.current

    LaunchedEffect(Unit) {
        TestHistoryRepository.initialize(context)
    }

    val history by TestHistoryRepository.history.collectAsState()

    var showClearDialog by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Test History",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Track your test performance",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
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
                    if (history.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                showClearDialog = true
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.DeleteSweep,
                                contentDescription = "Clear test history"
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->

        if (history.isEmpty()) {
            EmptyTestHistory(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                onBack = onBack
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(
                    horizontal = CommerzoDimensions.ScreenHorizontal,
                    vertical = CommerzoDimensions.Space16
                ),
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.CardSpacing
                )
            ) {
                item {
                    TestHistorySummary(
                        totalTests = history.size
                    )
                }

                items(
                    items = history,
                    key = { it.id }
                ) { item ->
                    TestHistoryCard(item = item)
                }

                item {
                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space8
                        )
                    )
                }
            }
        }
    }

    if (showClearDialog) {
        AlertDialog(
            onDismissRequest = {
                showClearDialog = false
            },
            title = {
                Text(
                    text = "Clear Test History?"
                )
            },
            text = {
                Text(
                    text = "All saved test results will be removed from this device. This action cannot be undone."
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        TestHistoryRepository.clearHistory(context)
                        showClearDialog = false
                    }
                ) {
                    Text("Clear History")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showClearDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
private fun TestHistorySummary(
    totalTests: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = CommerzoDimensions.CardPaddingLarge,
                    vertical = CommerzoDimensions.Space20
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space16
            )
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.History,
                    contentDescription = null,
                    modifier = Modifier.padding(
                        CommerzoDimensions.Space12
                    ),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Your Test Journey",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space4
                    )
                )

                Text(
                    text = "$totalTests completed test${if (totalTests == 1) "" else "s"}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space8
                    )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        CommerzoDimensions.Space4
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.TrendingUp,
                        contentDescription = null,
                        modifier = Modifier.height(16.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "Keep practicing and improving",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }
    }
}

@Composable
private fun TestHistoryCard(
    item: TestHistoryItem
) {
    val subjectName = subjectDisplayName(item.subjectId)
    val chapterName = chapterDisplayName(item.chapterId)
    val boardName = boardDisplayName(item.board)
    val className = classDisplayName(item.classLevel)

    val dateText = remember(item.completedAt) {
        SimpleDateFormat(
            "dd MMM yyyy • hh:mm a",
            Locale.getDefault()
        ).format(Date(item.completedAt))
    }

    val progress = item.percentage
        .coerceIn(0, 100) / 100f

    val scoreColor = when {
        item.percentage >= 80 ->
            MaterialTheme.colorScheme.primary

        item.percentage >= 50 ->
            MaterialTheme.colorScheme.tertiary

        else ->
            MaterialTheme.colorScheme.error
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
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
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = subjectName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space4
                        )
                    )

                    Text(
                        text = chapterName,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2
                    )
                }

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space4
                    )
                )

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = scoreColor.copy(alpha = 0.12f)
                ) {
                    Text(
                        text = "${item.percentage}%",
                        modifier = Modifier.padding(
                            horizontal = CommerzoDimensions.Space12,
                            vertical = CommerzoDimensions.Space8
                        ),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = scoreColor
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space16
                )
            )

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(7.dp),
                color = scoreColor,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space16
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space8
                )
            ) {
                HistoryInfoChip(
                    label = boardName,
                    modifier = Modifier.weight(1f)
                )

                HistoryInfoChip(
                    label = className,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space16
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HistoryStat(
                    label = "Score",
                    value = "${item.correct}/${item.totalQuestions}"
                )

                HistoryStat(
                    label = "Answered",
                    value = item.answered.toString()
                )

                HistoryStat(
                    label = "Wrong",
                    value = item.wrong.toString()
                )

                HistoryStat(
                    label = "Unattempted",
                    value = item.unattempted.toString()
                )
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Marked: ${item.marked}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = dateText,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun HistoryStat(
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space2
            )
        )

        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun HistoryInfoChip(
    label: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(
                horizontal = CommerzoDimensions.Space12,
                vertical = CommerzoDimensions.Space8
            ),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun EmptyTestHistory(
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    Column(
        modifier = modifier.padding(
            horizontal = CommerzoDimensions.ScreenHorizontal
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            shape = RoundedCornerShape(22.dp),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Icon(
                imageVector = Icons.Default.History,
                contentDescription = null,
                modifier = Modifier.padding(
                    CommerzoDimensions.Space20
                ),
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space20
            )
        )

        Text(
            text = "No test history yet",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        Text(
            text = "Complete a test and your results will appear here.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space20
            )
        )

        OutlinedButton(
            onClick = onBack
        ) {
            Text("Back")
        }
    }
}

private fun subjectDisplayName(
    subjectId: String
): String {
    return when (subjectId) {
        "accountancy" -> "📊 Accountancy"
        "business_studies" -> "💼 Business Studies"
        "economics" -> "📈 Economics"
        "mathematics" -> "🧮 Mathematics"
        "english" -> "📖 English"
        "hindi" -> "📝 Hindi"
        else -> subjectId
    }
}

private fun chapterDisplayName(
    chapterId: String
): String {
    return when (chapterId) {
        "accountancy_class_12_1" ->
            "Accounting for Partnership Firms"

        "accountancy_class_12_2" ->
            "Accounting for Companies"

        "accountancy_class_12_3" ->
            "Analysis of Financial Statements"

        "accountancy_class_12_4" ->
            "Cash Flow Statement"

        "business_studies_class_12_1" ->
            "Nature and Significance of Management"

        "business_studies_class_12_2" ->
            "Principles of Management"

        "economics_class_12_1" ->
            "National Income Accounting"

        "economics_class_12_2" ->
            "Money and Banking"

        "mathematics_class_12_3" ->
            "Matrices"

        "mathematics_class_12_4" ->
            "Determinants"

        else -> chapterId
    }
}

private fun boardDisplayName(
    board: Board
): String {
    return when (board) {
        Board.MP_BOARD -> "MP Board"
        Board.CBSE -> "CBSE"
    }
}

private fun classDisplayName(
    classLevel: ClassLevel
): String {
    return when (classLevel) {
        ClassLevel.CLASS_11 -> "Class 11"
        ClassLevel.CLASS_12 -> "Class 12"
    }
}
