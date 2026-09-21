package com.commerzo.app.data.remote.content

object RemoteContentApiProvider {

    private val remoteApi: RemoteContentApi by lazy {
        LocalRemoteContentApi()
    }

    fun getApi(): RemoteContentApi = remoteApi
}
