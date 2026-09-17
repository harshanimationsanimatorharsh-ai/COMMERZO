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
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Delete
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question
import com.commerzo.app.ui.viewmodel.PracticeSessionViewModel

@Composable
fun BookmarksScreen(
    onBack: () -> Unit,
    viewModel: PracticeSessionViewModel = viewModel()
) {
    val bookmarkedQuestions by
        viewModel.bookmarkedQuestions.collectAsState()

    val questionDetails by
        viewModel.bookmarkedQuestionDetails.collectAsState()

    var showClearDialog by
        remember {
            mutableStateOf(false)
        }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Bookmarks",
                        fontWeight = FontWeight.Bold
                    )
                },
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
                actions = {
                    if (bookmarkedQuestions.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                showClearDialog = true
                            }
                        ) {
                            Icon(
                                imageVector =
                                    Icons.Default.DeleteSweep,
                                contentDescription =
                                    "Clear all bookmarks"
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

        when {
            bookmarkedQuestions.isEmpty() -> {
                EmptyBookmarksContent(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                )
            }

            questionDetails.isEmpty() -> {
                MissingBookmarksContent(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                )
            }

            else -> {
                LazyColumn(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(horizontal = 16.dp),
                    verticalArrangement =
                        Arrangement.spacedBy(14.dp)
                ) {
                    item {
                        Spacer(
                            modifier =
                                Modifier.height(8.dp)
                        )

                        Text(
                            text =
                                "${bookmarkedQuestions.size} saved " +
                                    if (
                                        bookmarkedQuestions.size == 1
                                    ) {
                                        "question"
                                    } else {
                                        "questions"
                                    },
                            style =
                                MaterialTheme.typography.titleMedium,
                            fontWeight =
                                FontWeight.SemiBold
                        )

                        Spacer(
                            modifier =
                                Modifier.height(4.dp)
                        )

                        Text(
                            text =
                                "Your saved questions for quick revision.",
                            style =
                                MaterialTheme.typography.bodySmall,
                            color =
                                MaterialTheme
                                    .colorScheme
                                    .onSurfaceVariant
                        )

                        Spacer(
                            modifier =
                                Modifier.height(4.dp)
                        )
                    }

                    items(
                        items = questionDetails,
                        key = {
                            it.id
                        }
                    ) { question ->

                        BookmarkQuestionCard(
                            question = question,
                            onRemove = {
                                viewModel.removeBookmark(
                                    question.id
                                )
                            }
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
    }

    if (showClearDialog) {
        AlertDialog(
            onDismissRequest = {
                showClearDialog = false
            },
            title = {
                Text(
                    text = "Clear bookmarks?"
                )
            },
            text = {
                Text(
                    text =
                        "All saved questions will be removed from your bookmarks."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.clearAllBookmarks()
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
private fun BookmarkQuestionCard(
    question: Question,
    onRemove: () -> Unit
) {
    Card(
        modifier =
            Modifier.fillMaxWidth(),
        shape =
            RoundedCornerShape(18.dp),
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

            Row(
                modifier =
                    Modifier.fillMaxWidth(),
                verticalAlignment =
                    Alignment.CenterVertically
            ) {
                Icon(
                    imageVector =
                        Icons.Default.Bookmark,
                    contentDescription =
                        "Bookmarked"
                )

                Spacer(
                    modifier =
                        Modifier.width(8.dp)
                )

                Column(
                    modifier =
                        Modifier.weight(1f)
                ) {
                    Text(
                        text =
                            subjectDisplayName(
                                question.subjectId
                            ),
                        style =
                            MaterialTheme
                                .typography
                                .labelLarge,
                        color =
                            MaterialTheme
                                .colorScheme
                                .primary,
                        fontWeight =
                            FontWeight.SemiBold
                    )

                    Spacer(
                        modifier =
                            Modifier.height(2.dp)
                    )

                    Text(
                        text =
                            chapterDisplayName(
                                question.chapterId
                            ),
                        style =
                            MaterialTheme
                                .typography
                                .labelMedium,
                        color =
                            MaterialTheme
                                .colorScheme
                                .onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = onRemove
                ) {
                    Icon(
                        imageVector =
                            Icons.Default.Delete,
                        contentDescription =
                            "Remove bookmark"
                    )
                }
            }

            Spacer(
                modifier =
                    Modifier.height(8.dp)
            )

            Text(
                text =
                    "${question.board.displayName()} • " +
                        question.classLevel.displayName(),
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
                    Modifier.height(14.dp)
            )

            Text(
                text =
                    question.question,
                style =
                    MaterialTheme
                        .typography
                        .titleMedium,
                fontWeight =
                    FontWeight.SemiBold
            )

            Spacer(
                modifier =
                    Modifier.height(14.dp)
            )

            question.options.forEachIndexed {
                    index,
                    option ->

                val isCorrect =
                    index == question.correctAnswer

                Card(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = 4.dp
                            ),
                    shape =
                        RoundedCornerShape(12.dp),
                    colors =
                        CardDefaults.cardColors(
                            containerColor =
                                if (isCorrect) {
                                    MaterialTheme
                                        .colorScheme
                                        .primaryContainer
                                } else {
                                    MaterialTheme
                                        .colorScheme
                                        .surfaceVariant
                                }
                        )
                ) {
                    Row(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {
                        Text(
                            text =
                                optionLetter(index),
                            fontWeight =
                                FontWeight.Bold,
                            modifier =
                                Modifier.width(28.dp)
                        )

                        Text(
                            text = option,
                            modifier =
                                Modifier.weight(1f),
                            style =
                                MaterialTheme
                                    .typography
                                    .bodyMedium
                        )

                        if (isCorrect) {
                            Text(
                                text = "✓",
                                color =
                                    MaterialTheme
                                        .colorScheme
                                        .primary,
                                fontWeight =
                                    FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Spacer(
                modifier =
                    Modifier.height(12.dp)
            )

            Text(
                text = "Explanation",
                style =
                    MaterialTheme
                        .typography
                        .labelLarge,
                fontWeight =
                    FontWeight.Bold
            )

            Spacer(
                modifier =
                    Modifier.height(4.dp)
            )

            Text(
                text =
                    question.explanation,
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
}

@Composable
private fun EmptyBookmarksContent(
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
                Icons.Default.Bookmark,
            contentDescription = null,
            modifier =
                Modifier.height(56.dp)
        )

        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        Text(
            text = "No Bookmarks Yet",
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
                "Save important questions while practicing. They will appear here.",
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

        OutlinedButton(
            onClick = {},
            enabled = false
        ) {
            Text("Start Practice")
        }
    }
}

@Composable
private fun MissingBookmarksContent(
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
        Text(
            text =
                "Saved questions unavailable",
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
                "Some bookmarked questions are not currently available in the local question bank.",
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

private fun subjectDisplayName(
    subjectId: String
): String {
    return when (subjectId) {
        "accountancy" -> "Accountancy"
        "business_studies" -> "Business Studies"
        "economics" -> "Economics"
        "mathematics" -> "Mathematics"
        "english" -> "English"
        "hindi" -> "Hindi"
        else ->
            subjectId
                .replace("_", " ")
                .replaceFirstChar {
                    it.uppercase()
                }
    }
}

private fun chapterDisplayName(
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
                .replace("_", " ")
                .replaceFirstChar {
                    it.uppercase()
                }
    }
}

private fun Board.displayName(): String {
    return when (this) {
        Board.MP_BOARD -> "MP Board"
        Board.CBSE -> "CBSE"
    }
}

private fun ClassLevel.displayName(): String {
    return when (this) {
        ClassLevel.CLASS_11 -> "Class 11"
        ClassLevel.CLASS_12 -> "Class 12"
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
