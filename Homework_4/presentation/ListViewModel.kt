package hr.ferit.emanuelflorijan.myapplication.presentation

import androidx.lifecycle.ViewModel
import hr.ferit.emanuelflorijan.myapplication.model.DependencyProvider
import hr.ferit.emanuelflorijan.myapplication.model.Note
import kotlinx.coroutines.flow.StateFlow

class ListViewModel : ViewModel() {
    private val repository = DependencyProvider.notesRepository

    val notes: StateFlow<List<Note>> = repository.notesFlow
}