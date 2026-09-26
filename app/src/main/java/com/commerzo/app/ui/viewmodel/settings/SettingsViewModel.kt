package com.commerzo.app.ui.viewmodel.settings

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel(
    application: Application
) : AndroidViewModel(application) {

    companion object {
        private const val PREFS_NAME = "commerzo_settings"
        private const val KEY_DARK_MODE = "dark_mode"
        private const val KEY_NOTIFICATIONS_ENABLED = "notifications_enabled"

        const val SUPPORT_EMAIL = "theharshshrivas@gmail.com"
    }

    private val preferences = application.getSharedPreferences(
        PREFS_NAME,
        Context.MODE_PRIVATE
    )

    private val _darkModeEnabled = MutableStateFlow(
        preferences.getBoolean(KEY_DARK_MODE, false)
    )
    val darkModeEnabled: StateFlow<Boolean> =
        _darkModeEnabled.asStateFlow()

    private val _notificationsEnabled = MutableStateFlow(
        preferences.getBoolean(
            KEY_NOTIFICATIONS_ENABLED,
            true
        )
    )
    val notificationsEnabled: StateFlow<Boolean> =
        _notificationsEnabled.asStateFlow()

    fun setDarkModeEnabled(enabled: Boolean) {
        preferences.edit()
            .putBoolean(KEY_DARK_MODE, enabled)
            .apply()

        _darkModeEnabled.value = enabled
    }

    fun setNotificationsEnabled(enabled: Boolean) {
        preferences.edit()
            .putBoolean(KEY_NOTIFICATIONS_ENABLED, enabled)
            .apply()

        _notificationsEnabled.value = enabled
    }

    fun resetSettings() {
        preferences.edit()
            .clear()
            .apply()

        _darkModeEnabled.value = false
        _notificationsEnabled.value = true
    }
}
