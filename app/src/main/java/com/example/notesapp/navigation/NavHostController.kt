package com.example.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.screens.AddScreen
import com.example.notesapp.screens.MainScreen
import com.example.notesapp.screens.NoteScreen
import com.example.notesapp.screens.StartScreen

sealed class NavRoute(val route : String){
    object Start : NavRoute("start")
    object Main : NavRoute("main")
    object Add : NavRoute("add")
    object Note : NavRoute("note")

}

@Composable
fun NavHostController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.Main.route){
        composable(NavRoute.Start.route,){StartScreen(navController)}
        composable(NavRoute.Add.route,){ AddScreen(navController) }
        composable(NavRoute.Main.route,){ MainScreen(navController) }
        composable(NavRoute.Note.route,){ NoteScreen(navController) }
    }
}