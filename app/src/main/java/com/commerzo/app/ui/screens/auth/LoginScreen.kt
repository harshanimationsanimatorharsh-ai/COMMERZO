package com.commerzo.app.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.ui.viewmodel.auth.AuthViewModel

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onCreateAccount: () -> Unit = {}
) {
    val viewModel: AuthViewModel = viewModel()

    val authState by
        viewModel.authState.collectAsState()

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var showEmailLogin by remember {
        mutableStateOf(false)
    }

    var showPhoneLogin by remember {
        mutableStateOf(false)
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var otp by remember {
        mutableStateOf("")
    }

    var otpSent by remember {
        mutableStateOf(false)
    }

    val isLoading =
        authState is AuthState.Loading

    androidx.compose.runtime.LaunchedEffect(
        authState
    ) {
        if (authState is AuthState.LoggedIn) {
            onLoginSuccess()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            ),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(28.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment =
                    Alignment.CenterHorizontally,
                verticalArrangement =
                    Arrangement.Center
            ) {

                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = "COMMERZO",
                    tint =
                        MaterialTheme.colorScheme.primary
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text = "Welcome to COMMERZO",
                    style =
                        MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text =
                        "Learn. Practice. Score.",
                    style =
                        MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                when {
                    showPhoneLogin -> {

                        OutlinedTextField(
                            value = phoneNumber,
                            onValueChange = {
                                phoneNumber = it
                            },
                            modifier =
                                Modifier.fillMaxWidth(),
                            label = {
                                Text("Mobile number")
                            },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Phone,
                                    contentDescription =
                                        "Mobile number"
                                )
                            },
                            keyboardOptions =
                                KeyboardOptions(
                                    keyboardType =
                                        KeyboardType.Phone
                                ),
                            singleLine = true
                        )

                        Spacer(
                            modifier =
                                Modifier.height(12.dp)
                        )

                        if (otpSent) {

                            OutlinedTextField(
                                value = otp,
                                onValueChange = {
                                    otp = it
                                },
                                modifier =
                                    Modifier.fillMaxWidth(),
                                label = {
                                    Text("OTP")
                                },
                                keyboardOptions =
                                    KeyboardOptions(
                                        keyboardType =
                                            KeyboardType.Number
                                    ),
                                singleLine = true
                            )

                            Spacer(
                                modifier =
                                    Modifier.height(12.dp)
                            )

                            Button(
                                onClick = {
                                    viewModel
                                        .verifyPhoneOtp(
                                            phoneNumber,
                                            otp
                                        )
                                },
                                enabled =
                                    !isLoading &&
                                        phoneNumber.isNotBlank() &&
                                        otp.isNotBlank(),
                                modifier =
                                    Modifier.fillMaxWidth(),
                                shape =
                                    RoundedCornerShape(14.dp)
                            ) {
                                Text("Verify OTP")
                            }

                        } else {

                            Button(
                                onClick = {
                                    viewModel
                                        .sendPhoneOtp(
                                            phoneNumber
                                        )
                                    otpSent = true
                                },
                                enabled =
                                    !isLoading &&
                                        phoneNumber.isNotBlank(),
                                modifier =
                                    Modifier.fillMaxWidth(),
                                shape =
                                    RoundedCornerShape(14.dp)
                            ) {
                                Text("Send OTP")
                            }
                        }

                        Spacer(
                            modifier =
                                Modifier.height(10.dp)
                        )

                        OutlinedButton(
                            onClick = {
                                showPhoneLogin = false
                            },
                            modifier =
                                Modifier.fillMaxWidth()
                        ) {
                            Text("Back")
                        }
                    }

                    showEmailLogin -> {

                        OutlinedTextField(
                            value = email,
                            onValueChange = {
                                email = it
                            },
                            modifier =
                                Modifier.fillMaxWidth(),
                            label = {
                                Text("Email / Gmail")
                            },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Email,
                                    contentDescription =
                                        "Email"
                                )
                            },
                            keyboardOptions =
                                KeyboardOptions(
                                    keyboardType =
                                        KeyboardType.Email
                                ),
                            singleLine = true
                        )

                        Spacer(
                            modifier =
                                Modifier.height(12.dp)
                        )

                        OutlinedTextField(
                            value = password,
                            onValueChange = {
                                password = it
                            },
                            modifier =
                                Modifier.fillMaxWidth(),
                            label = {
                                Text("Password")
                            },
                            visualTransformation =
                                PasswordVisualTransformation(),
                            singleLine = true
                        )

                        Spacer(
                            modifier =
                                Modifier.height(12.dp)
                        )

                        Button(
                            onClick = {
                                viewModel
                                    .signInWithEmail(
                                        email = email,
                                        password = password
                                    )
                            },
                            enabled =
                                !isLoading &&
                                    email.isNotBlank() &&
                                    password.isNotBlank(),
                            modifier =
                                Modifier.fillMaxWidth(),
                            shape =
                                RoundedCornerShape(14.dp)
                        ) {
                            Text("Continue with Email")
                        }

                        Spacer(
                            modifier =
                                Modifier.height(10.dp)
                        )

                        OutlinedButton(
                            onClick = {
                                showEmailLogin = false
                            },
                            modifier =
                                Modifier.fillMaxWidth()
                        ) {
                            Text("Back")
                        }
                    }

                    else -> {

                        Button(
                            onClick = {
                                viewModel
                                    .signInWithGoogle()
                            },
                            enabled = !isLoading,
                            modifier =
                                Modifier.fillMaxWidth(),
                            shape =
                                RoundedCornerShape(14.dp),
                            colors =
                                ButtonDefaults.buttonColors()
                        ) {
                            Text(
                                "Continue with Google"
                            )
                        }

                        Spacer(
                            modifier =
                                Modifier.height(12.dp)
                        )

                        OutlinedButton(
                            onClick = {
                                showEmailLogin = true
                            },
                            enabled = !isLoading,
                            modifier =
                                Modifier.fillMaxWidth(),
                            shape =
                                RoundedCornerShape(14.dp)
                        ) {
                            Text(
                                "Continue with Email"
                            )
                        }

                        Spacer(
                            modifier =
                                Modifier.height(12.dp)
                        )

                        OutlinedButton(
                            onClick = {
                                showPhoneLogin = true
                            },
                            enabled = !isLoading,
                            modifier =
                                Modifier.fillMaxWidth(),
                            shape =
                                RoundedCornerShape(14.dp)
                        ) {
                            Text(
                                "Continue with Mobile"
                            )
                        }

                        Spacer(
                            modifier =
                                Modifier.height(18.dp)
                        )

                        Divider()

                        Spacer(
                            modifier =
                                Modifier.height(18.dp)
                        )

                        Text(
                            text =
                                "New to COMMERZO?",
                            style =
                                MaterialTheme.typography.bodyMedium
                        )

                        Spacer(
                            modifier =
                                Modifier.height(8.dp)
                        )

                        OutlinedButton(
                            onClick =
                                onCreateAccount,
                            enabled = !isLoading,
                            modifier =
                                Modifier.fillMaxWidth()
                        ) {
                            Text("Create Account")
                        }
                    }
                }

                if (authState is AuthState.Error) {

                    Spacer(
                        modifier =
                            Modifier.height(16.dp)
                    )

                    Text(
                        text =
                            (authState as AuthState.Error)
                                .message,
                        color =
                            MaterialTheme.colorScheme.error,
                        style =
                            MaterialTheme.typography.bodySmall,
                        textAlign =
                            TextAlign.Center
                    )
                }

                if (isLoading) {

                    Spacer(
                        modifier =
                            Modifier.height(16.dp)
                    )

                    CircularProgressIndicator()
                }
            }
        }
    }
}
