package com.example.notesapp.screens.main

import com.example.notesapp.data.cache.NoteEntity

sealed class MainScreenState {
    object Empty : MainScreenState()
    class Data(val notes : List<NoteEntity>) : MainScreenState()
}