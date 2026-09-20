package com.commerzo.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.SubjectData
import com.commerzo.app.data.repository.content.ContentManager
import com.commerzo.app.data.repository.content.CurriculumContentMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SubjectSelectionViewModel : ViewModel() {

    private val contentManager = ContentManager()

    private val _selectedBoard = MutableStateFlow(Board.MP_BOARD)
    val selectedBoard: StateFlow<Board> =
        _selectedBoard.asStateFlow()

    private val _selectedClass = MutableStateFlow(ClassLevel.CLASS_12)
    val selectedClass: StateFlow<ClassLevel> =
        _selectedClass.asStateFlow()

    private val _subjects =
        MutableStateFlow<List<SubjectData>>(emptyList())

    val subjects: StateFlow<List<SubjectData>> =
        _subjects.asStateFlow()

    init {
        refreshSubjects()
    }

    fun setBoard(board: Board) {
        _selectedBoard.value = board
        refreshSubjects()
    }

    fun setClassLevel(classLevel: ClassLevel) {
        _selectedClass.value = classLevel
        refreshSubjects()
    }

    fun setSelection(
        board: Board,
        classLevel: ClassLevel
    ) {
        _selectedBoard.value = board
        _selectedClass.value = classLevel
        refreshSubjects()
    }

    private fun refreshSubjects() {

        val board = _selectedBoard.value
        val classLevel = _selectedClass.value

        viewModelScope.launch {

            val boardId =
                CurriculumContentMapper.getBoardId(board)

            val classId =
                CurriculumContentMapper.getClassId(classLevel)

            val contentSubjects =
                contentManager.getSubjects(
                    boardId = boardId,
                    classId = classId
                )

            val mappedSubjects =
                contentSubjects.map { subject ->

                    val chapters =
                        contentManager.getChapters(
                            boardId = boardId,
                            classId = classId,
                            subjectId = subject.id
                        )

                    SubjectData(
                        id = subject.id,
                        name = subject.name,
                        emoji = subject.emoji,
                        board = board,
                        classLevel = classLevel,
                        chaptersCount = chapters.size
                    )
                }

            _subjects.value = mappedSubjects
        }
    }
}
