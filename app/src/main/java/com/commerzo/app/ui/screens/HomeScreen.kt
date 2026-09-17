package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.repository.SubjectRepository
import com.commerzo.app.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    onSubjectClick: (String) -> Unit = {},
    homeViewModel: HomeViewModel = viewModel()
) {
    val subjects = listOf(
        HomeSubject(
            id = "accountancy",
            name = "Accountancy",
            emoji = "📊"
        ),
        HomeSubject(
            id = "business_studies",
            name = "Business Studies",
            emoji = "💼"
        ),
        HomeSubject(
            id = "economics",
            name = "Economics",
            emoji = "📈"
        ),
        HomeSubject(
            id = "mathematics",
            name = "Mathematics",
            emoji = "🧮"
        ),
        HomeSubject(
            id = "english",
            name = "English",
            emoji = "📖"
        ),
        HomeSubject(
            id = "hindi",
            name = "Hindi",
            emoji = "📝"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "COMMERZO",
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Learn. Practice. Grow.",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Choose a subject to continue learning.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(8.dp))
            }

            items(
                items = subjects,
                key = { it.id }
            ) { subject ->

                HomeSubjectCard(
                    subject = subject,
                    onClick = {
                        onSubjectClick(subject.id)
                    }
                )
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Founded by Mr.Harsh Shrivas",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

private data class HomeSubject(
    val id: String,
    val name: String,
    val emoji: String
)

@Composable
private fun HomeSubjectCard(
    subject: HomeSubject,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = subject.emoji,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = subject.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Open chapters and practice",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open ${subject.name}"
            )
        }
    }
}
