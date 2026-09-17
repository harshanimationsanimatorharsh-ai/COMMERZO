package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question

data class QuestionBank(
    val subjectId: String,
    val chapterId: String,
    val board: Board,
    val classLevel: ClassLevel,
    val questions: List<Question>
) {
    val size: Int
        get() = questions.size

    val isEmpty: Boolean
        get() = questions.isEmpty()
}

object QuestionBankFactory {

    fun create(
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel,
        questions: List<Question>
    ): QuestionBank {

        val matchingQuestions =
            questions
                .filter { question ->
                    question.subjectId == subjectId &&
                        question.chapterId == chapterId &&
                        question.board == board &&
                        question.classLevel == classLevel
                }
                .distinctBy { it.id }

        val validatedQuestions =
            matchingQuestions.filter { question ->
                QuestionBankValidator
                    .validate(question)
                    .isValid
            }

        return QuestionBank(
            subjectId = subjectId,
            chapterId = chapterId,
            board = board,
            classLevel = classLevel,
            questions = validatedQuestions
        )
    }
}
