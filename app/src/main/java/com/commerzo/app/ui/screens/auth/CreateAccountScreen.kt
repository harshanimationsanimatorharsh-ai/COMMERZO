package com.commerzo.app.ui.screens.auth

import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.ui.theme.CommerzoDimensions
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

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Create Account",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        enabled = authState !is AuthState.Loading
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(
                    horizontal = CommerzoDimensions.ScreenHorizontal,
                    vertical = CommerzoDimensions.ScreenVertical
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CreateAccountHeader()

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.SectionSpacing
                )
            )

            if (verificationMessage != null) {
                VerificationSuccessCard(
                    message = verificationMessage.orEmpty(),
                    onGoToLogin = onBack,
                    onCreateAnother = {
                        verificationMessage = null
                        localError = null
                        name = ""
                        email = ""
                        password = ""
                        confirmPassword = ""
                        viewModel.refreshSession()
                    }
                )

                return@Column
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(CommerzoDimensions.CardPaddingLarge)
                ) {

                    Text(
                        text = "Student Details",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space16
                        )
                    )

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
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Person,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        enabled = authState !is AuthState.Loading
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space12
                        )
                    )

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
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Email,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        enabled = authState !is AuthState.Loading
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space12
                        )
                    )

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
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Lock,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                        enabled = authState !is AuthState.Loading
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space12
                        )
                    )

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
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Lock,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                        enabled = authState !is AuthState.Loading
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space8
                        )
                    )

                    Text(
                        text = "Password must contain at least 6 characters.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(
                        modifier = Modifier.height(
                            CommerzoDimensions.Space16
                        )
                    )

                    localError?.let { error ->
                        AuthErrorMessage(
                            message = error
                        )

                        Spacer(
                            modifier = Modifier.height(
                                CommerzoDimensions.Space12
                            )
                        )
                    }

                    if (authError != null && !isVerificationRequired) {
                        AuthErrorMessage(
                            message = authError
                        )

                        Spacer(
                            modifier = Modifier.height(
                                CommerzoDimensions.Space12
                            )
                        )
                    }

                    Button(
                        onClick = {
                            when {
                                name.isBlank() -> {
                                    localError =
                                        "Please enter your name."
                                }

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
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(
                                CommerzoDimensions.ButtonHeight
                            ),
                        enabled = authState !is AuthState.Loading
                    ) {
                        if (authState is AuthState.Loading) {
                            CircularProgressIndicator(
                                modifier = Modifier.height(
                                    CommerzoDimensions.IconSmall
                                ),
                                strokeWidth = 2.dp
                            )
                        } else {
                            Text(
                                text = "Create Account",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )

            TextButton(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth(),
                enabled = authState !is AuthState.Loading
            ) {
                Text("Already have an account? Sign in")
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space16
                )
            )
        }
    }
}

@Composable
private fun CreateAccountHeader() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CommerzoDimensions.CardPaddingLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "COMMERZO",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            Text(
                text = "Start your learning journey",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space4
                )
            )

            Text(
                text = "Create your student account to continue.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
private fun VerificationSuccessCard(
    message: String,
    onGoToLogin: () -> Unit,
    onCreateAnother: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CommerzoDimensions.CardPaddingLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Outlined.CheckCircle,
                contentDescription = null,
                modifier = Modifier.height(
                    CommerzoDimensions.IconExtraLarge
                ),
                tint = MaterialTheme.colorScheme.primary
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space16
                )
            )

            Text(
                text = "Account Created",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )

            HorizontalDivider()

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space12
                )
            )

            Text(
                text = "Open the verification email, verify your email address, then return to Login and sign in.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space20
                )
            )

            Button(
                onClick = onGoToLogin,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        CommerzoDimensions.ButtonHeight
                    )
            ) {
                Text("Go to Login")
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space8
                )
            )

            TextButton(
                onClick = onCreateAnother,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Create Another Account")
            }
        }
    }
}

@Composable
private fun AuthErrorMessage(
    message: String
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.errorContainer,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CommerzoDimensions.Space12),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onErrorContainer
            )
        }
    }
}
