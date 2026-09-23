package com.commerzo.app.data.repository.auth

import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.data.model.auth.AuthUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class FirebaseAuthRepository(
    private val sessionStore: AuthSessionStore
) : AuthRepository {

    private val firebaseAuth: FirebaseAuth =
        FirebaseAuth.getInstance()

    override fun getAuthState(): AuthState {
        val user = firebaseAuth.currentUser

        return if (user != null) {
            AuthState.LoggedIn(user.uid)
        } else {
            AuthState.LoggedOut
        }
    }

    override fun getCurrentUser(): AuthUser? {
        return firebaseAuth.currentUser?.toAuthUser()
    }

    override suspend fun createAccountWithEmail(
        email: String,
        password: String,
        displayName: String
    ): Result<AuthUser> {

        return try {
            val result = firebaseAuth
                .createUserWithEmailAndPassword(
                    email,
                    password
                )
                .awaitResult()

            val firebaseUser =
                result.user
                    ?: return Result.failure(
                        IllegalStateException(
                            "Account creation succeeded but user data is unavailable."
                        )
                    )

            val profileRequest =
                UserProfileChangeRequest.Builder()
                    .setDisplayName(displayName)
                    .build()

            firebaseUser
                .updateProfile(profileRequest)
                .awaitCompletion()

            val updatedUser =
                firebaseAuth.currentUser
                    ?: firebaseUser

            val authUser =
                updatedUser.toAuthUser()

            sessionStore.saveUser(authUser)

            Result.success(authUser)

        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun signInWithGoogle(): Result<AuthUser> {
        return Result.failure(
            UnsupportedOperationException(
                "Google Sign-In is not connected yet."
            )
        )
    }

    override suspend fun signInWithEmail(
        email: String,
        password: String
    ): Result<AuthUser> {

        return try {
            val result = firebaseAuth
                .signInWithEmailAndPassword(
                    email,
                    password
                )
                .awaitResult()

            val firebaseUser =
                result.user
                    ?: return Result.failure(
                        IllegalStateException(
                            "Sign-in succeeded but user data is unavailable."
                        )
                    )

            val authUser =
                firebaseUser.toAuthUser()

            sessionStore.saveUser(authUser)

            Result.success(authUser)

        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun sendPhoneOtp(
        phoneNumber: String
    ): Result<Unit> {
        return Result.failure(
            UnsupportedOperationException(
                "Phone OTP authentication is not connected yet."
            )
        )
    }

    override suspend fun verifyPhoneOtp(
        phoneNumber: String,
        otp: String
    ): Result<AuthUser> {
        return Result.failure(
            UnsupportedOperationException(
                "Phone OTP authentication is not connected yet."
            )
        )
    }

    override suspend fun signOut(): Result<Unit> {
        return try {
            firebaseAuth.signOut()
            sessionStore.clearUser()
            Result.success(Unit)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun deleteAccount(): Result<Unit> {
        return try {
            val user =
                firebaseAuth.currentUser
                    ?: return Result.failure(
                        IllegalStateException(
                            "No signed-in account found."
                        )
                    )

            user.delete().awaitCompletion()

            sessionStore.clearUser()

            Result.success(Unit)

        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}

private fun com.google.firebase.auth.FirebaseUser.toAuthUser(): AuthUser {
    return AuthUser(
        userId = uid,
        email = email,
        phoneNumber = phoneNumber,
        displayName = displayName,
        photoUrl = photoUrl?.toString(),
        isEmailVerified = isEmailVerified,
        isPhoneVerified = phoneNumber != null
    )
}

private suspend fun <T> com.google.android.gms.tasks.Task<T>.awaitResult(): T {
    return suspendCancellableCoroutine { continuation ->

        addOnCompleteListener { task ->

            if (task.isSuccessful) {
                continuation.resume(task.result)
            } else {
                continuation.resumeWith(
                    Result.failure(
                        task.exception
                            ?: IllegalStateException(
                                "Firebase operation failed."
                            )
                    )
                )
            }
        }
    }
}

private suspend fun com.google.android.gms.tasks.Task<Void>.awaitCompletion() {
    suspendCancellableCoroutine<Unit> { continuation ->

        addOnCompleteListener { task ->

            if (task.isSuccessful) {
                continuation.resume(Unit)
            } else {
                continuation.resumeWith(
                    Result.failure(
                        task.exception
                            ?: IllegalStateException(
                                "Firebase operation failed."
                            )
                    )
                )
            }
        }
    }
}
