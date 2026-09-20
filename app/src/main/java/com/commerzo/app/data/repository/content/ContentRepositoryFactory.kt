package com.commerzo.app.data.repository.content

/**
 * Central factory for creating the COMMERZO content repository.
 *
 * Keeping repository creation here allows us to switch
 * from local content to remote/backend content later
 * without changing the UI or service layer.
 */
object ContentRepositoryFactory {

    fun create(): ContentRepository {
        return LocalContentRepository()
    }
}
