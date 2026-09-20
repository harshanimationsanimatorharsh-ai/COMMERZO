package com.commerzo.app.data.repository.content

/**
 * Provides the active RemoteContentClient.
 *
 * The real networking implementation will be connected
 * later. Until then, a safe local-compatible client keeps
 * the remote architecture non-breaking.
 */
object RemoteContentClientProvider {

    private val client: RemoteContentClient by lazy {
        LocalRemoteContentClient()
    }

    fun getClient(): RemoteContentClient {
        return client
    }
}
