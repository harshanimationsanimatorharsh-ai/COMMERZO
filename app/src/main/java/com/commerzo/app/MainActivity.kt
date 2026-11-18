
package com.commerzo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.navigation.AuthNavigation
import com.commerzo.app.ui.theme.CommerzoTheme
import com.commerzo.app.ui.viewmodel.settings.SettingsViewModel
import com.commerzo.app.ui.viewmodel.settings.ThemeMode

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val settingsViewModel: SettingsViewModel = viewModel()

            val themeMode by settingsViewModel.themeMode
                .collectAsState()

            val systemDarkTheme = isSystemInDarkTheme()

            val darkTheme = when (themeMode) {
                ThemeMode.SYSTEM -> systemDarkTheme
                ThemeMode.LIGHT -> false
                ThemeMode.DARK -> true
            }

            CommerzoTheme(
                darkTheme = darkTheme
            ) {
                AuthNavigation(
                    settingsViewModel = settingsViewModel
                )
            }
        }
    }
}
