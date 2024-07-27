package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    navigationController: NavHostController,
    viewModel: NotesViewModel,
    modifier: Modifier = Modifier,
) {
    val notes by viewModel.notes.collectAsState()
    NavHost(
        navController = navigationController,
        startDestination = "allNotes",
        modifier = modifier,
    ) {
        composable("allNotes") {
            SideEffect { viewModel.loadNotes() }

            AllNotesView(
                notes = notes,
                onNoteClick = { note ->
                    navigationController.navigate("noteDetails/${note.id}")
                },
                onNoteDeleted = { note ->
                    viewModel.delete(note)
                },
            )
        }
        composable("noteDetails/{noteId}") { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId") ?: ""
            val note = notes.find { it.id == noteId }!!
            NoteDetailsView(note) { updatedNote ->
                navigationController.navigate("noteEditor/${updatedNote.id}")
            }
        }
        composable("createNote") {
            CreateNoteView { note ->
                viewModel.addNote(note)
                navigationController.popBackStack()
            }
        }
        composable("noteEditor/{noteId}") { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId") ?: ""
            val note = notes.find { it.id == noteId }!!
            NoteEditorView(note) { updatedNote ->
                viewModel.update(updatedNote)
                navigationController.popBackStack()
            }
        }
    }
}