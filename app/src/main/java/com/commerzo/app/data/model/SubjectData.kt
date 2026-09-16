package com.commerzo.app.data.model

data class SubjectData(
    val id: String,
    val name: String,
    val emoji: String,
    val board: Board,
    val classLevel: ClassLevel,
    val chaptersCount: Int
)
