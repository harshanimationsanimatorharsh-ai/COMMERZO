package com.commerzo.app.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.repository.PracticeProgressRepository
import com.commerzo.app.data.repository.QuestionBankManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.json.JSONArray
import org.json.JSONObject

data class PracticeAnswerState(
    val selectedAnswer: Int? = null,
    val submitted: Boolean = false
)

class PracticeSessionViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val questionBankManager =
        QuestionBankManager()

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

    private val _answerStates =
        MutableStateFlow<List<PracticeAnswerState>>(emptyList())

    val answerStates: StateFlow<List<PracticeAnswerState>> =
        _answerStates.asStateFlow()

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

    private val _bookmarkedQuestionDetails =
        MutableStateFlow(
            loadBookmarkedQuestionDetails()
        )

    val bookmarkedQuestionDetails: StateFlow<List<Question>> =
        _bookmarkedQuestionDetails.asStateFlow()

    private val _progressPercent =
        MutableStateFlow(0)

    val progressPercent: StateFlow<Int> =
        _progressPercent.asStateFlow()

    private var currentSubjectId: String? = null
    private var currentChapterId: String? = null
    private var currentBoard: Board = Board.MP_BOARD
    private var currentClassLevel: ClassLevel =
        ClassLevel.CLASS_12

    init {
        recalculateResults()
    }

    fun loadQuestions(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ) {
        currentSubjectId = subjectId
        currentChapterId = chapterId
        currentBoard = board
        currentClassLevel = classLevel

        val loadedQuestions =
            questionBankManager
                .getRandomizedValidatedQuestions(
                    subjectId = subjectId,
                    chapterId = chapterId,
                    board = board,
                    classLevel = classLevel
                )

        _questions.value =
            loadedQuestions

        resetSession()

        loadSavedProgressPercent()
    }

    fun selectAnswer(
        index: Int
    ) {
        if (
            _submitted.value ||
            _isFinished.value
        ) {
            return
        }

        val currentQuestion =
            _questions.value.getOrNull(
                _currentIndex.value
            ) ?: return

        if (
            index !in
            currentQuestion.options.indices
        ) {
            return
        }

        updateCurrentAnswerState(
            selectedAnswer = index,
            submitted = false
        )

        _selectedAnswer.value =
            index
    }

    fun submitAnswer() {
        if (
            _submitted.value ||
            _isFinished.value
        ) {
            return
        }

        val selected =
            _selectedAnswer.value ?: return

        val currentQuestion =
            _questions.value.getOrNull(
                _currentIndex.value
            ) ?: return

        updateCurrentAnswerState(
            selectedAnswer = selected,
            submitted = true
        )

        recalculateResults()

        saveCurrentProgress()

        _submitted.value = true
    }

    fun skipQuestion() {
        if (
            _submitted.value ||
            _isFinished.value
        ) {
            return
        }

        if (
            _questions.value.getOrNull(
                _currentIndex.value
            ) == null
        ) {
            return
        }

        updateCurrentAnswerState(
            selectedAnswer = null,
            submitted = false
        )

        _selectedAnswer.value = null

        recalculateResults()

        saveCurrentProgress()

        val nextIndex =
            _currentIndex.value + 1

        if (
            nextIndex >=
            _questions.value.size
        ) {
            _isFinished.value = true
            recalculateResults()
            saveCurrentProgress()
            return
        }

        _currentIndex.value =
            nextIndex

        restoreCurrentQuestionState()
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

            recalculateResults()
            saveCurrentProgress()

            return
        }

        _currentIndex.value =
            nextIndex

        restoreCurrentQuestionState()
    }

    fun previousQuestion() {
        if (_currentIndex.value <= 0) {
            return
        }

        _currentIndex.value -= 1

        restoreCurrentQuestionState()
    }

    fun goToQuestion(
        index: Int
    ) {
        if (
            index !in
            _questions.value.indices
        ) {
            return
        }

        _currentIndex.value =
            index

        restoreCurrentQuestionState()
    }

    fun toggleBookmark() {
        val currentQuestion =
            _questions.value.getOrNull(
                _currentIndex.value
            ) ?: return

        val updatedBookmarks =
            _bookmarkedQuestions.value
                .toMutableSet()

        val updatedDetails =
            _bookmarkedQuestionDetails.value
                .toMutableList()

        if (
            updatedBookmarks.contains(
                currentQuestion.id
            )
        ) {
            updatedBookmarks.remove(
                currentQuestion.id
            )

            updatedDetails.removeAll {
                it.id == currentQuestion.id
            }
        } else {
            updatedBookmarks.add(
                currentQuestion.id
            )

            updatedDetails.removeAll {
                it.id == currentQuestion.id
            }

            updatedDetails.add(
                currentQuestion
            )
        }

        val finalBookmarks =
            updatedBookmarks.toSet()

        val finalDetails =
            updatedDetails
                .distinctBy { it.id }

        _bookmarkedQuestions.value =
            finalBookmarks

        _bookmarkedQuestionDetails.value =
            finalDetails

        saveBookmarks(
            finalBookmarks
        )

        saveBookmarkedQuestionDetails(
            finalDetails
        )
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

        val updatedDetails =
            _bookmarkedQuestionDetails.value
                .filterNot {
                    it.id == questionId
                }

        val finalBookmarks =
            updatedBookmarks.toSet()

        _bookmarkedQuestions.value =
            finalBookmarks

        _bookmarkedQuestionDetails.value =
            updatedDetails

        saveBookmarks(
            finalBookmarks
        )

        saveBookmarkedQuestionDetails(
            updatedDetails
        )
    }

    fun clearAllBookmarks() {
        _bookmarkedQuestions.value =
            emptySet()

        _bookmarkedQuestionDetails.value =
            emptyList()

        saveBookmarks(
            emptySet()
        )

        saveBookmarkedQuestionDetails(
            emptyList()
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

    fun getUnattemptedCount(): Int {
        return _unattemptedAnswers.value
    }

    fun getCorrectCount(): Int {
        return _correctAnswers.value
    }

    fun getWrongCount(): Int {
        return _wrongAnswers.value
    }

    fun getProgressPercent(): Int {
        return _progressPercent.value
    }

    fun getPercentage(): Int {
        val total =
            _questions.value.size

        if (total == 0) {
            return 0
        }

        return (
            _correctAnswers.value * 100 /
                total
            )
    }

    fun resetSession() {
        _currentIndex.value = 0

        _selectedAnswer.value = null

        _submitted.value = false

        _correctAnswers.value = 0

        _wrongAnswers.value = 0

        _unattemptedAnswers.value =
            _questions.value.size

        _answeredQuestions.value =
            emptySet()

        _progressPercent.value = 0

        _isFinished.value = false

        _answerStates.value =
            List(
                _questions.value.size
            ) {
                PracticeAnswerState()
            }
    }

    fun restart() {
        resetSession()
        loadSavedProgressPercent()
    }

    private fun updateCurrentAnswerState(
        selectedAnswer: Int?,
        submitted: Boolean
    ) {
        val index =
            _currentIndex.value

        val states =
            _answerStates.value
                .toMutableList()

        if (
            index !in states.indices
        ) {
            return
        }

        states[index] =
            PracticeAnswerState(
                selectedAnswer =
                    selectedAnswer,
                submitted =
                    submitted
            )

        _answerStates.value =
            states
    }

    private fun restoreCurrentQuestionState() {
        val state =
            _answerStates.value.getOrNull(
                _currentIndex.value
            ) ?: PracticeAnswerState()

        _selectedAnswer.value =
            state.selectedAnswer

        _submitted.value =
            state.submitted
    }

    private fun recalculateResults() {
        val questionsList =
            _questions.value

        val states =
            _answerStates.value

        var correct = 0
        var wrong = 0

        val answered =
            mutableSetOf<String>()

        questionsList.forEachIndexed { index, question ->

            val state =
                states.getOrNull(index)
                    ?: return@forEachIndexed

            val selected =
                state.selectedAnswer

            if (
                selected != null &&
                state.submitted
            ) {
                answered.add(
                    question.id
                )

                if (
                    selected ==
                    question.correctAnswer
                ) {
                    correct++
                } else {
                    wrong++
                }
            }
        }

        val total =
            questionsList.size

        val answeredCount =
            answered.size

        _correctAnswers.value =
            correct

        _wrongAnswers.value =
            wrong

        _answeredQuestions.value =
            answered

        _unattemptedAnswers.value =
            total - answeredCount

        _progressPercent.value =
            if (total > 0) {
                answeredCount * 100 / total
            } else {
                0
            }
    }

    private fun saveCurrentProgress() {
        val subjectId =
            currentSubjectId ?: return

        val chapterId =
            currentChapterId ?: return

        val total =
            _questions.value.size

        if (total <= 0) {
            return
        }

        PracticeProgressRepository.saveProgress(
            context = getApplication<Application>(),
            subjectId = subjectId,
            chapterId = chapterId,
            board = currentBoard,
            classLevel = currentClassLevel,
            totalQuestions = total,
            answered = _answeredQuestions.value.size,
            correct = _correctAnswers.value,
            wrong = _wrongAnswers.value
        )
    }

    private fun loadSavedProgressPercent() {
        val subjectId =
            currentSubjectId ?: return

        val chapterId =
            currentChapterId ?: return

        val savedProgress =
            PracticeProgressRepository
                .getChapterProgressPercent(
                    context = getApplication<Application>(),
                    subjectId = subjectId,
                    chapterId = chapterId,
                    board = currentBoard,
                    classLevel = currentClassLevel
                )

        if (savedProgress > 0) {
            _progressPercent.value =
                savedProgress
        }
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

    private fun loadBookmarkedQuestionDetails(): List<Question> {
        val stored =
            preferences.getString(
                BOOKMARK_DETAILS_KEY,
                null
            ) ?: return emptyList()

        return try {
            val array =
                JSONArray(stored)

            val questions =
                mutableListOf<Question>()

            for (
                index in
                0 until array.length()
            ) {
                val json =
                    array.optJSONObject(index)
                        ?: continue

                val optionsJson =
                    json.optJSONArray(
                        "options"
                    ) ?: continue

                val options =
                    mutableListOf<String>()

                for (
                    optionIndex in
                    0 until optionsJson.length()
                ) {
                    options.add(
                        optionsJson.optString(
                            optionIndex
                        )
                    )
                }

                val tagsJson =
                    json.optJSONArray(
                        "tags"
                    )

                val tags =
                    mutableListOf<String>()

                if (tagsJson != null) {
                    for (
                        tagIndex in
                        0 until tagsJson.length()
                    ) {
                        tags.add(
                            tagsJson.optString(
                                tagIndex
                            )
                        )
                    }
                }

                val board =
                    try {
                        Board.valueOf(
                            json.optString(
                                "board"
                            )
                        )
                    } catch (
                        _: IllegalArgumentException
                    ) {
                        Board.MP_BOARD
                    }

                val classLevel =
                    try {
                        ClassLevel.valueOf(
                            json.optString(
                                "classLevel"
                            )
                        )
                    } catch (
                        _: IllegalArgumentException
                    ) {
                        ClassLevel.CLASS_12
                    }

                val question =
                    Question(
                        id =
                            json.optString("id"),
                        question =
                            json.optString("question"),
                        options =
                            options,
                        correctAnswer =
                            json.optInt(
                                "correctAnswer"
                            ),
                        explanation =
                            json.optString(
                                "explanation"
                            ),
                        subjectId =
                            json.optString(
                                "subjectId"
                            ),
                        chapterId =
                            json.optString(
                                "chapterId"
                            ),
                        board =
                            board,
                        classLevel =
                            classLevel,
                        tags =
                            tags
                    )

                if (
                    question.id.isNotBlank()
                ) {
                    questions.add(
                        question
                    )
                }
            }

            questions
                .distinctBy { it.id }

        } catch (_: Exception) {
            emptyList()
        }
    }

    private fun saveBookmarkedQuestionDetails(
        questions: List<Question>
    ) {
        val array =
            JSONArray()

        questions
            .distinctBy { it.id }
            .forEach { question ->

                val json =
                    JSONObject()

                json.put(
                    "id",
                    question.id
                )

                json.put(
                    "question",
                    question.question
                )

                val options =
                    JSONArray()

                question.options.forEach {
                    options.put(it)
                }

                json.put(
                    "options",
                    options
                )

                json.put(
                    "correctAnswer",
                    question.correctAnswer
                )

                json.put(
                    "explanation",
                    question.explanation
                )

                json.put(
                    "subjectId",
                    question.subjectId
                )

                json.put(
                    "chapterId",
                    question.chapterId
                )

                json.put(
                    "board",
                    question.board.name
                )

                json.put(
                    "classLevel",
                    question.classLevel.name
                )

                val tags =
                    JSONArray()

                question.tags.forEach {
                    tags.put(it)
                }

                json.put(
                    "tags",
                    tags
                )

                array.put(json)
            }

        preferences
            .edit()
            .putString(
                BOOKMARK_DETAILS_KEY,
                array.toString()
            )
            .apply()
    }

    companion object {

        private const val PREFS_NAME =
            "commerzo_practice_preferences"

        private const val BOOKMARKS_KEY =
            "bookmarked_questions"

        private const val BOOKMARK_DETAILS_KEY =
            "bookmarked_question_details"
    }
}
