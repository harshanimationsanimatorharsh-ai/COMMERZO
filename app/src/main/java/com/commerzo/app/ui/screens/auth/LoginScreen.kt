package com.commerzo.app.ui.screens.auth

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.ui.viewmodel.auth.AuthViewModel

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onCreateAccount: () -> Unit,
    viewModel: AuthViewModel = viewModel()
) {
    val context = LocalContext.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var localError by remember {
        mutableStateOf<String?>(null)
    }

    var passwordResetRequested by remember {
        mutableStateOf(false)
    }

    var passwordResetSuccess by remember {
        mutableStateOf(false)
    }

    val authState by viewModel.authState.collectAsState()

    LaunchedEffect(authState) {
        if (authState is AuthState.LoggedIn) {
            onLoginSuccess()
        }

        /*
         * Password reset is intentionally handled separately from
         * normal authentication. The repository returns LoggedOut
         * after a successful reset-email request.
         */
        if (
            passwordResetRequested &&
            authState is AuthState.LoggedOut
        ) {
            passwordResetSuccess = true
            passwordResetRequested = false
            localError = null
        }

        if (
            passwordResetRequested &&
            authState is AuthState.Error
        ) {
            passwordResetRequested = false
        }
    }

    val authError =
        (authState as? AuthState.Error)?.message

    val isEmailVerificationError =
        authError?.contains(
            "verify your email",
            ignoreCase = true
        ) == true ||
        authError?.contains(
            "verification",
            ignoreCase = true
        ) == true

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to COMMERZO",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Learn. Practice. Score.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(28.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                localError = null
                passwordResetSuccess = false
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Email")
            },
            singleLine = true,
            enabled = authState !is AuthState.Loading
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                localError = null
                passwordResetSuccess = false
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Password")
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            enabled = authState !is AuthState.Loading
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            onClick = {
                when {
                    email.isBlank() -> {
                        localError =
                            "Please enter your email address."
                    }

                    !Patterns.EMAIL_ADDRESS
                        .matcher(email.trim())
                        .matches() -> {
                        localError =
                            "Please enter a valid email address."
                    }

                    else -> {
                        localError = null
                        passwordResetSuccess = false
                        passwordResetRequested = true

                        viewModel.sendPasswordResetEmail(
                            email = email.trim()
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = authState !is AuthState.Loading
        ) {
            Text("Forgot Password?")
        }

        if (passwordResetSuccess) {
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Password reset email sent. Check your inbox and follow the instructions.",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        localError?.let { error ->
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        if (authError != null) {
            Text(
                text = authError,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )

            if (isEmailVerificationError) {
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Open the verification email sent to your inbox, verify your email address, and then sign in again.",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
        }

        Button(
            onClick = {
                when {
                    email.isBlank() -> {
                        localError = "Please enter your email."
                    }

                    !Patterns.EMAIL_ADDRESS
                        .matcher(email.trim())
                        .matches() -> {
                        localError =
                            "Please enter a valid email address."
                    }

                    password.isBlank() -> {
                        localError = "Please enter your password."
                    }

                    else -> {
                        localError = null
                        passwordResetSuccess = false

                        viewModel.signInWithEmail(
                            email = email.trim(),
                            password = password
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = authState !is AuthState.Loading
        ) {
            if (authState is AuthState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier.height(20.dp)
                )
            } else {
                Text("Sign In with Email")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = {
                val activity = context as? Activity

                if (activity != null) {
                    localError = null
                    passwordResetSuccess = false
                    viewModel.signInWithGoogle(activity)
                } else {
                    localError =
                        "Unable to open Google Sign-In."
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = authState !is AuthState.Loading
        ) {
            Text("Continue with Google")
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = {
                localError =
                    "Mobile OTP will be connected in the next authentication step."
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = authState !is AuthState.Loading
        ) {
            Text("Continue with Mobile")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = onCreateAccount,
            modifier = Modifier.fillMaxWidth(),
            enabled = authState !is AuthState.Loading
        ) {
            Text("Create New Account")
        }
    }
}
