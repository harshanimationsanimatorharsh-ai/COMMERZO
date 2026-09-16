package com.commerzo.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.model.TestQuestionState
import com.commerzo.app.data.repository.QuestionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TestViewModel : ViewModel() {

    private val repository =
        QuestionRepository()

    private val _questions =
        MutableStateFlow<List<TestQuestionState>>(emptyList())

    val questions: StateFlow<List<TestQuestionState>> =
        _questions.asStateFlow()

    private val _currentIndex =
        MutableStateFlow(0)

    val currentIndex: StateFlow<Int> =
        _currentIndex.asStateFlow()

    private val _timeRemaining =
        MutableStateFlow(50 * 60)

    val timeRemaining: StateFlow<Int> =
        _timeRemaining.asStateFlow()

    private val _isFinished =
        MutableStateFlow(false)

    val isFinished: StateFlow<Boolean> =
        _isFinished.asStateFlow()

    fun loadTest(
        subjectId: String,
        chapterId: String
    ) {

        val sourceQuestions =
            repository.getQuestions(
                subjectId = subjectId,
                chapterId = chapterId
            )

        if (sourceQuestions.isEmpty()) {
            return
        }

        val testQuestions =
            buildTestQuestions(
                sourceQuestions
            )

        _questions.value =
            testQuestions

        _currentIndex.value = 0
        _timeRemaining.value = 50 * 60
        _isFinished.value = false
    }

    private fun buildTestQuestions(
        source: List<Question>
    ): List<TestQuestionState> {

        val result =
            mutableListOf<TestQuestionState>()

        var index = 0

        while (result.size < 50) {

            val question =
                source[index % source.size]

            result.add(
                TestQuestionState(
                    question = question
                )
            )

            index++
        }

        return result
    }

    fun selectAnswer(answer: Int) {

        val list =
            _questions.value.toMutableList()

        val current =
            list.getOrNull(_currentIndex.value)
                ?: return

        list[_currentIndex.value] =
            current.copy(
                selectedAnswer = answer
            )

        _questions.value = list
    }

    fun getSelectedAnswer(
        index: Int
    ): Int? {

        return _questions.value
            .getOrNull(index)
            ?.selectedAnswer
    }

    fun nextQuestion() {

        if (
            _currentIndex.value <
            _questions.value.lastIndex
        ) {

            _currentIndex.value++
        } else {

            finishTest()
        }
    }

    fun previousQuestion() {

        if (_currentIndex.value > 0) {
            _currentIndex.value--
        }
    }

    fun toggleMarkForReview() {

        val list =
            _questions.value.toMutableList()

        val current =
            list.getOrNull(_currentIndex.value)
                ?: return

        list[_currentIndex.value] =
            current.copy(
                markedForReview =
                    !current.markedForReview
            )

        _questions.value = list
    }

    fun isCurrentQuestionMarked(): Boolean {

        return _questions.value
            .getOrNull(_currentIndex.value)
            ?.markedForReview
            ?: false
    }

    fun decreaseTimer() {

        if (_isFinished.value) {
            return
        }

        if (_timeRemaining.value > 0) {

            _timeRemaining.value--
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
        _timeRemaining.value = 50 * 60
        _isFinished.value = false
    }

    fun getAnsweredCount(): Int {

        return _questions.value.count {
            it.selectedAnswer != null
        }
    }

    fun getUnattemptedCount(): Int {

        return _questions.value.count {
            it.selectedAnswer == null
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
}
