package com.commerzo.app.data.repository.content

/**
 * Central configuration for the COMMERZO content system.
 *
 * This keeps content-source decisions outside the UI layer.
 */
data class ContentConfiguration(
    val source: ContentSource = ContentSource.AUTO,
    val enableRemoteContent: Boolean = false,
    val enableLocalCache: Boolean = true
)

/**
 * Provides the current content configuration.
 *
 * Remote content is intentionally disabled for now.
 * It will be enabled when the backend/API layer is implemented.
 */
object ContentConfigurationProvider {

    private val configuration = ContentConfiguration(
        source = ContentSource.AUTO,
        enableRemoteContent = false,
        enableLocalCache = true
    )

    fun getConfiguration(): ContentConfiguration {
        return configuration
    }
}
