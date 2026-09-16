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
fun GamesScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Study Games",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("🧮 Math Challenge")
        Text("➗ Equation Game")
        Text("🧠 Mind Sharp")
        Text("🧩 Puzzle Challenge")
        Text("⚡ Speed Challenge")
        Text("🔥 Daily Challenge")
    }
}
