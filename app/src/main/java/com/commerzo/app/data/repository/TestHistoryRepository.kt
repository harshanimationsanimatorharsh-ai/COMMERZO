package com.commerzo.app.data.repository

import com.commerzo.app.data.model.TestHistory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TestHistoryRepository {

    private val _history =
        MutableStateFlow<List<TestHistory>>(emptyList())

    val history: StateFlow<List<TestHistory>> =
        _history.asStateFlow()

    fun saveTest(
        subjectId: String,
        chapterId: String,
        totalQuestions: Int,
        answered: Int,
        correct: Int,
        wrong: Int,
        unattempted: Int,
        marked: Int
    ) {

        val percentage =
            if (totalQuestions > 0) {
                (correct * 100) / totalQuestions
            } else {
                0
            }

        val test =
            TestHistory(
                id = System.currentTimeMillis(),
                subjectId = subjectId,
                chapterId = chapterId,
                totalQuestions = totalQuestions,
                answered = answered,
                correct = correct,
                wrong = wrong,
                unattempted = unattempted,
                marked = marked,
                percentage = percentage,
                timestamp = System.currentTimeMillis()
            )

        _history.value =
            listOf(test) + _history.value
    }

    fun clearHistory() {
        _history.value = emptyList()
    }
}
