package com.commerzo.app.data.remote.content

object RemoteContentApiProvider {

    private val api: RemoteContentApi by lazy {
        LocalRemoteContentApi()
    }

    fun getApi(): RemoteContentApi = api
}
