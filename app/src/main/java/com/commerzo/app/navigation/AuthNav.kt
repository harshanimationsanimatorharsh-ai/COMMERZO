package com.commerzo.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.commerzo.app.ui.screens.auth.CreateAccountScreen
import com.commerzo.app.ui.screens.auth.LoginScreen

/**
 * COMMERZO authentication navigation routes.
 *
 * Authentication is intentionally kept separate from
 * the main application navigation graph.
 *
 * Current flow:
 *
 * Login
 *   ↓
 * Create Account
 *
 * Successful authentication is handed back to the
 * root application through onLoginSuccess().
 *
 * Future auth destinations such as:
 * - OTP verification
 * - Forgot password
 * - Email verification
 *
 * can be added here without mixing them with AppNavigation.
 */
object AuthRoutes {

    const val LOGIN = "auth_login"

    const val CREATE_ACCOUNT = "auth_create_account"

    // Reserved route names for future authentication expansion.
    const val OTP_VERIFICATION = "auth_otp_verification"

    const val FORGOT_PASSWORD = "auth_forgot_password"
}

/**
 * COMMERZO authentication navigation graph.
 *
 * This graph owns only authentication-related screens.
 * The root application remains responsible for deciding
 * when to enter or leave the authenticated app.
 */
@Composable
fun AuthNav(
    navController: NavHostController,
    onLoginSuccess: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = AuthRoutes.LOGIN
    ) {

        // ============================================================
        // LOGIN
        // ============================================================

        composable(
            route = AuthRoutes.LOGIN
        ) {
            LoginScreen(
                onLoginSuccess = onLoginSuccess,
                onCreateAccount = {
                    navController.navigate(
                        AuthRoutes.CREATE_ACCOUNT
                    ) {
                        launchSingleTop = true
                    }
                }
            )
        }

        // ============================================================
        // CREATE ACCOUNT
        // ============================================================

        composable(
            route = AuthRoutes.CREATE_ACCOUNT
        ) {
            CreateAccountScreen(
                onBack = {
                    navController.popBackStack()
                },
                onAccountCreated = {
                    onLoginSuccess()
                }
            )
        }
    }
}
