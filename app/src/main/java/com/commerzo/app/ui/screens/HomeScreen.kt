package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "COMMERZO",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Learn. Practice. Score.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Welcome back 👋",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Choose a subject and start learning."
        )

        Text(
            text = "🔥 Daily Streak: 0 days"
        )

        Text(
            text = "⭐ XP: 0"
        )
    }
}
