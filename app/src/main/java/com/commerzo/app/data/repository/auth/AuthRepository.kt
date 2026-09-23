package com.commerzo.app.data.repository.auth

import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.data.model.auth.AuthUser

interface AuthRepository {

    fun getAuthState(): AuthState

    fun getCurrentUser(): AuthUser?

    suspend fun signInWithGoogle(): Result<AuthUser>

    suspend fun signInWithEmail(
        email: String,
        password: String
    ): Result<AuthUser>

    suspend fun sendPhoneOtp(
        phoneNumber: String
    ): Result<Unit>

    suspend fun verifyPhoneOtp(
        phoneNumber: String,
        otp: String
    ): Result<AuthUser>

    suspend fun signOut(): Result<Unit>

    suspend fun deleteAccount(): Result<Unit>
}
