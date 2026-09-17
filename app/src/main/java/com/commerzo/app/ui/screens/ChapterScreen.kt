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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.repository.ChapterRepository
import com.commerzo.app.data.repository.PracticeProgressRepository
import com.commerzo.app.data.repository.QuestionBankManager

@Composable
fun ChapterScreen(
    subjectId: String,
    subjectName: String,
    board: Board,
    classLevel: ClassLevel,
    onBack: () -> Unit,
    onChapterClick: (String, String) -> Unit
) {
    val chapterRepository = remember {
        ChapterRepository()
    }

    val questionBankManager = remember {
        QuestionBankManager()
    }

    val chapters = remember(
        subjectId,
        board,
        classLevel
    ) {
        chapterRepository.getChapters(
            subjectId = subjectId,
            board = board,
            classLevel = classLevel
        )
    }

    val context =
        androidx.compose.ui.platform.LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = subjectName,
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
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {
                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text =
                        "${board.displayName()} • ${classLevel.displayName()}",
                    style =
                        MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Choose a chapter",
                    style =
                        MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text =
                        "Practice chapter-wise MCQs and track your progress.",
                    style =
                        MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )
            }

            if (chapters.isEmpty()) {

                item {
                    Card(
                        modifier =
                            Modifier.fillMaxWidth(),
                        colors =
                            CardDefaults.cardColors(
                                containerColor =
                                    MaterialTheme.colorScheme.surfaceVariant
                            )
                    ) {
                        Text(
                            text =
                                "No chapters available for this subject.",
                            modifier =
                                Modifier.padding(18.dp),
                            style =
                                MaterialTheme.typography.bodyMedium,
                            color =
                                MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

            } else {

                items(
                    items = chapters,
                    key = { it.id }
                ) { chapter ->

                    val questionCount =
                        remember(
                            chapter.id,
                            subjectId,
                            board,
                            classLevel
                        ) {
                            questionBankManager
                                .getValidatedQuestions(
                                    subjectId =
                                        subjectId,
                                    chapterId =
                                        chapter.id,
                                    board =
                                        board,
                                    classLevel =
                                        classLevel
                                )
                                .size
                        }

                    val progressPercent =
                        remember(
                            chapter.id,
                            subjectId,
                            board,
                            classLevel
                        ) {
                            PracticeProgressRepository
                                .getChapterProgressPercent(
                                    context =
                                        context,
                                    subjectId =
                                        subjectId,
                                    chapterId =
                                        chapter.id,
                                    board =
                                        board,
                                    classLevel =
                                        classLevel
                                )
                        }

                    ChapterCard(
                        chapterNumber =
                            chapter.chapterNumber,
                        title =
                            chapter.title,
                        questionCount =
                            questionCount,
                        progressPercent =
                            progressPercent,
                        enabled =
                            questionCount > 0,
                        onClick = {
                            if (questionCount > 0) {
                                onChapterClick(
                                    chapter.id,
                                    chapter.title
                                )
                            }
                        }
                    )
                }
            }

            item {
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }
        }
    }
}

@Composable
private fun ChapterCard(
    chapterNumber: Int,
    title: String,
    questionCount: Int,
    progressPercent: Int,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier =
            Modifier.fillMaxWidth(),
        onClick = onClick,
        enabled = enabled,
        colors =
            CardDefaults.cardColors(
                containerColor =
                    if (enabled) {
                        MaterialTheme.colorScheme.surface
                    } else {
                        MaterialTheme.colorScheme.surfaceVariant
                    }
            )
    ) {

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Text(
                text =
                    chapterNumber.toString(),
                style =
                    MaterialTheme.typography.titleLarge,
                fontWeight =
                    FontWeight.Bold,
                color =
                    if (enabled) {
                        MaterialTheme.colorScheme.onSurface
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
            )

            Spacer(
                modifier =
                    Modifier.width(14.dp)
            )

            Column(
                modifier =
                    Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    style =
                        MaterialTheme.typography.titleMedium,
                    fontWeight =
                        FontWeight.SemiBold,
                    color =
                        if (enabled) {
                            MaterialTheme.colorScheme.onSurface
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        }
                )

                Spacer(
                    modifier =
                        Modifier.height(4.dp)
                )

                Text(
                    text =
                        if (questionCount > 0) {
                            "$questionCount valid MCQs available"
                        } else {
                            "MCQs coming soon"
                        },
                    style =
                        MaterialTheme.typography.bodySmall,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )

                if (enabled) {

                    Spacer(
                        modifier =
                            Modifier.height(10.dp)
                    )

                    LinearProgressIndicator(
                        progress = {
                            progressPercent
                                .coerceIn(0, 100) / 100f
                        },
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .height(5.dp)
                    )

                    Spacer(
                        modifier =
                            Modifier.height(5.dp)
                    )

                    Text(
                        text =
                            when {
                                progressPercent >= 100 ->
                                    "Completed • 100%"

                                progressPercent > 0 ->
                                    "$progressPercent% completed"

                                else ->
                                    "Not started"
                            },
                        style =
                            MaterialTheme.typography.labelSmall,
                        color =
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            if (enabled) {

                Spacer(
                    modifier =
                        Modifier.width(10.dp)
                )

                Icon(
                    imageVector =
                        Icons.Default.ArrowForward,
                    contentDescription =
                        "Open $title"
                )
            }
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
