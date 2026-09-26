package com.commerzo.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.profile.StudentProfile
import com.commerzo.app.ui.viewmodel.profile.ProfileState
import com.commerzo.app.ui.viewmodel.profile.ProfileViewModel

@Composable
fun ProfileScreen(
    onBookmarks: () -> Unit = {},
    onTestHistory: () -> Unit = {},
    onAchievements: () -> Unit = {},
    onSettings: () -> Unit = {},
    onStudyTracker: () -> Unit = {},
    onLogout: () -> Unit = {},
    viewModel: ProfileViewModel = viewModel()
) {
    val profileState by viewModel.profileState.collectAsState()

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
        val profile = (profileState as? ProfileState.Success)?.profile

        if (profile != null && displayNameInput.isBlank()) {
            displayNameInput = profile.displayName
        }
    }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                title = {
                    Column {
                        Text(
                            text = "Profile",
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF102A56)
                        )

                        Text(
                            text = "Manage your account and progress.",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(0xFF6B7892)
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = onSettings
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = Color(0xFF243B64)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(horizontal = 18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Spacer(
                modifier = Modifier.height(2.dp)
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
                    StudentProfileHeroCard(
                        profile = state.profile,
                        onEdit = {
                            displayNameInput = state.profile.displayName
                            showEditDialog = true
                        }
                    )

                    XPProgressCard()
                }
            }

            SectionHeader(
                title = "Your Progress",
                subtitle = "Track your learning journey"
            )

            ProfileMenuGroup {
                ProfileMenuRow(
                    icon = Icons.Default.AccessTime,
                    title = "Study Tracker",
                    subtitle = "Track study time, goals and progress",
                    iconBackground = Color(0xFFE8F7F1),
                    iconTint = Color(0xFF0AA66E),
                    onClick = onStudyTracker
                )
            }

            SectionHeader(
                title = "Account",
                subtitle = "Your COMMERZO account"
            )

            ProfileMenuGroup {
                ProfileMenuRow(
                    icon = Icons.Default.Bookmark,
                    title = "Bookmarks",
                    subtitle = "View your saved questions",
                    iconBackground = Color(0xFFE8F0FF),
                    iconTint = Color(0xFF2563EB),
                    onClick = onBookmarks
                )

                MenuDivider()

                ProfileMenuRow(
                    icon = Icons.Default.History,
                    title = "Test History",
                    subtitle = "View your previous test results",
                    iconBackground = Color(0xFFF0EBFF),
                    iconTint = Color(0xFF7048E8),
                    onClick = onTestHistory
                )

                MenuDivider()

                ProfileMenuRow(
                    icon = Icons.Default.EmojiEvents,
                    title = "Achievements",
                    subtitle = "Track milestones and achievements",
                    iconBackground = Color(0xFFFFF3D9),
                    iconTint = Color(0xFFE89B00),
                    onClick = onAchievements
                )
            }

            SectionHeader(
                title = "More",
                subtitle = "Manage your COMMERZO experience"
            )

            ProfileMenuGroup {
                ProfileMenuRow(
                    icon = Icons.Default.Settings,
                    title = "Settings",
                    subtitle = "Notifications, appearance and preferences",
                    iconBackground = Color(0xFFEDEBFF),
                    iconTint = Color(0xFF6250E8),
                    onClick = onSettings
                )

                MenuDivider()

                ProfileMenuRow(
                    icon = Icons.Default.ExitToApp,
                    title = "Logout",
                    subtitle = "Sign out from your COMMERZO account",
                    iconBackground = Color(0xFFFFE9E9),
                    iconTint = Color(0xFFE5484D),
                    titleColor = Color(0xFFD9363E),
                    arrowTint = Color(0xFFD9363E),
                    onClick = {
                        showLogoutDialog = true
                    }
                )
            }

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp),
                shape = RoundedCornerShape(22.dp),
                color = Color(0xFFF7F9FD)
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    Text(
                        text = "COMMERZO",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF102A56)
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Learn. Practice. Score.",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF36558A)
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Your focused Commerce learning space.",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF71809B)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }

    if (showEditDialog) {
        AlertDialog(
            onDismissRequest = {
                showEditDialog = false
            },
            title = {
                Text(
                    text = "Edit Profile",
                    fontWeight = FontWeight.Bold
                )
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
                        val name = displayNameInput.trim()

                        if (name.isNotBlank()) {
                            viewModel.updateDisplayName(name)
                            showEditDialog = false
                        }
                    },
                    enabled = displayNameInput.trim().isNotBlank(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF315FEA)
                    )
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
                showLogoutDialog = false
            },
            title = {
                Text(
                    text = "Logout",
                    fontWeight = FontWeight.Bold
                )
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
                        onLogout()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE5484D)
                    )
                ) {
                    Text("Logout")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showLogoutDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
private fun StudentProfileHeroCard(
    profile: StudentProfile,
    onEdit: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 7.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF1557D6),
                            Color(0xFF3568F2),
                            Color(0xFF7057E8)
                        )
                    ),
                    shape = RoundedCornerShape(28.dp)
                )
                .padding(20.dp)
        ) {
            Column {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Surface(
                        modifier = Modifier.size(76.dp),
                        shape = CircleShape,
                        color = Color.White.copy(alpha = 0.94f)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            Surface(
                                modifier = Modifier.size(66.dp),
                                shape = CircleShape,
                                color = Color(0xFFE2F0FF)
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = profile.displayName
                                            .firstOrNull()
                                            ?.uppercase()
                                            ?: "C",
                                        style = MaterialTheme.typography.headlineMedium,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color(0xFF245EDC)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(
                        modifier = Modifier.width(14.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = profile.displayName.ifBlank {
                                "COMMERZO Student"
                            },
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )

                        Spacer(
                            modifier = Modifier.height(3.dp)
                        )

                        Text(
                            text = profile.email.ifBlank {
                                "Email not available"
                            },
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White.copy(alpha = 0.84f)
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Surface(
                            shape = RoundedCornerShape(50.dp),
                            color = Color.White.copy(alpha = 0.18f)
                        ) {
                            Row(
                                modifier = Modifier.padding(
                                    horizontal = 10.dp,
                                    vertical = 6.dp
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Verified,
                                    contentDescription = "Student",
                                    modifier = Modifier.size(15.dp),
                                    tint = Color.White
                                )

                                Spacer(
                                    modifier = Modifier.width(5.dp)
                                )

                                Text(
                                    text = "Student",
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }

                    Surface(
                        modifier = Modifier.size(42.dp),
                        shape = RoundedCornerShape(14.dp),
                        color = Color.White.copy(alpha = 0.16f)
                    ) {
                        IconButton(
                            onClick = onEdit
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Edit Profile",
                                tint = Color.White
                            )
                        }
                    }
                }

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 14.dp,
                                vertical = 14.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        ProfileStat(
                            icon = Icons.Default.Star,
                            iconTint = Color(0xFFE7A600),
                            title = "Level 1",
                            subtitle = "0 / 800 XP",
                            modifier = Modifier.weight(1f)
                        )

                        StatDivider()

                        ProfileStat(
                            icon = Icons.Default.AccessTime,
                            iconTint = Color(0xFF0AA66E),
                            title = "Study",
                            subtitle = "Keep going",
                            modifier = Modifier.weight(1f)
                        )

                        StatDivider()

                        ProfileStat(
                            icon = Icons.Default.EmojiEvents,
                            iconTint = Color(0xFF7048E8),
                            title = "Student",
                            subtitle = "Active",
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ProfileStat(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconTint: Color,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier.size(36.dp),
            shape = RoundedCornerShape(11.dp),
            color = iconTint.copy(alpha = 0.12f)
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = iconTint
                )
            }
        }

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF18294A)
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.labelSmall,
            color = Color(0xFF71809B)
        )
    }
}

@Composable
private fun StatDivider() {
    Surface(
        modifier = Modifier
            .width(1.dp)
            .height(52.dp),
        color = Color(0xFFE8ECF4)
    ) {}
}

@Composable
private fun XPProgressCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F8FF)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(46.dp),
                    shape = RoundedCornerShape(14.dp),
                    color = Color(0xFFFFF1C7)
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "XP",
                            tint = Color(0xFFE7A600),
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.width(12.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Level 1",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF172A4D)
                    )

                    Text(
                        text = "Keep learning to unlock your next level",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF71809B)
                    )
                }

                Text(
                    text = "0 XP",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF315FEA)
                )
            }

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(9.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(Color(0xFFE1E8F7))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0f)
                        .height(9.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFF315FEA),
                                    Color(0xFF7048E8)
                                )
                            )
                        )
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "0 / 800 XP",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF596A89)
                )

                Text(
                    text = "Earn XP from practice & tests",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(0xFF71809B)
                )
            }
        }
    }
}

