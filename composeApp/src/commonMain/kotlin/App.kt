@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import data.Note
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.Navigation
import ui.NotesViewModel
import ui.TopBar

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navigationController = rememberNavController()
        val viewModel = viewModel { NotesViewModel() }
        Scaffold(
            topBar = { TopBar(navigationController) }
        ) { innerPadding ->
            Navigation(
                navigationController = navigationController,
                viewModel = viewModel,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

















