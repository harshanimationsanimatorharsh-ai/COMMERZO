package com.commerzo.app.data.repository.content

/**
 * Represents the result of a remote-content operation.
 *
 * This keeps success and failure handling separate from
 * UI code and allows the future remote layer to provide
 * safe local fallback when required.
 */
sealed class RemoteContentResult<out T> {

    /**
     * Remote operation completed successfully.
     */
    data class Success<T>(
        val data: T
    ) : RemoteContentResult<T>()

    /**
     * Remote operation failed.
     */
    data class Failure(
        val error: RemoteContentError
    ) : RemoteContentResult<Nothing>()
}
