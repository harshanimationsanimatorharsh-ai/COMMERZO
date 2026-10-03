package com.commerzo.app.ui.screens.auth

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.ui.theme.CommerzoDimensions
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

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(
                    horizontal = CommerzoDimensions.ScreenHorizontal,
                    vertical = CommerzoDimensions.Space24
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LoginBrandHeader()

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space28
                )
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    CommerzoDimensions.Space20
                ),
                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.surface
                )
            ) {

                Column(
                    modifier = Modifier.padding(
                        CommerzoDimensions.CardPaddingLarge
                    )
                ) {

                    if (phoneLoginMode) {
                        PhoneLoginContent(
                            phoneNumber = phoneNumber,
                            otp = otp,
                            isOtpSent = isOtpSent,
                            isLoading = isLoading,
                            localError = localError,
                            authError = authError,
                            onPhoneNumberChange = {
                                phoneNumber = it
                                localError = null
                            },
                            onOtpChange = {
                                if (it.length <= 6) {
                                    otp = it.filter { character ->
                                        character.isDigit()
                                    }
                                    localError = null
                                }
                            },
                            onSendOtp = {
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
                            onVerifyOtp = {
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
                            onBackToEmail = {
                                phoneLoginMode = false
                                phoneNumber = ""
                                otp = ""
                                localError = null
                                viewModel.refreshSession()
                            }
                        )
                    } else {
                        EmailLoginContent(
                            email = email,
                            password = password,
                            isLoading = isLoading,
                            localError = localError,
                            authError = authError,
                            isEmailVerificationError =
                                isEmailVerificationError,
                            passwordResetSuccess =
                                passwordResetSuccess,
                            onEmailChange = {
                                email = it
                                localError = null
                                passwordResetSuccess = false
                            },
                            onPasswordChange = {
                                password = it
                                localError = null
                                passwordResetSuccess = false
                            },
                            onForgotPassword = {
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
                            onEmailSignIn = {
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
                            onGoogleSignIn = {
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
                            onPhoneLogin = {
                                phoneLoginMode = true
                                localError = null
                                passwordResetSuccess = false
                            },
                            onCreateAccount = onCreateAccount
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space20
                )
            )

            Text(
                text = "Learn. Practice. Score.",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun LoginBrandHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shape = RoundedCornerShape(
                CommerzoDimensions.Space20
            ),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Icon(
                imageVector = Icons.Default.School,
                contentDescription = null,
                modifier = Modifier.padding(
                    CommerzoDimensions.Space16
                ),
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space16
            )
        )

        Text(
            text = "Welcome to COMMERZO",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space4
            )
        )

        Text(
            text = "Your learning journey starts here.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun EmailLoginContent(
    email: String,
    password: String,
    isLoading: Boolean,
    localError: String?,
    authError: String?,
    isEmailVerificationError: Boolean,
    passwordResetSuccess: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPassword: () -> Unit,
    onEmailSignIn: () -> Unit,
    onGoogleSignIn: () -> Unit,
    onPhoneLogin: () -> Unit,
    onCreateAccount: () -> Unit
) {
    Text(
        text = "Sign in",
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold
    )

    Spacer(
        modifier = Modifier.height(
            CommerzoDimensions.Space4
        )
    )

    Text(
        text = "Continue with your COMMERZO account.",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )

    Spacer(
        modifier = Modifier.height(
            CommerzoDimensions.Space20
        )
    )

    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text("Email")
        },
        singleLine = true,
        enabled = !isLoading
    )

    Spacer(
        modifier = Modifier.height(
            CommerzoDimensions.Space12
        )
    )

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text("Password")
        },
        singleLine = true,
        visualTransformation =
            PasswordVisualTransformation(),
        enabled = !isLoading
    )

    TextButton(
        onClick = onForgotPassword,
        modifier = Modifier.fillMaxWidth(),
        enabled = !isLoading
    ) {
        Text("Forgot Password?")
    }

    if (passwordResetSuccess) {
        StatusMessage(
            message =
                "Password reset email sent. Check your inbox and follow the instructions.",
            positive = true
        )
    }

    if (localError != null) {
        StatusMessage(
            message = localError,
            positive = false
        )
    }

    if (authError != null) {
        StatusMessage(
            message = authError,
            positive = false
        )

        if (isEmailVerificationError) {
            Spacer(
                modifier = Modifier.height(
                    CommerzoDimensions.Space6
                )
            )

            Text(
                text =
                    "Open the verification email, verify your address, and sign in again.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }

    Spacer(
        modifier = Modifier.height(
            CommerzoDimensions.Space12
        )
    )

    PrimaryLoadingButton(
        text = "Sign In with Email",
        isLoading = isLoading,
        onClick = onEmailSignIn,
        enabled = !isLoading
    )

    Spacer(
        modifier = Modifier.height(
            CommerzoDimensions.Space16
        )
    )

    LoginDivider()

    Spacer(
        modifier = Modifier.height(
            CommerzoDimensions.Space16
        )
    )

    OutlinedButton(
        onClick = onGoogleSignIn,
        modifier = Modifier.fillMaxWidth(),
        enabled = !isLoading
    ) {
        Text("Continue with Google")
    }

    Spacer(
        modifier = Modifier.height(
            CommerzoDimensions.Space10
        )
    )

    OutlinedButton(
        onClick = onPhoneLogin,
        modifier = Modifier.fillMaxWidth(),
        enabled = !isLoading
    ) {
        Icon(
            imageVector = Icons.Default.Phone,
            contentDescription = null
        )

        Spacer(
            modifier = Modifier.width(
                CommerzoDimensions.Space8
            )
        )

        Text("Continue with Mobile")
    }

    Spacer(
        modifier = Modifier.height(
            CommerzoDimensions.Space16
        )
    )

    TextButton(
        onClick = onCreateAccount,
        modifier = Modifier.fillMaxWidth(),
        enabled = !isLoading
    ) {
        Text("Create New Account")
    }
}

@Composable
private fun PhoneLoginContent(
    phoneNumber: String,
    otp: String,
    isOtpSent: Boolean,
    isLoading: Boolean,
    localError: String?,
    authError: String?,
    onPhoneNumberChange: (String) -> Unit,
    onOtpChange: (String) -> Unit,
    onSendOtp: () -> Unit,
    onVerifyOtp: () -> Unit,
    onBackToEmail: () -> Unit
) {
    Text(
        text = if (isOtpSent) {
            "Verify Mobile Number"
        } else {
            "Login with Mobile"
        },
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold
    )

    Spacer(
        modifier = Modifier.height(
            CommerzoDimensions.Space4
        )
    )

    Text(
        text = if (isOtpSent) {
            "Enter the verification code sent to your mobile."
        } else {
            "Use your mobile number to continue."
        },
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )

    Spacer(
        modifier = Modifier.height(
            CommerzoDimensions.Space20
        )
    )

    if (isOtpSent) {
        OutlinedTextField(
            value = otp,
            onValueChange = onOtpChange,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("6-Digit OTP")
            },
            singleLine = true,
            enabled = !isLoading
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        Text(
            text = "OTP sent to $phoneNumber",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        ShowAuthMessages(
            localError = localError,
            authError = authError
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space12
            )
        )

        PrimaryLoadingButton(
            text = "Verify & Continue",
            isLoading = isLoading,
            onClick = onVerifyOtp,
            enabled = !isLoading
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        TextButton(
            onClick = onBackToEmail,
            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoading
        ) {
            Text("Use Another Login Method")
        }
    } else {
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = onPhoneNumberChange,
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
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        Text(
            text =
                "Include your country code, for example +91XXXXXXXXXX.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        ShowAuthMessages(
            localError = localError,
            authError = authError
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space12
            )
        )

        PrimaryLoadingButton(
            text = "Send OTP",
            isLoading = isLoading,
            onClick = onSendOtp,
            enabled = !isLoading
        )

        Spacer(
            modifier = Modifier.height(
                CommerzoDimensions.Space8
            )
        )

        TextButton(
            onClick = onBackToEmail,
            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoading
        ) {
            Text("Back to Email Login")
        }
    }
}

@Composable
private fun PrimaryLoadingButton(
    text: String,
    isLoading: Boolean,
    onClick: () -> Unit,
    enabled: Boolean
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(
                CommerzoDimensions.ButtonHeight
            ),
        enabled = enabled,
        shape = RoundedCornerShape(
            CommerzoDimensions.Space12
        )
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.height(
                    CommerzoDimensions.IconSmall
                ),
                strokeWidth = CommerzoDimensions.Space2
            )
        } else {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun LoginDivider() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "  OR  ",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        HorizontalDivider(
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun ShowAuthMessages(
    localError: String?,
    authError: String?
) {
    if (localError != null) {
        StatusMessage(
            message = localError,
            positive = false
        )
    }

    if (authError != null) {
        StatusMessage(
            message = authError,
            positive = false
        )
    }
}

@Composable
private fun StatusMessage(
    message: String,
    positive: Boolean
) {
    Text(
        text = message,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = CommerzoDimensions.Space4,
                bottom = CommerzoDimensions.Space4
            ),
        style = MaterialTheme.typography.bodySmall,
        color = if (positive) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.error
        }
    )
}
