package com.commerzo.app.ui.screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.ui.theme.CommerzoDimensions
import com.commerzo.app.ui.viewmodel.settings.SettingsViewModel

// ============================================================
// COMMERZO — Settings Screen
// Phase 7 — Professional UI/UX Overhaul
// ============================================================

@Composable
fun SettingsScreen(
    onBack: () -> Unit,
    viewModel: SettingsViewModel = viewModel()
) {
    val darkModeEnabled by viewModel.darkModeEnabled.collectAsState()
    val notificationsEnabled by viewModel.notificationsEnabled.collectAsState()

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
                            text = "Settings",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Customize your COMMERZO experience.",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    Surface(
                        onClick = onBack,
                        modifier = Modifier
                            .padding(start = CommerzoDimensions.Space8)
                            .size(40.dp),
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "‹",
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(
                    horizontal = CommerzoDimensions.ScreenHorizontal,
                    vertical = CommerzoDimensions.Space12
                ),
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space16
            )
        ) {

            SettingsIntroCard()

            // ------------------------------------------------
            // Appearance
            // ------------------------------------------------

            SettingsSectionTitle(
                title = "Appearance",
                subtitle = "Make COMMERZO comfortable to use"
            )

            SettingsToggleCard(
                icon = Icons.Default.DarkMode,
                title = "Dark Mode",
                subtitle = "Use a darker appearance",
                checked = darkModeEnabled,
                onCheckedChange = {
                    viewModel.setDarkModeEnabled(it)
                }
            )

            // ------------------------------------------------
            // Notifications
            // ------------------------------------------------

            SettingsSectionTitle(
                title = "Notifications",
                subtitle = "Stay updated with your learning"
            )

            SettingsToggleCard(
                icon = Icons.Default.Notifications,
                title = "Learning Notifications",
                subtitle = "Receive reminders and important updates",
                checked = notificationsEnabled,
                onCheckedChange = {
                    viewModel.setNotificationsEnabled(it)
                }
            )

            // ------------------------------------------------
            // Account
            // ------------------------------------------------

            SettingsSectionTitle(
                title = "Account",
                subtitle = "Manage your student preferences"
            )

            SettingsActionCard(
                icon = Icons.Default.Person,
                title = "Student Profile",
                subtitle = "View and update your profile"
            )

            SettingsActionCard(
                icon = Icons.Default.SwapHoriz,
                title = "Learning Preferences",
                subtitle = "Board, class and study preferences"
            )

            // ------------------------------------------------
            // Help & Support
            // ------------------------------------------------

            SettingsSectionTitle(
                title = "Help & Support",
                subtitle = "We're here when you need help"
            )

            SettingsActionCard(
                icon = Icons.Default.SupportAgent,
                title = "Support Team",
                subtitle = "Get help from the COMMERZO team"
            )

            SupportEmailCard()

            // ------------------------------------------------
            // Information
            // ------------------------------------------------

            SettingsSectionTitle(
                title = "Information",
                subtitle = "About COMMERZO"
            )

            SettingsActionCard(
                icon = Icons.Default.Info,
                title = "About COMMERZO",
                subtitle = "Learn more about the app"
            )

            SettingsActionCard(
                icon = Icons.Default.Policy,
                title = "Privacy & Security",
                subtitle = "Understand how your account is protected"
            )

            VersionCard()

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space24
                )
            )
        }
    }
}

// ============================================================
// Intro Card
// ============================================================

@Composable
private fun SettingsIntroCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = CommerzoDimensions.Space2
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CommerzoDimensions.CardPaddingLarge),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(52.dp),
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.primary.copy(
                    alpha = 0.12f
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "⚙",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space16
                )
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    CommerzoDimensions.Space4
                )
            ) {
                Text(
                    text = "Your preferences",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Text(
                    text = "Personalize your learning experience and account settings.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

// ============================================================
// Section Title
// ============================================================

@Composable
private fun SettingsSectionTitle(
    title: String,
    subtitle: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            CommerzoDimensions.Space4
        )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

// ============================================================
// Toggle Card
// ============================================================

@Composable
private fun SettingsToggleCard(
    icon: ImageVector,
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = CommerzoDimensions.Space2
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CommerzoDimensions.CardPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SettingsIcon(
                icon = icon,
                selected = checked
            )

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
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(
                modifier = Modifier.width(
                    CommerzoDimensions.Space8
                )
            )

            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}

// ============================================================
// Action Card
// ============================================================

@Composable
private fun SettingsActionCard(
    icon: ImageVector,
    title: String,
    subtitle: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = CommerzoDimensions.Space2
        ),
        onClick = {}
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CommerzoDimensions.CardPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SettingsIcon(
                icon = icon
            )

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
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text = "›",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

// ============================================================
// Settings Icon
// ============================================================

@Composable
private fun SettingsIcon(
    icon: ImageVector,
    selected: Boolean = false
) {
    Surface(
        modifier = Modifier.size(46.dp),
        shape = RoundedCornerShape(14.dp),
        color = if (selected) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.surfaceVariant
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(
                    CommerzoDimensions.IconMedium
                ),
                tint = if (selected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
        }
    }
}

// ============================================================
// Support Email
// ============================================================

@Composable
private fun SupportEmailCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = CommerzoDimensions.Space2
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CommerzoDimensions.CardPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(46.dp),
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.surface
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Support email",
                        modifier = Modifier.size(
                            CommerzoDimensions.IconMedium
                        ),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
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
                    text = "Support Email",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Text(
                    text = SettingsViewModel.SUPPORT_EMAIL,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

// ============================================================
// Version Card
// ============================================================

@Composable
private fun VersionCard() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(
            modifier = Modifier.padding(
                CommerzoDimensions.CardPaddingLarge
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                CommerzoDimensions.Space4
            )
        ) {
            Text(
                text = "COMMERZO",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = "Learn. Practice. Score.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = "Version 5.3.1",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
