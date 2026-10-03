package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.platform.LocalContext
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.CurriculumContentIds
import com.commerzo.app.data.repository.PracticeProgressRepository
import com.commerzo.app.data.repository.QuestionBankManager
import com.commerzo.app.data.repository.content.ContentManager
import com.commerzo.app.data.repository.content.CurriculumContentMapper
import com.commerzo.app.ui.theme.CommerzoDimensions

@Composable
fun ChapterScreen(
    subjectId: String,
    subjectName: String,
    board: Board,
    classLevel: ClassLevel,
    onBack: () -> Unit,
    onChapterClick: (String, String) -> Unit,
    onStartStudy: (String, String, String, String, String) -> Unit
) {
    val contentManager = remember {
        ContentManager()
    }

    val questionBankManager = remember {
        QuestionBankManager()
    }

    val context = LocalContext.current

    var searchQuery by remember {
        mutableStateOf("")
    }

    val boardId = remember(board) {
        CurriculumContentMapper.getBoardId(board)
    }

    val classId = remember(classLevel) {
        CurriculumContentMapper.getClassId(classLevel)
    }

    val chaptersState = produceState(
        initialValue = emptyList<ContentChapter>(),
        subjectId,
        boardId,
        classId
    ) {
        value = contentManager.getChapters(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    val chapters = chaptersState.value

    /*
     * Content architecture can use stable Economics IDs,
     * while the existing question/progress systems use
     * the compatibility ID "economics".
     */
    val questionSubjectId = remember(subjectId) {
        when (subjectId) {
            CurriculumContentIds.MP_BOARD_CLASS_12_ECONOMICS_MICRO,
            CurriculumContentIds.MP_BOARD_CLASS_12_ECONOMICS_MACRO,
            CurriculumContentIds.CBSE_CLASS_12_ECONOMICS_INDIAN,
            CurriculumContentIds.CBSE_CLASS_12_ECONOMICS_MACRO -> {
                "economics"
            }

            else -> subjectId
        }
    }

    val filteredChapters = remember(
        chapters,
        searchQuery
    ) {
        val query = searchQuery.trim()

        if (query.isBlank()) {
            chapters
        } else {
            chapters.filter { chapter ->
                chapter.title.contains(
                    query,
                    ignoreCase = true
                ) ||
                    chapter.chapterNumber
                        .toString()
                        .contains(query)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
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
                title = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            CommerzoDimensions.Space2
                        )
                    ) {
                        Text(
                            text = subjectName,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )

                        Text(
                            text = "Choose a chapter to practice",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1
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
            contentPadding = PaddingValues(
                horizontal = CommerzoDimensions.ScreenHorizontal,
                vertical = CommerzoDimensions.Space12
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space16
            )
        ) {

            // ========================================================
            // SUBJECT SUMMARY
            // ========================================================

            item {
                ChapterHeaderCard(
                    subjectName = subjectName,
                    board = board.displayName(),
                    className = classLevel.displayName(),
                    chapterCount = chapters.size
                )
            }

            if (chapters.isEmpty()) {

                item {
                    EmptyChapterState()
                }

            } else {

                // ====================================================
                // SEARCH
                // ====================================================

                item {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = {
                            searchQuery = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(18.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search chapters"
                            )
                        },
                        placeholder = {
                            Text(
                                text = "Search chapters..."
                            )
                        }
                    )
                }

                // ====================================================
                // CHAPTER HEADER
                // ====================================================

                item {
                    SectionHeader(
                        title = "Chapters",
                        subtitle = if (searchQuery.isBlank()) {
                            "${chapters.size} chapters available"
                        } else {
                            "${filteredChapters.size} matching chapters"
                        }
                    )
                }

                if (filteredChapters.isEmpty()) {

                    item {
                        EmptySearchState()
                    }

                } else {

                    items(
                        items = filteredChapters,
                        key = { it.id }
                    ) { chapter ->

                        val questionCount = remember(
                            chapter.id,
                            questionSubjectId,
                            board,
                            classLevel
                        ) {
                            questionBankManager
                                .getValidatedQuestions(
                                    subjectId = questionSubjectId,
                                    chapterId = chapter.id,
                                    board = board,
                                    classLevel = classLevel
                                )
                                .size
                        }

                        val progressPercent = remember(
                            chapter.id,
                            questionSubjectId,
                            board,
                            classLevel
                        ) {
                            PracticeProgressRepository
                                .getChapterProgressPercent(
                                    context = context,
                                    subjectId = questionSubjectId,
                                    chapterId = chapter.id,
                                    board = board,
                                    classLevel = classLevel
                                )
                        }

                        ChapterItemCard(
                            chapterNumber = chapter.chapterNumber,
                            title = chapter.title,
                            questionCount = questionCount,
                            progressPercent = progressPercent,
                            onOpen = {
                                if (questionCount > 0) {
                                    onChapterClick(
                                        chapter.id,
                                        chapter.title
                                    )
                                }
                            },
                            onStartStudy = {
                                onStartStudy(
                                    subjectId,
                                    chapter.id,
                                    boardId,
                                    classId,
                                    chapter.title
                                )
                            }
                        )
                    }
                }
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

@Composable
private fun ChapterHeaderCard(
    subjectName: String,
    board: String,
    className: String,
    chapterCount: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
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
                modifier = Modifier.size(54.dp),
                shape = RoundedCornerShape(17.dp),
                color = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.82f
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.MenuBook,
                        contentDescription = null,
                        modifier = Modifier.size(
                            CommerzoDimensions.IconMedium
                        ),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
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
                    text = subjectName,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    maxLines = 2
                )

                Text(
                    text = "$className • $board",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(
                        alpha = 0.78f
                    )
                )

                Text(
                    text = "$chapterCount chapters",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Composable
private fun ChapterItemCard(
    chapterNumber: Int,
    title: String,
    questionCount: Int,
    progressPercent: Int,
    onOpen: () -> Unit,
    onStartStudy: () -> Unit
) {
    val hasQuestions = questionCount > 0
    val isCompleted = progressPercent >= 100

    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = if (hasQuestions) {
            onOpen
        } else {
            {}
        },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space10
            )
        ) {

            // ========================================================
            // CHAPTER IDENTITY
            // ========================================================

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(46.dp),
                    shape = RoundedCornerShape(14.dp),
                    color = if (isCompleted) {
                        MaterialTheme.colorScheme.primaryContainer
                    } else {
                        MaterialTheme.colorScheme.surfaceVariant
                    }
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = chapterNumber.toString(),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
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
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 2
                    )

                    Text(
                        text = if (hasQuestions) {
                            "$questionCount MCQs available"
                        } else {
                            "MCQs coming soon"
                        },
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1
                    )
                }

                if (isCompleted) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Completed",
                        tint = MaterialTheme.colorScheme.primary
                    )
                } else if (hasQuestions) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Open $title",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            // ========================================================
            // PROGRESS
            // ========================================================

            LinearProgressIndicator(
                progress = {
                    progressPercent
                        .coerceIn(0, 100) / 100f
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
            )

            Text(
                text = when {
                    progressPercent >= 100 ->
                        "Completed • 100%"

                    progressPercent > 0 ->
                        "$progressPercent% completed"

                    else ->
                        "Not started"
                },
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // ========================================================
            // STUDY TRACKER — SECONDARY ACTION
            // ========================================================

            TextButton(
                onClick = onStartStudy,
                modifier = Modifier.fillMaxWidth(),
                enabled = hasQuestions
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.width(
                        CommerzoDimensions.Space6
                    )
                )

                Text(
                    text = if (progressPercent > 0) {
                        "Continue Study Session"
                    } else {
                        "Start Study Session"
                    },
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun EmptyChapterState() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space8
            )
        ) {
            Icon(
                imageVector = Icons.Default.MenuBook,
                contentDescription = null,
                modifier = Modifier.size(
                    CommerzoDimensions.IconLarge
                ),
                tint = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "No chapters available",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Chapter content is not available for this subject yet.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun EmptySearchState() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space6
            )
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.size(
                    CommerzoDimensions.IconLarge
                ),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = "No matching chapters",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Try another chapter name or number.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun SectionHeader(
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space4
        )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 1
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 2
        )
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
