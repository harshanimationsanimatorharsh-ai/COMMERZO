package com.commerzo.app.data.model.auth

sealed class AuthState {

    data object Loading : AuthState()

    data object LoggedOut : AuthState()

    data class LoggedIn(
        val userId: String
    ) : AuthState()

    data object PhoneOtpSent : AuthState()

    data class Error(
        val message: String
    ) : AuthState()
}
