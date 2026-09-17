package com.commerzo.app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.model.SubjectData

@Composable
fun SubjectCard(
    subject: SubjectData,
    onClick: () -> Unit = {}
) {

    val className = when (subject.classLevel) {
        com.commerzo.app.data.model.ClassLevel.CLASS_11 -> "Class 11"
        com.commerzo.app.data.model.ClassLevel.CLASS_12 -> "Class 12"
    }

    val boardName = when (subject.board) {
        com.commerzo.app.data.model.Board.CBSE -> "CBSE"
        com.commerzo.app.data.model.Board.MP_BOARD -> "MP Board"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = subject.emoji,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.width(14.dp)
            )

            Column {

                Text(
                    text = subject.name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "${subject.chaptersCount} chapters",
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    text = "$className • $boardName",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
