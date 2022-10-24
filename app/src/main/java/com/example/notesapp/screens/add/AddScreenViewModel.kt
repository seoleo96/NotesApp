package com.example.notesapp.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.cache.NoteEntity
import com.example.notesapp.data.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddScreenViewModel(
    private val noteRepository: NoteRepository
) : ViewModel() {


    fun saveNote(note: NoteEntity) {
        println("vmEntity - $note")
        println("noteRepository - ${noteRepository.hashCode()}")
        println("noteRepository - ${noteRepository.toString()}")
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.insert(note)
        }
    }


    fun validateNote() : Boolean{
        return false
    }
}