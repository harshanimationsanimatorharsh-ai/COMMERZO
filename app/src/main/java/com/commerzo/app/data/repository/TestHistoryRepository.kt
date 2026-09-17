package com.commerzo.app.data.repository

import android.content.Context
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.json.JSONArray
import org.json.JSONObject

data class TestHistoryItem(
    val id: String,
    val subjectId: String,
    val chapterId: String,
    val board: Board,
    val classLevel: ClassLevel,
    val totalQuestions: Int,
    val answered: Int,
    val correct: Int,
    val wrong: Int,
    val unattempted: Int,
    val marked: Int,
    val percentage: Int,
    val completedAt: Long
)

object TestHistoryRepository {

    private const val PREFS_NAME =
        "commerzo_test_history"

    private const val HISTORY_KEY =
        "test_history"

    private val _history =
        MutableStateFlow<List<TestHistoryItem>>(emptyList())

    val history: StateFlow<List<TestHistoryItem>> =
        _history

    private var initialized = false

    fun initialize(context: Context) {
        if (initialized) return

        _history.value =
            loadHistory(context)

        initialized = true
    }

    fun saveTest(
        context: Context,
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel,
        totalQuestions: Int,
        answered: Int,
        correct: Int,
        wrong: Int,
        unattempted: Int,
        marked: Int
    ) {

        val percentage =
            if (answered > 0) {
                correct * 100 / answered
            } else {
                0
            }

        val item =
            TestHistoryItem(
                id =
                    "${System.currentTimeMillis()}_${subjectId}_${chapterId}",
                subjectId =
                    subjectId,
                chapterId =
                    chapterId,
                board =
                    board,
                classLevel =
                    classLevel,
                totalQuestions =
                    totalQuestions,
                answered =
                    answered,
                correct =
                    correct,
                wrong =
                    wrong,
                unattempted =
                    unattempted,
                marked =
                    marked,
                percentage =
                    percentage,
                completedAt =
                    System.currentTimeMillis()
            )

        val updated =
            listOf(item) +
                _history.value

        _history.value =
            updated

        saveHistory(
            context = context,
            history = updated
        )
    }

    fun getHistory(): List<TestHistoryItem> {
        return _history.value
    }

    fun clearHistory(
        context: Context
    ) {

        _history.value =
            emptyList()

        context
            .getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            .edit()
            .remove(HISTORY_KEY)
            .apply()
    }

    private fun loadHistory(
        context: Context
    ): List<TestHistoryItem> {

        val preferences =
            context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )

        val stored =
            preferences.getString(
                HISTORY_KEY,
                null
            ) ?: return emptyList()

        return try {

            val array =
                JSONArray(stored)

            val result =
                mutableListOf<TestHistoryItem>()

            for (
                index in
                0 until array.length()
            ) {

                val json =
                    array.optJSONObject(index)
                        ?: continue

                val subjectId =
                    json.optString(
                        "subjectId"
                    )

                val chapterId =
                    json.optString(
                        "chapterId"
                    )

                if (
                    subjectId.isBlank() ||
                    chapterId.isBlank()
                ) {
                    continue
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

                result.add(
                    TestHistoryItem(
                        id =
                            json.optString(
                                "id",
                                "${System.currentTimeMillis()}_$index"
                            ),
                        subjectId =
                            subjectId,
                        chapterId =
                            chapterId,
                        board =
                            board,
                        classLevel =
                            classLevel,
                        totalQuestions =
                            json.optInt(
                                "totalQuestions"
                            ),
                        answered =
                            json.optInt(
                                "answered"
                            ),
                        correct =
                            json.optInt(
                                "correct"
                            ),
                        wrong =
                            json.optInt(
                                "wrong"
                            ),
                        unattempted =
                            json.optInt(
                                "unattempted"
                            ),
                        marked =
                            json.optInt(
                                "marked"
                            ),
                        percentage =
                            json.optInt(
                                "percentage"
                            ),
                        completedAt =
                            json.optLong(
                                "completedAt"
                            )
                    )
                )
            }

            result

        } catch (
            _: Exception
        ) {
            emptyList()
        }
    }

    private fun saveHistory(
        context: Context,
        history: List<TestHistoryItem>
    ) {

        val array =
            JSONArray()

        history.forEach { item ->

            val json =
                JSONObject()

            json.put(
                "id",
                item.id
            )

            json.put(
                "subjectId",
                item.subjectId
            )

            json.put(
                "chapterId",
                item.chapterId
            )

            json.put(
                "board",
                item.board.name
            )

            json.put(
                "classLevel",
                item.classLevel.name
            )

            json.put(
                "totalQuestions",
                item.totalQuestions
            )

            json.put(
                "answered",
                item.answered
            )

            json.put(
                "correct",
                item.correct
            )

            json.put(
                "wrong",
                item.wrong
            )

            json.put(
                "unattempted",
                item.unattempted
            )

            json.put(
                "marked",
                item.marked
            )

            json.put(
                "percentage",
                item.percentage
            )

            json.put(
                "completedAt",
                item.completedAt
            )

            array.put(json)
        }

        context
            .getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            .edit()
            .putString(
                HISTORY_KEY,
                array.toString()
            )
            .apply()
    }
}