@Composable
private fun ProfileMenuGroup(
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = 4.dp
            ),
            content = content
        )
    }
}

@Composable
private fun ProfileMenuRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String,
    iconBackground: Color,
    iconTint: Color,
    titleColor: Color = Color(0xFF172A4D),
    arrowTint: Color = Color(0xFF72819C),
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)),
        color = Color.Transparent,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 14.dp,
                    vertical = 14.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier.size(46.dp),
                shape = RoundedCornerShape(14.dp),
                color = iconBackground
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        modifier = Modifier.size(22.dp),
                        tint = iconTint
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(13.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = titleColor
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF71809B)
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open $title",
                modifier = Modifier.size(21.dp),
                tint = arrowTint
            )
        }
    }
}

@Composable
private fun MenuDivider() {
    HorizontalDivider(
        modifier = Modifier.padding(
            start = 73.dp,
            end = 14.dp
        ),
        color = Color(0xFFEDF0F5)
    )
}

@Composable
private fun SectionHeader(
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier.padding(
            start = 2.dp,
            top = 2.dp
        )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF12284C)
        )

        Spacer(
            modifier = Modifier.height(3.dp)
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF71809B)
        )
    }
}

@Composable
private fun ProfileLoadingCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF7F9FD)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularProgressIndicator(
                color = Color(0xFF315FEA)
            )
        }
    }
}

@Composable
private fun ProfileEmptyCard(
    onRetry: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF7F9FD)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Profile not found",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF172A4D)
            )

            Spacer(
                modifier = Modifier.height(7.dp)
            )

            Text(
                text = "Your student profile has not been created yet.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF71809B)
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Button(
                onClick = onRetry,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF315FEA)
                )
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
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF2F2)
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
                fontWeight = FontWeight.Bold,
                color = Color(0xFFB4232B)
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF6D3A3E)
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Button(
                onClick = onRetry,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF315FEA)
                )
            ) {
                Text("Retry")
            }
        }
    }
}
