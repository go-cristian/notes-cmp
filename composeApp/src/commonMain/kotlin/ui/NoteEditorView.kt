package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.Note
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NoteEditorView(
    note: Note,
    onNoteSave: (Note) -> Unit,
) {
    var title by remember { mutableStateOf(note.title) }
    var content by remember { mutableStateOf(note.content) }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp).fillMaxSize().imePadding(),
    ) {

        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") }
        )
        TextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Content") }
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { onNoteSave(note.copy(title = title, content = content)) },
            enabled = (title != note.title || content != note.content) && title.isNotBlank() && content.isNotBlank(),
        ) {
            Text("Save")
        }
    }
}

@Composable
@Preview
fun NoteEditorViewPreview() {
    NoteEditorView(
        note = Note(
            id = "id",
            title = "Title",
            content = "Content"
        ),
        onNoteSave = {}
    )
}