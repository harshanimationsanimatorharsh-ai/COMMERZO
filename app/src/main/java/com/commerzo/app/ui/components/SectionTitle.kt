package com.commerzo.app.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.commerzo.app.ui.theme.CommerzoDimensions

@Composable
fun SectionTitle(
    title: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = androidx.compose.ui.Modifier.padding(
            vertical = CommerzoDimensions.Space4
        )
    )
}
