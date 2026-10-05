package com.commerzo.app.data.repository.firebase

/**
 * Provides a single FirebaseCurriculumRepository instance
 * for the COMMERZO application.
 *
 * The repository itself owns the FirebaseFirestore instance,
 * so no Android Context is required here.
 */
object FirebaseCurriculumRepositoryProvider {

    @Volatile
    private var repository: FirebaseCurriculumRepository? = null

    fun getRepository(): FirebaseCurriculumRepository {
        return repository ?: synchronized(this) {
            repository ?: FirebaseCurriculumRepository().also {
                repository = it
            }
        }
    }
}
