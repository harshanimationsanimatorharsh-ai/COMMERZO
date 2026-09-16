package com.commerzo.app.data.model

data class TestQuestionState(
    val question: Question,
    val selectedAnswer: Int? = null,
    val markedForReview: Boolean = false
)
