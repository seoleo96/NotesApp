package com.example.notesapp.screens.add

import com.example.notesapp.utils.NoteColors

sealed class AddScreenEvent{
    object OnSavedButtonClicked : AddScreenEvent()
    object OnBackButtonClicked : AddScreenEvent()
    object OnExpandedButtonClicked : AddScreenEvent()
    class OnTitleChanged(val title: String) : AddScreenEvent()
    class OnNoteChanged(val note: String) : AddScreenEvent()
    class OnColorChanged(val color: NoteColors) : AddScreenEvent()
}
