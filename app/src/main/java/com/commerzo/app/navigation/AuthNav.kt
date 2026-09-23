package com.commerzo.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.commerzo.app.ui.screens.auth.CreateAccountScreen
import com.commerzo.app.ui.screens.auth.LoginScreen

object AuthRoutes {

    const val LOGIN = "auth_login"
    const val CREATE_ACCOUNT = "auth_create_account"
}

@Composable
fun AuthNav(
    navController: NavHostController,
    onLoginSuccess: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = AuthRoutes.LOGIN
    ) {

        composable(AuthRoutes.LOGIN) {

            LoginScreen(
                onLoginSuccess = onLoginSuccess,
                onCreateAccount = {
                    navController.navigate(
                        AuthRoutes.CREATE_ACCOUNT
                    )
                }
            )
        }

        composable(AuthRoutes.CREATE_ACCOUNT) {

            CreateAccountScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
