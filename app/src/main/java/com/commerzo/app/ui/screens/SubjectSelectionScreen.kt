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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.SubjectData
import com.commerzo.app.ui.theme.CommerzoDimensions
import com.commerzo.app.viewmodel.SubjectSelectionViewModel

@Composable
fun SubjectSelectionScreen(
    viewModel: SubjectSelectionViewModel = viewModel(),
    onSubjectClick: (SubjectData) -> Unit = {}
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

    val subjects by viewModel.subjects.collectAsState()

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
                    Column {
                        Text(
                            text = "Subjects",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Choose a subject to continue learning",
                            style = MaterialTheme.typography.labelSmall,
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
                vertical = CommerzoDimensions.ScreenVertical
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.CardSpacing
            )
        ) {

            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = {
                        searchQuery = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search subjects"
                        )
                    },
                    placeholder = {
                        Text("Search subjects")
                    }
                )
            }

            item {
                CurriculumSelector(
                    selectedClass = selectedClass,
                    selectedBoard = selectedBoard,
                    onClassSelected = { classLevel ->
                        selectedClass = classLevel
                        viewModel.setClassLevel(classLevel)
                    },
                    onBoardSelected = { board ->
                        selectedBoard = board
                        viewModel.setBoard(board)
                    }
                )
            }

            item {
                LearnOverviewCard(
                    board = selectedBoard,
                    classLevel = selectedClass
                )
            }

            item {
                SectionHeader(
                    title = "Your Subjects",
                    subtitle = if (filteredSubjects.isEmpty()) {
                        "No matching subjects"
                    } else {
                        "${filteredSubjects.size} subjects available"
                    }
                )
            }

            if (filteredSubjects.isEmpty()) {
                item {
                    EmptySubjectsCard()
                }
            } else {
                items(
                    items = filteredSubjects,
                    key = { subject ->
                        subject.id
                    }
                ) { subject ->

                    LearnSubjectCard(
                        subject = subject,
                        onClick = {
                            onSubjectClick(subject)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun CurriculumSelector(
    selectedClass: ClassLevel,
    selectedBoard: Board,
    onClassSelected: (ClassLevel) -> Unit,
    onBoardSelected: (Board) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space12
        )
    ) {

        CurriculumFilterGroup(
            title = "Class",
            options = listOf(
                ClassLevel.CLASS_11 to "Class 11",
                ClassLevel.CLASS_12 to "Class 12"
            ),
            selected = selectedClass,
            onSelected = onClassSelected
        )

        CurriculumFilterGroup(
            title = "Board",
            options = listOf(
                Board.MP_BOARD to "MP Board",
                Board.CBSE to "CBSE"
            ),
            selected = selectedBoard,
            onSelected = onBoardSelected
        )
    }
}

@Composable
private fun <T> CurriculumFilterGroup(
    title: String,
    options: List<Pair<T, String>>,
    selected: T,
    onSelected: (T) -> Unit
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space8
            )
        ) {
            options.forEach { (value, label) ->
                FilterChip(
                    selected = selected == value,
                    onClick = {
                        onSelected(value)
                    },
                    label = {
                        Text(label)
                    }
                )
            }
        }
    }
}

@Composable
private fun LearnOverviewCard(
    board: Board,
    classLevel: ClassLevel
) {
    val boardName = when (board) {
        Board.MP_BOARD -> "MP Board"
        Board.CBSE -> "CBSE"
    }

    val className = when (classLevel) {
        ClassLevel.CLASS_11 -> "Class 11"
        ClassLevel.CLASS_12 -> "Class 12"
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
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
                modifier = Modifier.size(48.dp),
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.75f
                )
            ) {
                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = null,
                    modifier = Modifier.padding(
                        CommerzoDimensions.Space12
                    ),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(
                modifier = Modifier.size(
                    CommerzoDimensions.Space12
                )
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "LEARNING PATH",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space4
                    )
                )

                Text(
                    text = "$className • $boardName",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space4
                    )
                )

                Text(
                    text = "Subjects and chapters for your curriculum.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Composable
private fun LearnSubjectCard(
    subject: SubjectData,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPadding
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(50.dp),
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Text(
                    text = subject.emoji,
                    modifier = Modifier.padding(
                        CommerzoDimensions.Space10
                    ),
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Spacer(
                modifier = Modifier.size(
                    CommerzoDimensions.Space12
                )
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = subject.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space4
                    )
                )

                Text(
                    text = "${subject.chaptersCount} chapters",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open ${subject.name}",
                tint = MaterialTheme.colorScheme.primary
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
        modifier = Modifier.padding(
            top = CommerzoDimensions.Space8
        )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space4
            )
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun EmptySubjectsCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.size(
                    CommerzoDimensions.IconLarge
                ),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )

            Text(
                text = "No subjects found",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space4
                )
            )

            Text(
                text = "Try another class, board or search term.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
