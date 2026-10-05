package com.commerzo.app.data.repository.firebase

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ChapterData
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.model.QuestionDifficulty
import com.commerzo.app.data.model.Subject
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

/**
 * Firebase/Firestore repository for COMMERZO curriculum data.
 *
 * Firestore collections:
 *
 * subjects/{subjectId}
 * chapters/{chapterId}
 * questions/{questionId}
 *
 * This repository intentionally works with the existing
 * COMMERZO models:
 *
 * Subject
 * ChapterData
 * Question
 *
 * Existing local repositories remain untouched.
 */
class FirebaseCurriculumRepository(
    private val firestore: FirebaseFirestore =
        FirebaseFirestore.getInstance()
) {

    private val subjectsCollection =
        firestore.collection("subjects")

    private val chaptersCollection =
        firestore.collection("chapters")

    private val questionsCollection =
        firestore.collection("questions")

    /**
     * Fetch subjects for a specific board and class.
     */
    suspend fun getSubjects(
        board: Board,
        classLevel: ClassLevel
    ): Result<List<Subject>> {

        return try {
            val snapshot = subjectsCollection
                .whereEqualTo("board", board.name)
                .whereEqualTo("classLevel", classLevel.name)
                .get()
                .await()

            val subjects = snapshot.documents.mapNotNull { document ->
                document.toSubject()
            }

            Result.success(
                subjects.sortedBy { it.name }
            )
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /**
     * Fetch chapters for a specific subject,
     * board and class.
     */
    suspend fun getChapters(
        subjectId: String,
        board: Board,
        classLevel: ClassLevel
    ): Result<List<ChapterData>> {

        return try {
            val snapshot = chaptersCollection
                .whereEqualTo("subjectId", subjectId)
                .whereEqualTo("board", board.name)
                .whereEqualTo("classLevel", classLevel.name)
                .get()
                .await()

            val chapters = snapshot.documents.mapNotNull { document ->
                document.toChapterData()
            }

            Result.success(
                chapters.sortedBy { it.chapterNumber }
            )
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /**
     * Fetch questions for a specific chapter,
     * subject, board and class.
     */
    suspend fun getQuestions(
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel
    ): Result<List<Question>> {

        return try {
            val snapshot = questionsCollection
                .whereEqualTo("subjectId", subjectId)
                .whereEqualTo("chapterId", chapterId)
                .whereEqualTo("board", board.name)
                .whereEqualTo("classLevel", classLevel.name)
                .get()
                .await()

            val questions = snapshot.documents.mapNotNull { document ->
                document.toQuestion()
            }

            Result.success(questions)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /**
     * Fetch all questions for a subject,
     * board and class.
     */
    suspend fun getSubjectQuestions(
        subjectId: String,
        board: Board,
        classLevel: ClassLevel
    ): Result<List<Question>> {

        return try {
            val snapshot = questionsCollection
                .whereEqualTo("subjectId", subjectId)
                .whereEqualTo("board", board.name)
                .whereEqualTo("classLevel", classLevel.name)
                .get()
                .await()

            val questions = snapshot.documents.mapNotNull { document ->
                document.toQuestion()
            }

            Result.success(questions)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /**
     * Fetch one subject by ID.
     */
    suspend fun getSubject(
        subjectId: String
    ): Result<Subject?> {

        return try {
            val document =
                subjectsCollection
                    .document(subjectId)
                    .get()
                    .await()

            Result.success(
                if (document.exists()) {
                    document.toSubject()
                } else {
                    null
                }
            )
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /**
     * Fetch one chapter by ID.
     */
    suspend fun getChapter(
        chapterId: String
    ): Result<ChapterData?> {

        return try {
            val document =
                chaptersCollection
                    .document(chapterId)
                    .get()
                    .await()

            Result.success(
                if (document.exists()) {
                    document.toChapterData()
                } else {
                    null
                }
            )
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /**
     * Fetch one question by ID.
     */
    suspend fun getQuestion(
        questionId: String
    ): Result<Question?> {

        return try {
            val document =
                questionsCollection
                    .document(questionId)
                    .get()
                    .await()

            Result.success(
                if (document.exists()) {
                    document.toQuestion()
                } else {
                    null
                }
            )
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /**
     * Converts a Firestore document into the existing
     * COMMERZO Subject model.
     */
    private fun com.google.firebase.firestore.DocumentSnapshot.toSubject():
        Subject? {

        val id =
            getString("id")
                ?: id

        val name =
            getString("name")
                ?: return null

        val icon =
            getString("icon")
                ?: ""

        val board =
            parseBoard(getString("board"))
                ?: return null

        val classLevel =
            parseClassLevel(getString("classLevel"))
                ?: return null

        return Subject(
            id = id,
            name = name,
            icon = icon,
            classLevel = classLevel,
            board = board
        )
    }

    /**
     * Converts a Firestore document into the existing
     * COMMERZO ChapterData model.
     */
    private fun com.google.firebase.firestore.DocumentSnapshot.toChapterData():
        ChapterData? {

        val id =
            getString("id")
                ?: id

        val subjectId =
            getString("subjectId")
                ?: return null

        val title =
            getString("title")
                ?: return null

        val chapterNumber =
            getLong("chapterNumber")?.toInt()
                ?: return null

        val board =
            parseBoard(getString("board"))
                ?: return null

        val classLevel =
            parseClassLevel(getString("classLevel"))
                ?: return null

        return ChapterData(
            id = id,
            subjectId = subjectId,
            title = title,
            chapterNumber = chapterNumber,
            board = board,
            classLevel = classLevel
        )
    }

    /**
     * Converts a Firestore document into the existing
     * COMMERZO Question model.
     */
    private fun com.google.firebase.firestore.DocumentSnapshot.toQuestion():
        Question? {

        val id =
            getString("id")
                ?: id

        val question =
            getString("question")
                ?: return null

        val options =
            get("options") as? List<*>
                ?: return null

        val correctAnswer =
            getLong("correctAnswer")?.toInt()
                ?: return null

        val explanation =
            getString("explanation")
                ?: ""

        val subjectId =
            getString("subjectId")
                ?: return null

        val chapterId =
            getString("chapterId")
                ?: return null

        val board =
            parseBoard(getString("board"))
                ?: return null

        val classLevel =
            parseClassLevel(getString("classLevel"))
                ?: return null

        val difficulty =
            parseQuestionDifficulty(
                getString("difficulty")
            ) ?: QuestionDifficulty.MEDIUM

        val tags =
            (get("tags") as? List<*>)
                ?.mapNotNull { it as? String }
                ?: emptyList()

        return Question(
            id = id,
            question = question,
            options = options.mapNotNull { it as? String },
            correctAnswer = correctAnswer,
            explanation = explanation,
            subjectId = subjectId,
            chapterId = chapterId,
            board = board,
            classLevel = classLevel,
            difficulty = difficulty,
            tags = tags
        )
    }

    private fun parseBoard(
        value: String?
    ): Board? {

        return when (value) {
            Board.CBSE.name -> Board.CBSE
            Board.MP_BOARD.name -> Board.MP_BOARD
            else -> null
        }
    }

    private fun parseClassLevel(
        value: String?
    ): ClassLevel? {

        return when (value) {
            ClassLevel.CLASS_11.name -> ClassLevel.CLASS_11
            ClassLevel.CLASS_12.name -> ClassLevel.CLASS_12
            else -> null
        }
    }

    private fun parseQuestionDifficulty(
        value: String?
    ): QuestionDifficulty? {

        return when (value) {
            QuestionDifficulty.EASY.name ->
                QuestionDifficulty.EASY

            QuestionDifficulty.MEDIUM.name ->
                QuestionDifficulty.MEDIUM

            QuestionDifficulty.HARD.name ->
                QuestionDifficulty.HARD

            else -> null
        }
    }
}
