
package com.commerzo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.navigation.AuthNavigation
import com.commerzo.app.ui.theme.CommerzoTheme
import com.commerzo.app.ui.viewmodel.settings.SettingsViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val settingsViewModel: SettingsViewModel = viewModel()

            val darkModeEnabled by settingsViewModel.darkModeEnabled
                .collectAsState()

            CommerzoTheme(
                darkTheme = darkModeEnabled
            ) {
                AuthNavigation(
                    settingsViewModel = settingsViewModel
                )
            }
        }
    }
}
