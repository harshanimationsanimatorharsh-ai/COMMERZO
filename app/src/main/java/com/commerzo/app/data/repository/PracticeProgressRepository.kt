package com.commerzo.app.data.repository

import android.content.Context
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import org.json.JSONArray
import org.json.JSONObject

data class PracticeProgress(
    val subjectId: String,
    val chapterId: String,
    val board: Board,
    val classLevel: ClassLevel,
    val totalQuestions: Int,
    val answered: Int,
    val correct: Int,
    val wrong: Int,
    val percentage: Int,
    val lastUpdated: Long
)

object PracticeProgressRepository {

    private const val PREFS_NAME =
        "commerzo_practice_progress"

    private const val PROGRESS_KEY =
        "chapter_progress"

    fun saveProgress(
        context: Context,
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel,
        totalQuestions: Int,
        answered: Int,
        correct: Int,
        wrong: Int
    ) {
        val preferences =
            context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )

        val progressList =
            loadAllProgress(context)
                .toMutableList()

        val percentage =
            if (totalQuestions > 0) {
                correct * 100 / totalQuestions
            } else {
                0
            }

        val progress =
            PracticeProgress(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                totalQuestions = totalQuestions,
                answered = answered,
                correct = correct,
                wrong = wrong,
                percentage = percentage,
                lastUpdated = System.currentTimeMillis()
            )

        progressList.removeAll {
            it.subjectId == subjectId &&
                it.chapterId == chapterId &&
                it.board == board &&
                it.classLevel == classLevel
        }

        progressList.add(progress)

        saveAllProgress(
            context = context,
            progressList = progressList
        )
    }

    fun getProgress(
        context: Context,
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel
    ): PracticeProgress? {

        return loadAllProgress(context)
            .firstOrNull {
                it.subjectId == subjectId &&
                    it.chapterId == chapterId &&
                    it.board == board &&
                    it.classLevel == classLevel
            }
    }

    fun getChapterProgressPercent(
        context: Context,
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel
    ): Int {

        return getProgress(
            context = context,
            subjectId = subjectId,
            chapterId = chapterId,
            board = board,
            classLevel = classLevel
        )?.percentage ?: 0
    }

    fun getAllProgress(
        context: Context
    ): List<PracticeProgress> {
        return loadAllProgress(context)
    }

    fun clearProgress(
        context: Context,
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel
    ) {

        val updated =
            loadAllProgress(context)
                .filterNot {
                    it.subjectId == subjectId &&
                        it.chapterId == chapterId &&
                        it.board == board &&
                        it.classLevel == classLevel
                }

        saveAllProgress(
            context = context,
            progressList = updated
        )
    }

    fun clearAllProgress(
        context: Context
    ) {
        context
            .getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            .edit()
            .remove(PROGRESS_KEY)
            .apply()
    }

    private fun loadAllProgress(
        context: Context
    ): List<PracticeProgress> {

        val preferences =
            context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )

        val stored =
            preferences.getString(
                PROGRESS_KEY,
                null
            ) ?: return emptyList()

        return try {

            val array =
                JSONArray(stored)

            val result =
                mutableListOf<PracticeProgress>()

            for (
                index in
                0 until array.length()
            ) {

                val json =
                    array.optJSONObject(index)
                        ?: continue

                val board =
                    try {
                        Board.valueOf(
                            json.optString("board")
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

                result.add(
                    PracticeProgress(
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
                        percentage =
                            json.optInt(
                                "percentage"
                            ),
                        lastUpdated =
                            json.optLong(
                                "lastUpdated"
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

    private fun saveAllProgress(
        context: Context,
        progressList: List<PracticeProgress>
    ) {

        val array =
            JSONArray()

        progressList.forEach { progress ->

            val json =
                JSONObject()

            json.put(
                "subjectId",
                progress.subjectId
            )

            json.put(
                "chapterId",
                progress.chapterId
            )

            json.put(
                "board",
                progress.board.name
            )

            json.put(
                "classLevel",
                progress.classLevel.name
            )

            json.put(
                "totalQuestions",
                progress.totalQuestions
            )

            json.put(
                "answered",
                progress.answered
            )

            json.put(
                "correct",
                progress.correct
            )

            json.put(
                "wrong",
                progress.wrong
            )

            json.put(
                "percentage",
                progress.percentage
            )

            json.put(
                "lastUpdated",
                progress.lastUpdated
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
                PROGRESS_KEY,
                array.toString()
            )
            .apply()
    }
}
