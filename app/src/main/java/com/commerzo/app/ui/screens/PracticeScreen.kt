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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.WorkspacePremium
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.repository.SubjectRepository

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
                    Column {
                        Text(
                            text = "Practice",
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = "Test your knowledge and improve.",
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
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 28.dp
            ),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

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
                        Text("Search subjects, chapters...")
                    }
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = selectedClass == ClassLevel.CLASS_12,
                        onClick = {
                            selectedClass = ClassLevel.CLASS_12
                        },
                        label = {
                            Text("Class 12")
                        }
                    )

                    FilterChip(
                        selected = selectedClass == ClassLevel.CLASS_11,
                        onClick = {
                            selectedClass = ClassLevel.CLASS_11
                        },
                        label = {
                            Text("Class 11")
                        }
                    )
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = selectedBoard == Board.MP_BOARD,
                        onClick = {
                            selectedBoard = Board.MP_BOARD
                        },
                        label = {
                            Text("MP Board")
                        }
                    )

                    FilterChip(
                        selected = selectedBoard == Board.CBSE,
                        onClick = {
                            selectedBoard = Board.CBSE
                        },
                        label = {
                            Text("CBSE")
                        }
                    )
                }
            }

            item {
                PracticeIntroCard()
            }

            item {
                SectionTitle(
                    title = "Practice by Subject",
                    subtitle = "${filteredSubjects.size} subjects available"
                )
            }

            if (filteredSubjects.isEmpty()) {

                item {
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
                                .padding(22.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "No subjects found",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = "Try another search or change your selection.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
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
                                "chapters/" +
                                    "${subject.id}/" +
                                    "${selectedBoard.name}/" +
                                    "${selectedClass.name}"
                            )
                        }
                    )
                }
            }

            item {
                SectionTitle(
                    title = "Test Series",
                    subtitle = "More practice options"
                )
            }

            item {
                TestSeriesCard(
                    title = "Full Syllabus Test",
                    subtitle = "Practice complete syllabus",
                    icon = Icons.Default.WorkspacePremium,
                    onClick = {
                        onNavigate("tests")
                    }
                )
            }

            item {
                TestSeriesCard(
                    title = "Chapter Wise Test",
                    subtitle = "Focus on individual chapters",
                    icon = Icons.Default.Quiz,
                    onClick = {
                        onNavigate("tests")
                    }
                )
            }

            item {
                TestSeriesCard(
                    title = "Quick MCQ Practice",
                    subtitle = "Start a fast practice session",
                    icon = Icons.Default.CheckCircle,
                    onClick = {
                        onNavigate("tests")
                    }
                )
            }
        }
    }
}

@Composable
private fun PracticeIntroCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.75f
                )
            ) {
                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = "Practice",
                    modifier = Modifier.padding(13.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(
                modifier = Modifier.width(14.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Practice smarter",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = "Build accuracy with subject and chapter-wise MCQs.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Composable
private fun SectionTitle(
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(
            modifier = Modifier.height(3.dp)
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
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
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier.padding(end = 14.dp),
                shape = RoundedCornerShape(15.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Text(
                    text = emoji,
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = "$chaptersCount chapters • Practice MCQs",
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
private fun TestSeriesCard(
    title: String,
    subtitle: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    modifier = Modifier.padding(11.dp),
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }

            Spacer(
                modifier = Modifier.width(13.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(2.dp)
                )

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open $title"
            )
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
