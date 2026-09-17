package com.commerzo.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.repository.TestHistoryItem
import com.commerzo.app.data.repository.TestHistoryRepository
import kotlinx.coroutines.flow.StateFlow

class TestHistoryViewModel : ViewModel() {

    val history: StateFlow<List<TestHistoryItem>> =
        TestHistoryRepository.history

    fun getTotalTests(): Int {
        return history.value.size
    }

    fun getBestScore(): Int {
        return history.value.maxOfOrNull { it.percentage } ?: 0
    }

    fun getAverageScore(): Int {
        val items = history.value

        if (items.isEmpty()) {
            return 0
        }

        return items
            .map { it.percentage }
            .average()
            .toInt()
    }

    fun getTotalCorrect(): Int {
        return history.value.sumOf { it.correct }
    }

    fun getTotalQuestions(): Int {
        return history.value.sumOf { it.totalQuestions }
    }
}
