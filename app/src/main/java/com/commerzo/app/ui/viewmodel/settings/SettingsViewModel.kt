
package com.commerzo.app.ui.viewmodel.settings

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class ThemeMode {
    SYSTEM,
    LIGHT,
    DARK
}

class SettingsViewModel(
    application: Application
) : AndroidViewModel(application) {

    companion object {
        private const val PREFS_NAME = "commerzo_settings"
        private const val KEY_DARK_MODE = "dark_mode"
        private const val KEY_THEME_MODE = "theme_mode"
        private const val KEY_NOTIFICATIONS_ENABLED =
            "notifications_enabled"

        const val SUPPORT_EMAIL = "theharshshrivas@gmail.com"
    }

    private val preferences = application.getSharedPreferences(
        PREFS_NAME,
        Context.MODE_PRIVATE
    )

    private fun loadThemeMode(): ThemeMode {
        val savedMode = preferences.getString(
            KEY_THEME_MODE,
            null
        )

        if (savedMode != null) {
            return runCatching {
                ThemeMode.valueOf(savedMode)
            }.getOrDefault(ThemeMode.SYSTEM)
        }

        // Migrate users from the previous Boolean preference.
        val oldDarkMode = preferences.getBoolean(
            KEY_DARK_MODE,
            false
        )

        return if (oldDarkMode) {
            ThemeMode.DARK
        } else {
            ThemeMode.SYSTEM
        }
    }

    private val _themeMode = MutableStateFlow(loadThemeMode())
    val themeMode: StateFlow<ThemeMode> =
        _themeMode.asStateFlow()

    // Backward compatibility during the UI migration.
    private val _darkModeEnabled = MutableStateFlow(
        _themeMode.value == ThemeMode.DARK
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

    fun setThemeMode(mode: ThemeMode) {
        preferences.edit()
            .putString(KEY_THEME_MODE, mode.name)
            .apply()

        _themeMode.value = mode
        _darkModeEnabled.value = mode == ThemeMode.DARK
    }

    fun setDarkModeEnabled(enabled: Boolean) {
        setThemeMode(
            if (enabled) ThemeMode.DARK else ThemeMode.LIGHT
        )
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

        _themeMode.value = ThemeMode.SYSTEM
        _darkModeEnabled.value = false
        _notificationsEnabled.value = true
    }
}
