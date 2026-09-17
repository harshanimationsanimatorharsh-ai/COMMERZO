package com.commerzo.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.repository.TestHistoryRepository
import com.commerzo.app.data.repository.TestHistoryItem
import kotlinx.coroutines.flow.StateFlow

class TestHistoryViewModel : ViewModel() {

val history: StateFlow<List<TestHistoryItem>> =
    TestHistoryRepository.history

fun getTotalTests(): Int {
    return TestHistoryRepository.getTotalTests()
}

fun getBestScore(): Int {
    return TestHistoryRepository.getBestScore()
}

fun getAverageScore(): Int {
    return TestHistoryRepository.getAverageScore()
}

fun getTotalCorrect(): Int {
    return TestHistoryRepository.getTotalCorrect()
}

fun getTotalQuestions(): Int {
    return TestHistoryRepository.getTotalQuestions()
}

}
