package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commerzo.app.ui.theme.CommerzoDimensions

@Composable
fun ChapterHubScreen(
    subjectId: String,
    chapterId: String,
    subjectName: String,
    chapterTitle: String,
    board: String,
    classLevel: String,
    onBack: () -> Unit,
    onPractice: () -> Unit,
    onTest: () -> Unit,
    onNotes: () -> Unit,
    onPdfs: () -> Unit,
    onPyq: () -> Unit,
    onBookmarks: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            CommerzoDimensions.Space2
                        )
                    ) {
                        Text(
                            text = "Chapter",
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = subjectName,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
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

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(
                horizontal = CommerzoDimensions.ScreenHorizontal,
                vertical = CommerzoDimensions.Space12
            ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.CardSpacing
            )
        ) {

            /*
             * CHAPTER HEADER
             */
            item {
                ChapterHeroCard(
                    subjectName = subjectName,
                    chapterTitle = chapterTitle,
                    board = board,
                    classLevel = classLevel
                )
            }

            /*
             * PRIMARY ACTIONS
             */
            item {
                SectionHeader(
                    title = "Learn & Practice",
                    subtitle = "Choose what you want to do"
                )
            }

            item {
                HubActionCard(
                    title = "Practice",
                    subtitle = "Solve chapter-wise MCQs",
                    icon = Icons.Default.QuestionAnswer,
                    enabled = true,
                    onClick = onPractice
                )
            }

            item {
                HubActionCard(
                    title = "Test",
                    subtitle = "Take a chapter test",
                    icon = Icons.Default.Assessment,
                    enabled = true,
                    onClick = onTest
                )
            }

            item {
                HubActionCard(
                    title = "Notes",
                    subtitle = "Read chapter notes",
                    icon = Icons.Default.Book,
                    enabled = false,
                    onClick = onNotes
                )
            }

            /*
             * STUDY MATERIAL
             */
            item {
                SectionHeader(
                    title = "Study Material",
                    subtitle = "Additional chapter resources"
                )
            }

            item {
                HubActionCard(
                    title = "PDFs",
                    subtitle = "Chapter PDFs and study material",
                    icon = Icons.Default.Description,
                    enabled = false,
                    onClick = onPdfs
                )
            }

            item {
                HubActionCard(
                    title = "Previous Year Questions",
                    subtitle = "Board questions from previous years",
                    icon = Icons.Default.MenuBook,
                    enabled = false,
                    onClick = onPyq
                )
            }

            item {
                HubActionCard(
                    title = "Bookmarks",
                    subtitle = "Saved questions from this chapter",
                    icon = Icons.Default.Bookmark,
                    enabled = false,
                    onClick = onBookmarks
                )
            }

            item {
                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space16
                    )
                )
            }
        }
    }
}

@Composable
private fun ChapterHeroCard(
    subjectName: String,
    chapterTitle: String,
    board: String,
    classLevel: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(17.dp),
                color = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.82f
                )
            ) {
                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = "Chapter",
                    modifier = Modifier.padding(
                        CommerzoDimensions.Space14
                    ),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space12
                )
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space4
                )
            ) {
                Text(
                    text = chapterTitle,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color =
                        MaterialTheme.colorScheme.onPrimaryContainer
                )

                Text(
                    text = subjectName,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.SemiBold,
                    color =
                        MaterialTheme.colorScheme.onPrimaryContainer.copy(
                            alpha = 0.82f
                        )
                )

                Text(
                    text = "$board • $classLevel",
                    style = MaterialTheme.typography.labelMedium,
                    color =
                        MaterialTheme.colorScheme.onPrimaryContainer.copy(
                            alpha = 0.72f
                        )
                )
            }
        }
    }
}

@Composable
private fun HubActionCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(21.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if (enabled) {
                    MaterialTheme.colorScheme.surface
                } else {
                    MaterialTheme.colorScheme.surfaceVariant
                },
            disabledContainerColor =
                MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPadding
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier.size(48.dp),
                shape = RoundedCornerShape(15.dp),
                color =
                    if (enabled) {
                        MaterialTheme.colorScheme.primaryContainer
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    modifier = Modifier.padding(
                        CommerzoDimensions.Space12
                    ),
                    tint =
                        if (enabled) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        }
                )
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space12
                )
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space4
                )
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color =
                        if (enabled) {
                            MaterialTheme.colorScheme.onSurface
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        }
                )

                Text(
                    text =
                        if (enabled) {
                            subtitle
                        } else {
                            "$subtitle • Coming soon"
                        },
                    style = MaterialTheme.typography.bodySmall,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            if (enabled) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Open $title",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun SectionHeader(
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space4
        )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
