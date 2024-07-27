package ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.Note
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AllNotesViewPreview() {
    AllNotesView(
        notes = (0..100).map { Note("id$it", "Title $it", "Content $it") },
        onNoteClick = {},
        onNoteDeleted = {},
    )
}


data class Note(
    val id: String,
    val title: String,
    val content: String
) {
    companion object
}

@Composable
fun AllNotesView(
    notes: List<Note>,
    onNoteClick: (Note) -> Unit,
    onNoteDeleted: (Note) -> Unit = {},
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        notes.map {
            item {
                NoteView(it, onNoteClick, onNoteDeleted)
            }
        }
    }
}