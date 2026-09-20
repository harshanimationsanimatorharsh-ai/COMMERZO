package com.commerzo.app.data.remote.content

data class NetworkContentConfiguration(
    val baseUrl: String = "",
    val connectTimeoutSeconds: Long = 15L,
    val readTimeoutSeconds: Long = 30L,
    val writeTimeoutSeconds: Long = 30L
)
