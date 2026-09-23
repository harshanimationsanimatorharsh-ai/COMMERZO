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
    data class Success(val profile: StudentProfile) : ProfileState()
    data object Empty : ProfileState()
    data class Error(val message: String) : ProfileState()
}

class ProfileViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val authRepository =
        AuthRepositoryProvider.getRepository(application.applicationContext)

    private val profileRepository =
        UserProfileRepositoryProvider.getRepository()

    private val _profileState =
        MutableStateFlow<ProfileState>(ProfileState.Loading)

    val profileState: StateFlow<ProfileState> =
        _profileState.asStateFlow()

    init {
        loadProfile()
    }

    fun loadProfile() {
        viewModelScope.launch {
            _profileState.value = ProfileState.Loading

            val firebaseUser = authRepository.getCurrentUser()

            if (firebaseUser == null) {
                _profileState.value =
                    ProfileState.Error("No signed-in user found.")
                return@launch
            }

            val result =
                profileRepository.getProfile(firebaseUser.userId)

            result
                .onSuccess { profile ->
                    if (profile != null) {
                        _profileState.value =
                            ProfileState.Success(profile)
                    } else {
                        val newProfile = StudentProfile(
                            userId = firebaseUser.userId,
                            displayName = firebaseUser.displayName.orEmpty(),
                            email = firebaseUser.email.orEmpty(),
                            phoneNumber = firebaseUser.phoneNumber,
                            photoUrl = firebaseUser.photoUrl,
                            role = "student",
                            createdAt = System.currentTimeMillis(),
                            updatedAt = System.currentTimeMillis()
                        )

                        val createResult =
                            profileRepository.createOrUpdateProfile(newProfile)

                        if (createResult.isSuccess) {
                            _profileState.value =
                                ProfileState.Success(newProfile)
                        } else {
                            _profileState.value =
                                ProfileState.Error(
                                    createResult.exceptionOrNull()?.message
                                        ?: "Unable to create student profile."
                                )
                        }
                    }
                }
                .onFailure { error ->
                    _profileState.value =
                        ProfileState.Error(
                            error.message
                                ?: "Unable to load student profile."
                        )
                }
        }
    }

    fun updateDisplayName(displayName: String) {
        updateProfileField(
            mapOf(
                "displayName" to displayName.trim(),
                "updatedAt" to System.currentTimeMillis()
            )
        )
    }

    fun updatePhoneNumber(phoneNumber: String?) {
        updateProfileField(
            mapOf(
                "phoneNumber" to phoneNumber?.trim(),
                "updatedAt" to System.currentTimeMillis()
            )
        )
    }

    fun updatePhotoUrl(photoUrl: String?) {
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
            val currentState = _profileState.value

            val currentProfile =
                (currentState as? ProfileState.Success)?.profile

            if (currentProfile == null) {
                _profileState.value =
                    ProfileState.Error(
                        "Student profile is not loaded yet."
                    )
                return@launch
            }

            val result =
                profileRepository.updateProfile(
                    userId = currentProfile.userId,
                    updates = updates
                )

            result
                .onSuccess {
                    loadProfile()
                }
                .onFailure { error ->
                    _profileState.value =
                        ProfileState.Error(
                            error.message
                                ?: "Unable to update student profile."
                        )
                }
        }
    }
}
