package com.example.notesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.navigation.NavRoute


@Composable
fun StartScreen(navController: NavHostController) {
    Scaffold(

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    navController.navigate(NavRoute.Add.route)
                },
                modifier = Modifier
                    .fillMaxHeight(fraction = 0.07f)
                    .padding(8.dp)
            ) {
                Text(text = "Welcome to Notes App")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    MaterialTheme(colors = MaterialTheme.colors) {
        StartScreen(navController = rememberNavController())
    }
}