package com.commerzo.app.data.repository.profile

object UserProfileRepositoryProvider {

    @Volatile
    private var repository: UserProfileRepository? = null

    fun getRepository(): UserProfileRepository {
        return repository ?: synchronized(this) {
            repository ?: UserProfileRepository().also {
                repository = it
            }
        }
    }
}
