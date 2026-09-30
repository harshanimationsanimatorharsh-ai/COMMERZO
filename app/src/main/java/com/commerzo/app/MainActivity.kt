package com.commerzo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.navigation.AuthNavigation
import com.commerzo.app.ui.theme.CommerzoTheme
import com.commerzo.app.ui.viewmodel.settings.SettingsViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val settingsViewModel: SettingsViewModel = viewModel()

            val darkModeEnabled = settingsViewModel.darkModeEnabled.value

            CommerzoTheme(
                darkTheme = darkModeEnabled
            ) {
                AuthNavigation()
            }
        }
    }
}
