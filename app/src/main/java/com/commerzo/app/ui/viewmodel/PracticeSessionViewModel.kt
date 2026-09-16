package com.commerzo.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.repository.QuestionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PracticeSessionViewModel : ViewModel() {

    private val repository = QuestionRepository()

    private val _questions =
        MutableStateFlow<List<Question>>(emptyList())

    val questions: StateFlow<List<Question>> =
        _questions.asStateFlow()

    private val _currentIndex =
        MutableStateFlow(0)

    val currentIndex: StateFlow<Int> =
        _currentIndex.asStateFlow()

    private val _selectedAnswer =
        MutableStateFlow<Int?>(null)

    val selectedAnswer: StateFlow<Int?> =
        _selectedAnswer.asStateFlow()

    private val _submitted =
        MutableStateFlow(false)

    val submitted: StateFlow<Boolean> =
        _submitted.asStateFlow()

    private val _correctAnswers =
        MutableStateFlow(0)

    val correctAnswers: StateFlow<Int> =
        _correctAnswers.asStateFlow()

    private val _wrongAnswers =
        MutableStateFlow(0)

    val wrongAnswers: StateFlow<Int> =
        _wrongAnswers.asStateFlow()

    private val _unattemptedAnswers =
        MutableStateFlow(0)

    val unattemptedAnswers: StateFlow<Int> =
        _unattemptedAnswers.asStateFlow()

    private val _isFinished =
        MutableStateFlow(false)

    val isFinished: StateFlow<Boolean> =
        _isFinished.asStateFlow()

    private val _bookmarkedQuestions =
        MutableStateFlow<Set<String>>(emptySet())

    val bookmarkedQuestions: StateFlow<Set<String>> =
        _bookmarkedQuestions.asStateFlow()

    fun loadQuestions(
        subjectId: String,
        chapterId: String
    ) {

        _questions.value =
            repository.getQuestions(
                subjectId = subjectId,
                chapterId = chapterId
            )

        resetSession()
    }

    fun selectAnswer(index: Int) {

        if (!_submitted.value && !_isFinished.value) {
            _selectedAnswer.value = index
        }
    }

    fun submitAnswer() {

        if (_submitted.value) return

        val selected = _selectedAnswer.value
            ?: run {
                _unattemptedAnswers.value += 1
                return
            }

        val questionsList = _questions.value

        if (questionsList.isEmpty()) return

        val currentQuestion =
            questionsList[_currentIndex.value]

        if (selected == currentQuestion.correctAnswer) {
            _correctAnswers.value += 1
        } else {
            _wrongAnswers.value += 1
        }

        _submitted.value = true
    }

    fun nextQuestion() {

        if (!_submitted.value) return

        val nextIndex =
            _currentIndex.value + 1

        if (nextIndex >= _questions.value.size) {

            _isFinished.value = true

        } else {

            _currentIndex.value = nextIndex
            _selectedAnswer.value = null
            _submitted.value = false
        }
    }

    fun toggleBookmark() {

        val questionsList = _questions.value

        if (questionsList.isEmpty()) return

        val currentQuestion =
            questionsList[_currentIndex.value]

        val currentBookmarks =
            _bookmarkedQuestions.value.toMutableSet()

        if (currentBookmarks.contains(currentQuestion.id)) {
            currentBookmarks.remove(currentQuestion.id)
        } else {
            currentBookmarks.add(currentQuestion.id)
        }

        _bookmarkedQuestions.value =
            currentBookmarks
    }

    fun isCurrentQuestionBookmarked(): Boolean {

        val questionsList = _questions.value

        if (questionsList.isEmpty()) return false

        val currentQuestion =
            questionsList[_currentIndex.value]

        return _bookmarkedQuestions.value
            .contains(currentQuestion.id)
    }

    fun resetSession() {

        _currentIndex.value = 0
        _selectedAnswer.value = null
        _submitted.value = false
        _correctAnswers.value = 0
        _wrongAnswers.value = 0
        _unattemptedAnswers.value = 0
        _isFinished.value = false
    }

    fun restart() {
        resetSession()
    }
}
