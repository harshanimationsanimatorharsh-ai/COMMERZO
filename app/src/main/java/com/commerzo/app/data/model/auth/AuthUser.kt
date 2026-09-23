package com.commerzo.app.data.model.auth

data class AuthUser(
    val userId: String,
    val email: String? = null,
    val phoneNumber: String? = null,
    val displayName: String? = null,
    val photoUrl: String? = null,
    val isEmailVerified: Boolean = false,
    val isPhoneVerified: Boolean = false
)
