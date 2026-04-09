package hr.ferit.emanuelflorijan.myapplication.ui.Zadatak_2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotesViewModel : ViewModel() {
    private val _notes = MutableStateFlow<List<Note>>(
        listOf(
            Note(1, "Prva", "Opis 1"),
            Note(2, "Druga", "Opis 2"),
            Note(3, "Treća", "Opis 3")
        )
    )
    val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    fun getNote(id: Int): Note? {
        return _notes.value.find { it.id == id }
    }

    fun saveNote(id: Int, title: String, description: String) {
        val currentNotes = _notes.value.toMutableList()

        if (id == -1) {
            val newId = if (currentNotes.isEmpty()) 1 else currentNotes.maxOf { it.id } + 1
            currentNotes.add(Note(newId, title, description))
        } else {
            val index = currentNotes.indexOfFirst { it.id == id }
            if (index != -1) {
                currentNotes[index] = Note(id, title, description)
            }
        }
        _notes.value = currentNotes
    }
}