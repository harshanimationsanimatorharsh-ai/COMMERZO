package com.commerzo.app.data.model

data class TestHistory(
    val id: Long,
    val subjectId: String,
    val chapterId: String,
    val totalQuestions: Int,
    val answered: Int,
    val correct: Int,
    val wrong: Int,
    val unattempted: Int,
    val marked: Int,
    val percentage: Int,
    val timestamp: Long
)
