package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question

object QuestionBankValidator {

    data class ValidationResult(
        val isValid: Boolean,
        val errors: List<String>
    )

    fun validate(
        question: Question
    ): ValidationResult {

        val errors =
            mutableListOf<String>()

        val id =
            question.id.trim()

        val questionText =
            question.question.trim()

        if (id.isBlank()) {
            errors.add(
                "Question ID is empty."
            )
        }

        if (questionText.isBlank()) {
            errors.add(
                "Question ${question.id} has empty question text."
            )
        }

        if (question.options.size != 4) {
            errors.add(
                "Question ${question.id} must have exactly 4 options."
            )
        }

        if (
            question.options.any {
                it.trim().isBlank()
            }
        ) {
            errors.add(
                "Question ${question.id} contains an empty option."
            )
        }

        val normalizedOptions =
            question.options.map {
                it.trim()
            }

        if (
            normalizedOptions
                .distinct()
                .size != normalizedOptions.size
        ) {
            errors.add(
                "Question ${question.id} contains duplicate options."
            )
        }

        if (
            question.correctAnswer !in
            question.options.indices
        ) {
            errors.add(
                "Question ${question.id} has an invalid correct answer index."
            )
        }

        if (
            question.explanation
                .trim()
                .isBlank()
        ) {
            errors.add(
                "Question ${question.id} has no explanation."
            )
        }

        if (
            question.subjectId
                .trim()
                .isBlank()
        ) {
            errors.add(
                "Question ${question.id} has no subject ID."
            )
        }

        if (
            question.chapterId
                .trim()
                .isBlank()
        ) {
            errors.add(
                "Question ${question.id} has no chapter ID."
            )
        }

        if (question.board !in Board.values()) {
            errors.add(
                "Question ${question.id} has an invalid board."
            )
        }

        if (
            question.classLevel !in
            ClassLevel.values()
        ) {
            errors.add(
                "Question ${question.id} has an invalid class level."
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

        val errors =
            mutableListOf<String>()

        val nonBlankIds =
            questions
                .map { it.id.trim() }
                .filter { it.isNotBlank() }

        val duplicateIds =
            nonBlankIds
                .groupingBy { it }
                .eachCount()
                .filterValues { count ->
                    count > 1
                }
                .keys

        duplicateIds.forEach { duplicateId ->
            errors.add(
                "Duplicate question ID found: $duplicateId."
            )
        }

        questions.forEach { question ->
            errors.addAll(
                validate(question).errors
            )
        }

        return ValidationResult(
            isValid = errors.isEmpty(),
            errors = errors
        )
    }

    fun validateBank(
        questions: List<Question>,
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel
    ): ValidationResult {

        val errors =
            mutableListOf<String>()

        if (questions.isEmpty()) {
            errors.add(
                "Question bank is empty for " +
                    "$subjectId / $chapterId / " +
                    "${board.name} / ${classLevel.name}."
            )
        }

        questions.forEach { question ->

            errors.addAll(
                validate(question).errors
            )

            if (
                question.subjectId != subjectId
            ) {
                errors.add(
                    "Question ${question.id} has subject " +
                        "'${question.subjectId}' but expected '$subjectId'."
                )
            }

            if (
                question.chapterId != chapterId
            ) {
                errors.add(
                    "Question ${question.id} has chapter " +
                        "'${question.chapterId}' but expected '$chapterId'."
                )
            }

            if (
                question.board != board
            ) {
                errors.add(
                    "Question ${question.id} has board " +
                        "'${question.board.name}' but expected '${board.name}'."
                )
            }

            if (
                question.classLevel != classLevel
            ) {
                errors.add(
                    "Question ${question.id} has class level " +
                        "'${question.classLevel.name}' but expected '${classLevel.name}'."
                )
            }
        }

        val duplicateIds =
            questions
                .map { it.id }
                .groupingBy { it }
                .eachCount()
                .filterValues { count ->
                    count > 1
                }
                .keys

        duplicateIds.forEach { duplicateId ->
            errors.add(
                "Question bank contains duplicate ID: $duplicateId."
            )
        }

        return ValidationResult(
            isValid = errors.isEmpty(),
            errors = errors.distinct()
        )
    }
}
