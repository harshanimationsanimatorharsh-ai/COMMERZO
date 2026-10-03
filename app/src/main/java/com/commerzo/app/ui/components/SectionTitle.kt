package com.commerzo.app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.commerzo.app.ui.theme.CommerzoDimensions

// ============================================================
// COMMERZO — Premium Section Title
// Clean • Clear • Consistent
// ============================================================

@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = CommerzoDimensions.Space8,
                bottom = CommerzoDimensions.Space4
            ),
        maxLines = 2
    )
}
