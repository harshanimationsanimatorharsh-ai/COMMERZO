package com.commerzo.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.model.TestQuestionState
import com.commerzo.app.data.repository.QuestionBankManager
import com.commerzo.app.data.repository.content.CurriculumContentIds
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TestViewModel : ViewModel() {

    private val questionBankManager =
        QuestionBankManager()

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
        val questionSubjectId =
            toQuestionSubjectId(subjectId)

        val sourceQuestions =
            questionBankManager
                .getRandomizedValidatedQuestions(
                    subjectId = questionSubjectId,
                    chapterId = chapterId,
                    board = board,
                    classLevel = classLevel
                )

        if (sourceQuestions.isEmpty()) {
            _questions.value = emptyList()
            _currentIndex.value = 0
            _timeRemaining.value =
                TEST_DURATION_SECONDS
            _isFinished.value = false
            return
        }

        val selectedQuestions =
            sourceQuestions
                .distinctBy { it.id }
                .take(TEST_SIZE)

        _questions.value =
            buildTestQuestions(
                selectedQuestions
            )

        _currentIndex.value = 0

        _timeRemaining.value =
            calculateTestDuration(
                _questions.value.size
            )

        _isFinished.value = false
    }

    private fun toQuestionSubjectId(
        subjectId: String
    ): String {
        return when (subjectId) {

            CurriculumContentIds
                .MP_BOARD_CLASS_12_ECONOMICS_MICRO,

            CurriculumContentIds
                .MP_BOARD_CLASS_12_ECONOMICS_MACRO,

            CurriculumContentIds
                .CBSE_CLASS_12_ECONOMICS_INDIAN,

            CurriculumContentIds
                .CBSE_CLASS_12_ECONOMICS_MACRO -> {
                "economics"
            }

            else -> subjectId
        }
    }

    private fun buildTestQuestions(
        source: List<Question>
    ): List<TestQuestionState> {
        return source.map { question ->
            TestQuestionState(
                question = question,
                selectedAnswer = null,
                markedForReview = false
            )
        }
    }

    fun selectAnswer(answer: Int) {
        if (_isFinished.value) return

        val list =
            _questions.value.toMutableList()

        val index =
            _currentIndex.value

        val current =
            list.getOrNull(index)
                ?: return

        if (
            answer !in
            current.question.options.indices
        ) {
            return
        }

        list[index] =
            current.copy(
                selectedAnswer = answer
            )

        _questions.value = list
    }

    fun getSelectedAnswer(
        index: Int
    ): Int? =
        _questions.value
            .getOrNull(index)
            ?.selectedAnswer

    fun nextQuestion() {
        if (_questions.value.isEmpty()) return

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

    fun goToQuestion(index: Int) {
        if (
            index in
            _questions.value.indices
        ) {
            _currentIndex.value = index
        }
    }

    fun toggleMarkForReview() {
        val list =
            _questions.value.toMutableList()

        val index =
            _currentIndex.value

        val current =
            list.getOrNull(index)
                ?: return

        list[index] =
            current.copy(
                markedForReview =
                    !current.markedForReview
            )

        _questions.value = list
    }

    fun isCurrentQuestionMarked(): Boolean =
        _questions.value
            .getOrNull(
                _currentIndex.value
            )
            ?.markedForReview
            ?: false

    fun decreaseTimer() {
        if (_isFinished.value) return

        if (_timeRemaining.value > 0) {
            _timeRemaining.value--
        } else {
            finishTest()
        }
    }

    fun finishTest() {
        if (_isFinished.value) return

        _isFinished.value = true
    }

    fun restartTest() {
        if (_questions.value.isEmpty()) return

        _questions.value =
            _questions.value.map {
                it.copy(
                    selectedAnswer = null,
                    markedForReview = false
                )
            }

        _currentIndex.value = 0

        _timeRemaining.value =
            calculateTestDuration(
                _questions.value.size
            )

        _isFinished.value = false
    }

    fun getAnsweredCount(): Int =
        _questions.value.count {
            it.selectedAnswer != null
        }

    fun getUnattemptedCount(): Int =
        _questions.value.count {
            it.selectedAnswer == null
        }

    fun getMarkedCount(): Int =
        _questions.value.count {
            it.markedForReview
        }

    fun getCorrectCount(): Int =
        _questions.value.count {
            val selected =
                it.selectedAnswer

            selected != null &&
                selected ==
                it.question.correctAnswer
        }

    fun getWrongCount(): Int =
        _questions.value.count {
            val selected =
                it.selectedAnswer

            selected != null &&
                selected !=
                it.question.correctAnswer
        }

    fun getPercentage(): Int {
        val total =
            _questions.value.size

        if (total == 0) return 0

        return (
            getCorrectCount() * 100
        ) / total
    }

    fun getTotalQuestions(): Int =
        _questions.value.size

    private fun calculateTestDuration(
        questionCount: Int
    ): Int {
        if (questionCount <= 0) {
            return TEST_DURATION_SECONDS
        }

        return questionCount *
            SECONDS_PER_QUESTION
    }

    companion object {
        private const val TEST_SIZE = 50

        private const val SECONDS_PER_QUESTION =
            60

        private const val TEST_DURATION_SECONDS =
            TEST_SIZE *
                SECONDS_PER_QUESTION
    }
}
