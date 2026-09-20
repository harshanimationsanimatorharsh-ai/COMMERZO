package com.commerzo.app.data.remote.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries

class LocalNetworkContentService : NetworkContentService {

    private val client: NetworkContentClient by lazy {
        NetworkContentClientProvider.getClient()
    }

    override suspend fun getSubjects(
        boardId: String,
        classId: String
    ): List<ContentSubject> {
        return client.getSubjects(boardId, classId)
    }

    override suspend fun getChapters(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<ContentChapter> {
        return client.getChapters(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    override suspend fun getContent(
        boardId: String,
        classId: String,
        subjectId: String,
        chapterId: String
    ): List<ContentItem> {
        return client.getContent(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId,
            chapterId = chapterId
        )
    }

    override suspend fun getPreviousYearPapers(
        boardId: String,
        classId: String,
        subjectId: String?
    ): List<PreviousYearPaper> {
        return client.getPreviousYearPapers(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    override suspend fun getSamplePapers(
        boardId: String,
        classId: String,
        subjectId: String?
    ): List<SamplePaper> {
        return client.getSamplePapers(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    override suspend fun getTestSeries(
        boardId: String,
        classId: String,
        subjectId: String?
    ): List<TestSeries> {
        return client.getTestSeries(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    override suspend fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule> {
        return client.getModules(boardId, classId)
    }
}
