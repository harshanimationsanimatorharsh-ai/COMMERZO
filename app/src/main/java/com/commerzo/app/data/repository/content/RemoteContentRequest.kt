package com.commerzo.app.data.repository.content

/**
 * Common request parameters used by the remote COMMERZO
 * content API.
 *
 * Keeping these parameters in one model makes the future
 * API layer consistent across subjects, chapters, papers
 * and test series.
 */
data class RemoteContentRequest(
    val boardId: String,
    val classId: String,
    val subjectId: String? = null,
    val chapterId: String? = null
)
