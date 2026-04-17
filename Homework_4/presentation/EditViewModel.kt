package hr.ferit.emanuelflorijan.myapplication.presentation

import androidx.lifecycle.ViewModel
import hr.ferit.emanuelflorijan.myapplication.model.DependencyProvider
import hr.ferit.emanuelflorijan.myapplication.model.Note

class EditViewModel : ViewModel() {
    private val repository = DependencyProvider.notesRepository

    fun getNote(id: Int): Note? {
        return repository.getNote(id)
    }

    fun saveNote(id: Int, title: String, content: String) {
        repository.saveNote(id, title, content)
    }
}