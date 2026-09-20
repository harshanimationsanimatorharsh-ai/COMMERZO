package com.commerzo.app.data.repository.content

/**
 * Central factory for creating the active COMMERZO
 * content repository.
 *
 * Current state:
 * - LOCAL -> LocalContentRepository
 * - REMOTE -> Remote-compatible repository
 * - CACHE -> Local repository for now
 * - AUTO -> Automatically selects the safest available source
 *
 * The actual HTTP/backend implementation will be connected
 * later without changing ContentManager or the UI layer.
 */
object ContentRepositoryFactory {

    fun create(): ContentRepository {

        val configuration =
            ContentConfigurationProvider.getConfiguration()

        return when (configuration.source) {

            ContentSource.LOCAL -> {
                LocalContentRepository()
            }

            ContentSource.REMOTE -> {
                LocalRemoteContentRepository()
            }

            ContentSource.CACHE -> {
                LocalContentRepository()
            }

            ContentSource.AUTO -> {

                if (
                    configuration.enableRemoteContent
                ) {
                    LocalRemoteContentRepository()
                } else {
                    LocalContentRepository()
                }
            }
        }
    }
}
