package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question

class QuestionProvider(
    private val questionRepository: QuestionRepository =
        QuestionRepository()
) {

    fun getChapterQuestions(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): List<Question> {

        return questionRepository
            .getQuestions(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )
            .filter { question ->
                question.subjectId == subjectId &&
                    question.chapterId == chapterId &&
                    question.board == board &&
                    question.classLevel == classLevel
            }
            .distinctBy { it.id }
    }

    fun getValidatedChapterQuestions(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): List<Question> {

        return getChapterQuestions(
            subjectId = subjectId,
            chapterId = chapterId,
            board = board,
            classLevel = classLevel
        ).filter { question ->
            QuestionBankValidator
                .validate(question)
                .isValid
        }
    }

    fun getPracticeQuestions(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): List<Question> {

        return QuestionRandomizer.prepareForTest(
            getValidatedChapterQuestions(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )
        )
    }
}
