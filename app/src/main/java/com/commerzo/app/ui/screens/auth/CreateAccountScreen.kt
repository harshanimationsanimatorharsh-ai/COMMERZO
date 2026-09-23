package com.commerzo.app.ui.screens.auth

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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.ui.viewmodel.auth.AuthViewModel

@Composable
fun CreateAccountScreen(
    onBack: () -> Unit,
    onAccountCreated: () -> Unit,
    viewModel: AuthViewModel = viewModel()
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var localError by remember { mutableStateOf<String?>(null) }
    var verificationMessage by remember { mutableStateOf<String?>(null) }

    val authState by viewModel.authState.collectAsState()

    LaunchedEffect(authState) {
        if (authState is AuthState.LoggedIn) {
            onAccountCreated()
        }
    }

    val authError =
        (authState as? AuthState.Error)?.message

    val isVerificationRequired =
        authError?.contains(
            "verify your email",
            ignoreCase = true
        ) == true ||
        authError?.contains(
            "verification",
            ignoreCase = true
        ) == true

    LaunchedEffect(authState) {
        if (isVerificationRequired) {
            verificationMessage =
                "Account created successfully. A verification email has been sent to ${email.trim()}."
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Create Account",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Create your COMMERZO student account.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (verificationMessage != null) {
            Text(
                text = "Email Verification Required",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = verificationMessage.orEmpty(),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Open that email, verify your email address, then return to the Login screen and sign in.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Go to Login")
            }

            Spacer(modifier = Modifier.height(12.dp))

            TextButton(
                onClick = {
                    verificationMessage = null
                    localError = null
                    viewModel.refreshSession()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Create Another Account")
            }

            return@Column
        }

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                localError = null
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Full Name")
            },
            singleLine = true,
            enabled = authState !is AuthState.Loading
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                localError = null
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
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Password")
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            enabled = authState !is AuthState.Loading
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                localError = null
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Confirm Password")
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            enabled = authState !is AuthState.Loading
        )

        Spacer(modifier = Modifier.height(20.dp))

        localError?.let { error ->
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        if (authError != null && !isVerificationRequired) {
            Text(
                text = authError,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        Button(
            onClick = {
                when {
                    name.isBlank() -> {
                        localError = "Please enter your name."
                    }

                    email.isBlank() -> {
                        localError = "Please enter your email."
                    }

                    !android.util.Patterns.EMAIL_ADDRESS
                        .matcher(email.trim())
                        .matches() -> {
                        localError =
                            "Please enter a valid email address."
                    }

                    password.length < 6 -> {
                        localError =
                            "Password must be at least 6 characters."
                    }

                    password != confirmPassword -> {
                        localError =
                            "Passwords do not match."
                    }

                    else -> {
                        localError = null
                        verificationMessage = null

                        viewModel.createAccountWithEmail(
                            email = email.trim(),
                            password = password,
                            displayName = name.trim()
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
                Text("Create Account")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth(),
            enabled = authState !is AuthState.Loading
        ) {
            Text("Back to Login")
        }
    }
}
