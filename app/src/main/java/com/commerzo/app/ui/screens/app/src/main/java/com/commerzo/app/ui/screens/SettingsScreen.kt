package com.commerzo.app.ui.screens

import android.content.Context
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

private const val SETTINGS_PREFS =
    "commerzo_settings"

private const val DARK_MODE_KEY =
    "dark_mode"

private const val NOTIFICATIONS_KEY =
    "notifications_enabled"

@Composable
fun SettingsScreen(
    onBack: () -> Unit
) {

    val context =
        LocalContext.current

    val preferences =
        context.getSharedPreferences(
            SETTINGS_PREFS,
            Context.MODE_PRIVATE
        )

    var darkMode by rememberSaveable {

        mutableStateOf(
            preferences.getBoolean(
                DARK_MODE_KEY,
                false
            )
        )
    }

    var notificationsEnabled by
        rememberSaveable {

            mutableStateOf(
                preferences.getBoolean(
                    NOTIFICATIONS_KEY,
                    true
                )
            )
        }

    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    Text(
                        text = "Settings",
                        fontWeight =
                            FontWeight.Bold
                    )
                },

                navigationIcon = {

                    IconButton(
                        onClick = onBack
                    ) {

                        Icon(
                            imageVector =
                                Icons.Default.ArrowBack,

                            contentDescription =
                                "Back"
                        )
                    }
                },

                colors =
                    TopAppBarDefaults
                        .topAppBarColors(
                            containerColor =
                                MaterialTheme
                                    .colorScheme
                                    .surface
                        )
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(
                        paddingValues
                    )
                    .padding(
                        horizontal = 16.dp
                    ),

            verticalArrangement =
                Arrangement.spacedBy(
                    12.dp
                )
        ) {

            item {

                Spacer(
                    modifier =
                        Modifier.height(
                            8.dp
                        )
                )
            }

            item {

                SettingsSectionTitle(
                    title = "Preferences"
                )
            }

            item {

                SettingSwitchCard(
                    icon =
                        Icons.Default.DarkMode,

                    title =
                        "Dark Mode",

                    description =
                        "Use a darker appearance throughout COMMERZO.",

                    checked =
                        darkMode,

                    onCheckedChange = {

                        darkMode = it

                        preferences
                            .edit()
                            .putBoolean(
                                DARK_MODE_KEY,
                                it
                            )
                            .apply()
                    }
                )
            }

            item {

                SettingSwitchCard(
                    icon =
                        Icons.Default.Notifications,

                    title =
                        "Notifications",

                    description =
                        "Receive learning and practice reminders.",

                    checked =
                        notificationsEnabled,

                    onCheckedChange = {

                        notificationsEnabled = it

                        preferences
                            .edit()
                            .putBoolean(
                                NOTIFICATIONS_KEY,
                                it
                            )
                            .apply()
                    }
                )
            }

            item {

                Spacer(
                    modifier =
                        Modifier.height(
                            8.dp
                        )
                )

                SettingsSectionTitle(
                    title = "About"
                )
            }

            item {

                AboutCard()
            }

            item {

                Spacer(
                    modifier =
                        Modifier.height(
                            8.dp
                        )
                )

                SettingsSectionTitle(
                    title = "Support"
                )
            }

            item {

                SupportCard()
            }

            item {

                Spacer(
                    modifier =
                        Modifier.height(
                            20.dp
                        )
                )

                Column(
                    modifier =
                        Modifier.fillMaxWidth(),

                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Text(
                        text =
                            "COMMERZO",

                        style =
                            MaterialTheme
                                .typography
                                .titleMedium,

                        fontWeight =
                            FontWeight.Bold
                    )

                    Spacer(
                        modifier =
                            Modifier.height(
                                4.dp
                            )
                    )

                    Text(
                        text =
                            "Learn. Practice. Grow.",

                        style =
                            MaterialTheme
                                .typography
                                .bodySmall,

                        color =
                            MaterialTheme
                                .colorScheme
                                .onSurfaceVariant
                    )

                    Spacer(
                        modifier =
                            Modifier.height(
                                4.dp
                            )
                    )

                    Text(
                        text =
                            "Founded by Mr.Harsh Shrivas",

                        style =
                            MaterialTheme
                                .typography
                                .labelSmall,

                        color =
                            MaterialTheme
                                .colorScheme
                                .primary
                    )
                }

                Spacer(
                    modifier =
                        Modifier.height(
                            20.dp
                        )
                )
            }
        }
    }
}

