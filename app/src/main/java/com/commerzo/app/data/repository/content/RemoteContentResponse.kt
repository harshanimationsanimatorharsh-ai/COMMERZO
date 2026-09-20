package com.commerzo.app.data.repository.content

/**
 * Generic response wrapper for COMMERZO remote-content APIs.
 *
 * The backend can later return:
 * - success/failure state
 * - optional message
 * - requested content data
 *
 * The generic type keeps this reusable for subjects,
 * chapters, content items, papers and test series.
 */
data class RemoteContentResponse<T>(
    val success: Boolean,
    val message: String? = null,
    val data: T? = null
)
