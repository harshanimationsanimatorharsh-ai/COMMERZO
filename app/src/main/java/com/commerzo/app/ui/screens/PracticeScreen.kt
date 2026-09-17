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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
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

Scaffold(
    topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Practice",
                    fontWeight = FontWeight.Bold
                )
            }
        )
    }
) { paddingValues ->

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 16.dp),
        verticalArrangement =
            Arrangement.spacedBy(12.dp)
    ) {

        item {
            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Chapter-wise Practice",
                style =
                    MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text =
                    "Select your board and class, then choose a subject.",
                style =
                    MaterialTheme.typography.bodyMedium,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "Board",
                style =
                    MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.spacedBy(8.dp)
            ) {

                BoardButton(
                    text = "MP Board",
                    selected =
                        selectedBoard == Board.MP_BOARD,
                    onClick = {
                        selectedBoard = Board.MP_BOARD
                    },
                    modifier = Modifier.weight(1f)
                )

                BoardButton(
                    text = "CBSE",
                    selected =
                        selectedBoard == Board.CBSE,
                    onClick = {
                        selectedBoard = Board.CBSE
                    },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "Class",
                style =
                    MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.spacedBy(8.dp)
            ) {

                BoardButton(
                    text = "Class 11",
                    selected =
                        selectedClass ==
                            ClassLevel.CLASS_11,
                    onClick = {
                        selectedClass =
                            ClassLevel.CLASS_11
                    },
                    modifier = Modifier.weight(1f)
                )

                BoardButton(
                    text = "Class 12",
                    selected =
                        selectedClass ==
                            ClassLevel.CLASS_12,
                    onClick = {
                        selectedClass =
                            ClassLevel.CLASS_12
                    },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text =
                    "${selectedBoard.displayName()} • " +
                        selectedClass.displayName(),
                style =
                    MaterialTheme.typography.bodyMedium,
                color =
                    MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }

        if (subjects.isEmpty()) {

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor =
                            MaterialTheme.colorScheme
                                .surfaceVariant
                    )
                ) {
                    Text(
                        text =
                            "No subjects available for this selection.",
                        modifier =
                            Modifier.padding(18.dp),
                        color =
                            MaterialTheme.colorScheme
                                .onSurfaceVariant
                    )
                }
            }

        } else {

            items(
                items = subjects,
                key = { it.id }
            ) { subject ->

                PracticeSubjectCard(
                    name = subject.name,
                    emoji = subject.emoji,
                    chaptersCount =
                        subject.chaptersCount,
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
            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }
    }
}

}

@Composable
private fun BoardButton(
text: String,
selected: Boolean,
onClick: () -> Unit,
modifier: Modifier
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
private fun PracticeSubjectCard(
name: String,
emoji: String,
chaptersCount: Int,
onClick: () -> Unit
) {
Card(
modifier = Modifier.fillMaxWidth(),
onClick = onClick,
colors = CardDefaults.cardColors(
containerColor =
MaterialTheme.colorScheme.surface
)
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Text(
            text = emoji,
            style =
                MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.width(14.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = name,
                style =
                    MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text =
                    "$chaptersCount chapters • " +
                        "Practice MCQs",
                style =
                    MaterialTheme.typography.bodySmall,
                color =
                    MaterialTheme.colorScheme
                        .onSurfaceVariant
            )
        }

        Text(
            text = "›",
            style =
                MaterialTheme.typography.headlineMedium,
            color =
                MaterialTheme.colorScheme.primary
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
