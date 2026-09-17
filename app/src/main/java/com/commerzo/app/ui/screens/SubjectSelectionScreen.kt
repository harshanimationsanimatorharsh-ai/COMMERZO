package com.commerzo.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.SubjectData
import com.commerzo.app.viewmodel.SubjectSelectionViewModel

@Composable
fun SubjectSelectionScreen(
    viewModel: SubjectSelectionViewModel,
    onSubjectClick: (SubjectData) -> Unit
) {

    val selectedBoard by viewModel.selectedBoard.collectAsState()
    val selectedClass by viewModel.selectedClass.collectAsState()
    val subjects by viewModel.subjects.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B0B0F))
            .padding(16.dp)
    ) {

        Text(
            text = "Select Your Curriculum",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Board",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            FilterChip(
                selected = selectedBoard == Board.MP_BOARD,
                onClick = {
                    viewModel.setBoard(Board.MP_BOARD)
                },
                label = {
                    Text("MP Board")
                }
            )

            FilterChip(
                selected = selectedBoard == Board.CBSE,
                onClick = {
                    viewModel.setBoard(Board.CBSE)
                },
                label = {
                    Text("CBSE")
                }
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Class",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            FilterChip(
                selected = selectedClass == ClassLevel.CLASS_11,
                onClick = {
                    viewModel.setClassLevel(ClassLevel.CLASS_11)
                },
                label = {
                    Text("Class 11")
                }
            )

            FilterChip(
                selected = selectedClass == ClassLevel.CLASS_12,
                onClick = {
                    viewModel.setClassLevel(ClassLevel.CLASS_12)
                },
                label = {
                    Text("Class 12")
                }
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        Text(
            text = "Subjects",
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(
                items = subjects,
                key = { it.id }
            ) { subject ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onSubjectClick(subject)
                    },
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF17171D)
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp),
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {

                        Text(
                            text = subject.emoji,
                            fontSize = 27.sp
                        )

                        Column {

                            Text(
                                text = subject.name,
                                color = Color.White,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "${subject.chaptersCount} Chapters",
                                color = Color(0xFFBDB9D9),
                                fontSize = 13.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
