
package com.commerzo.app.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.ui.viewmodel.auth.AuthViewModel
import com.commerzo.app.ui.viewmodel.settings.SettingsViewModel

@Composable
fun AuthNavigation(
    authViewModel: AuthViewModel = viewModel(),
    settingsViewModel: SettingsViewModel = viewModel()
) {
    val authState by authViewModel.authState.collectAsState()
    val authNavController = rememberNavController()

    when (authState) {
        AuthState.Loading -> {
            AuthLoadingScreen()
        }

        AuthState.LoggedOut -> {
            AuthNav(
                navController = authNavController,
                onLoginSuccess = {
                    authViewModel.refreshSession()
                }
            )
        }

        is AuthState.LoggedIn -> {
            AppNavigation(
                authViewModel = authViewModel,
                settingsViewModel = settingsViewModel
            )
        }

        AuthState.PhoneOtpSent -> {
            AuthNav(
                navController = authNavController,
                onLoginSuccess = {
                    authViewModel.refreshSession()
                }
            )
        }

        is AuthState.Error -> {
            AuthNav(
                navController = authNavController,
                onLoginSuccess = {
                    authViewModel.refreshSession()
                }
            )
        }
    }
}

@Composable
private fun AuthLoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
