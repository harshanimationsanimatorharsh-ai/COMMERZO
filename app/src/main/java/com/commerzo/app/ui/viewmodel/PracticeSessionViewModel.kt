package com.commerzo.app.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.repository.QuestionBankManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PracticeSessionViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val questionBankManager = QuestionBankManager()

    private val preferences =
        application.getSharedPreferences(
            PREFS_NAME,
            Application.MODE_PRIVATE
        )

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

    private val _answeredQuestions =
        MutableStateFlow<Set<String>>(emptySet())

    val answeredQuestions: StateFlow<Set<String>> =
        _answeredQuestions.asStateFlow()

    private val _isFinished =
        MutableStateFlow(false)

    val isFinished: StateFlow<Boolean> =
        _isFinished.asStateFlow()

    private val _bookmarkedQuestions =
        MutableStateFlow(
            loadBookmarks()
        )

    val bookmarkedQuestions: StateFlow<Set<String>> =
        _bookmarkedQuestions.asStateFlow()

    fun loadQuestions(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ) {

        val loadedQuestions =
            questionBankManager.getRandomizedValidatedQuestions(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )

        _questions.value = loadedQuestions

        resetSession()
    }

    fun selectAnswer(index: Int) {

        if (_submitted.value || _isFinished.value) {
            return
        }

        val currentQuestion =
            _questions.value.getOrNull(
                _currentIndex.value
            ) ?: return

        if (index !in currentQuestion.options.indices) {
            return
        }

        _selectedAnswer.value = index
    }

    fun submitAnswer() {

        if (_submitted.value || _isFinished.value) {
            return
        }

        val selected =
            _selectedAnswer.value ?: return

        val currentQuestion =
            _questions.value.getOrNull(
                _currentIndex.value
            ) ?: return

        val updatedAnswered =
            _answeredQuestions.value.toMutableSet()

        updatedAnswered.add(
            currentQuestion.id
        )

        _answeredQuestions.value =
            updatedAnswered

        if (
            selected ==
            currentQuestion.correctAnswer
        ) {
            _correctAnswers.value += 1
        } else {
            _wrongAnswers.value += 1
        }

        _submitted.value = true
    }

    fun nextQuestion() {

        if (!_submitted.value) {
            return
        }

        val nextIndex =
            _currentIndex.value + 1

        if (
            nextIndex >=
            _questions.value.size
        ) {

            _isFinished.value = true

        } else {

            _currentIndex.value = nextIndex
            _selectedAnswer.value = null
            _submitted.value = false
        }
    }

    fun previousQuestion() {

        if (_currentIndex.value <= 0) {
            return
        }

        _currentIndex.value -= 1

        val currentQuestion =
            _questions.value.getOrNull(
                _currentIndex.value
            ) ?: return

        _selectedAnswer.value = null

        _submitted.value =
            _answeredQuestions.value
                .contains(currentQuestion.id)
    }

    fun toggleBookmark() {

        val currentQuestion =
            _questions.value.getOrNull(
                _currentIndex.value
            ) ?: return

        val updatedBookmarks =
            _bookmarkedQuestions.value
                .toMutableSet()

        if (
            updatedBookmarks.contains(
                currentQuestion.id
            )
        ) {

            updatedBookmarks.remove(
                currentQuestion.id
            )

        } else {

            updatedBookmarks.add(
                currentQuestion.id
            )
        }

        val finalBookmarks =
            updatedBookmarks.toSet()

        _bookmarkedQuestions.value =
            finalBookmarks

        saveBookmarks(finalBookmarks)
    }

    fun removeBookmark(
        questionId: String
    ) {

        if (
            !_bookmarkedQuestions.value
                .contains(questionId)
        ) {
            return
        }

        val updatedBookmarks =
            _bookmarkedQuestions.value
                .toMutableSet()

        updatedBookmarks.remove(
            questionId
        )

        val finalBookmarks =
            updatedBookmarks.toSet()

        _bookmarkedQuestions.value =
            finalBookmarks

        saveBookmarks(finalBookmarks)
    }

    fun clearAllBookmarks() {

        _bookmarkedQuestions.value =
            emptySet()

        saveBookmarks(
            emptySet()
        )
    }

    fun isCurrentQuestionBookmarked(): Boolean {

        val currentQuestion =
            _questions.value.getOrNull(
                _currentIndex.value
            ) ?: return false

        return _bookmarkedQuestions.value
            .contains(currentQuestion.id)
    }

    fun getAnsweredCount(): Int {
        return _answeredQuestions.value.size
    }

    fun getProgressPercent(): Int {

        val total =
            _questions.value.size

        if (total == 0) {
            return 0
        }

        return (
            _answeredQuestions.value.size * 100
                / total
            )
    }

    fun resetSession() {

        _currentIndex.value = 0
        _selectedAnswer.value = null
        _submitted.value = false
        _correctAnswers.value = 0
        _wrongAnswers.value = 0
        _unattemptedAnswers.value = 0
        _answeredQuestions.value = emptySet()
        _isFinished.value = false
    }

    fun restart() {
        resetSession()
    }

    private fun loadBookmarks(): Set<String> {

        return preferences
            .getStringSet(
                BOOKMARKS_KEY,
                emptySet()
            )
            ?.toSet()
            ?: emptySet()
    }

    private fun saveBookmarks(
        bookmarks: Set<String>
    ) {

        preferences
            .edit()
            .putStringSet(
                BOOKMARKS_KEY,
                bookmarks
            )
            .apply()
    }

    companion object {

        private const val PREFS_NAME =
            "commerzo_practice_preferences"

        private const val BOOKMARKS_KEY =
            "bookmarked_questions"
    }
}
