package com.example.notesapp.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainScreenViewModel(
    private val noteRepository: NoteRepository
) : ViewModel() {
    private val _mainState = MutableStateFlow<MainScreenState>(MainScreenState.Empty)
    val mainState : StateFlow<MainScreenState>  = _mainState
    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.notes().collect{notes ->
               withContext(Dispatchers.Main){
                   if(notes.isEmpty()){
                       _mainState.value = MainScreenState.Empty
                   }else{
                       _mainState.value = MainScreenState.Data(notes = notes)
                   }
               }
            }
        }
    }
}