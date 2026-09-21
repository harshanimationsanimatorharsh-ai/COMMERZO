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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.repository.QuestionBankManager
import com.commerzo.app.data.repository.content.ContentManager
import com.commerzo.app.data.repository.content.CurriculumContentMapper
import com.commerzo.app.data.model.content.CurriculumContentIds

@Composable
fun TestSelectionScreen(
    onStartTest: (
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel
    ) -> Unit,
    onBack: () -> Unit
) {
    val contentManager =
        remember {
            ContentManager()
        }

    val questionBankManager =
        remember {
            QuestionBankManager()
        }

    var selectedBoard by remember {
        mutableStateOf(Board.MP_BOARD)
    }

    var selectedClass by remember {
        mutableStateOf(ClassLevel.CLASS_12)
    }

    var selectedSubjectId by remember {
        mutableStateOf<String?>(null)
    }

    var selectedChapterId by remember {
        mutableStateOf<String?>(null)
    }

    val boardId =
        remember(selectedBoard) {
            CurriculumContentMapper.getBoardId(
                selectedBoard
            )
        }

    val classId =
        remember(selectedClass) {
            CurriculumContentMapper.getClassId(
                selectedClass
            )
        }

    val subjects by produceState<List<ContentSubject>>(
        initialValue = emptyList(),
        boardId,
        classId
    ) {
        value =
            contentManager.getSubjects(
                boardId = boardId,
                classId = classId
            )
    }

    val chapters by produceState<List<ContentChapter>>(
        initialValue = emptyList(),
        selectedSubjectId,
        boardId,
        classId
    ) {
        value =
            selectedSubjectId?.let { subjectId ->
                contentManager.getChapters(
                    boardId = boardId,
                    classId = classId,
                    subjectId = subjectId
                )
            } ?: emptyList()
    }

    val questionSubjectId =
        remember(selectedSubjectId) {
            toQuestionSubjectId(
                selectedSubjectId
            )
        }

    val selectedChapter =
        chapters.firstOrNull {
            it.id == selectedChapterId
        }

    val selectedQuestionCount =
        selectedChapter?.let { chapter ->
            questionBankManager
                .getValidatedQuestions(
                    subjectId =
                        questionSubjectId ?: "",
                    chapterId =
                        chapter.id,
                    board =
                        selectedBoard,
                    classLevel =
                        selectedClass
                )
                .size
        } ?: 0

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Choose Test",
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
                }
            )
        }
    ) { paddingValues ->

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
                        "Test Selection",
                    style =
                        MaterialTheme.typography.headlineSmall,
                    fontWeight =
                        FontWeight.Bold
                )

                Spacer(
                    modifier =
                        Modifier.height(4.dp)
                )

                Text(
                    text =
                        "Select your board, class, subject and chapter.",
                    style =
                        MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(
                    modifier =
                        Modifier.height(16.dp)
                )
            }

            item {

                Text(
                    text = "Board",
                    style =
                        MaterialTheme.typography.titleMedium,
                    fontWeight =
                        FontWeight.SemiBold
                )

                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )

                Row(
                    modifier =
                        Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.spacedBy(8.dp)
                ) {

                    SelectionButton(
                        text = "MP Board",
                        selected =
                            selectedBoard ==
                                Board.MP_BOARD,
                        onClick = {
                            selectedBoard =
                                Board.MP_BOARD
                            selectedSubjectId =
                                null
                            selectedChapterId =
                                null
                        },
                        modifier =
                            Modifier.weight(1f)
                    )

                    SelectionButton(
                        text = "CBSE",
                        selected =
                            selectedBoard ==
                                Board.CBSE,
                        onClick = {
                            selectedBoard =
                                Board.CBSE
                            selectedSubjectId =
                                null
                            selectedChapterId =
                                null
                        },
                        modifier =
                            Modifier.weight(1f)
                    )
                }
            }

            item {

                Text(
                    text = "Class",
                    style =
                        MaterialTheme.typography.titleMedium,
                    fontWeight =
                        FontWeight.SemiBold
                )

                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )

                Row(
                    modifier =
                        Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.spacedBy(8.dp)
                ) {

                    SelectionButton(
                        text = "Class 11",
                        selected =
                            selectedClass ==
                                ClassLevel.CLASS_11,
                        onClick = {
                            selectedClass =
                                ClassLevel.CLASS_11
                            selectedSubjectId =
                                null
                            selectedChapterId =
                                null
                        },
                        modifier =
                            Modifier.weight(1f)
                    )

                    SelectionButton(
                        text = "Class 12",
                        selected =
                            selectedClass ==
                                ClassLevel.CLASS_12,
                        onClick = {
                            selectedClass =
                                ClassLevel.CLASS_12
                            selectedSubjectId =
                                null
                            selectedChapterId =
                                null
                        },
                        modifier =
                            Modifier.weight(1f)
                    )
                }
            }

            item {

                Spacer(
                    modifier =
                        Modifier.height(4.dp)
                )

                Text(
                    text = "Subject",
                    style =
                        MaterialTheme.typography.titleMedium,
                    fontWeight =
                        FontWeight.SemiBold
                )
            }

            items(
                items = subjects,
                key = { it.id }
            ) { subject ->

                val chapterCount =
                    if (selectedSubjectId == subject.id) {
                        chapters.size
                    } else {
                        0
                    }

                SelectionCard(
                    title =
                        "${subject.emoji} ${subject.name}",
                    subtitle =
                        if (selectedSubjectId == subject.id) {
                            "$chapterCount chapters"
                        } else {
                            "Select to view chapters"
                        },
                    selected =
                        selectedSubjectId ==
                            subject.id,
                    onClick = {
                        selectedSubjectId =
                            subject.id
                        selectedChapterId =
                            null
                    }
                )
            }

            if (selectedSubjectId != null) {

                item {

                    Spacer(
                        modifier =
                            Modifier.height(4.dp)
                    )

                    Text(
                        text = "Chapter",
                        style =
                            MaterialTheme.typography.titleMedium,
                        fontWeight =
                            FontWeight.SemiBold
                    )
                }

                items(
                    items = chapters,
                    key = { it.id }
                ) { chapter ->

                    val count =
                        questionBankManager
                            .getValidatedQuestions(
                                subjectId =
                                    questionSubjectId
                                        ?: "",
                                chapterId =
                                    chapter.id,
                                board =
                                    selectedBoard,
                                classLevel =
                                    selectedClass
                            )
                            .size

                    SelectionCard(
                        title =
                            "${chapter.chapterNumber}. ${chapter.title}",
                        subtitle =
                            if (count > 0) {
                                "$count valid MCQs available"
                            } else {
                                "No valid MCQs yet"
                            },
                        selected =
                            selectedChapterId ==
                                chapter.id,
                        enabled =
                            count > 0,
                        onClick = {
                            if (count > 0) {
                                selectedChapterId =
                                    chapter.id
                            }
                        }
                    )
                }
            }

            item {

                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )

                Card(
                    modifier =
                        Modifier.fillMaxWidth(),
                    colors =
                        CardDefaults.cardColors(
                            containerColor =
                                MaterialTheme.colorScheme.surfaceVariant
                        )
                ) {

                    Column(
                        modifier =
                            Modifier.padding(16.dp)
                    ) {

                        Text(
                            text =
                                "Test Summary",
                            style =
                                MaterialTheme.typography.titleMedium,
                            fontWeight =
                                FontWeight.Bold
                        )

                        Spacer(
                            modifier =
                                Modifier.height(8.dp)
                        )

                        Text(
                            text =
                                "Board: ${selectedBoard.displayName()}",
                            style =
                                MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text =
                                "Class: ${selectedClass.displayName()}",
                            style =
                                MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text =
                                "Subject: ${
                                    subjects
                                        .firstOrNull {
                                            it.id ==
                                                selectedSubjectId
                                        }
                                        ?.name
                                        ?: "Not selected"
                                }",
                            style =
                                MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text =
                                "Chapter: ${
                                    selectedChapter
                                        ?.title
                                        ?: "Not selected"
                                }",
                            style =
                                MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text =
                                "Questions available: $selectedQuestionCount",
                            style =
                                MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            item {

                Spacer(
                    modifier =
                        Modifier.height(4.dp)
                )

                Button(
                    onClick = {

                        val subjectId =
                            selectedSubjectId
                                ?: return@Button

                        val chapterId =
                            selectedChapterId
                                ?: return@Button

                        if (
                            selectedQuestionCount <= 0
                        ) {
                            return@Button
                        }

                        onStartTest(
                            subjectId,
                            chapterId,
                            selectedBoard,
                            selectedClass
                        )
                    },
                    enabled =
                        selectedSubjectId != null &&
                            selectedChapterId != null &&
                            selectedQuestionCount > 0,
                    modifier =
                        Modifier.fillMaxWidth()
                ) {
                    Text("Start Test")
                }

                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )

                OutlinedButton(
                    onClick = onBack,
                    modifier =
                        Modifier.fillMaxWidth()
                ) {
                    Text("Cancel")
                }

                Spacer(
                    modifier =
                        Modifier.height(16.dp)
                )
            }
        }
    }
}

