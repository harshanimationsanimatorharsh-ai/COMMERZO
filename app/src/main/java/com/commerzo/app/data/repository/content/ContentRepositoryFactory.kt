package com.commerzo.app.data.repository.content

/**
 * Central factory for creating the active COMMERZO
 * content repository.
 *
 * Source behaviour:
 *
 * LOCAL:
 *      LocalContentRepository
 *
 * REMOTE:
 *      ApiRemoteContentRepository
 *
 * CACHE:
 *      LocalContentRepository for now.
 *      A real cache will be connected later.
 *
 * AUTO:
 *      HybridContentRepository when remote content is
 *      enabled; otherwise LocalContentRepository.
 *
 * The current configuration keeps remote content disabled,
 * so the existing local system remains the active source.
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
                ApiRemoteContentRepository()
            }

            ContentSource.CACHE -> {
                LocalContentRepository()
            }

            ContentSource.AUTO -> {

                if (configuration.enableRemoteContent) {
                    HybridContentRepository()
                } else {
                    LocalContentRepository()
                }
            }
        }
    }
}
