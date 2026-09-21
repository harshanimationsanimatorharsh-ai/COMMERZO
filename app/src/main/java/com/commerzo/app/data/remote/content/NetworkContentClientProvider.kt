package com.commerzo.app.data.remote.content

object NetworkContentClientProvider {

    private val networkClient: NetworkContentClient by lazy {
        LocalNetworkContentClient()
    }

    fun getClient(): NetworkContentClient = networkClient
}
