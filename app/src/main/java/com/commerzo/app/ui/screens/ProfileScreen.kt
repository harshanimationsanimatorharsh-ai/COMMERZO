package com.commerzo.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.profile.StudentProfile
import com.commerzo.app.ui.theme.CommerzoDimensions
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
        val profile =
            (profileState as? ProfileState.Success)?.profile

        if (profile != null) {
            displayNameInput = profile.displayName
        }
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                ),
                title = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            CommerzoDimensions.Space2
                        )
                    ) {
                        Text(
                            text = "Profile",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = "Your account and learning progress",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
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
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
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
                .padding(
                    horizontal = CommerzoDimensions.ScreenHorizontal
                ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space16
            )
        ) {

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space2
                )
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
                            displayNameInput =
                                state.profile.displayName
                            showEditDialog = true
                        }
                    )

                    XPProgressCard()
                }
            }

            SectionHeader(
                title = "Learning",
                subtitle = "Your study activity"
            )

            ProfileMenuGroup {
                ProfileMenuRow(
                    icon = Icons.Default.AccessTime,
                    title = "Study Tracker",
                    subtitle = "Track study time and daily goals",
                    iconBackground =
                        MaterialTheme.colorScheme.secondaryContainer,
                    iconTint =
                        MaterialTheme.colorScheme.secondary,
                    onClick = onStudyTracker
                )
            }

            SectionHeader(
                title = "Your Activity",
                subtitle = "Saved and completed work"
            )

            ProfileMenuGroup {

                ProfileMenuRow(
                    icon = Icons.Default.Bookmark,
                    title = "Bookmarks",
                    subtitle = "View your saved questions",
                    iconBackground =
                        MaterialTheme.colorScheme.primaryContainer,
                    iconTint =
                        MaterialTheme.colorScheme.primary,
                    onClick = onBookmarks
                )

                MenuDivider()

                ProfileMenuRow(
                    icon = Icons.Default.History,
                    title = "Test History",
                    subtitle = "View your previous test results",
                    iconBackground =
                        MaterialTheme.colorScheme.tertiaryContainer,
                    iconTint =
                        MaterialTheme.colorScheme.tertiary,
                    onClick = onTestHistory
                )

                MenuDivider()

                ProfileMenuRow(
                    icon = Icons.Default.EmojiEvents,
                    title = "Achievements",
                    subtitle = "Track your learning milestones",
                    iconBackground =
                        MaterialTheme.colorScheme.secondaryContainer,
                    iconTint =
                        MaterialTheme.colorScheme.secondary,
                    onClick = onAchievements
                )
            }

            SectionHeader(
                title = "Account",
                subtitle = "Manage your COMMERZO account"
            )

            ProfileMenuGroup {

                ProfileMenuRow(
                    icon = Icons.Default.Settings,
                    title = "Settings",
                    subtitle = "Appearance, notifications and preferences",
                    iconBackground =
                        MaterialTheme.colorScheme.primaryContainer,
                    iconTint =
                        MaterialTheme.colorScheme.primary,
                    onClick = onSettings
                )

                MenuDivider()

                ProfileMenuRow(
                    icon = Icons.Default.ExitToApp,
                    title = "Logout",
                    subtitle = "Sign out from this account",
                    iconBackground =
                        MaterialTheme.colorScheme.errorContainer,
                    iconTint =
                        MaterialTheme.colorScheme.error,
                    titleColor =
                        MaterialTheme.colorScheme.error,
                    arrowTint =
                        MaterialTheme.colorScheme.error,
                    onClick = {
                        showLogoutDialog = true
                    }
                )
            }

            ProfileBrandCard()

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space20
                )
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
                        val name =
                            displayNameInput.trim()

                        if (name.isNotBlank()) {
                            viewModel.updateDisplayName(name)
                            showEditDialog = false
                        }
                    },
                    enabled = displayNameInput
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
                    text = "Are you sure you want to logout from your COMMERZO account?"
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        showLogoutDialog = false
                        onLogout()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor =
                            MaterialTheme.colorScheme.error
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
            containerColor =
                MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = CommerzoDimensions.Space4
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.tertiary
                        )
                    ),
                    shape = RoundedCornerShape(28.dp)
                )
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                )
        ) {
            Column {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Surface(
                        modifier = Modifier.size(
                            CommerzoDimensions.AvatarLarge
                        ),
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.surface.copy(
                            alpha = 0.94f
                        )
                    ) {
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            Surface(
                                modifier = Modifier.size(
                                    CommerzoDimensions.AvatarMedium
                                ),
                                shape = CircleShape,
                                color =
                                    MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = profile.displayName
                                            .firstOrNull()
                                            ?.uppercase()
                                            ?: "C",
                                        style =
                                            MaterialTheme.typography.headlineMedium,
                                        fontWeight =
                                            FontWeight.ExtraBold,
                                        color =
                                            MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        }
                    }

                    Spacer(
                        modifier = Modifier.width(
                            CommerzoDimensions.Space12
                        )
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = profile.displayName.ifBlank {
                                "COMMERZO Student"
                            },
                            style =
                                MaterialTheme.typography.titleLarge,
                            fontWeight =
                                FontWeight.ExtraBold,
                            color =
                                MaterialTheme.colorScheme.onPrimary
                        )

                        Spacer(
                            modifier = Modifier.height(
                                CommerzoDimensions.Space2
                            )
                        )

                        Text(
                            text = profile.email.ifBlank {
                                "Email not available"
                            },
                            style =
                                MaterialTheme.typography.bodySmall,
                            color =
                                MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.82f
                                )
                        )

                        Spacer(
                            modifier = Modifier.height(
                                CommerzoDimensions.Space8
                            )
                        )

                        Surface(
                            shape = RoundedCornerShape(50.dp),
                            color =
                                MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.16f
                                )
                        ) {
                            Row(
                                modifier = Modifier.padding(
                                    horizontal =
                                        CommerzoDimensions.Space10,
                                    vertical =
                                        CommerzoDimensions.Space6
                                ),
                                verticalAlignment =
                                    Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector =
                                        Icons.Default.Verified,
                                    contentDescription =
                                        "Student",
                                    modifier = Modifier.size(
                                        CommerzoDimensions.IconSmall
                                    ),
                                    tint =
                                        MaterialTheme.colorScheme.onPrimary
                                )

                                Spacer(
                                    modifier = Modifier.width(
                                        CommerzoDimensions.Space4
                                    )
                                )

                                Text(
                                    text = "Student",
                                    style =
                                        MaterialTheme.typography.labelMedium,
                                    fontWeight =
                                        FontWeight.Bold,
                                    color =
                                        MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }
                    }

                    Surface(
                        modifier = Modifier.size(
                            CommerzoDimensions.IconButtonSize
                        ),
                        shape = RoundedCornerShape(14.dp),
                        color =
                            MaterialTheme.colorScheme.onPrimary.copy(
                                alpha = 0.16f
                            )
                    ) {
                        IconButton(
                            onClick = onEdit
                        ) {
                            Icon(
                                imageVector =
                                    Icons.Default.Edit,
                                contentDescription =
                                    "Edit Profile",
                                tint =
                                    MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space20
                    )
                )

                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal =
                                    CommerzoDimensions.Space12,
                                vertical =
                                    CommerzoDimensions.Space12
                            ),
                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {
                        ProfileStat(
                            icon = Icons.Default.Star,
                            iconTint =
                                MaterialTheme.colorScheme.secondary,
                            title = "Level 1",
                            subtitle = "0 / 800 XP",
                            modifier = Modifier.weight(1f)
                        )

                        StatDivider()

                        ProfileStat(
                            icon = Icons.Default.AccessTime,
                            iconTint =
                                MaterialTheme.colorScheme.primary,
                            title = "Study",
                            subtitle = "Keep going",
                            modifier = Modifier.weight(1f)
                        )

                        StatDivider()

                        ProfileStat(
                            icon = Icons.Default.EmojiEvents,
                            iconTint =
                                MaterialTheme.colorScheme.tertiary,
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
    icon: ImageVector,
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
            modifier = Modifier.size(
                CommerzoDimensions.Space40
            ),
            shape = RoundedCornerShape(11.dp),
            color = iconTint.copy(alpha = 0.12f)
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(
                        CommerzoDimensions.IconMedium
                    ),
                    tint = iconTint
                )
            }
        }

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space6
            )
        )

        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun StatDivider() {
    HorizontalDivider(
        modifier = Modifier
            .width(1.dp)
            .height(
                CommerzoDimensions.Space48
            ),
        color = MaterialTheme.colorScheme.outlineVariant
    )
}

