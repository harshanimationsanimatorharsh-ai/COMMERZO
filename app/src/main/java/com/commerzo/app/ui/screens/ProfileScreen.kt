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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.data.model.profile.StudentProfile
import com.commerzo.app.ui.viewmodel.auth.AuthViewModel
import com.commerzo.app.ui.viewmodel.profile.ProfileState
import com.commerzo.app.ui.viewmodel.profile.ProfileViewModel

@Composable
fun ProfileScreen(
    onBookmarks: () -> Unit = {},
    onTestHistory: () -> Unit = {},
    onAchievements: () -> Unit = {},
    onSettings: () -> Unit = {},
    viewModel: ProfileViewModel = viewModel(),
    authViewModel: AuthViewModel = viewModel()
) {
    val profileState by viewModel.profileState.collectAsState()
    val authState by authViewModel.authState.collectAsState()

    var showEditDialog by remember {
        mutableStateOf(false)
    }

    var showLogoutDialog by remember {
        mutableStateOf(false)
    }

    var displayNameInput by remember {
        mutableStateOf("")
    }

    LaunchedEffect(profileState) {
        val profile =
            (profileState as? ProfileState.Success)?.profile

        if (
            profile != null &&
            displayNameInput.isBlank()
        ) {
            displayNameInput = profile.displayName
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Profile",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor =
                        MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement =
                Arrangement.spacedBy(12.dp)
        ) {

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            when (val state = profileState) {

                ProfileState.Loading -> {
                    ProfileLoadingCard()
                }

                ProfileState.Empty -> {
                    ProfileEmptyCard(
                        onRetry = viewModel::loadProfile
                    )
                }

                is ProfileState.Error -> {
                    ProfileErrorCard(
                        message = state.message,
                        onRetry = viewModel::loadProfile
                    )
                }

                is ProfileState.Success -> {
                    StudentProfileCard(
                        profile = state.profile,
                        onEdit = {
                            displayNameInput =
                                state.profile.displayName

                            showEditDialog = true
                        }
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            ProfileMenuCard(
                icon = Icons.Default.Bookmark,
                title = "Bookmarks",
                subtitle = "View your saved questions",
                onClick = onBookmarks
            )

            ProfileMenuCard(
                icon = Icons.Default.History,
                title = "Test History",
                subtitle = "View your previous test results",
                onClick = onTestHistory
            )

            ProfileMenuCard(
                icon = Icons.Default.EmojiEvents,
                title = "Achievements",
                subtitle = "Track milestones and achievements",
                onClick = onAchievements
            )

            ProfileMenuCard(
                icon = Icons.Default.Settings,
                title = "Settings",
                subtitle = "Manage your app preferences",
                onClick = onSettings
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            ProfileMenuCard(
                icon = Icons.Default.ExitToApp,
                title = "Logout",
                subtitle = "Sign out from your COMMERZO account",
                onClick = {
                    showLogoutDialog = true
                }
            )

            if (authState is AuthState.Error) {
                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text =
                        (authState as AuthState.Error).message,
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "COMMERZO",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Learn. Practice. Score.",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodySmall,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }
    }

    if (showEditDialog) {
        AlertDialog(
            onDismissRequest = {
                showEditDialog = false
            },
            title = {
                Text("Edit Profile")
            },
            text = {
                OutlinedTextField(
                    value = displayNameInput,
                    onValueChange = {
                        displayNameInput = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text("Display Name")
                    },
                    singleLine = true
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        val name =
                            displayNameInput.trim()

                        if (name.isNotBlank()) {
                            viewModel.updateDisplayName(
                                name
                            )

                            showEditDialog = false
                        }
                    },
                    enabled =
                        displayNameInput
                            .trim()
                            .isNotBlank()
                ) {
                    Text("Save")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showEditDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = {
                if (authState !is AuthState.Loading) {
                    showLogoutDialog = false
                }
            },
            title = {
                Text("Logout")
            },
            text = {
                Text(
                    "Are you sure you want to logout from your COMMERZO account?"
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        showLogoutDialog = false
                        authViewModel.signOut()
                    },
                    enabled =
                        authState !is AuthState.Loading
                ) {
                    if (authState is AuthState.Loading) {
                        CircularProgressIndicator(
                            modifier = Modifier.height(20.dp)
                        )
                    } else {
                        Text("Logout")
                    }
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showLogoutDialog = false
                    },
                    enabled =
                        authState !is AuthState.Loading
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
private fun StudentProfileCard(
    profile: StudentProfile,
    onEdit: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text =
                            profile.displayName.ifBlank {
                                "COMMERZO Student"
                            },
                        style =
                            MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text =
                            profile.email.ifBlank {
                                "Email not available"
                            },
                        style =
                            MaterialTheme.typography.bodyMedium,
                        color =
                            MaterialTheme.colorScheme
                                .onPrimaryContainer
                    )
                }

                IconButton(
                    onClick = onEdit
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Profile"
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            ProfileInfoRow(
                label = "Account",
                value = "Student"
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            ProfileInfoRow(
                label = "Mobile",
                value =
                    profile.phoneNumber
                        ?: "Not added"
            )
        }
    }
}

@Composable
private fun ProfileInfoRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement =
            Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color =
                MaterialTheme.colorScheme
                    .onPrimaryContainer
                    .copy(alpha = 0.75f)
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun ProfileLoadingCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement =
                Arrangement.Center,
            verticalAlignment =
                Alignment.CenterVertically
        ) {
            CircularProgressIndicator()
        }
    }
}

@Composable
private fun ProfileEmptyCard(
    onRetry: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(
                text = "Profile not found",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text =
                    "Your student profile has not been created yet."
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Button(
                onClick = onRetry
            ) {
                Text("Try Again")
            }
        }
    }
}

@Composable
private fun ProfileErrorCard(
    message: String,
    onRetry: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.errorContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {

            Text(
                text = "Unable to load profile",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Button(
                onClick = onRetry
            ) {
                Text("Retry")
            }
        }
    }
}

@Composable
private fun ProfileMenuCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surface
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(2.dp)
            )

            Spacer(
                modifier = Modifier.width(14.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    style =
                        MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = subtitle,
                    style =
                        MaterialTheme.typography.bodySmall,
                    color =
                        MaterialTheme.colorScheme
                            .onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open $title"
            )
        }
    }
}
