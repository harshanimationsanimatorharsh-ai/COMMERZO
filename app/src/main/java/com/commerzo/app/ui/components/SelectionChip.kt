package com.commerzo.app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SelectionChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Surface(
        modifier = Modifier.clickable {
            onClick()
        },
        shape = RoundedCornerShape(50.dp),
        tonalElevation = if (selected) 4.dp else 1.dp
    ) {

        Text(
            text = if (selected) "✓ $text" else text,
            modifier = Modifier.padding(
                horizontal = 18.dp,
                vertical = 10.dp
            )
        )
    }
}
