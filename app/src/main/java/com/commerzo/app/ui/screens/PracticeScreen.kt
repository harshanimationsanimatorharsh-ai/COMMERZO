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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
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
        if (searchQuery.isBlank()) {
            subjects
        } else {
            subjects.filter {
                it.name.contains(
                    searchQuery.trim(),
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
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = "Learn by solving. Improve by practicing.",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
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
                CommerzoDimensions.SectionSpacing
            )
        ) {

            /*
             * PRACTICE MODES
             *
             * Keep the outside simple.
             * Powerful functionality can live inside each mode later.
             */
            item {
                SectionHeader(
                    title = "Practice Modes",
                    subtitle = "Choose how you want to practice"
                )
            }

            item {
                PracticeModeCard(
                    title = "Chapter Practice",
                    subtitle = "Practice MCQs chapter by chapter",
                    icon = Icons.Default.MenuBook,
                    enabled = true,
                    onClick = {
                        onNavigate(
                            Screen.Subjects.route
                        )
                    }
                )
            }

            item {
                PracticeModeCard(
                    title = "Mixed Practice",
                    subtitle = "Practice questions across topics",
                    icon = Icons.Default.Refresh,
                    enabled = true,
                    onClick = {
                        onNavigate(
                            Screen.Tests.route
                        )
                    }
                )
            }

            item {
                PracticeModeCard(
                    title = "Weak Topics",
                    subtitle = "Target concepts that need improvement",
                    icon = Icons.Default.Warning,
                    enabled = false,
                    onClick = {}
                )
            }

            item {
                PracticeModeCard(
                    title = "Mistakes",
                    subtitle = "Review questions you answered incorrectly",
                    icon = Icons.Default.ErrorOutline,
                    enabled = false,
                    onClick = {}
                )
            }

            item {
                PracticeModeCard(
                    title = "Bookmarks",
                    subtitle = "Practice questions you saved",
                    icon = Icons.Default.Bookmark,
                    enabled = true,
                    onClick = {
                        onNavigate(
                            Screen.Bookmarks.route
                        )
                    }
                )
            }

            /*
             * Games remain accessible from Practice,
             * but the current Games engine is not yet real.
             */
            item {
                PracticeModeCard(
                    title = "Games",
                    subtitle = "Mind games and learning challenges",
                    icon = Icons.Default.SportsEsports,
                    enabled = true,
                    onClick = {
                        onNavigate(
                            Screen.Games.route
                        )
                    }
                )
            }

            /*
             * CURRICULUM FILTER
             */
            item {
                SectionHeader(
                    title = "Choose Subject",
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

            /*
             * SEARCH
             */
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
                            contentDescription = "Search"
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Search subjects..."
                        )
                    }
                )
            }

            /*
             * SUBJECT LIST
             */
            item {
                SectionHeader(
                    title = "Subjects",
                    subtitle = "${filteredSubjects.size} subjects available"
                )
            }

            if (filteredSubjects.isEmpty()) {

                item {
                    EmptyPracticeState()
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
private fun PracticeModeCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (enabled) {
                MaterialTheme.colorScheme.surface
            } else {
                MaterialTheme.colorScheme.surfaceVariant
            },
            disabledContainerColor =
                MaterialTheme.colorScheme.surfaceVariant.copy(
                    alpha = 0.65f
                )
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
                modifier = Modifier.size(48.dp),
                shape = RoundedCornerShape(15.dp),
                color = if (enabled) {
                    MaterialTheme.colorScheme.primaryContainer
                } else {
                    MaterialTheme.colorScheme.surface
                }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    modifier = Modifier.padding(
                        CommerzoDimensions.Space12
                    ),
                    tint = if (enabled) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
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
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (enabled) {
                        MaterialTheme.colorScheme.onSurface
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )

                Text(
                    text = if (enabled) {
                        subtitle
                    } else {
                        "$subtitle • Coming soon"
                    },
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            if (enabled) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Open $title",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
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

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space8
            )
        ) {
            item {
                FilterChip(
                    selected = selectedBoard == Board.MP_BOARD,
                    onClick = {
                        onBoardSelected(
                            Board.MP_BOARD
                        )
                    },
                    label = {
                        Text("MP Board")
                    },
                    leadingIcon = {
                        if (selectedBoard == Board.MP_BOARD) {
                            Icon(
                                imageVector = Icons.Default.Tune,
                                contentDescription = null,
                                modifier = Modifier.size(
                                    CommerzoDimensions.IconSmall
                                )
                            )
                        }
                    }
                )
            }

            item {
                FilterChip(
                    selected = selectedBoard == Board.CBSE,
                    onClick = {
                        onBoardSelected(
                            Board.CBSE
                        )
                    },
                    label = {
                        Text("CBSE")
                    },
                    leadingIcon = {
                        if (selectedBoard == Board.CBSE) {
                            Icon(
                                imageVector = Icons.Default.Tune,
                                contentDescription = null,
                                modifier = Modifier.size(
                                    CommerzoDimensions.IconSmall
                                )
                            )
                        }
                    }
                )
            }
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space8
            )
        ) {
            item {
                FilterChip(
                    selected = selectedClass == ClassLevel.CLASS_11,
                    onClick = {
                        onClassSelected(
                            ClassLevel.CLASS_11
                        )
                    },
                    label = {
                        Text("Class 11")
                    }
                )
            }

            item {
                FilterChip(
                    selected = selectedClass == ClassLevel.CLASS_12,
                    onClick = {
                        onClassSelected(
                            ClassLevel.CLASS_12
                        )
                    },
                    label = {
                        Text("Class 12")
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
        shape = RoundedCornerShape(22.dp)
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
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = "$chaptersCount chapters • MCQ practice",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open $name",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun EmptyPracticeState() {
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
                CommerzoDimensions.Space6
            )
        ) {
            Text(
                text = "No subjects found",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Try another subject search or curriculum.",
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
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
