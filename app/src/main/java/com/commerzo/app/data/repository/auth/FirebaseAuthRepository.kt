package com.commerzo.app.data.repository.auth

import android.app.Activity
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.data.model.auth.AuthUser
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
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

            firebaseUser
                .sendEmailVerification()
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

    override suspend fun signInWithGoogle(
        activity: Activity
    ): Result<AuthUser> {
        return try {
            val credentialManager =
                CredentialManager.create(activity)

            val googleIdOption =
                GetGoogleIdOption.Builder()
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(
                        activity.getString(
                            com.commerzo.app.R.string.default_web_client_id
                        )
                    )
                    .setAutoSelectEnabled(false)
                    .build()

            val request =
                GetCredentialRequest.Builder()
                    .addCredentialOption(
                        googleIdOption
                    )
                    .build()

            val result =
                credentialManager.getCredential(
                    activity,
                    request
                )

            val credential =
                GoogleIdTokenCredential
                    .createFrom(
                        result.credential.data
                    )

            val firebaseCredential =
                GoogleAuthProvider.getCredential(
                    credential.idToken,
                    null
                )

            val authResult =
                firebaseAuth
                    .signInWithCredential(
                        firebaseCredential
                    )
                    .awaitResult()

            val firebaseUser =
                authResult.user
                    ?: return Result.failure(
                        IllegalStateException(
                            "Google sign-in succeeded but user data is unavailable."
                        )
                    )

            val authUser =
                firebaseUser.toAuthUser()

            sessionStore.saveUser(authUser)

            Result.success(authUser)
        } catch (exception: GetCredentialException) {
            Result.failure(
                IllegalStateException(
                    "Google Sign-In was cancelled or unavailable.",
                    exception
                )
            )
        } catch (exception: Exception) {
            Result.failure(exception)
        }
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

private suspend fun <T> Task<T>.awaitResult(): T {
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

private suspend fun Task<Void>.awaitCompletion() {
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
