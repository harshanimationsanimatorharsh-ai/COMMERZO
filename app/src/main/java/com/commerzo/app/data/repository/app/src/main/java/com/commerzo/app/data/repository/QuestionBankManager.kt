package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question

class QuestionBankManager(
    private val dataSource: QuestionDataSource =
        QuestionDataSource()
) {

    fun getValidatedQuestions(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): List<Question> {

        return dataSource
            .getValidatedQuestions(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )
            .distinctBy { it.id }
    }

    fun getRandomizedValidatedQuestions(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): List<Question> {

        return QuestionRandomizer.prepareForTest(
            getValidatedQuestions(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )
        )
    }

    fun validateQuestionBank(
        questions: List<Question>
    ): QuestionBankValidator.ValidationResult {

        return QuestionBankValidator.validateAll(
            questions
        )
    }

    fun validateChapterBank(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): QuestionBankValidator.ValidationResult {

        return QuestionBankValidator.validateBank(
            questions =
                dataSource.getQuestions(
                    subjectId = subjectId,
                    chapterId = chapterId,
                    board = board,
                    classLevel = classLevel
                ),
            subjectId = subjectId,
            chapterId = chapterId,
            board = board,
            classLevel = classLevel
        )
    }
}
