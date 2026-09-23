package com.commerzo.app.data.repository.auth

import android.content.Context

object AuthRepositoryProvider {

    @Volatile
    private var repository: AuthRepository? = null

    fun getRepository(
        context: Context
    ): AuthRepository {

        return repository
            ?: synchronized(this) {

                repository
                    ?: createRepository(
                        context.applicationContext
                    ).also {
                        repository = it
                    }
            }
    }

    private fun createRepository(
        context: Context
    ): AuthRepository {

        return LocalAuthRepository(
            AuthSessionStore(context)
        )
    }
}
