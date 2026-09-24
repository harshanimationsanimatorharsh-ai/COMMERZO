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

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var otp by remember {
        mutableStateOf("")
    }

    var phoneLoginMode by remember {
        mutableStateOf(false)
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
        when (authState) {
            is AuthState.LoggedIn -> {
                onLoginSuccess()
            }

            is AuthState.LoggedOut -> {
                if (passwordResetRequested) {
                    passwordResetSuccess = true
                    passwordResetRequested = false
                    localError = null
                }
            }

            else -> Unit
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

    val isLoading =
        authState is AuthState.Loading

    val isOtpSent =
        authState is AuthState.PhoneOtpSent

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Welcome to COMMERZO",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            Modifier.height(8.dp)
        )

        Text(
            text = "Learn. Practice. Score.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            Modifier.height(28.dp)
        )

        if (phoneLoginMode) {

            Text(
                text = if (isOtpSent) {
                    "Verify Mobile Number"
                } else {
                    "Login with Mobile"
                },
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(
                Modifier.height(8.dp)
            )

            if (isOtpSent) {

                Text(
                    text = "Enter the OTP sent to $phoneNumber",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(
                    Modifier.height(16.dp)
                )

                OutlinedTextField(
                    value = otp,
                    onValueChange = {
                        if (it.length <= 6) {
                            otp = it.filter { character ->
                                character.isDigit()
                            }
                            localError = null
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text("6-Digit OTP")
                    },
                    singleLine = true,
                    enabled = !isLoading
                )

                Spacer(
                    Modifier.height(16.dp)
                )

                if (localError != null) {
                    Text(
                        text = localError.orEmpty(),
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        Modifier.height(12.dp)
                    )
                }

                if (authError != null) {
                    Text(
                        text = authError,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        Modifier.height(12.dp)
                    )
                }

                Button(
                    onClick = {
                        when {
                            otp.length != 6 -> {
                                localError =
                                    "Please enter the 6-digit OTP."
                            }

                            else -> {
                                localError = null
                                viewModel.verifyPhoneOtp(otp)
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isLoading
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.height(20.dp)
                        )
                    } else {
                        Text("Verify & Continue")
                    }
                }

                Spacer(
                    Modifier.height(8.dp)
                )

                TextButton(
                    onClick = {
                        phoneLoginMode = false
                        otp = ""
                        phoneNumber = ""
                        localError = null
                        viewModel.refreshSession()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isLoading
                ) {
                    Text("Use Another Login Method")
                }

            } else {

                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = {
                        phoneNumber = it
                        localError = null
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text("Mobile Number")
                    },
                    placeholder = {
                        Text("+91XXXXXXXXXX")
                    },
                    singleLine = true,
                    enabled = !isLoading
                )

                Spacer(
                    Modifier.height(8.dp)
                )

                Text(
                    text = "Include your country code, for example +91XXXXXXXXXX.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(
                    Modifier.height(16.dp)
                )

                if (localError != null) {
                    Text(
                        text = localError.orEmpty(),
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        Modifier.height(12.dp)
                    )
                }

                if (authError != null) {
                    Text(
                        text = authError,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        Modifier.height(12.dp)
                    )
                }

                Button(
                    onClick = {
                        val normalizedPhone =
                            phoneNumber.trim()

                        when {
                            normalizedPhone.isBlank() -> {
                                localError =
                                    "Please enter your mobile number."
                            }

                            !normalizedPhone.startsWith("+") -> {
                                localError =
                                    "Please include the country code, for example +91XXXXXXXXXX."
                            }

                            normalizedPhone.length < 10 -> {
                                localError =
                                    "Please enter a valid mobile number."
                            }

                            else -> {
                                val activity =
                                    context as? Activity

                                if (activity == null) {
                                    localError =
                                        "Unable to start mobile verification."
                                } else {
                                    localError = null
                                    viewModel.sendPhoneOtp(
                                        activity = activity,
                                        phoneNumber = normalizedPhone
                                    )
                                }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isLoading
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.height(20.dp)
                        )
                    } else {
                        Text("Send OTP")
                    }
                }

                Spacer(
                    Modifier.height(8.dp)
                )

                TextButton(
                    onClick = {
                        phoneLoginMode = false
                        phoneNumber = ""
                        localError = null
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isLoading
                ) {
                    Text("Back to Email Login")
                }
            }

            Spacer(
                Modifier.height(16.dp)
            )

            TextButton(
                onClick = {
                    phoneLoginMode = false
                    phoneNumber = ""
                    otp = ""
                    localError = null
                    viewModel.refreshSession()
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading
            ) {
                Text("Back")
            }

        } else {

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
                enabled = !isLoading
            )

            Spacer(
                Modifier.height(12.dp)
            )

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
                visualTransformation =
                    PasswordVisualTransformation(),
                enabled = !isLoading
            )

            Spacer(
                Modifier.height(8.dp)
            )

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
                                email.trim()
                            )
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading
            ) {
                Text("Forgot Password?")
            }

            if (passwordResetSuccess) {
                Spacer(
                    Modifier.height(4.dp)
                )

                Text(
                    text = "Password reset email sent. Check your inbox and follow the instructions.",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(
                Modifier.height(8.dp)
            )

            localError?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(
                    Modifier.height(12.dp)
                )
            }

            if (authError != null) {
                Text(
                    text = authError,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium
                )

                if (isEmailVerificationError) {
                    Spacer(
                        Modifier.height(8.dp)
                    )

                    Text(
                        text = "Open the verification email sent to your inbox, verify your email address, and then sign in again.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Spacer(
                    Modifier.height(12.dp)
                )
            }

            Button(
                onClick = {
                    when {
                        email.isBlank() -> {
                            localError =
                                "Please enter your email."
                        }

                        !Patterns.EMAIL_ADDRESS
                            .matcher(email.trim())
                            .matches() -> {
                            localError =
                                "Please enter a valid email address."
                        }

                        password.isBlank() -> {
                            localError =
                                "Please enter your password."
                        }

                        else -> {
                            localError = null
                            passwordResetSuccess = false

                            viewModel.signInWithEmail(
                                email.trim(),
                                password
                            )
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.height(20.dp)
                    )
                } else {
                    Text("Sign In with Email")
                }
            }

            Spacer(
                Modifier.height(12.dp)
            )

            OutlinedButton(
                onClick = {
                    val activity =
                        context as? Activity

                    if (activity != null) {
                        localError = null
                        passwordResetSuccess = false

                        viewModel.signInWithGoogle(
                            activity
                        )
                    } else {
                        localError =
                            "Unable to open Google Sign-In."
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading
            ) {
                Text("Continue with Google")
            }

            Spacer(
                Modifier.height(12.dp)
            )

            OutlinedButton(
                onClick = {
                    phoneLoginMode = true
                    localError = null
                    passwordResetSuccess = false
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading
            ) {
                Text("Continue with Mobile")
            }

            Spacer(
                Modifier.height(16.dp)
            )

            TextButton(
                onClick = onCreateAccount,
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading
            ) {
                Text("Create New Account")
            }
        }
    }
}
