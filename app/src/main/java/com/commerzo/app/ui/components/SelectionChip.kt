package com.commerzo.app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.commerzo.app.ui.theme.CommerzoDimensions

// ============================================================
// COMMERZO — Premium Selection Chip
// Clean • Compact • Easy to Scan
// ============================================================

@Composable
fun SelectionChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier.clickable(
            onClick = onClick
        ),
        shape = RoundedCornerShape(50),
        color = if (selected) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.surfaceVariant
        },
        contentColor = if (selected) {
            MaterialTheme.colorScheme.onPrimaryContainer
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        },
        tonalElevation = if (selected) 1.dp else 0.dp
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = CommerzoDimensions.Space16,
                vertical = CommerzoDimensions.Space10
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space6
            )
        ) {
            if (selected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.padding(0.dp)
                )
            }

            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                maxLines = 1
            )
        }
    }
}
