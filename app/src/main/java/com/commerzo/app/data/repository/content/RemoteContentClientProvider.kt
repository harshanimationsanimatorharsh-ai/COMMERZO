package com.commerzo.app.data.remote.content

object RemoteContentClientProvider {

    private val client: RemoteContentClient by lazy {
        LocalRemoteContentClient()
    }

    fun getClient(): RemoteContentClient = client
}
