package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Question

object QuestionBankValidator {

    data class ValidationResult(
        val isValid: Boolean,
        val errors: List<String>
    )

    fun validate(question: Question): ValidationResult {
        val errors = mutableListOf<String>()

        if (question.id.isBlank()) {
            errors.add("Question ID is empty.")
        }

        if (question.question.isBlank()) {
            errors.add("Question text is empty.")
        }

        if (question.options.size != 4) {
            errors.add(
                "Question ${question.id} must have exactly 4 options."
            )
        }

        if (question.options.any { it.isBlank() }) {
            errors.add(
                "Question ${question.id} contains an empty option."
            )
        }

        if (question.options.distinct().size != question.options.size) {
            errors.add(
                "Question ${question.id} contains duplicate options."
            )
        }

        if (
            question.correctAnswer !in question.options.indices
        ) {
            errors.add(
                "Question ${question.id} has an invalid correct answer index."
            )
        }

        if (question.explanation.isBlank()) {
            errors.add(
                "Question ${question.id} has no explanation."
            )
        }

        if (question.subjectId.isBlank()) {
            errors.add(
                "Question ${question.id} has no subject ID."
            )
        }

        if (question.chapterId.isBlank()) {
            errors.add(
                "Question ${question.id} has no chapter ID."
            )
        }

        return ValidationResult(
            isValid = errors.isEmpty(),
            errors = errors
        )
    }

    fun validateAll(
        questions: List<Question>
    ): ValidationResult {

        val errors = questions.flatMap { question ->
            validate(question).errors
        }

        return ValidationResult(
            isValid = errors.isEmpty(),
            errors = errors
        )
    }
}
