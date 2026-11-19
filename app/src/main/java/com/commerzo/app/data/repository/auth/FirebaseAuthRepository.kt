package com.commerzo.app.data.repository.auth

import android.app.Activity
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import com.commerzo.app.data.model.auth.AuthState
import com.commerzo.app.data.model.auth.AuthUser
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseException
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.FirebaseAuthMultiFactorException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume

class FirebaseAuthRepository(
    private val sessionStore: AuthSessionStore
) : AuthRepository {

    private val firebaseAuth: FirebaseAuth =
        FirebaseAuth.getInstance()

    @Volatile
    private var phoneVerificationId: String? = null

    override fun getAuthState(): AuthState {
        val user = firebaseAuth.currentUser

        if (user == null) {
            return AuthState.LoggedOut
        }

        val isEmailPasswordAccount = user.providerData.any {
            it.providerId == EmailAuthProvider.PROVIDER_ID
        }

        if (isEmailPasswordAccount && !user.isEmailVerified) {
            return AuthState.LoggedOut
        }

        return AuthState.LoggedIn(user.uid)
    }

    override fun getCurrentUser(): AuthUser? {
        val user = firebaseAuth.currentUser ?: return null

        val isEmailPasswordAccount = user.providerData.any {
            it.providerId == EmailAuthProvider.PROVIDER_ID
        }

        if (isEmailPasswordAccount && !user.isEmailVerified) {
            return null
        }

        return user.toAuthUser()
    }

    override suspend fun createAccountWithEmail(
        email: String,
        password: String,
        displayName: String
    ): Result<AuthUser> {
        return try {
            val result =
                firebaseAuth
                    .createUserWithEmailAndPassword(
                        email.trim(),
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
                    .setDisplayName(displayName.trim())
                    .build()

            firebaseUser
                .updateProfile(profileRequest)
                .awaitCompletion()

            firebaseUser
                .sendEmailVerification()
                .awaitCompletion()

            firebaseAuth.signOut()
            sessionStore.clearUser()

            Result.failure(
                EmailVerificationRequiredException(
                    "Account created. Please verify your email address using the verification link sent to your inbox, then sign in again."
                )
            )
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
                GoogleIdTokenCredential.createFrom(
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
            val result =
                firebaseAuth
                    .signInWithEmailAndPassword(
                        email.trim(),
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

            firebaseUser
                .reload()
                .awaitCompletion()

            val refreshedUser =
                firebaseAuth.currentUser
                    ?: return Result.failure(
                        IllegalStateException(
                            "Signed-in user is no longer available."
                        )
                    )

            val isEmailPasswordAccount =
                refreshedUser.providerData.any {
                    it.providerId == EmailAuthProvider.PROVIDER_ID
                }

            if (
                isEmailPasswordAccount &&
                !refreshedUser.isEmailVerified
            ) {
                firebaseAuth.signOut()
                sessionStore.clearUser()

                return Result.failure(
                    EmailVerificationRequiredException(
                        "Please verify your email address before signing in to COMMERZO."
                    )
                )
            }

            val authUser =
                refreshedUser.toAuthUser()

            sessionStore.saveUser(authUser)

            Result.success(authUser)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun sendPasswordResetEmail(
        email: String
    ): Result<Unit> {
        return try {
            val normalizedEmail = email.trim()

            if (normalizedEmail.isBlank()) {
                return Result.failure(
                    IllegalArgumentException(
                        "Please enter your email address."
                    )
                )
            }

            firebaseAuth
                .sendPasswordResetEmail(normalizedEmail)
                .awaitCompletion()

            Result.success(Unit)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

 override suspend fun sendPhoneOtp(
    activity: Activity,
    phoneNumber: String
): Result<Unit> {
    return try {
        val digits = phoneNumber.filter { it.isDigit() }

        val normalizedPhoneNumber = when {
            digits.length == 10 &&
                digits.firstOrNull() in '6'..'9' -> {
                "+91$digits"
            }

            digits.length == 12 &&
                digits.startsWith("91") &&
                digits[2] in '6'..'9' -> {
                "+$digits"
            }

            else -> {
                return Result.failure(
                    IllegalArgumentException(
                        "Please enter a valid 10-digit Indian mobile number."
                    )
                )
            }
        }

        phoneVerificationId = null

        suspendCancellableCoroutine { continuation ->

            val callbacks =
                object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                    override fun onVerificationCompleted(
                        credential: PhoneAuthCredential
                    ) {
                        // Manual OTP verification remains the current UI flow.
                    }

                    override fun onVerificationFailed(
                        exception: FirebaseException
                    ) {
                        if (continuation.isActive) {
                            continuation.resumeWith(
                                Result.failure(
                                    exception.toUserFacingPhoneAuthException()
                                )
                            )
                        }
                    }

                    override fun onCodeSent(
                        verificationId: String,
                        token: PhoneAuthProvider.ForceResendingToken
                    ) {
                        phoneVerificationId = verificationId

                        if (continuation.isActive) {
                            continuation.resume(
                                Result.success(Unit)
                            )
                        }
                    }

                    override fun onCodeAutoRetrievalTimeOut(
                        verificationId: String
                    ) {
                        if (phoneVerificationId == null) {
                            phoneVerificationId = verificationId
                        }

                        if (continuation.isActive) {
                            continuation.resume(
                                Result.success(Unit)
                            )
                        }
                    }
                }

            val options =
                PhoneAuthOptions.newBuilder(firebaseAuth)
                    .setPhoneNumber(normalizedPhoneNumber)
                    .setTimeout(60L, TimeUnit.SECONDS)
                    .setActivity(activity)
                    .setCallbacks(callbacks)
                    .build()

            PhoneAuthProvider.verifyPhoneNumber(options)

            continuation.invokeOnCancellation {
                phoneVerificationId = null
            }
        }
    } catch (exception: Exception) {
        Result.failure(exception)
    }
 }

    override suspend fun verifyPhoneOtp(
        otp: String
    ): Result<AuthUser> {
        return try {
            val verificationId =
                phoneVerificationId

            if (verificationId.isNullOrBlank()) {
                return Result.failure(
                    IllegalStateException(
                        "OTP verification session has expired. Please request a new OTP."
                    )
                )
            }

            val normalizedOtp =
                otp.trim()

            if (normalizedOtp.isBlank()) {
                return Result.failure(
                    IllegalArgumentException(
                        "Please enter the OTP."
                    )
                )
            }

            val credential =
                PhoneAuthProvider.getCredential(
                    verificationId,
                    normalizedOtp
                )

            val authResult =
                firebaseAuth
                    .signInWithCredential(
                        credential
                    )
                    .awaitResult()

            val firebaseUser =
                authResult.user
                    ?: return Result.failure(
                        IllegalStateException(
                            "Phone verification succeeded but user data is unavailable."
                        )
                    )

            val authUser =
                firebaseUser.toAuthUser()

            phoneVerificationId = null
            sessionStore.saveUser(authUser)

            Result.success(authUser)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun signOut(): Result<Unit> {
        return try {
            firebaseAuth.signOut()
            phoneVerificationId = null
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

            phoneVerificationId = null
            sessionStore.clearUser()

            Result.success(Unit)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}

class EmailVerificationRequiredException(
    message: String
) : IllegalStateException(message)

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

private fun Exception.toUserFacingPhoneAuthException(): Exception {
    return when (this) {
        is FirebaseAuthInvalidCredentialsException -> {
            IllegalArgumentException(
                "The mobile number format is invalid."
            )
        }

        is FirebaseAuthMissingActivityForRecaptchaException -> {
            IllegalStateException(
                "Phone verification requires an active COMMERZO screen."
            )
        }

        is FirebaseAuthMultiFactorException -> {
            IllegalStateException(
                "Additional phone verification is required."
            )
        }

        else -> {
            IllegalStateException(
                message
                    ?: "Unable to send OTP. Please try again."
            )
        }
    }
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
