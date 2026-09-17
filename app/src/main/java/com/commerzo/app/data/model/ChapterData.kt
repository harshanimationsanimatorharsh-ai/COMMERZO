package com.commerzo.app.data.model

data class ChapterData(
    val id: String,
    val subjectId: String,
    val title: String,
    val chapterNumber: Int,
    val board: Board,
    val classLevel: ClassLevel
)
