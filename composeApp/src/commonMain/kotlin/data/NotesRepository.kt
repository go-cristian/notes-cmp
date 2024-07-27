package data

import kotlinx.coroutines.delay

class NotesRepository {
    private val notes = mutableListOf<Note>()
    suspend fun save(note: Note) {
        // Save the note, add some delay
        notes.add(note)
        delay(1000)
    }

    suspend fun update(note: Note) {
        // Update the note, add some delay
        val index = notes.indexOfFirst { it.id == note.id }
        notes[index] = note
        delay(1000)
    }

    suspend fun delete(note: Note) {
        // Delete the note, add some delay
        notes.remove(note)
        delay(1000)
    }

    suspend fun getNotes(): List<Note> {
        // Get the notes, add some delay
        if (notes.isEmpty()) {
            notes.addAll((0..5).map {
                Note(
                    id = createRandomID(),
                    title = "Title $it",
                    content = "Content $it"
                )
            })
            delay(10000)
        }
        return notes
    }
}
