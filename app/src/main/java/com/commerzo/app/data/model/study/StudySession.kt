package com.commerzo.app.data.model.study

data class StudySession(
    val sessionId: String = "",
    val userId: String = "",
    val board: String = "",
    val classLevel: String = "",
    val subjectId: String = "",
    val chapterId: String? = null,
    val startedAt: Long = 0L,
    val endedAt: Long? = null,
    val durationSeconds: Long = 0L,
    val status: String = STATUS_COMPLETED,
    val createdAt: Long = 0L,
    val updatedAt: Long = 0L
) {
    companion object {
        const val STATUS_ACTIVE = "ACTIVE"
        const val STATUS_COMPLETED = "COMPLETED"
    }
}
