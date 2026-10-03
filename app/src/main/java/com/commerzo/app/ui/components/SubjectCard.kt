package com.commerzo.app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.SubjectData
import com.commerzo.app.ui.theme.CommerzoDimensions

@Composable
fun SubjectCard(
    subject: SubjectData,
    onClick: () -> Unit = {}
) {
    val className = when (subject.classLevel) {
        ClassLevel.CLASS_11 -> "Class 11"
        ClassLevel.CLASS_12 -> "Class 12"
    }

    val boardName = when (subject.board) {
        Board.CBSE -> "CBSE"
        Board.MP_BOARD -> "MP Board"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
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
                .padding(CommerzoDimensions.CardPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Subject identity
            Text(
                text = subject.emoji,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.size(40.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = CommerzoDimensions.Space12),
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space4
                )
            ) {

                Text(
                    text = subject.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1
                )

                Text(
                    text = "${subject.chaptersCount} chapters",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1
                )

                Text(
                    text = "$className • $boardName",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1
                )
            }
        }
    }
}
