package com.commerzo.app.data.remote.content

object NetworkContentServiceProvider {

    private val networkService: NetworkContentService by lazy {
        LocalNetworkContentService()
    }

    fun getService(): NetworkContentService = networkService
}
