package ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
//import notesmanager.composeapp.generated.resources.Res
//import notesmanager.composeapp.generated.resources.back_button
//import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navigationController: NavController
) {
    val backStackEntry by navigationController.currentBackStackEntryAsState()

    val canNavigateBack = backStackEntry?.destination?.route != "allNotes"
    TopAppBar(
        title = { Text("Notes") },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = { navigationController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "",
                    )
                }
            }
        },
        actions = {
            if (!canNavigateBack) {
                IconButton(onClick = { navigationController.navigate("createNote") }) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = ""
                    )
                }
            }
        }
    )
}