package com.commerzo.app.data.repository.auth

import android.app.Activity
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.data.model.auth.AuthUser

class LocalAuthRepository(
    private val sessionStore: AuthSessionStore
) : AuthRepository {

    override fun getAuthState(): AuthState {
        val user = sessionStore.getUser()

        return if (user != null) {
            AuthState.LoggedIn(user.userId)
        } else {
            AuthState.LoggedOut
        }
    }

    override fun getCurrentUser(): AuthUser? {
        return sessionStore.getUser()
    }

    override suspend fun createAccountWithEmail(
        email: String,
        password: String,
        displayName: String
    ): Result<AuthUser> {
        return Result.failure(
            UnsupportedOperationException(
                "Email account registration is not connected to the local authentication repository."
            )
        )
    }

    override suspend fun signInWithGoogle(
        activity: Activity
    ): Result<AuthUser> {
        return Result.failure(
            UnsupportedOperationException(
                "Google Sign-In is not connected to the local authentication repository."
            )
        )
    }

    override suspend fun signInWithEmail(
        email: String,
        password: String
    ): Result<AuthUser> {
        return Result.failure(
            UnsupportedOperationException(
                "Email authentication is not connected to the local authentication repository."
            )
        )
    }

    override suspend fun sendPhoneOtp(
        activity: Activity,
        phoneNumber: String
    ): Result<Unit> {
        return Result.failure(
            UnsupportedOperationException(
                "Phone OTP authentication is not connected to the local authentication repository."
            )
        )
    }

    override suspend fun verifyPhoneOtp(
        otp: String
    ): Result<AuthUser> {
        return Result.failure(
            UnsupportedOperationException(
                "Phone OTP authentication is not connected to the local authentication repository."
            )
        )
    }

    override suspend fun sendPasswordResetEmail(
        email: String
    ): Result<Unit> {
        return Result.failure(
            UnsupportedOperationException(
                "Password reset is not connected to the local authentication repository."
            )
        )
    }

    override suspend fun signOut(): Result<Unit> {
        sessionStore.clearUser()
        return Result.success(Unit)
    }

    override suspend fun deleteAccount(): Result<Unit> {
        sessionStore.clearUser()
        return Result.success(Unit)
    }
}
