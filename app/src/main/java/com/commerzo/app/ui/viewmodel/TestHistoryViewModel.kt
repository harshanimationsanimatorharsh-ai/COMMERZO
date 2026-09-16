package com.commerzo.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.model.TestHistory
import com.commerzo.app.data.repository.TestHistoryRepository
import kotlinx.coroutines.flow.StateFlow

class TestHistoryViewModel : ViewModel() {

    val history: StateFlow<List<TestHistory>> =
        TestHistoryRepository.history

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
