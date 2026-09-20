package com.commerzo.app.data.repository.content

/**
 * Central provider for the current remote-content status.
 *
 * Current state:
 * - Remote content is disabled by configuration.
 * - Therefore the initial status is DISABLED.
 *
 * Later this provider can be updated by the real
 * backend/API health-check layer.
 */
object ContentRemoteStatusProvider {

    private var status: ContentRemoteStatus =
        if (
            ContentSourceProvider.isRemoteContentEnabled()
        ) {
            ContentRemoteStatus.UNKNOWN
        } else {
            ContentRemoteStatus.DISABLED
        }

    fun getStatus(): ContentRemoteStatus {
        return status
    }

    fun setStatus(
        newStatus: ContentRemoteStatus
    ) {
        status = newStatus
    }

    fun isAvailable(): Boolean {
        return status == ContentRemoteStatus.AVAILABLE
    }
}
