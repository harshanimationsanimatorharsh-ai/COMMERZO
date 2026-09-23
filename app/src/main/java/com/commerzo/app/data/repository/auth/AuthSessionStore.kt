package com.commerzo.app.data.repository.auth

import android.content.Context
import com.commerzo.app.data.model.auth.AuthUser
import org.json.JSONObject

class AuthSessionStore(
    context: Context
) {

    private val preferences =
        context.getSharedPreferences(
            "commerzo_auth_session",
            Context.MODE_PRIVATE
        )

    fun saveUser(user: AuthUser) {

        val json = JSONObject().apply {
            put("userId", user.userId)
            put("email", user.email)
            put("phoneNumber", user.phoneNumber)
            put("displayName", user.displayName)
            put("photoUrl", user.photoUrl)
            put("isEmailVerified", user.isEmailVerified)
            put("isPhoneVerified", user.isPhoneVerified)
        }

        preferences
            .edit()
            .putString("auth_user", json.toString())
            .apply()
    }

    fun getUser(): AuthUser? {

        val rawUser =
            preferences.getString(
                "auth_user",
                null
            ) ?: return null

        return try {

            val json =
                JSONObject(rawUser)

            AuthUser(
                userId =
                    json.optString("userId"),
                email =
                    json.optNullableString("email"),
                phoneNumber =
                    json.optNullableString("phoneNumber"),
                displayName =
                    json.optNullableString("displayName"),
                photoUrl =
                    json.optNullableString("photoUrl"),
                isEmailVerified =
                    json.optBoolean(
                        "isEmailVerified",
                        false
                    ),
                isPhoneVerified =
                    json.optBoolean(
                        "isPhoneVerified",
                        false
                    )
            )

        } catch (
            _: Exception
        ) {
            null
        }
    }

    fun clearUser() {

        preferences
            .edit()
            .remove("auth_user")
            .apply()
    }

    fun isLoggedIn(): Boolean {
        return getUser() != null
    }
}

private fun JSONObject.optNullableString(
    key: String
): String? {

    if (!has(key) || isNull(key)) {
        return null
    }

    return optString(key)
        .takeIf { it.isNotBlank() }
}
