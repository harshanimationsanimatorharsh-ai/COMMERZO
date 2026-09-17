package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ChapterData
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.CurriculumKey
import com.commerzo.app.data.model.SubjectData

class CurriculumRepository {

    private val subjectRepository = SubjectRepository()
    private val chapterRepository = ChapterRepository()

    fun getSubjects(
        board: Board,
        classLevel: ClassLevel
    ): List<SubjectData> {
        return subjectRepository.getSubjects(
            board = board,
            classLevel = classLevel
        )
    }

    fun getChapters(
        subjectId: String,
        board: Board,
        classLevel: ClassLevel
    ): List<ChapterData> {
        return chapterRepository.getChapters(
            subjectId = subjectId,
            board = board,
            classLevel = classLevel
        )
    }

    fun getAllChapters(
        board: Board,
        classLevel: ClassLevel
    ): Map<String, List<ChapterData>> {
        return getSubjects(board, classLevel).associate { subject ->
            subject.id to getChapters(
                subjectId = subject.id,
                board = board,
                classLevel = classLevel
            )
        }
    }

    fun findChapter(
        key: CurriculumKey
    ): ChapterData? {
        return getChapters(
            subjectId = key.subjectId,
            board = key.board,
            classLevel = key.classLevel
        ).firstOrNull { chapter ->
            chapter.id == key.chapterId
        }
    }

    fun isValidChapter(
        key: CurriculumKey
    ): Boolean {
        return findChapter(key) != null
    }
}
