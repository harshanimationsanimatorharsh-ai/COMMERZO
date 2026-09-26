package com.commerzo.app.ui.viewmodel.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.commerzo.app.data.model.profile.StudentProfile
import com.commerzo.app.data.repository.auth.AuthRepositoryProvider
import com.commerzo.app.data.repository.profile.UserProfileRepositoryProvider
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class ProfileState {
    data object Loading : ProfileState()

    data class Success(
        val profile: StudentProfile
    ) : ProfileState()

    data object Empty : ProfileState()

    data class Error(
        val message: String
    ) : ProfileState()
}

class ProfileViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val authRepository =
        AuthRepositoryProvider.getRepository(
            application.applicationContext
        )

    private val profileRepository =
        UserProfileRepositoryProvider.getRepository()

    private val _profileState =
        MutableStateFlow<ProfileState>(
            ProfileState.Loading
        )

    val profileState: StateFlow<ProfileState> =
        _profileState.asStateFlow()

    init {
        loadProfile()
    }

    fun loadProfile() {
        viewModelScope.launch {

            _profileState.value =
                ProfileState.Loading

            val firebaseUser =
                authRepository.getCurrentUser()

            if (firebaseUser == null) {
                _profileState.value =
                    ProfileState.Error(
                        "No signed-in user found."
                    )

                return@launch
            }

            val result =
                profileRepository.getProfile(
                    firebaseUser.uid
                )

            result.onSuccess { profile ->

                if (profile != null) {

                    _profileState.value =
                        ProfileState.Success(profile)

                } else {

                    val newProfile =
                        createProfileFromFirebaseUser(
                            firebaseUser
                        )

                    val createResult =
                        profileRepository.createOrUpdateProfile(
                            newProfile
                        )

                    if (createResult.isSuccess) {

                        _profileState.value =
                            ProfileState.Success(
                                newProfile
                            )

                    } else {

                        // Firestore may be temporarily offline.
                        // Keep the authenticated Firebase
                        // user visible instead of showing an error.
                        _profileState.value =
                            ProfileState.Success(
                                newProfile
                            )
                    }
                }

            }.onFailure {

                /*
                 * Firestore can temporarily be offline.
                 *
                 * Firebase Authentication already contains
                 * the user's basic profile information, so use
                 * that information as a safe local fallback.
                 */
                val fallbackProfile =
                    createProfileFromFirebaseUser(
                        firebaseUser
                    )

                _profileState.value =
                    ProfileState.Success(
                        fallbackProfile
                    )
            }
        }
    }

    fun updateDisplayName(
        displayName: String
    ) {
        val name = displayName.trim()

        if (name.isBlank()) {
            return
        }

        updateProfileField(
            mapOf(
                "displayName" to name,
                "updatedAt" to System.currentTimeMillis()
            )
        )
    }

    fun updatePhoneNumber(
        phoneNumber: String?
    ) {
        updateProfileField(
            mapOf(
                "phoneNumber" to phoneNumber?.trim(),
                "updatedAt" to System.currentTimeMillis()
            )
        )
    }

    fun updatePhotoUrl(
        photoUrl: String?
    ) {
        updateProfileField(
            mapOf(
                "photoUrl" to photoUrl,
                "updatedAt" to System.currentTimeMillis()
            )
        )
    }

    private fun updateProfileField(
        updates: Map<String, Any?>
    ) {
        viewModelScope.launch {

            val currentState =
                _profileState.value

            val currentProfile =
                (currentState as? ProfileState.Success)
                    ?.profile

            if (currentProfile == null) {
                _profileState.value =
                    ProfileState.Error(
                        "Student profile is not loaded yet."
                    )

                return@launch
            }

            val result =
                profileRepository.updateProfile(
                    currentProfile.userId,
                    updates
                )

            if (result.isSuccess) {

                loadProfile()

            } else {

                /*
                 * Optimistic local update.
                 *
                 * If Firestore is offline, the user should
                 * still see the updated information locally.
                 */
                val updatedProfile =
                    applyLocalUpdates(
                        profile = currentProfile,
                        updates = updates
                    )

                _profileState.value =
                    ProfileState.Success(
                        updatedProfile
                    )
            }
        }
    }

    private fun createProfileFromFirebaseUser(
        firebaseUser: FirebaseUser
    ): StudentProfile {

        return StudentProfile(
            userId = firebaseUser.uid,
            displayName =
                firebaseUser.displayName.orEmpty(),
            email =
                firebaseUser.email.orEmpty(),
            phoneNumber =
                firebaseUser.phoneNumber,
            photoUrl =
                firebaseUser.photoUrl?.toString(),
            role = "student",
            createdAt = System.currentTimeMillis(),
            updatedAt = System.currentTimeMillis()
        )
    }

    private fun applyLocalUpdates(
        profile: StudentProfile,
        updates: Map<String, Any?>
    ): StudentProfile {

        return profile.copy(
            displayName =
                updates["displayName"]
                    ?.toString()
                    ?: profile.displayName,

            phoneNumber =
                if (updates.containsKey("phoneNumber")) {
                    updates["phoneNumber"] as? String
                } else {
                    profile.phoneNumber
                },

            photoUrl =
                if (updates.containsKey("photoUrl")) {
                    updates["photoUrl"] as? String
                } else {
                    profile.photoUrl
                },

            updatedAt =
                (updates["updatedAt"] as? Long)
                    ?: profile.updatedAt
        )
    }
}
