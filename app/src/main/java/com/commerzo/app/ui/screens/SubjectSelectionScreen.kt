package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.ui.components.SectionTitle
import com.commerzo.app.ui.components.SelectionChip
import com.commerzo.app.ui.components.SubjectCard
import com.commerzo.app.ui.viewmodel.SubjectSelectionViewModel

@Composable
fun SubjectSelectionScreen(
    onSubjectClick: (String) -> Unit,
    viewModel: SubjectSelectionViewModel = viewModel()
) {

    val board by viewModel.board.collectAsState()
    val classLevel by viewModel.classLevel.collectAsState()
    val subjects by viewModel.subjects.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Practice",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Select your class and board.",
            style = MaterialTheme.typography.bodyMedium
        )

        androidx.compose.foundation.layout.Spacer(
            modifier = Modifier.padding(6.dp)
        )

        SectionTitle("Class")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            SelectionChip(
                text = "Class 11",
                selected = classLevel == ClassLevel.CLASS_11,
                onClick = {
                    viewModel.setClassLevel(ClassLevel.CLASS_11)
                }
            )

            SelectionChip(
                text = "Class 12",
                selected = classLevel == ClassLevel.CLASS_12,
                onClick = {
                    viewModel.setClassLevel(ClassLevel.CLASS_12)
                }
            )
        }

        SectionTitle("Board")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            SelectionChip(
                text = "CBSE",
                selected = board == Board.CBSE,
                onClick = {
                    viewModel.setBoard(Board.CBSE)
                }
            )

            SelectionChip(
                text = "MP Board",
                selected = board == Board.MP_BOARD,
                onClick = {
                    viewModel.setBoard(Board.MP_BOARD)
                }
            )
        }

        SectionTitle("Subjects")

        androidx.compose.foundation.lazy.LazyColumn(
            modifier = Modifier.padding(top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(
                count = subjects.size,
                key = {
                    subjects[it].id
                }
            ) { index ->

                val subject = subjects[index]

                SubjectCard(
                    subject = subject,
                    onClick = {
                        onSubjectClick(subject.id)
                    }
                )
            }
        }
    }
}
