package com.example.notesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun StartScreen(navController: NavHostController) {
    val text = remember {
        mutableStateOf("")
    }
    val textView: State<String> = remember {
        derivedStateOf {
            if (text.value.length > 9){
                text.value
            }else{
                ""
            }
        }
    }
    Scaffold(

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = textView.value)
            Button(
                onClick = {

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