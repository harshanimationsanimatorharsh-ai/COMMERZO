package com.commerzo.app.data.repository.firebase

import com.google.firebase.firestore.FirebaseFirestore

object FirebaseCurriculumRepositoryProvider {

    @Volatile
    private var repository: FirebaseCurriculumRepository? = null

    fun getRepository(): FirebaseCurriculumRepository {
        return repository ?: synchronized(this) {
            repository ?: FirebaseCurriculumRepository(
                firestore = FirebaseFirestore.getInstance()
            ).also {
                repository = it
            }
        }
    }
}
