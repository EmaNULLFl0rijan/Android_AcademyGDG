package hr.ferit.emanuelflorijan.myapplication.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotesRepository {
    private val _notesList = mutableListOf(
        Note(1, "Prva", "Opis 1"),
        Note(2, "Druga", "Opis 2"),
        Note(3, "Treća", "Opis 3")
    )

    private val _notesFlow = MutableStateFlow<List<Note>>(_notesList.toList())
    val notesFlow: StateFlow<List<Note>> = _notesFlow.asStateFlow()

    fun getNote(id: Int): Note? {
        return _notesList.find { it.id == id }
    }

    fun saveNote(id: Int, title: String, content: String) {
        if (id == -1) {
            val newId = if (_notesList.isEmpty()) 1 else _notesList.maxOf { it.id } + 1
            _notesList.add(Note(newId, title, content))
        } else {
            val index = _notesList.indexOfFirst { it.id == id }
            if (index != -1) {
                val existingNote = _notesList[index]
                _notesList[index] = existingNote.copy(title = title, content = content)
            }
        }
        _notesFlow.value = _notesList.toList()
    }
}

object DependencyProvider {
    val notesRepository: NotesRepository by lazy {
        NotesRepository()
    }
}