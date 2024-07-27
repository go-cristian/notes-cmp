package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import data.Note
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NoteView(
    note: Note,
    onNoteClick: (Note) -> Unit,
    onNoteDeleted: (Note) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth().clickable { onNoteClick(note) }
    ) {
        Row {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(note.title)
                Text(note.content)
            }
            IconButton(onClick = { onNoteDeleted(note) }) {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = "Delete"
                )
            }
        }
        Divider()
    }
}

@Composable
@Preview
fun NoteViewPreview() {
    NoteView(
        note = Note(
            id = "id",
            title = "Title",
            content = "Content"
        ),
        onNoteClick = {},
        onNoteDeleted = {},
    )
}