@Composable
private fun SettingSwitchCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Card(
        modifier =
            Modifier.fillMaxWidth(),

        colors =
            CardDefaults.cardColors(
                containerColor =
                    MaterialTheme
                        .colorScheme
                        .surface
            )
    ) {

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(
                        16.dp
                    ),

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Icon(
                imageVector =
                    icon,

                contentDescription =
                    null
            )

            Spacer(
                modifier =
                    Modifier.width(
                        14.dp
                    )
            )

            Column(
                modifier =
                    Modifier.weight(
                        1f
                    )
            ) {

                Text(
                    text =
                        title,

                    style =
                        MaterialTheme
                            .typography
                            .titleMedium,

                    fontWeight =
                        FontWeight.SemiBold
                )

                Spacer(
                    modifier =
                        Modifier.height(
                            3.dp
                        )
                )

                Text(
                    text =
                        description,

                    style =
                        MaterialTheme
                            .typography
                            .bodySmall,

                    color =
                        MaterialTheme
                            .colorScheme
                            .onSurfaceVariant
                )
            }

            Switch(
                checked =
                    checked,

                onCheckedChange =
                    onCheckedChange
            )
        }
    }
}

@Composable
private fun AboutCard() {

    Card(
        modifier =
            Modifier.fillMaxWidth(),

        colors =
            CardDefaults.cardColors(
                containerColor =
                    MaterialTheme
                        .colorScheme
                        .surface
            )
    ) {

        Column(
            modifier =
                Modifier.padding(
                    16.dp
                )
        ) {

            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Icon(
                    imageVector =
                        Icons.Default.Info,

                    contentDescription =
                        null
                )

                Spacer(
                    modifier =
                        Modifier.width(
                            12.dp
                        )
                )

                Text(
                    text =
                        "About COMMERZO",

                    style =
                        MaterialTheme
                            .typography
                            .titleMedium,

                    fontWeight =
                        FontWeight.Bold
                )
            }

            Spacer(
                modifier =
                    Modifier.height(
                        14.dp
                    )
            )

            InfoRow(
                label =
                    "Version",

                value =
                    "1.0"
            )

            InfoRow(
                label =
                    "Founder",

                value =
                    "Mr.Harsh Shrivas"
            )

            InfoRow(
                label =
                    "Platform",

                value =
                    "Android"
            )

            InfoRow(
                label =
                    "Focus",

                value =
                    "Commerce Education"
            )
        }
    }
}

@Composable
private fun SupportCard() {

    Card(
        modifier =
            Modifier.fillMaxWidth(),

        colors =
            CardDefaults.cardColors(
                containerColor =
                    MaterialTheme
                        .colorScheme
                        .surface
            )
    ) {

        Column(
            modifier =
                Modifier.padding(
                    16.dp
                )
        ) {

            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Icon(
                    imageVector =
                        Icons.Default.Person,

                    contentDescription =
                        null
                )

                Spacer(
                    modifier =
                        Modifier.width(
                            12.dp
                        )
                )

                Text(
                    text =
                        "Help & Support",

                    style =
                        MaterialTheme
                            .typography
                            .titleMedium,

                    fontWeight =
                        FontWeight.Bold
                )
            }

            Spacer(
                modifier =
                    Modifier.height(
                        12.dp
                    )
            )

            Text(
                text =
                    "For questions, feedback, or support, contact:",

                style =
                    MaterialTheme
                        .typography
                        .bodyMedium
            )

            Spacer(
                modifier =
                    Modifier.height(
                        6.dp
                    )
            )

            Text(
                text =
                    "theharshshrivas@gmail.com",

                style =
                    MaterialTheme
                        .typography
                        .bodyMedium,

                color =
                    MaterialTheme
                        .colorScheme
                        .primary,

                fontWeight =
                    FontWeight.Medium
            )
        }
    }
}

@Composable
private fun SettingsSectionTitle(
    title: String
) {

    Text(
        text =
            title,

        style =
            MaterialTheme
                .typography
                .titleSmall,

        fontWeight =
            FontWeight.Bold,

        color =
            MaterialTheme
                .colorScheme
                .primary
    )
}

@Composable
private fun InfoRow(
    label: String,
    value: String
) {

    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 5.dp
                ),

        horizontalArrangement =
            Arrangement.SpaceBetween
    ) {

        Text(
            text =
                label,

            style =
                MaterialTheme
                    .typography
                    .bodyMedium,

            color =
                MaterialTheme
                    .colorScheme
                    .onSurfaceVariant
        )

        Text(
            text =
                value,

            style =
                MaterialTheme
                    .typography
                    .bodyMedium,

            fontWeight =
                FontWeight.Medium
        )
    }
}
