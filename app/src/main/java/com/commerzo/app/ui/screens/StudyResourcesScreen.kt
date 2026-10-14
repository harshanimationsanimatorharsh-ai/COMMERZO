
package com.commerzo.app.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private data class StudyResourceItem(
    val title: String,
    val description: String,
    val icon: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudyResourcesScreen(
    onBack: () -> Unit
) {
    val boards = listOf("MP Board", "CBSE")
    val classes = listOf("Class 11", "Class 12")
    val subjects = listOf(
        "Accountancy",
        "Business Studies",
        "Economics",
        "Mathematics",
        "English",
        "Hindi"
    )

    val resources = listOf(
        StudyResourceItem(
            "Notes",
            "Chapter-wise study notes",
            Icons.Default.MenuBook
        ),
        StudyResourceItem(
            "Previous Year Papers",
            "Previous examination papers",
            Icons.Default.Description
        ),
        StudyResourceItem(
            "Marking Scheme",
            "Marks distribution and answer guidelines",
            Icons.Default.WorkspacePremium
        ),
        StudyResourceItem(
            "Sample Papers",
            "Practice papers for exam preparation",
            Icons.Default.School
        ),
        StudyResourceItem(
            "Important Questions",
            "Important chapter-wise questions",
            Icons.Default.Quiz
        ),
        StudyResourceItem(
            "Syllabus",
            "Subject-wise syllabus and chapters",
            Icons.Default.Book
        )
    )

    var selectedBoard by remember { mutableStateOf("MP Board") }
    var selectedClass by remember { mutableStateOf("Class 12") }
    var selectedSubject by remember { mutableStateOf("Accountancy") }
    var searchQuery by remember { mutableStateOf("") }
    var expandedMenu by remember { mutableStateOf("") }
    var selectedResource by remember { mutableStateOf("") }

    val filteredResources = resources.filter {
        it.title.contains(searchQuery, ignoreCase = true) ||
            it.description.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Study Resources",
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Your exam preparation hub",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "Study smarter. Score better.",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Text(
                            text = "Find notes, papers and exam resources in one place.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }

            item {
                Text(
                    text = "Choose your syllabus",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                SelectionDropdown(
                    label = "Board",
                    selectedValue = selectedBoard,
                    options = boards,
                    expanded = expandedMenu == "board",
                    onExpand = {
                        expandedMenu =
                            if (expandedMenu == "board") "" else "board"
                    },
                    onDismiss = { expandedMenu = "" },
                    onSelect = {
                        selectedBoard = it
                        expandedMenu = ""
                    }
                )
            }

            item {
                SelectionDropdown(
                    label = "Class",
                    selectedValue = selectedClass,
                    options = classes,
                    expanded = expandedMenu == "class",
                    onExpand = {
                        expandedMenu =
                            if (expandedMenu == "class") "" else "class"
                    },
                    onDismiss = { expandedMenu = "" },
                    onSelect = {
                        selectedClass = it
                        expandedMenu = ""
                    }
                )
            }

            item {
                SelectionDropdown(
                    label = "Subject",
                    selectedValue = selectedSubject,
                    options = subjects,
                    expanded = expandedMenu == "subject",
                    onExpand = {
                        expandedMenu =
                            if (expandedMenu == "subject") "" else "subject"
                    },
                    onDismiss = { expandedMenu = "" },
                    onSelect = {
                        selectedSubject = it
                        expandedMenu = ""
                    }
                )
            }

            item {
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Explore resources",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    label = { Text("Search resources") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    },
                    shape = RoundedCornerShape(14.dp)
                )
            }

            items(filteredResources) { resource ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedResource = resource.title
                        },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Icon(
                            imageVector = resource.icon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )

                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = resource.title,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = resource.description,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }

                        Text(
                            text = "View",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }

            if (filteredResources.isEmpty()) {
                item {
                    Text(
                        text = "No matching resources found.",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            if (selectedResource.isNotEmpty()) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = selectedResource,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Resources for $selectedBoard • $selectedClass • $selectedSubject",
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = "Study content will appear here once the resource library is connected.",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SelectionDropdown(
    label: String,
    selectedValue: String,
    options: List<String>,
    expanded: Boolean,
    onExpand: () -> Unit,
    onDismiss: () -> Unit,
    onSelect: (String) -> Unit
) {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onExpand),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = selectedValue,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                }
                Text(
                    text = if (expanded) "▲" else "▼",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onDismiss,
            modifier = Modifier.fillMaxWidth(0.85f)
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = { onSelect(option) }
                )
            }
        }
    }
}