@Composable
private fun XPProgressCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation =
                CommerzoDimensions.Space2
        )
    ) {
        Column(
            modifier = Modifier.padding(
                CommerzoDimensions.CardPaddingLarge
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(
                        CommerzoDimensions.Space48
                    ),
                    shape = RoundedCornerShape(14.dp),
                    color =
                        MaterialTheme.colorScheme.secondaryContainer
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector =
                                Icons.Default.Star,
                            contentDescription = "XP",
                            tint =
                                MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.size(
                                CommerzoDimensions.IconLarge
                            )
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.width(
                        CommerzoDimensions.Space12
                    )
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Level 1",
                        style =
                            MaterialTheme.typography.titleMedium,
                        fontWeight =
                            FontWeight.ExtraBold
                    )

                    Text(
                        text = "Keep learning to unlock your next level",
                        style =
                            MaterialTheme.typography.bodySmall,
                        color =
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Text(
                    text = "0 XP",
                    style =
                        MaterialTheme.typography.titleMedium,
                    fontWeight =
                        FontWeight.ExtraBold,
                    color =
                        MaterialTheme.colorScheme.primary
                )
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )

            LinearXPBar()

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {
                Text(
                    text = "0 / 800 XP",
                    style =
                        MaterialTheme.typography.labelSmall,
                    fontWeight =
                        FontWeight.Bold,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = "Practice & tests earn XP",
                    style =
                        MaterialTheme.typography.labelSmall,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun LinearXPBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(
                CommerzoDimensions.Space8
            )
            .clip(
                RoundedCornerShape(50.dp)
            )
            .background(
                MaterialTheme.colorScheme.outlineVariant
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0f)
                .height(
                    CommerzoDimensions.Space8
                )
                .clip(
                    RoundedCornerShape(50.dp)
                )
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.tertiary
                        )
                    )
                )
        )
    }
}

