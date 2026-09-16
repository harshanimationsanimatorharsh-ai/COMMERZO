package com.commerzo.app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.model.ChapterData

@Composable
fun ChapterCard(
    chapter: ChapterData,
    onClick: () -> Unit = {}
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surfaceVariant
        )
    ) {

        Row(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "${chapter.chapterNumber}",
                style = MaterialTheme.typography.titleLarge
            )

            Column(
                modifier = Modifier.padding(
                    start = 14.dp
                )
            ) {

                Text(
                    text = chapter.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Practice chapter",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
