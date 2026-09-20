package com.commerzo.app.data.remote.content

object NetworkContentConfigurationProvider {

    private val configuration = NetworkContentConfiguration()

    fun getConfiguration(): NetworkContentConfiguration = configuration
}
