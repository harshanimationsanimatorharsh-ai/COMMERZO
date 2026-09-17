package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question

class QuestionBankManager(
    private val dataSource: QuestionDataSource = QuestionDataSource()
) {

    fun getValidatedQuestions(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): List<Question> {

        val questions =
            dataSource.getQuestions(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )

        return questions
            .distinctBy { it.id }
            .filter { question ->
                QuestionBankValidator
                    .validate(question)
                    .isValid
            }
    }

    fun getRandomizedValidatedQuestions(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): List<Question> {

        val validatedQuestions =
            getValidatedQuestions(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )

        return QuestionRandomizer
            .prepareForTest(
                validatedQuestions
            )
    }

    fun validateQuestionBank(
        questions: List<Question>
    ): QuestionBankValidator.ValidationResult {

        return QuestionBankValidator
            .validateAll(questions)
    }

    fun validateChapterBank(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): QuestionBankValidator.ValidationResult {

        val questions =
            dataSource.getQuestions(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )

        return QuestionBankValidator.validateBank(
            questions = questions,
            subjectId = subjectId,
            chapterId = chapterId,
            board = board,
            classLevel = classLevel
        )
    }
}
