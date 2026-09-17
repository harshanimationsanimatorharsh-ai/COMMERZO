package com.commerzo.app.data.model

data class Question(
    val id: String,
    val question: String,
    val options: List<String>,
    val correctAnswer: Int,
    val explanation: String,
    val subjectId: String,
    val chapterId: String,
    val board: Board = Board.MP_BOARD,
    val classLevel: ClassLevel = ClassLevel.CLASS_12,
    val difficulty: QuestionDifficulty = QuestionDifficulty.MEDIUM,
    val tags: List<String> = emptyList()
)

enum class QuestionDifficulty {
    EASY,
    MEDIUM,
    HARD
}
