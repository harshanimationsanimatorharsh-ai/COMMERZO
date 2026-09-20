package com.commerzo.app.data.repository.content

/**
 * Provides the active content source configuration.
 *
 * This keeps source selection centralized so the rest of
 * COMMERZO does not need to know whether content is coming
 * from local storage, cache, or a remote backend.
 */
object ContentSourceProvider {

    fun getSource(): ContentSource {
        return ContentConfigurationProvider
            .getConfiguration()
            .source
    }

    fun isRemoteContentEnabled(): Boolean {
        return ContentConfigurationProvider
            .getConfiguration()
            .enableRemoteContent
    }

    fun isLocalCacheEnabled(): Boolean {
        return ContentConfigurationProvider
            .getConfiguration()
            .enableLocalCache
    }
}
