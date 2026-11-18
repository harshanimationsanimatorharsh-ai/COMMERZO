
package com.commerzo.app.ui.viewmodel.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.commerzo.app.data.model.auth.AuthUser
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
            _profileState.value = ProfileState.Loading

            try {
                val authUser =
                    authRepository.getCurrentUser()

                if (authUser == null) {
                    _profileState.value =
                        ProfileState.Error(
                            "No signed-in user found."
                        )
                    return@launch
                }

                val result =
                    profileRepository.getProfile(
                        authUser.userId
                    )

                result.fold(
                    onSuccess = { profile ->
                        if (profile != null) {
                            _profileState.value =
                                ProfileState.Success(profile)
                        } else {
                            createMissingProfile(authUser)
                        }
                    },
                    onFailure = { error ->
                        _profileState.value =
                            ProfileState.Error(
                                error.message
                                    ?: "Unable to load your profile. Please try again."
                            )
                    }
                )
            } catch (error: Exception) {
                _profileState.value =
                    ProfileState.Error(
                        error.message
                            ?: "Something went wrong while loading your profile."
                    )
            }
        }
    }

    private suspend fun createMissingProfile(
        authUser: AuthUser
    ) {
        val newProfile =
            createProfileFromAuthUser(authUser)

        val result =
            profileRepository.createOrUpdateProfile(
                newProfile
            )

        result.fold(
            onSuccess = {
                _profileState.value =
                    ProfileState.Success(newProfile)
            },
            onFailure = { error ->
                _profileState.value =
                    ProfileState.Error(
                        error.message
                            ?: "Your profile could not be saved. Please retry."
                    )
            }
        )
    }

    fun updateDisplayName(
        displayName: String
    ) {
        val name = displayName.trim()

        if (name.isBlank()) return

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
                (_profileState.value as? ProfileState.Success)
                    ?.profile

            if (currentProfile == null) {
                _profileState.value =
                    ProfileState.Error(
                        "Student profile is not loaded. Please retry."
                    )
                return@launch
            }

            val result =
                profileRepository.updateProfile(
                    currentProfile.userId,
                    updates
                )

            result.fold(
                onSuccess = {
                    loadProfile()
                },
                onFailure = { error ->
                    _profileState.value =
                        ProfileState.Error(
                            error.message
                                ?: "Profile update failed. Your changes were not confirmed as saved."
                        )
                }
            )
        }
    }

    private fun createProfileFromAuthUser(
        authUser: AuthUser
    ): StudentProfile {
        val currentTime = System.currentTimeMillis()

        return StudentProfile(
            userId = authUser.userId,
            displayName = authUser.displayName.orEmpty(),
            email = authUser.email.orEmpty(),
            phoneNumber = authUser.phoneNumber,
            photoUrl = authUser.photoUrl,
            role = "student",
            createdAt = currentTime,
            updatedAt = currentTime
        )
    }
}
