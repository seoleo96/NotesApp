package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.notesapp.navigation.NavHostController
import com.example.notesapp.screens.add.AddScreenViewModel
import com.example.notesapp.screens.main.MainScreenViewModel
import com.example.notesapp.ui.theme.NotesAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val addScreenViewModel: AddScreenViewModel by viewModel()
    private val mainScreenViewModel: MainScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                Scaffold(
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {

                        NavHostController(addScreenViewModel, mainScreenViewModel)
                    }
                }
            }
        }
    }
}