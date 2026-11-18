package com.commerzo.app.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.ui.viewmodel.auth.AuthViewModel
import com.commerzo.app.ui.viewmodel.settings.SettingsViewModel

/**
 * COMMERZO authentication entry point.
 *
 * Responsibilities:
 * - Observe the single application auth state.
 * - Show loading while the session is being restored.
 * - Show the authentication graph when logged out.
 * - Show the main application graph when logged in.
 * - Keep the same AuthViewModel instance across both graphs.
 *
 * Navigation ownership:
 *
 * AuthNavigation
 *      │
 *      ├── LoggedOut / Auth states → AuthNav
 *      │
 *      └── LoggedIn              → AppNavigation
 */
@Composable
fun AuthNavigation(
    authViewModel: AuthViewModel = viewModel()
) {
    val authState by authViewModel.authState.collectAsState()

    /*
     * Keep one authentication NavController alive while the
     * authentication graph is active.
     *
     * This avoids recreating the auth navigation controller
     * separately for Loading/Error/OTP states.
     */
    val authNavController = rememberNavController()

    when (authState) {

        // ============================================================
        // SESSION RESTORATION
        // ============================================================

        AuthState.Loading -> {
            AuthLoadingScreen()
        }

        // ============================================================
        // LOGGED OUT
        // ============================================================

        AuthState.LoggedOut -> {
            AuthNav(
                navController = authNavController,
                onLoginSuccess = {
                    authViewModel.refreshSession()
                }
            )
        }

        // ============================================================
        // LOGGED IN
        // ============================================================

        is AuthState.LoggedIn -> {
            /*
             * Pass the SAME AuthViewModel instance into AppNavigation.
             *
             * This keeps logout/session changes connected to the
             * root auth state instead of creating another ViewModel.
             */
            AppNavigation(
                authViewModel = authViewModel
            )
        }

        // ============================================================
        // PHONE OTP FLOW
        // ============================================================

        AuthState.PhoneOtpSent -> {
            /*
             * OTP-specific UI is not yet part of AuthNav.
             *
             * Keep the existing authentication graph active until
             * the dedicated OTP screen/navigation is implemented.
             */
            AuthNav(
                navController = authNavController,
                onLoginSuccess = {
                    authViewModel.refreshSession()
                }
            )
        }

        // ============================================================
        // AUTH ERROR
        // ============================================================

        is AuthState.Error -> {
            /*
             * Error-specific UI is not yet part of the current
             * authentication navigation contract.
             *
             * Keep the user inside the auth graph rather than
             * navigating into the main application.
             */
            AuthNav(
                navController = authNavController,
                onLoginSuccess = {
                    authViewModel.refreshSession()
                }
            )
        }
    }
}

/**
 * Lightweight startup/session restoration screen.
 *
 * Authentication remains blocked until AuthViewModel determines
 * whether a valid session exists.
 */
@Composable
private fun AuthLoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
