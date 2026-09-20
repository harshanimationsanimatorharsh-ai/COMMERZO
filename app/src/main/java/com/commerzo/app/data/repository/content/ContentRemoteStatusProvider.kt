package com.commerzo.app.data.repository.content

/**
 * Central provider for the current remote-content status.
 *
 * The status starts from configuration and can later be
 * updated by the real backend/API health-check layer.
 */
object ContentRemoteStatusProvider {

    private var status: ContentRemoteStatus =
        initialStatus()

    private fun initialStatus(): ContentRemoteStatus {

        return if (
            ContentSourceProvider.isRemoteContentEnabled()
        ) {
            ContentRemoteStatus.UNKNOWN
        } else {
            ContentRemoteStatus.DISABLED
        }
    }

    fun getStatus(): ContentRemoteStatus {
        return status
    }

    fun setStatus(
        newStatus: ContentRemoteStatus
    ) {
        status = newStatus
    }

    fun markAvailable() {
        status = ContentRemoteStatus.AVAILABLE
    }

    fun markUnavailable() {
        status = ContentRemoteStatus.UNAVAILABLE
    }

    fun reset() {
        status = initialStatus()
    }

    fun isAvailable(): Boolean {
        return status == ContentRemoteStatus.AVAILABLE
    }

    fun isEnabled(): Boolean {
        return status != ContentRemoteStatus.DISABLED
    }
}
