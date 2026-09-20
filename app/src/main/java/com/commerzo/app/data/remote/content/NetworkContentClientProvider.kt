package com.commerzo.app.data.remote.content

object NetworkContentClientProvider {

    private val client: NetworkContentClient by lazy {
        LocalNetworkContentClient()
    }

    fun getClient(): NetworkContentClient = client
}
