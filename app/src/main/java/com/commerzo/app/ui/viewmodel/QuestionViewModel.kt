package com.commerzo.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.repository.QuestionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuestionViewModel : ViewModel() {

    private val repository = QuestionRepository()

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions.asStateFlow()

    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex: StateFlow<Int> =
        _currentQuestionIndex.asStateFlow()

    private val _selectedAnswer = MutableStateFlow<Int?>(null)
    val selectedAnswer: StateFlow<Int?> =
        _selectedAnswer.asStateFlow()

    private val _isSubmitted = MutableStateFlow(false)
    val isSubmitted: StateFlow<Boolean> =
        _isSubmitted.asStateFlow()

    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> =
        _score.asStateFlow()

    fun loadQuestions(
        subjectId: String,
        chapterId: String
    ) {
        _questions.value = repository.getQuestions(
            subjectId = subjectId,
            chapterId = chapterId
        )

        _currentQuestionIndex.value = 0
        _selectedAnswer.value = null
        _isSubmitted.value = false
        _score.value = 0
    }

    fun selectAnswer(index: Int) {
        if (!_isSubmitted.value) {
            _selectedAnswer.value = index
        }
    }

    fun submitAnswer() {

        val selected = _selectedAnswer.value ?: return

        if (_isSubmitted.value) return

        val questionsList = _questions.value
        val currentIndex = _currentQuestionIndex.value

        if (questionsList.isEmpty()) return

        val currentQuestion = questionsList[currentIndex]

        if (selected == currentQuestion.correctAnswer) {
            _score.value += 1
        }

        _isSubmitted.value = true
    }

    fun nextQuestion() {

        val nextIndex = _currentQuestionIndex.value + 1

        if (nextIndex < _questions.value.size) {
            _currentQuestionIndex.value = nextIndex
            _selectedAnswer.value = null
            _isSubmitted.value = false
        }
    }

    fun restart() {
        _currentQuestionIndex.value = 0
        _selectedAnswer.value = null
        _isSubmitted.value = false
        _score.value = 0
    }
}
