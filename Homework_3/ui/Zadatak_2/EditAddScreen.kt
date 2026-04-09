package hr.ferit.emanuelflorijan.myapplication.ui.Zadatak_2

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditAddScreen(navController: NavController, viewModel: NotesViewModel, noteId: Int) {

    val existingNote = if (noteId != -1) viewModel.getNote(noteId) else null

    var title by remember { mutableStateOf(existingNote?.title ?: "") }
    var description by remember { mutableStateOf(existingNote?.description ?: "") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (noteId == -1) "Dodaj bilješku" else "Uredi bilješku") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Natrag")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Unos naslova") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Unos opisa") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            )

            Button(
                onClick = {
                    if (title.isNotBlank() || description.isNotBlank()) {
                        viewModel.saveNote(noteId, title, description) //
                    }
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Done")
            }
        }
    }
}