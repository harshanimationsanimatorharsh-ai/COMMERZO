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
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DeleteSweep
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TestHistoryScreen(
    onBack: () -> Unit
) {
    val context =
        androidx.compose.ui.platform.LocalContext.current

    LaunchedEffect(Unit) {
        TestHistoryRepository.initialize(context)
    }

    val history by
        TestHistoryRepository.history.collectAsState()

    var showClearDialog by
        remember {
            mutableStateOf(false)
        }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Test History",
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

                    if (history.isNotEmpty()) {

                        IconButton(
                            onClick = {
                                showClearDialog = true
                            }
                        ) {
                            Icon(
                                imageVector =
                                    Icons.Default.DeleteSweep,
                                contentDescription =
                                    "Clear history"
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->

        if (history.isEmpty()) {

            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(24.dp),
                horizontalAlignment =
                    Alignment.CenterHorizontally,
                verticalArrangement =
                    Arrangement.Center
            ) {

                Text(
                    text =
                        "No test history yet",
                    style =
                        MaterialTheme.typography.headlineSmall,
                    fontWeight =
                        FontWeight.Bold
                )

                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )

                Text(
                    text =
                        "Complete a test and your result will appear here.",
                    style =
                        MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(
                    modifier =
                        Modifier.height(20.dp)
                )

                OutlinedButton(
                    onClick = onBack
                ) {
                    Text("Back")
                }
            }

        } else {

            LazyColumn(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(horizontal = 16.dp),
                verticalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                item {

                    Spacer(
                        modifier =
                            Modifier.height(8.dp)
                    )

                    Text(
                        text =
                            "${history.size} completed test${if (history.size == 1) "" else "s"}",
                        style =
                            MaterialTheme.typography.bodyMedium,
                        color =
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(
                        modifier =
                            Modifier.height(4.dp)
                    )
                }

                items(
                    items = history,
                    key = { it.id }
                ) { item ->

                    TestHistoryCard(
                        item = item
                    )
                }

                item {

                    Spacer(
                        modifier =
                            Modifier.height(16.dp)
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
                Text("Clear Test History?")
            },
            text = {
                Text(
                    "All saved test history will be removed from this device."
                )
            },
            confirmButton = {
                Button(
                    onClick = {

                        TestHistoryRepository
                            .clearHistory(context)

                        showClearDialog = false
                    }
                ) {
                    Text("Clear")
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
private fun TestHistoryCard(
    item: TestHistoryItem
) {

    val subjectName =
        subjectDisplayName(item.subjectId)

    val chapterName =
        chapterDisplayName(item.chapterId)

    val boardName =
        boardDisplayName(item.board)

    val className =
        classDisplayName(item.classLevel)

    val dateText =
        remember(item.completedAt) {
            SimpleDateFormat(
                "dd MMM yyyy • hh:mm a",
                Locale.getDefault()
            ).format(
                Date(item.completedAt)
            )
        }

    Card(
        modifier =
            Modifier.fillMaxWidth(),
        colors =
            CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme.surface
            )
    ) {

        Column(
            modifier =
                Modifier.padding(16.dp)
        ) {

            Text(
                text =
                    subjectName,
                style =
                    MaterialTheme.typography.titleMedium,
                fontWeight =
                    FontWeight.Bold
            )

            Spacer(
                modifier =
                    Modifier.height(4.dp)
            )

            Text(
                text =
                    chapterName,
                style =
                    MaterialTheme.typography.bodyMedium,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier =
                    Modifier.height(10.dp)
            )

            Row(
                modifier =
                    Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {

                Text(
                    text =
                        boardName,
                    style =
                        MaterialTheme.typography.bodySmall
                )

                Text(
                    text =
                        className,
                    style =
                        MaterialTheme.typography.bodySmall
                )
            }

            Spacer(
                modifier =
                    Modifier.height(10.dp)
            )

            Row(
                modifier =
                    Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {

                Text(
                    text =
                        "Score: ${item.correct}/${item.totalQuestions}",
                    style =
                        MaterialTheme.typography.bodyMedium,
                    fontWeight =
                        FontWeight.SemiBold
                )

                Text(
                    text =
                        "${item.percentage}%",
                    style =
                        MaterialTheme.typography.titleMedium,
                    fontWeight =
                        FontWeight.Bold
                )
            }

            Spacer(
                modifier =
                    Modifier.height(6.dp)
            )

            Text(
                text =
                    "Answered: ${item.answered} • Wrong: ${item.wrong}",
                style =
                    MaterialTheme.typography.bodySmall,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text =
                    "Unattempted: ${item.unattempted} • Marked: ${item.marked}",
                style =
                    MaterialTheme.typography.bodySmall,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier =
                    Modifier.height(8.dp)
            )

            Text(
                text =
                    dateText,
                style =
                    MaterialTheme.typography.labelSmall,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

private fun subjectDisplayName(
    subjectId: String
): String {

    return when (subjectId) {

        "accountancy" ->
            "📊 Accountancy"

        "business_studies" ->
            "💼 Business Studies"

        "economics" ->
            "📈 Economics"

        "mathematics" ->
            "🧮 Mathematics"

        "english" ->
            "📖 English"

        "hindi" ->
            "📝 Hindi"

        else ->
            subjectId
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

        else ->
            chapterId
    }
}

private fun boardDisplayName(
    board: Board
): String {

    return when (board) {

        Board.MP_BOARD ->
            "MP Board"

        Board.CBSE ->
            "CBSE"
    }
}

private fun classDisplayName(
    classLevel: ClassLevel
): String {

    return when (classLevel) {

        ClassLevel.CLASS_11 ->
            "Class 11"

        ClassLevel.CLASS_12 ->
            "Class 12"
    }
}
