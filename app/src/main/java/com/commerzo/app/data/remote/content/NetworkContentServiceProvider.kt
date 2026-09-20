package com.commerzo.app.data.remote.content

object NetworkContentServiceProvider {

    private val service: NetworkContentService by lazy {
        LocalNetworkContentService()
    }

    fun getService(): NetworkContentService = service
}
