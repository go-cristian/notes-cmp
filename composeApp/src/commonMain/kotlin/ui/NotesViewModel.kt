package ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.Note
import data.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NotesViewModel(
    private val notesRepository: NotesRepository = NotesRepository()
) : ViewModel() {

    private val _notes = MutableStateFlow(emptyList<Note>())
    val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    fun loadNotes() {
        viewModelScope.launch {
            _notes.value = notesRepository.getNotes()
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            notesRepository.save(note)
            _notes.value += note
        }
    }

    fun update(updatedNote: Note) {
        viewModelScope.launch {
            notesRepository.update(updatedNote)
            _notes.value = _notes.value.map { if (it.id == updatedNote.id) updatedNote else it }
        }
    }

    fun delete(note: Note) {
        viewModelScope.launch {
            notesRepository.delete(note)
            _notes.value = _notes.value.filter { it.id != note.id }
        }
    }
}