@Composable
private fun ProfileMenuGroup(
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation =
                CommerzoDimensions.Space2
        )
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = CommerzoDimensions.Space4
            ),
            content = content
        )
    }
}

@Composable
private fun ProfileMenuRow(
    icon: ImageVector,
    title: String,
    subtitle: String,
    iconBackground: Color,
    iconTint: Color,
    titleColor: Color =
        MaterialTheme.colorScheme.onSurface,
    arrowTint: Color =
        MaterialTheme.colorScheme.onSurfaceVariant,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(18.dp)
            ),
        color = Color.Transparent,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal =
                        CommerzoDimensions.Space12,
                    vertical =
                        CommerzoDimensions.Space12
                ),
            verticalAlignment =
                Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(
                    CommerzoDimensions.Space48
                ),
                shape = RoundedCornerShape(14.dp),
                color = iconBackground
            ) {
                Box(
                    contentAlignment =
                        Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        modifier = Modifier.size(
                            CommerzoDimensions.IconMedium
                        ),
                        tint = iconTint
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space12
                )
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style =
                        MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = titleColor
                )

                Spacer(
                    modifier = Modifier.height(
                        CommerzoDimensions.Space2
                    )
                )

                Text(
                    text = subtitle,
                    style =
                        MaterialTheme.typography.bodySmall,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector =
                    Icons.Default.ArrowForward,
                contentDescription =
                    "Open $title",
                modifier = Modifier.size(
                    CommerzoDimensions.IconMedium
                ),
                tint = arrowTint
            )
        }
    }
}

@Composable
private fun MenuDivider() {
    HorizontalDivider(
        modifier = Modifier.padding(
            start = 76.dp,
            end = CommerzoDimensions.Space12
        ),
        color = MaterialTheme.colorScheme.outlineVariant
    )
}

@Composable
private fun SectionHeader(
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space2
        )
    ) {
        Text(
            text = title,
            style =
                MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            color =
                MaterialTheme.colorScheme.onBackground
        )

        Text(
            text = subtitle,
            style =
                MaterialTheme.typography.bodySmall,
            color =
                MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun ProfileBrandCard() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color =
            MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(
            modifier = Modifier.padding(
                CommerzoDimensions.CardPaddingLarge
            )
        ) {
            Text(
                text = "COMMERZO",
                style =
                    MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space4
                )
            )

            Text(
                text = "Learn. Practice. Score.",
                style =
                    MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color =
                    MaterialTheme.colorScheme.primary
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space4
                )
            )

            Text(
                text = "Your focused Commerce learning space.",
                style =
                    MaterialTheme.typography.bodySmall,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun ProfileLoadingCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.Space28
                ),
            horizontalArrangement =
                Arrangement.Center,
            verticalAlignment =
                Alignment.CenterVertically
        ) {
            CircularProgressIndicator(
                color =
                    MaterialTheme.colorScheme.primary
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
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                ),
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {
            Text(
                text = "Profile not found",
                style =
                    MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space6
                )
            )

            Text(
                text = "Your student profile has not been created yet.",
                style =
                    MaterialTheme.typography.bodyMedium,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
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
                .padding(
                    CommerzoDimensions.CardPaddingLarge
                )
        ) {
            Text(
                text = "Unable to load profile",
                style =
                    MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color =
                    MaterialTheme.colorScheme.onErrorContainer
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space6
                )
            )

            Text(
                text = message,
                style =
                    MaterialTheme.typography.bodyMedium,
                color =
                    MaterialTheme.colorScheme.onErrorContainer
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )

            Button(
                onClick = onRetry
            ) {
                Text("Retry")
            }
        }
    }
}
