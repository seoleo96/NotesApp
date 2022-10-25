package com.example.notesapp.screens.add


sealed class AddScreenState {
    class ShowErrorSnackbar(val description: String) : AddScreenState()
    object Success : AddScreenState()
    object Loading : AddScreenState()
    object OnBackButtonClick : AddScreenState()
    object Init : AddScreenState()
}