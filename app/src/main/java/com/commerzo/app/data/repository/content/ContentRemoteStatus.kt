package com.commerzo.app.data.repository.content

/**
 * Represents the current availability of the remote
 * COMMERZO content system.
 *
 * This keeps remote availability separate from the
 * actual content models.
 */
enum class ContentRemoteStatus {

    /**
     * Remote content has not been checked yet.
     */
    UNKNOWN,

    /**
     * Remote content/API is available.
     */
    AVAILABLE,

    /**
     * Remote content/API is temporarily unavailable.
     */
    UNAVAILABLE,

    /**
     * Remote content is disabled by configuration.
     */
    DISABLED
}
