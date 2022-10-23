package com.example.notesapp.screens

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.notesapp.navigation.NavRoute


@Composable
fun NoteScreen(navController : NavHostController) {
    TextButton(
        onClick = {
            navController.navigate(NavRoute.Add.route)
        }
    ) {
        Text(text = "note screen")
    }
}