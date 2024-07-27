package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.Note
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun NoteDetailsViewPreview() {
    NoteDetailsView(
        note = Note(
            id = "id",
            title = "Title",
            content = "Content"
        ),
        onEditClick = { }
    )
}

@Composable
fun NoteDetailsView(
    note: Note,
    onEditClick: (Note) -> Unit,
) {
    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize()
    ) {
        Text(note.title)
        Text(note.content)
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { onEditClick(note) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Edit")
        }
    }
}