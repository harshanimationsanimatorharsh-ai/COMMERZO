package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Question
import kotlin.random.Random

object QuestionRandomizer {

    fun shuffleOptions(
        question: Question,
        random: Random = Random.Default
    ): Question {

        if (question.options.size < 2) {
            return question
        }

        val correctOption = question.options.getOrNull(question.correctAnswer)
            ?: return question

        val shuffledOptions = question.options.shuffled(random)
        val newCorrectAnswer = shuffledOptions.indexOf(correctOption)

        return question.copy(
            options = shuffledOptions,
            correctAnswer = newCorrectAnswer
        )
    }

    fun shuffleQuestions(
        questions: List<Question>,
        random: Random = Random.Default
    ): List<Question> {
        return questions.shuffled(random)
    }

    fun prepareForTest(
        questions: List<Question>,
        random: Random = Random.Default
    ): List<Question> {
        return shuffleQuestions(questions, random)
            .map { question ->
                shuffleOptions(question, random)
            }
    }
}
