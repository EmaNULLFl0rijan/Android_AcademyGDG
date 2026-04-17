package hr.ferit.emanuelflorijan.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import hr.ferit.emanuelflorijan.myapplication.presentation.EditViewModel
import hr.ferit.emanuelflorijan.myapplication.presentation.ListViewModel
import hr.ferit.emanuelflorijan.myapplication.ui.EditScreen
import hr.ferit.emanuelflorijan.myapplication.ui.theme.MyApplicationTheme
import hr.ferit.emanuelflorijan.myapplication.ui.ListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(android.graphics.Color.BLACK),
            navigationBarStyle = SystemBarStyle.dark(android.graphics.Color.BLACK)
        )
        setContent {
            MyApplicationTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "list",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = "list") {
                val listViewModel: ListViewModel = viewModel()
                ListScreen(navController = navController, viewModel = listViewModel)
            }

            composable(
                route = "editAdd/{noteId}",
                arguments = listOf(navArgument("noteId") { type = NavType.IntType })
            ) { backStackEntry ->
                val noteId = backStackEntry.arguments?.getInt("noteId") ?: -1
                val editViewModel: EditViewModel = viewModel()

                EditScreen(
                    navController = navController,
                    viewModel = editViewModel,
                    noteId = noteId
                )
            }
        }
    }
}












