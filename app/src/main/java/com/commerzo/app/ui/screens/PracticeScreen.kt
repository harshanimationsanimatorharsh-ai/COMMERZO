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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.repository.SubjectRepository
import com.commerzo.app.navigation.Screen
import com.commerzo.app.ui.components.SelectionChip
import com.commerzo.app.ui.theme.CommerzoDimensions

@Composable
fun PracticeScreen(
    onNavigate: (String) -> Unit = {}
) {
    var selectedBoard by remember {
        mutableStateOf(Board.MP_BOARD)
    }

    var selectedClass by remember {
        mutableStateOf(ClassLevel.CLASS_12)
    }

    var searchQuery by remember {
        mutableStateOf("")
    }

    val subjectRepository = remember {
        SubjectRepository()
    }

    val subjects = remember(
        selectedBoard,
        selectedClass
    ) {
        subjectRepository.getSubjects(
            board = selectedBoard,
            classLevel = selectedClass
        )
    }

    val filteredSubjects = remember(
        subjects,
        searchQuery
    ) {
        val query = searchQuery.trim()

        if (query.isBlank()) {
            subjects
        } else {
            subjects.filter { subject ->
                subject.name.contains(
                    query,
                    ignoreCase = true
                )
            }
        }
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
                            text = "Practice",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )

                        Text(
                            text = "Practice smart. Build strong concepts.",
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
                CommerzoDimensions.Space20
            )
        ) {

            // ========================================================
            // PRIMARY PRACTICE ACTION
            // ========================================================

            item {
                PrimaryPracticeCard(
                    onClick = {
                        onNavigate(
                            Screen.Subjects.route
                        )
                    }
                )
            }

            // ========================================================
            // SECONDARY PRACTICE ACTION
            // ========================================================

            item {
                SavedQuestionsCard(
                    onClick = {
                        onNavigate(
                            Screen.Bookmarks.route
                        )
                    }
                )
            }

            // ========================================================
            // CURRICULUM
            // ========================================================

            item {
                SectionHeader(
                    title = "Choose Curriculum",
                    subtitle = "Select your board and class"
                )
            }

            item {
                CurriculumSelector(
                    selectedBoard = selectedBoard,
                    selectedClass = selectedClass,
                    onBoardSelected = {
                        selectedBoard = it
                    },
                    onClassSelected = {
                        selectedClass = it
                    }
                )
            }

            // ========================================================
            // SEARCH
            // ========================================================

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
                            contentDescription = null
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Search subjects..."
                        )
                    }
                )
            }

            // ========================================================
            // SUBJECTS
            // ========================================================

            item {
                SectionHeader(
                    title = "Subjects",
                    subtitle = if (searchQuery.isBlank()) {
                        "Choose a subject to start practicing"
                    } else {
                        "${filteredSubjects.size} matching subjects"
                    }
                )
            }

            if (filteredSubjects.isEmpty()) {
                item {
                    EmptyPracticeState(
                        hasSearchQuery = searchQuery.isNotBlank()
                    )
                }
            } else {
                items(
                    items = filteredSubjects,
                    key = { it.id }
                ) { subject ->

                    PracticeSubjectCard(
                        name = subject.name,
                        emoji = subject.emoji,
                        chaptersCount = subject.chaptersCount,
                        onClick = {
                            onNavigate(
                                Screen.Chapters.createRoute(
                                    subjectId = subject.id,
                                    board = selectedBoard.name,
                                    classLevel = selectedClass.name
                                )
                            )
                        }
                    )
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
private fun PrimaryPracticeCard(
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = CommerzoDimensions.CardPaddingLarge,
                    vertical = CommerzoDimensions.Space20
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(18.dp),
                color = MaterialTheme.colorScheme.onPrimary.copy(
                    alpha = 0.14f
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.MenuBook,
                        contentDescription = null,
                        modifier = Modifier.size(
                            CommerzoDimensions.IconLarge
                        ),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space16
                )
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space4
                )
            ) {
                Text(
                    text = "Start Practice",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Text(
                    text = "Choose a subject and practice chapter-wise MCQs.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimary.copy(
                        alpha = 0.82f
                    ),
                    maxLines = 2
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
private fun SavedQuestionsCard(
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
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
                modifier = Modifier.size(50.dp),
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Bookmark,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary
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
                    text = "Saved Questions",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "Review questions you bookmarked.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun CurriculumSelector(
    selectedBoard: Board,
    selectedClass: ClassLevel,
    onBoardSelected: (Board) -> Unit,
    onClassSelected: (ClassLevel) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space10
        )
    ) {
        Text(
            text = "Board",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space8
            )
        ) {
            item {
                SelectionChip(
                    text = "MP Board",
                    selected = selectedBoard == Board.MP_BOARD,
                    onClick = {
                        onBoardSelected(
                            Board.MP_BOARD
                        )
                    }
                )
            }

            item {
                SelectionChip(
                    text = "CBSE",
                    selected = selectedBoard == Board.CBSE,
                    onClick = {
                        onBoardSelected(
                            Board.CBSE
                        )
                    }
                )
            }
        }

        Text(
            text = "Class",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space8
            )
        ) {
            item {
                SelectionChip(
                    text = "Class 11",
                    selected = selectedClass == ClassLevel.CLASS_11,
                    onClick = {
                        onClassSelected(
                            ClassLevel.CLASS_11
                        )
                    }
                )
            }

            item {
                SelectionChip(
                    text = "Class 12",
                    selected = selectedClass == ClassLevel.CLASS_12,
                    onClick = {
                        onClassSelected(
                            ClassLevel.CLASS_12
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun PracticeSubjectCard(
    name: String,
    emoji: String,
    chaptersCount: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
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
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = emoji,
                        style = MaterialTheme.typography.titleLarge
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
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )

                Text(
                    text = "$chaptersCount chapters • MCQ practice",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun EmptyPracticeState(
    hasSearchQuery: Boolean
) {
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
            Text(
                text = if (hasSearchQuery) {
                    "No matching subjects"
                } else {
                    "No subjects available"
                },
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = if (hasSearchQuery) {
                    "Try a different subject name."
                } else {
                    "Try another board or class."
                },
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
