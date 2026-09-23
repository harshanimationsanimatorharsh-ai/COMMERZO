package com.commerzo.app.ui.viewmodel.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.data.model.auth.AuthUser
import com.commerzo.app.data.repository.auth.AuthRepositoryProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        AuthRepositoryProvider.getRepository(
            application.applicationContext
        )

    private val _authState =
        MutableStateFlow<AuthState>(AuthState.Loading)

    val authState: StateFlow<AuthState> =
        _authState.asStateFlow()

    private val _currentUser =
        MutableStateFlow<AuthUser?>(null)

    val currentUser: StateFlow<AuthUser?> =
        _currentUser.asStateFlow()

    init {
        refreshSession()
    }

    fun refreshSession() {
        _authState.value = AuthState.Loading

        val user = repository.getCurrentUser()

        _currentUser.value = user

        _authState.value =
            if (user != null) {
                AuthState.LoggedIn(user.userId)
            } else {
                AuthState.LoggedOut
            }
    }

    fun createAccountWithEmail(
        email: String,
        password: String,
        displayName: String
    ) {
        executeAuthAction {
            repository.createAccountWithEmail(
                email = email,
                password = password,
                displayName = displayName
            )
        }
    }

    fun signInWithGoogle() {
        executeAuthAction {
            repository.signInWithGoogle()
        }
    }

    fun signInWithEmail(
        email: String,
        password: String
    ) {
        executeAuthAction {
            repository.signInWithEmail(
                email = email,
                password = password
            )
        }
    }

    fun sendPhoneOtp(
        phoneNumber: String
    ) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            val result =
                repository.sendPhoneOtp(
                    phoneNumber
                )

            if (result.isFailure) {
                _authState.value =
                    AuthState.Error(
                        result.exceptionOrNull()?.message
                            ?: "Unable to send OTP."
                    )
            }
        }
    }

    fun verifyPhoneOtp(
        phoneNumber: String,
        otp: String
    ) {
        executeAuthAction {
            repository.verifyPhoneOtp(
                phoneNumber = phoneNumber,
                otp = otp
            )
        }
    }

    fun signOut() {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            val result =
                repository.signOut()

            if (result.isSuccess) {
                _currentUser.value = null
                _authState.value = AuthState.LoggedOut
            } else {
                _authState.value =
                    AuthState.Error(
                        result.exceptionOrNull()?.message
                            ?: "Unable to sign out."
                    )
            }
        }
    }

    fun deleteAccount() {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            val result =
                repository.deleteAccount()

            if (result.isSuccess) {
                _currentUser.value = null
                _authState.value = AuthState.LoggedOut
            } else {
                _authState.value =
                    AuthState.Error(
                        result.exceptionOrNull()?.message
                            ?: "Unable to delete account."
                    )
            }
        }
    }

    private fun executeAuthAction(
        action: suspend () -> Result<AuthUser>
    ) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            val result = action()

            result.onSuccess { user ->
                _currentUser.value = user
                _authState.value =
                    AuthState.LoggedIn(user.userId)
            }.onFailure { error ->
                _authState.value =
                    AuthState.Error(
                        error.message
                            ?: "Authentication failed."
                    )
            }
        }
    }
}
