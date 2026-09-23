package com.commerzo.app.ui.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp

@Composable
fun CreateAccountScreen(
    onBack: () -> Unit
) {
    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    var showPassword by remember {
        mutableStateOf(false)
    }

    var showConfirmPassword by remember {
        mutableStateOf(false)
    }

    var message by remember {
        mutableStateOf<String?>(null)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment =
            Alignment.CenterHorizontally,
        verticalArrangement =
            Arrangement.Center
    ) {

        Text(
            text = "Create your COMMERZO account",
            style =
                MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text =
                "Create your account to save progress, XP and learning activity.",
            style =
                MaterialTheme.typography.bodyMedium,
            color =
                MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                message = null
            },
            modifier =
                Modifier.fillMaxWidth(),
            label = {
                Text("Full name")
            },
            leadingIcon = {
                Icon(
                    imageVector =
                        Icons.Default.Person,
                    contentDescription =
                        "Full name"
                )
            },
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                message = null
            },
            modifier =
                Modifier.fillMaxWidth(),
            label = {
                Text("Email / Gmail")
            },
            leadingIcon = {
                Icon(
                    imageVector =
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
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                message = null
            },
            modifier =
                Modifier.fillMaxWidth(),
            label = {
                Text("Password")
            },
            visualTransformation =
                if (showPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
            trailingIcon = {
                Text(
                    text =
                        if (showPassword) {
                            "Hide"
                        } else {
                            "Show"
                        },
                    modifier =
                        Modifier.padding(
                            horizontal = 12.dp
                        )
                )
            },
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                message = null
            },
            modifier =
                Modifier.fillMaxWidth(),
            label = {
                Text("Confirm password")
            },
            visualTransformation =
                if (showConfirmPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
            trailingIcon = {
                Text(
                    text =
                        if (showConfirmPassword) {
                            "Hide"
                        } else {
                            "Show"
                        },
                    modifier =
                        Modifier.padding(
                            horizontal = 12.dp
                        )
                )
            },
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        Button(
            onClick = {

                message =
                    when {
                        name.isBlank() ->
                            "Please enter your name."

                        email.isBlank() ->
                            "Please enter your email."

                        password.length < 6 ->
                            "Password must contain at least 6 characters."

                        password != confirmPassword ->
                            "Passwords do not match."

                        else ->
                            "Email account registration will be connected in the authentication provider."
                    }
            },
            enabled =
                name.isNotBlank() &&
                    email.isNotBlank() &&
                    password.isNotBlank() &&
                    confirmPassword.isNotBlank(),
            modifier =
                Modifier.fillMaxWidth(),
            shape =
                RoundedCornerShape(14.dp)
        ) {
            Text("Create Account")
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedButton(
            onClick = onBack,
            modifier =
                Modifier.fillMaxWidth(),
            shape =
                RoundedCornerShape(14.dp)
        ) {
            Text("Back to Login")
        }

        message?.let {

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = it,
                color =
                    if (
                        it.startsWith(
                            "Email account registration"
                        )
                    ) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.error
                    },
                style =
                    MaterialTheme.typography.bodySmall
            )
        }
    }
}
