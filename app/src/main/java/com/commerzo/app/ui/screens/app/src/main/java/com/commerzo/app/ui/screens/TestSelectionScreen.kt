package com.commerzo.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.CurriculumContentIds
import com.commerzo.app.data.repository.QuestionBankManager
import com.commerzo.app.data.repository.content.ContentManager
import com.commerzo.app.data.repository.content.CurriculumContentMapper

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
    val contentManager = remember {
        ContentManager()
    }

    val questionBankManager = remember {
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

    val boardId = remember(selectedBoard) {
        CurriculumContentMapper.getBoardId(selectedBoard)
    }

    val classId = remember(selectedClass) {
        CurriculumContentMapper.getClassId(selectedClass)
    }

    val subjects by produceState<List<ContentSubject>>(
        initialValue = emptyList(),
        boardId,
        classId
    ) {
        value = contentManager.getSubjects(
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
        value = selectedSubjectId?.let { subjectId ->
            contentManager.getChapters(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        } ?: emptyList()
    }

    val questionSubjectId = remember(selectedSubjectId) {
        toQuestionSubjectId(selectedSubjectId)
    }

    val selectedChapter = chapters.firstOrNull {
        it.id == selectedChapterId
    }

    val selectedQuestionCount =
        selectedChapter?.let { chapter ->
            questionBankManager
                .getValidatedQuestions(
                    subjectId = questionSubjectId ?: "",
                    chapterId = chapter.id,
                    board = selectedBoard,
                    classLevel = selectedClass
                )
                .size
        } ?: 0

    val selectedSubject = subjects.firstOrNull {
        it.id == selectedSubjectId
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Test Center",
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = "Build your test",
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
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 10.dp,
                bottom = 28.dp
            ),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            item {
                TestHeroCard()
            }

            item {
                SelectionSectionTitle(
                    number = "01",
                    title = "Choose Board",
                    subtitle = "Select your examination board"
                )
            }

            item {
                SelectionChoiceRow(
                    first = "MP Board",
                    second = "CBSE",
                    firstSelected = selectedBoard == Board.MP_BOARD,
                    secondSelected = selectedBoard == Board.CBSE,
                    onFirstClick = {
                        selectedBoard = Board.MP_BOARD
                        selectedSubjectId = null
                        selectedChapterId = null
                    },
                    onSecondClick = {
                        selectedBoard = Board.CBSE
                        selectedSubjectId = null
                        selectedChapterId = null
                    }
                )
            }

            item {
                SelectionSectionTitle(
                    number = "02",
                    title = "Choose Class",
                    subtitle = "Select your current class"
                )
            }

            item {
                SelectionChoiceRow(
                    first = "Class 11",
                    second = "Class 12",
                    firstSelected = selectedClass == ClassLevel.CLASS_11,
                    secondSelected = selectedClass == ClassLevel.CLASS_12,
                    onFirstClick = {
                        selectedClass = ClassLevel.CLASS_11
                        selectedSubjectId = null
                        selectedChapterId = null
                    },
                    onSecondClick = {
                        selectedClass = ClassLevel.CLASS_12
                        selectedSubjectId = null
                        selectedChapterId = null
                    }
                )
            }

            item {
                SelectionSectionTitle(
                    number = "03",
                    title = "Choose Subject",
                    subtitle = "Select a subject for your test"
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
                    title = "${subject.emoji} ${subject.name}",
                    subtitle =
                        if (selectedSubjectId == subject.id) {
                            "$chapterCount chapters available"
                        } else {
                            "Tap to explore chapters"
                        },
                    icon = Icons.Default.MenuBook,
                    selected = selectedSubjectId == subject.id,
                    onClick = {
                        selectedSubjectId = subject.id
                        selectedChapterId = null
                    }
                )
            }

            if (selectedSubjectId != null) {

                item {
                    SelectionSectionTitle(
                        number = "04",
                        title = "Choose Chapter",
                        subtitle = "Select the chapter you want to test"
                    )
                }

                items(
                    items = chapters,
                    key = { it.id }
                ) { chapter ->

                    val count =
                        questionBankManager
                            .getValidatedQuestions(
                                subjectId = questionSubjectId ?: "",
                                chapterId = chapter.id,
                                board = selectedBoard,
                                classLevel = selectedClass
                            )
                            .size

                    SelectionCard(
                        title = "${chapter.chapterNumber}. ${chapter.title}",
                        subtitle =
                            if (count > 0) {
                                "$count valid MCQs available"
                            } else {
                                "No valid MCQs available yet"
                            },
                        icon = Icons.Default.Assessment,
                        selected = selectedChapterId == chapter.id,
                        enabled = count > 0,
                        onClick = {
                            if (count > 0) {
                                selectedChapterId = chapter.id
                            }
                        }
                    )
                }
            }

            item {
                TestSummaryCard(
                    board = selectedBoard.displayName(),
                    className = selectedClass.displayName(),
                    subject = selectedSubject?.name ?: "Not selected",
                    chapter = selectedChapter?.title ?: "Not selected",
                    questionCount = selectedQuestionCount
                )
            }

            item {
                Button(
                    onClick = {

                        val subjectId =
                            selectedSubjectId ?: return@Button

                        val chapterId =
                            selectedChapterId ?: return@Button

                        if (selectedQuestionCount <= 0) {
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(17.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Start Test",
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                OutlinedButton(
                    onClick = onBack,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(17.dp)
                ) {
                    Text("Cancel")
                }
            }
        }
    }
}

@Composable
private fun TestHeroCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(58.dp),
                shape = RoundedCornerShape(18.dp),
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f)
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Assessment,
                        contentDescription = "Tests",
                        modifier = Modifier.size(28.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.width(15.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Test Center",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Choose your curriculum and challenge yourself.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(
                        alpha = 0.78f
                    )
                )
            }
        }
    }
}

