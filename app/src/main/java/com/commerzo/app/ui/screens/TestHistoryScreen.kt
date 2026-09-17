package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DeleteSweep
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.AlertDialog
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.model.TestHistory
import com.commerzo.app.data.repository.TestHistoryRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TestHistoryScreen(
    onBack: () -> Unit
) {

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
                                    "Clear test history"
                            )
                        }
                    }
                },

                colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor =
                            MaterialTheme
                                .colorScheme
                                .surface
                    )
            )
        }
    ) { paddingValues ->

        if (history.isEmpty()) {

            EmptyTestHistoryContent(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(
                            paddingValues
                        )
            )

        } else {

            LazyColumn(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(
                            paddingValues
                        )
                        .padding(
                            horizontal = 16.dp
                        ),

                verticalArrangement =
                    Arrangement.spacedBy(14.dp)
            ) {

                item {

                    Spacer(
                        modifier =
                            Modifier.height(
                                8.dp
                            )
                    )

                    Text(
                        text =
                            "${history.size} test" +
                                if (
                                    history.size == 1
                                ) {
                                    ""
                                } else {
                                    "s"
                                },

                        style =
                            MaterialTheme
                                .typography
                                .titleMedium,

                        fontWeight =
                            FontWeight.SemiBold
                    )

                    Spacer(
                        modifier =
                            Modifier.height(
                                4.dp
                            )
                    )

                    Text(
                        text =
                            "Review your previous test performance.",

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

                items(
                    items = history,
                    key = {
                        it.id
                    }
                ) { test ->

                    TestHistoryCard(
                        test = test
                    )
                }

                item {

                    Spacer(
                        modifier =
                            Modifier.height(
                                16.dp
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
                    text =
                        "Clear test history?"
                )
            },

            text = {
                Text(
                    text =
                        "All saved test results will be removed."
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {

                        TestHistoryRepository
                            .clearHistory()

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
    test: TestHistory
) {

    val percentage =
        test.percentage.coerceIn(
            0,
            100
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
                Modifier.padding(16.dp)
        ) {

            Row(
                modifier =
                    Modifier.fillMaxWidth(),

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Column(
                    modifier =
                        Modifier.weight(1f)
                ) {

                    Text(
                        text =
                            subjectName(
                                test.subjectId
                            ),

                        style =
                            MaterialTheme
                                .typography
                                .titleMedium,

                        fontWeight =
                            FontWeight.Bold
                    )

                    Spacer(
                        modifier =
                            Modifier.height(
                                3.dp
                            )
                    )

                    Text(
                        text =
                            chapterName(
                                test.chapterId
                            ),

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

                Text(
                    text =
                        "$percentage%",

                    style =
                        MaterialTheme
                            .typography
                            .headlineSmall,

                    fontWeight =
                        FontWeight.Bold,

                    color =
                        MaterialTheme
                            .colorScheme
                            .primary
                )
            }

            Spacer(
                modifier =
                    Modifier.height(
                        14.dp
                    )
            )

            Row(
                modifier =
                    Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(
                        8.dp
                    )
            ) {

                StatBox(
                    label = "Correct",
                    value = test.correct,
                    modifier =
                        Modifier.weight(
                            1f
                        )
                )

                StatBox(
                    label = "Wrong",
                    value = test.wrong,
                    modifier =
                        Modifier.weight(
                            1f
                        )
                )

                StatBox(
                    label = "Skipped",
                    value = test.unattempted,
                    modifier =
                        Modifier.weight(
                            1f
                        )
                )
            }

            Spacer(
                modifier =
                    Modifier.height(
                        12.dp
                    )
            )

            Row(
                modifier =
                    Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {

                Text(
                    text =
                        "Answered ${test.answered}/${test.totalQuestions}",

                    style =
                        MaterialTheme
                            .typography
                            .bodySmall,

                    color =
                        MaterialTheme
                            .colorScheme
                            .onSurfaceVariant
                )

                Text(
                    text =
                        formatTimestamp(
                            test.timestamp
                        ),

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
        }
    }
}

@Composable
private fun StatBox(
    label: String,
    value: Int,
    modifier: Modifier
) {

    Card(
        modifier = modifier,

        shape =
            RoundedCornerShape(12.dp),

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
                Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 10.dp,
                        horizontal = 6.dp
                    ),

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(
                text =
                    value.toString(),

                style =
                    MaterialTheme
                        .typography
                        .titleMedium,

                fontWeight =
                    FontWeight.Bold
            )

            Spacer(
                modifier =
                    Modifier.height(
                        2.dp
                    )
            )

            Text(
                text =
                    label,

                style =
                    MaterialTheme
                        .typography
                        .labelSmall,

                color =
                    MaterialTheme
                        .colorScheme
                        .onSurfaceVariant
            )
        }
    }
}

@Composable
private fun EmptyTestHistoryContent(
    modifier: Modifier = Modifier
) {

    Column(
        modifier =
            modifier.padding(24.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Center
    ) {

        Icon(
            imageVector =
                Icons.Default.History,

            contentDescription = null,

            modifier =
                Modifier.height(
                    56.dp
                )
        )

        Spacer(
            modifier =
                Modifier.height(
                    16.dp
                )
        )

        Text(
            text =
                "No Test History",

            style =
                MaterialTheme
                    .typography
                    .headlineSmall,

            fontWeight =
                FontWeight.Bold
        )

        Spacer(
            modifier =
                Modifier.height(
                    8.dp
                )
        )

        Text(
            text =
                "Complete a test and your result will appear here.",

            style =
                MaterialTheme
                    .typography
                    .bodyMedium,

            color =
                MaterialTheme
                    .colorScheme
                    .onSurfaceVariant
        )
    }
}

private fun subjectName(
    subjectId: String
): String {

    return when (subjectId) {

        "accountancy" ->
            "Accountancy"

        "business_studies" ->
            "Business Studies"

        "economics" ->
            "Economics"

        "mathematics" ->
            "Mathematics"

        "english" ->
            "English"

        "hindi" ->
            "Hindi"

        else ->
            subjectId
                .replace(
                    "_",
                    " "
                )
                .replaceFirstChar {
                    it.uppercase()
                }
    }
}

private fun chapterName(
    chapterId: String
): String {

    return when (chapterId) {

        "accountancy_class_12_1" ->
            "Accounting for Partnership Firms"

        "business_studies_class_12_1" ->
            "Nature and Significance of Management"

        "economics_class_12_1" ->
            "National Income Accounting"

        "mathematics_class_12_3" ->
            "Matrices"

        else ->
            chapterId
                .replace(
                    "_class_12_",
                    " • Chapter "
                )
                .replace(
                    "_class_11_",
                    " • Chapter "
                )
                .replace(
                    "_",
                    " "
                )
    }
}

private fun formatTimestamp(
    timestamp: Long
): String {

    return try {

        SimpleDateFormat(
            "dd MMM yyyy, hh:mm a",
            Locale.getDefault()
        ).format(
            Date(timestamp)
        )

    } catch (_: Exception) {

        "Unknown date"
    }
}
