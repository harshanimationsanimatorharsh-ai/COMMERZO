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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DeleteSweep
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.commerzo.app.ui.theme.CommerzoDimensions
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

    var showClearDialog by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            CommerzoDimensions.Space2
                        )
                    ) {
                        Text(
                            text = "Bookmarks",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Your saved revision questions",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
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
                                imageVector = Icons.Default.DeleteSweep,
                                contentDescription = "Clear all bookmarks"
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->

        when {
            bookmarkedQuestions.isEmpty() -> {
                EmptyBookmarksContent(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }

            questionDetails.isEmpty() -> {
                MissingBookmarksContent(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentPadding = PaddingValues(
                        horizontal = CommerzoDimensions.ScreenHorizontal,
                        vertical = CommerzoDimensions.ScreenVertical
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        CommerzoDimensions.CardSpacing
                    )
                ) {
                    item {
                        BookmarkSummaryCard(
                            count = bookmarkedQuestions.size
                        )
                    }

                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = CommerzoDimensions.Space4
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "Saved Questions",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onBackground
                                )

                                Spacer(
                                    modifier = Modifier.height(
                                        CommerzoDimensions.Space2
                                    )
                                )

                                Text(
                                    text = "Review these whenever you revise.",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant
                            ) {
                                Text(
                                    text = "${questionDetails.size}",
                                    modifier = Modifier.padding(
                                        horizontal = CommerzoDimensions.Space10,
                                        vertical = CommerzoDimensions.Space6
                                    ),
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
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
                                viewModel.removeBookmark(question.id)
                            }
                        )
                    }

                    item {
                        Spacer(
                            modifier = Modifier.height(
                                CommerzoDimensions.Space16
                            )
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
                    text = "Clear all bookmarks?"
                )
            },
            text = {
                Text(
                    text = "All saved questions will be removed from your bookmarks."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.clearAllBookmarks()
                        showClearDialog = false
                    }
                ) {
                    Text(
                        text = "Clear",
                        color = MaterialTheme.colorScheme.error
                    )
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
private fun BookmarkSummaryCard(
    count: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(52.dp),
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.82f
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = null,
                    modifier = Modifier.padding(
                        CommerzoDimensions.Space14
                    ),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space12
                )
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space4
                )
            ) {
                Text(
                    text = if (count == 1) {
                        "1 saved question"
                    } else {
                        "$count saved questions"
                    },
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Text(
                    text = "Important questions saved for focused revision.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Composable
private fun BookmarkQuestionCard(
    question: Question,
    onRemove: () -> Unit
) {
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
                CommerzoDimensions.CardPadding
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space12
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(42.dp),
                    shape = RoundedCornerShape(13.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Icon(
                        imageVector = Icons.Default.Bookmark,
                        contentDescription = null,
                        modifier = Modifier.padding(
                            CommerzoDimensions.Space10
                        ),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(
                    modifier = Modifier.width(
                        CommerzoDimensions.Space12
                    )
                )

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(
                        CommerzoDimensions.Space2
                    )
                ) {
                    Text(
                        text = subjectDisplayName(
                            question.subjectId
                        ),
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = chapterDisplayName(
                            question.chapterId
                        ),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2
                    )
                }

                IconButton(
                    onClick = onRemove
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Remove bookmark",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space8
                )
            ) {
                Surface(
                    shape = RoundedCornerShape(9.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Text(
                        text = question.board.displayName(),
                        modifier = Modifier.padding(
                            horizontal = CommerzoDimensions.Space10,
                            vertical = CommerzoDimensions.Space6
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Surface(
                    shape = RoundedCornerShape(9.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Text(
                        text = question.classLevel.displayName(),
                        modifier = Modifier.padding(
                            horizontal = CommerzoDimensions.Space10,
                            vertical = CommerzoDimensions.Space6
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Text(
                text = question.question,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space6
                )
            ) {
                question.options.forEachIndexed { index, option ->

                    val isCorrect =
                        index == question.correctAnswer

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(13.dp),
                        color = if (isCorrect) {
                            MaterialTheme.colorScheme.primaryContainer
                        } else {
                            MaterialTheme.colorScheme.surfaceVariant
                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = CommerzoDimensions.Space12,
                                    vertical = CommerzoDimensions.Space10
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = optionLetter(index),
                                modifier = Modifier.width(28.dp),
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = if (isCorrect) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant
                                }
                            )

                            Text(
                                text = option,
                                modifier = Modifier.weight(1f),
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            if (isCorrect) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = "Correct answer",
                                    modifier = Modifier.size(
                                        CommerzoDimensions.IconSmall
                                    ),
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }
            }

            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.surfaceVariant
            ) {
                Column(
                    modifier = Modifier.padding(
                        CommerzoDimensions.Space12
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        CommerzoDimensions.Space4
                    )
                ) {
                    Text(
                        text = "Explanation",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = question.explanation,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun EmptyBookmarksContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(
            horizontal = CommerzoDimensions.ScreenHorizontal
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier.size(76.dp),
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Icon(
                imageVector = Icons.Default.Bookmark,
                contentDescription = null,
                modifier = Modifier.padding(
                    CommerzoDimensions.Space20
                ),
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space16
            )
        )

        Text(
            text = "No bookmarks yet",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        Text(
            text = "Save important questions while practicing. They will appear here for quick revision.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun MissingBookmarksContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(
            horizontal = CommerzoDimensions.ScreenHorizontal
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier.size(68.dp),
            shape = RoundedCornerShape(22.dp),
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.padding(
                    CommerzoDimensions.Space16
                ),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space16
            )
        )

        Text(
            text = "Saved questions unavailable",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        Text(
            text = "Some bookmarked questions are not currently available in the local question bank.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
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