private fun toQuestionSubjectId(
    subjectId: String?
): String? {
    return when (subjectId) {

        CurriculumContentIds
            .MP_BOARD_CLASS_12_ECONOMICS_MICRO,
        CurriculumContentIds
            .MP_BOARD_CLASS_12_ECONOMICS_MACRO,
        CurriculumContentIds
            .CBSE_CLASS_12_ECONOMICS_INDIAN,
        CurriculumContentIds
            .CBSE_CLASS_12_ECONOMICS_MACRO -> {
            "economics"
        }

        else -> subjectId
    }
}

@Composable
private fun SelectionButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (selected) {
        Button(
            onClick = onClick,
            modifier = modifier
        ) {
            Text(text)
        }
    } else {
        OutlinedButton(
            onClick = onClick,
            modifier = modifier
        ) {
            Text(text)
        }
    }
}

@Composable
private fun SelectionCard(
    title: String,
    subtitle: String,
    selected: Boolean,
    enabled: Boolean = true,
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
                    when {
                        !enabled ->
                            MaterialTheme.colorScheme.surfaceVariant

                        selected ->
                            MaterialTheme.colorScheme.primaryContainer

                        else ->
                            MaterialTheme.colorScheme.surface
                    }
            )
    ) {

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Column(
                modifier =
                    Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    style =
                        MaterialTheme.typography.titleMedium,
                    fontWeight =
                        FontWeight.SemiBold
                )

                Spacer(
                    modifier =
                        Modifier.height(3.dp)
                )

                Text(
                    text = subtitle,
                    style =
                        MaterialTheme.typography.bodySmall,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            if (selected) {

                Spacer(
                    modifier =
                        Modifier.width(8.dp)
                )

                Icon(
                    imageVector =
                        Icons.Default.CheckCircle,
                    contentDescription =
                        "Selected",
                    tint =
                        MaterialTheme.colorScheme.primary
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