@Composable
private fun SelectionSectionTitle(
    number: String,
    title: String,
    subtitle: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.size(34.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.width(11.dp))

        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun SelectionChoiceRow(
    first: String,
    second: String,
    firstSelected: Boolean,
    secondSelected: Boolean,
    onFirstClick: () -> Unit,
    onSecondClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ChoiceCard(
            modifier = Modifier.weight(1f),
            title = first,
            selected = firstSelected,
            onClick = onFirstClick
        )

        ChoiceCard(
            modifier = Modifier.weight(1f),
            title = second,
            selected = secondSelected,
            onClick = onSecondClick
        )
    }
}

@Composable
private fun ChoiceCard(
    modifier: Modifier,
    title: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if (selected) {
                    MaterialTheme.colorScheme.primaryContainer
                } else {
                    MaterialTheme.colorScheme.surface
                }
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 14.dp,
                    vertical = 16.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.School,
                contentDescription = null,
                modifier = Modifier.size(21.dp),
                tint =
                    if (selected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
            )

            Spacer(modifier = Modifier.width(9.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )

            if (selected) {
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Selected",
                    modifier = Modifier.size(19.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun SelectionCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    selected: Boolean,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = when {
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(
                        if (selected) {
                            MaterialTheme.colorScheme.surface.copy(
                                alpha = 0.75f
                            )
                        } else {
                            MaterialTheme.colorScheme.surfaceVariant
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(21.dp),
                    tint =
                        if (enabled) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        }
                )
            }

            Spacer(modifier = Modifier.width(13.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            if (selected) {
                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Selected",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun TestSummaryCard(
    board: String,
    className: String,
    subject: String,
    chapter: String,
    questionCount: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(40.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            modifier = Modifier.size(21.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Spacer(modifier = Modifier.width(11.dp))

                Column {
                    Text(
                        text = "Test Summary",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        text = "Review your selection before starting",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            SummaryRow("Board", board)
            SummaryRow("Class", className)
            SummaryRow("Subject", subject)
            SummaryRow("Chapter", chapter)

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Questions available",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = questionCount.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun SummaryRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}

private fun toQuestionSubjectId(
    subjectId: String?
): String? {
    return when (subjectId) {
        CurriculumContentIds.MP_BOARD_CLASS_12_ECONOMICS_MICRO,
        CurriculumContentIds.MP_BOARD_CLASS_12_ECONOMICS_MACRO,
        CurriculumContentIds.CBSE_CLASS_12_ECONOMICS_INDIAN,
        CurriculumContentIds.CBSE_CLASS_12_ECONOMICS_MACRO -> {
            "economics"
        }

        else -> subjectId
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
