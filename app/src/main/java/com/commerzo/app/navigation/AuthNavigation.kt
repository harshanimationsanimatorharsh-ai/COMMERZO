package com.commerzo.app.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.CircularProgressIndicator
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.ui.viewmodel.auth.AuthViewModel

@Composable
fun AuthNavigation() {

    val authViewModel: AuthViewModel =
        viewModel()

    val authState by
        authViewModel.authState.collectAsState()

    when (authState) {

        AuthState.Loading -> {
            AuthLoadingScreen()
        }

        AuthState.LoggedOut -> {

            val authNavController =
                rememberNavController()

            AuthNav(
                navController =
                    authNavController,
                onLoginSuccess = {
                    authViewModel.refreshSession()
                }
            )
        }

        is AuthState.LoggedIn -> {
            AppNavigation()
        }

        is AuthState.Error -> {

            val authNavController =
                rememberNavController()

            AuthNav(
                navController =
                    authNavController,
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
