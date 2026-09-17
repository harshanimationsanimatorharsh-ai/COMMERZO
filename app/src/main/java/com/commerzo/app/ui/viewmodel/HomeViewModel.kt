package com.commerzo.app.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.SubjectData
import com.commerzo.app.data.repository.SubjectRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    private val subjectRepository = SubjectRepository()

    private val _selectedBoard = MutableStateFlow(Board.MP_BOARD)
    val selectedBoard: StateFlow<Board> = _selectedBoard.asStateFlow()

    private val _selectedClass = MutableStateFlow(ClassLevel.CLASS_12)
    val selectedClass: StateFlow<ClassLevel> = _selectedClass.asStateFlow()

    private val _subjects = MutableStateFlow(
        subjectRepository.getSubjects(
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12
        )
    )
    val subjects: StateFlow<List<SubjectData>> = _subjects.asStateFlow()

    fun setBoard(board: Board) {
        _selectedBoard.value = board
        refreshSubjects()
    }

    fun setClassLevel(classLevel: ClassLevel) {
        _selectedClass.value = classLevel
        refreshSubjects()
    }

    private fun refreshSubjects() {
        _subjects.value = subjectRepository.getSubjects(
            board = _selectedBoard.value,
            classLevel = _selectedClass.value
        )
    }
}
