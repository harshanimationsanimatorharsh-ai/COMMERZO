package com.commerzo.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.model.TestHistory
import com.commerzo.app.data.repository.TestHistoryRepository
import kotlinx.coroutines.flow.StateFlow

class TestHistoryViewModel : ViewModel() {

    private val repository =
        TestHistoryRepository()

    val history: StateFlow<List<TestHistory>> =
        repository.history

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

        repository.saveTest(
            subjectId = subjectId,
            chapterId = chapterId,
            totalQuestions = totalQuestions,
            answered = answered,
            correct = correct,
            wrong = wrong,
            unattempted = unattempted,
            marked = marked
        )
    }

    fun getTotalTests(): Int {
        return history.value.size
    }

    fun getBestScore(): Int {
        return history.value
            .maxOfOrNull { it.percentage }
            ?: 0
    }

    fun getAverageScore(): Int {

        if (history.value.isEmpty()) {
            return 0
        }

        return history.value
            .map { it.percentage }
            .average()
            .toInt()
    }

    fun getTotalCorrect(): Int {
        return history.value.sumOf {
            it.correct
        }
    }

    fun getTotalQuestions(): Int {
        return history.value.sumOf {
            it.totalQuestions
        }
    }
}
