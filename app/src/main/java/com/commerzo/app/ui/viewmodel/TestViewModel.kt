package com.commerzo.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.model.TestQuestionState
import com.commerzo.app.data.repository.QuestionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TestViewModel : ViewModel() {

    private val repository = QuestionRepository()

    private val _questions =
        MutableStateFlow<List<TestQuestionState>>(emptyList())

    val questions: StateFlow<List<TestQuestionState>> =
        _questions.asStateFlow()

    private val _currentIndex =
        MutableStateFlow(0)

    val currentIndex: StateFlow<Int> =
        _currentIndex.asStateFlow()

    private val _remainingSeconds =
        MutableStateFlow(50 * 60)

    val remainingSeconds: StateFlow<Int> =
        _remainingSeconds.asStateFlow()

    private val _isFinished =
        MutableStateFlow(false)

    val isFinished: StateFlow<Boolean> =
        _isFinished.asStateFlow()

    private val _isStarted =
        MutableStateFlow(false)

    val isStarted: StateFlow<Boolean> =
        _isStarted.asStateFlow()

    fun loadTest(
        subjectId: String,
        chapterId: String
    ) {

        val sourceQuestions =
            repository.getQuestions(
                subjectId = subjectId,
                chapterId = chapterId
            )

        val testQuestions =
            buildTestQuestions(sourceQuestions)

        _questions.value = testQuestions
        _currentIndex.value = 0
        _remainingSeconds.value = 50 * 60
        _isFinished.value = false
        _isStarted.value = true
    }

    private fun buildTestQuestions(
        sourceQuestions: List<Question>
    ): List<TestQuestionState> {

        if (sourceQuestions.isEmpty()) {
            return emptyList()
        }

        val result = mutableListOf<Question>()

        while (result.size < 50) {
            result.addAll(sourceQuestions)

            if (result.size >= 50) {
                break
            }
        }

        return result
            .take(50)
            .map { question ->
                TestQuestionState(
                    question = question
                )
            }
    }

    fun selectAnswer(index: Int) {

        if (_isFinished.value) return

        val list =
            _questions.value.toMutableList()

        if (list.isEmpty()) return

        val current =
            list[_currentIndex.value]

        list[_currentIndex.value] =
            current.copy(
                selectedAnswer = index
            )

        _questions.value = list
    }

    fun toggleMarkForReview() {

        if (_isFinished.value) return

        val list =
            _questions.value.toMutableList()

        if (list.isEmpty()) return

        val current =
            list[_currentIndex.value]

        list[_currentIndex.value] =
            current.copy(
                markedForReview =
                    !current.markedForReview
            )

        _questions.value = list
    }

    fun goToQuestion(index: Int) {

        if (
            index >= 0 &&
            index < _questions.value.size
        ) {
            _currentIndex.value = index
        }
    }

    fun nextQuestion() {

        val next =
            _currentIndex.value + 1

        if (next < _questions.value.size) {
            _currentIndex.value = next
        }
    }

    fun previousQuestion() {

        val previous =
            _currentIndex.value - 1

        if (previous >= 0) {
            _currentIndex.value = previous
        }
    }

    fun decreaseTimer() {

        if (_isFinished.value) return

        if (_remainingSeconds.value > 0) {

            _remainingSeconds.value -= 1

        } else {

            finishTest()
        }
    }

    fun finishTest() {
        _isFinished.value = true
    }

    fun restartTest() {

        val reset =
            _questions.value.map {

                it.copy(
                    selectedAnswer = null,
                    markedForReview = false
                )
            }

        _questions.value = reset
        _currentIndex.value = 0
        _remainingSeconds.value = 50 * 60
        _isFinished.value = false
        _isStarted.value = true
    }

    fun getAnsweredCount(): Int {

        return _questions.value.count {
            it.selectedAnswer != null
        }
    }

    fun getMarkedCount(): Int {

        return _questions.value.count {
            it.markedForReview
        }
    }

    fun getCorrectCount(): Int {

        return _questions.value.count {

            it.selectedAnswer != null &&
                it.selectedAnswer ==
                it.question.correctAnswer
        }
    }

    fun getWrongCount(): Int {

        return _questions.value.count {

            it.selectedAnswer != null &&
                it.selectedAnswer !=
                it.question.correctAnswer
        }
    }

    fun getUnattemptedCount(): Int {

        return _questions.value.count {
            it.selectedAnswer == null
        }
    }
}
