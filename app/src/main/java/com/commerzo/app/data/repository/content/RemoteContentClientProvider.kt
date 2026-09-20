package com.commerzo.app.data.remote.content

import com.commerzo.app.data.repository.content.RemoteContentClient

object RemoteContentClientProvider {

    private val client: RemoteContentClient by lazy {
        LocalRemoteContentClient()
    }

    fun getClient(): RemoteContentClient = client
}
