package com.commerzo.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.model.TestQuestionState
import com.commerzo.app.data.repository.QuestionBankManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TestViewModel : ViewModel() {

    private val questionBankManager = QuestionBankManager()

    private val _questions =
        MutableStateFlow<List<TestQuestionState>>(emptyList())

    val questions: StateFlow<List<TestQuestionState>> =
        _questions.asStateFlow()

    private val _currentIndex =
        MutableStateFlow(0)

    val currentIndex: StateFlow<Int> =
        _currentIndex.asStateFlow()

    private val _timeRemaining =
        MutableStateFlow(TEST_DURATION_SECONDS)

    val timeRemaining: StateFlow<Int> =
        _timeRemaining.asStateFlow()

    private val _isFinished =
        MutableStateFlow(false)

    val isFinished: StateFlow<Boolean> =
        _isFinished.asStateFlow()

    fun loadTest(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ) {

        val sourceQuestions =
            questionBankManager.getRandomizedValidatedQuestions(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )

        if (sourceQuestions.isEmpty()) {
            _questions.value = emptyList()
            return
        }

        _questions.value = buildTestQuestions(sourceQuestions)

        _currentIndex.value = 0
        _timeRemaining.value = TEST_DURATION_SECONDS
        _isFinished.value = false
    }

    private fun buildTestQuestions(
        source: List<Question>
    ): List<TestQuestionState> {

        val testQuestions = mutableListOf<TestQuestionState>()

        if (source.isEmpty()) {
            return emptyList()
        }

        var index = 0

        while (testQuestions.size < TEST_SIZE) {

            val question = source[index % source.size]

            testQuestions.add(
                TestQuestionState(
                    question = question,
                    selectedAnswer = null,
                    markedForReview = false
                )
            )

            index++
        }

        return testQuestions
    }

    fun selectAnswer(answer: Int) {

        val list = _questions.value.toMutableList()

        val currentIndex = _currentIndex.value

        val current = list.getOrNull(currentIndex)
            ?: return

        if (answer !in current.question.options.indices) {
            return
        }

        list[currentIndex] =
            current.copy(
                selectedAnswer = answer
            )

        _questions.value = list
    }

    fun getSelectedAnswer(index: Int): Int? {
        return _questions.value
            .getOrNull(index)
            ?.selectedAnswer
    }

    fun nextQuestion() {

        if (_currentIndex.value < _questions.value.lastIndex) {
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

    fun goToQuestion(index: Int) {

        if (index in _questions.value.indices) {
            _currentIndex.value = index
        }
    }

    fun toggleMarkForReview() {

        val list = _questions.value.toMutableList()

        val currentIndex = _currentIndex.value

        val current = list.getOrNull(currentIndex)
            ?: return

        list[currentIndex] =
            current.copy(
                markedForReview = !current.markedForReview
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
        if (!_isFinished.value) {
            _isFinished.value = true
        }
    }

    fun restartTest() {

        val resetQuestions =
            _questions.value.map { state ->
                state.copy(
                    selectedAnswer = null,
                    markedForReview = false
                )
            }

        _questions.value = resetQuestions
        _currentIndex.value = 0
        _timeRemaining.value = TEST_DURATION_SECONDS
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
        return _questions.value.count { state ->

            val selected = state.selectedAnswer

            selected != null &&
                selected == state.question.correctAnswer
        }
    }

    fun getWrongCount(): Int {
        return _questions.value.count { state ->

            val selected = state.selectedAnswer

            selected != null &&
                selected != state.question.correctAnswer
        }
    }

    fun getPercentage(): Int {

        val total = _questions.value.size

        if (total == 0) {
            return 0
        }

        return ((getCorrectCount() * 100.0) / total).toInt()
    }

    companion object {
        private const val TEST_SIZE = 50
        private const val TEST_DURATION_SECONDS = 50 * 60
    }
}
