package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.commerzo.app.data.repository.ChapterRepository
import com.commerzo.app.ui.components.ChapterCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterScreen(
    subjectId: String,
    onBack: () -> Unit
) {

    val repository = ChapterRepository()
    val chapters = repository.getChapters(subjectId)

    val subjectName = when (subjectId) {
        "accountancy" -> "Accountancy"
        "business_studies" -> "Business Studies"
        "economics" -> "Economics"
        "mathematics" -> "Mathematics"
        "english" -> "English"
        "hindi" -> "Hindi"
        else -> "Subject"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(subjectName)
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        if (chapters.isEmpty()) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "No chapters available.",
                    style = MaterialTheme.typography.titleMedium
                )
            }

        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                item {
                    Text(
                        text = "Choose a chapter",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(
                            top = 16.dp,
                            bottom = 6.dp
                        )
                    )
                }

                items(
                    items = chapters,
                    key = {
                        it.id
                    }
                ) { chapter ->

                    ChapterCard(
                        chapter = chapter
                    )
                }
            }
        }
    }
}
