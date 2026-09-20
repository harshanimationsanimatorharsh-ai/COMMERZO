package com.commerzo.app.data.repository.content

/**
 * Defines where COMMERZO content is currently loaded from.
 *
 * LOCAL:
 * Content comes from the app's local implementation.
 *
 * REMOTE:
 * Content comes from the backend/API.
 *
 * CACHE:
 * Content comes from locally cached remote data.
 *
 * AUTO:
 * The repository decides the best available source.
 */
enum class ContentSource {
    LOCAL,
    REMOTE,
    CACHE,
    AUTO
}
