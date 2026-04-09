package hr.ferit.emanuelflorijan.myapplication.ui.Zadatak_2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MainApp(viewModel: NotesViewModel = viewModel()) {
    val navController = rememberNavController()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "toDo",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("toDo") {
                ToDoScreen(navController = navController, viewModel = viewModel)
            }

            composable(
                route = "editAdd/{noteId}",
                arguments = listOf(navArgument("noteId") { type = NavType.IntType })
            ) { backStackEntry ->
                val noteId = backStackEntry.arguments?.getInt("noteId") ?: -1
                EditAddScreen(
                    navController = navController,
                    viewModel = viewModel,
                    noteId = noteId
                )
            }
        }
    }
}