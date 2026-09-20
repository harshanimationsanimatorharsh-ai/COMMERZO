package com.commerzo.app.data.repository.content

/**
 * Represents known remote-content failures.
 *
 * This keeps API/network failure handling separate from
 * UI code and allows the app to provide safe local fallback.
 */
sealed class RemoteContentError {

    /**
     * No network connection is available.
     */
    data object NetworkUnavailable : RemoteContentError()

    /**
     * Backend/API returned an unsuccessful response.
     */
    data class ServerError(
        val message: String? = null
    ) : RemoteContentError()

    /**
     * Requested content was not found.
     */
    data object NotFound : RemoteContentError()

    /**
     * Remote request took too long.
     */
    data object Timeout : RemoteContentError()

    /**
     * Response could not be decoded into the expected model.
     */
    data object InvalidResponse : RemoteContentError()

    /**
     * Remote content is disabled in app configuration.
     */
    data object Disabled : RemoteContentError()

    /**
     * Unknown/unclassified remote failure.
     */
    data class Unknown(
        val message: String? = null
    ) : RemoteContentError()
}
