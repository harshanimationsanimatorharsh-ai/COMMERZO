package com.commerzo.app.data.repository.content

/**
 * Provides the active content repository used by COMMERZO.
 *
 * Current implementation:
 * LocalContentRepository
 *
 * Future implementation:
 * RemoteContentRepository + Local Cache
 *
 * Keeping this decision in one place allows the rest of
 * the application to remain independent from the storage
 * or backend implementation.
 */
object ContentRepositoryProvider {

    private val repository: ContentRepository by lazy {
        ContentRepositoryFactory.create()
    }

    fun getRepository(): ContentRepository {
        return repository
    }
}
