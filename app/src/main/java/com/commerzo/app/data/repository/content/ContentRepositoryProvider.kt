package com.commerzo.app.data.repository.content

/**
 * Provides the single content repository instance used by COMMERZO.
 *
 * Keeping repository creation in one place makes it easier to
 * replace the local implementation with a remote/backend
 * implementation later without changing the UI layer.
 */
object ContentRepositoryProvider {

    private val repository: ContentRepository by lazy {
        LocalContentRepository()
    }

    fun getRepository(): ContentRepository {
        return repository
    }
}
