package com.commerzo.app.data.repository.content

/**
 * Provides the single ContentManager instance used by
 * the COMMERZO application.
 */
object ContentManagerProvider {

    private val contentManager: ContentManager by lazy {
        ContentManager()
    }

    fun getManager(): ContentManager {
        return contentManager
    }
}
