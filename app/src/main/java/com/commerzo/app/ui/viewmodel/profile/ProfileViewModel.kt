package com.commerzo.app.ui.viewmodel.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.commerzo.app.data.model.profile.StudentProfile
import com.commerzo.app.data.repository.auth.AuthRepositoryProvider
import com.commerzo.app.data.repository.profile.UserProfileRepositoryProvider
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

            val authUser =
                authRepository.getCurrentUser()

            if (authUser == null) {
                _profileState.value =
                    ProfileState.Error(
                        "No signed-in user found."
                    )

                return@launch
            }

            val userId =
                authUser.userId

            val result =
                profileRepository.getProfile(userId)

            result.onSuccess { profile ->

                if (profile != null) {

                    _profileState.value =
                        ProfileState.Success(
                            profile
                        )

                } else {

                    val newProfile =
                        createProfileFromAuthUser(
                            authUser
                        )

                    val createResult =
                        profileRepository
                            .createOrUpdateProfile(
                                newProfile
                            )

                    if (createResult.isSuccess) {

                        _profileState.value =
                            ProfileState.Success(
                                newProfile
                            )

                    } else {

                        /*
                         * Firestore may be temporarily
                         * unavailable/offline.
                         *
                         * Authentication data is still
                         * available locally, so keep the
                         * profile screen usable.
                         */
                        _profileState.value =
                            ProfileState.Success(
                                newProfile
                            )
                    }
                }

            }.onFailure {

                /*
                 * Firestore read can fail while the device
                 * is offline. Do not hide the authenticated
                 * user's profile in that situation.
                 */
                val fallbackProfile =
                    createProfileFromAuthUser(
                        authUser
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
        val name =
            displayName.trim()

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

            val currentProfile =
                (
                    _profileState.value
                        as? ProfileState.Success
                    )?.profile

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
                 * Keep the UI usable when Firestore
                 * is temporarily unavailable.
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

    private fun createProfileFromAuthUser(
        authUser: com.commerzo.app.data.repository.auth.AuthUser
    ): StudentProfile {

        return StudentProfile(
            userId = authUser.userId,
            displayName = authUser.displayName.orEmpty(),
            email = authUser.email.orEmpty(),
            phoneNumber = authUser.phoneNumber,
            photoUrl = authUser.photoUrl,
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
                if (updates.containsKey("displayName")) {
                    updates["displayName"]
                        ?.toString()
                        ?: profile.displayName
                } else {
                    profile.displayName
                },

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
