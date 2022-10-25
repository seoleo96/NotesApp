package com.example.notesapp.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.cache.NoteEntity
import com.example.notesapp.data.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AddScreenViewModel(
    private val noteRepository: NoteRepository
) : ViewModel() {


    fun saveNote(note: NoteEntity) {
        if(note.title.isEmpty() && note.note.isEmpty()){
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.insert(note)
        }
    }

    fun clear() {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.clear()
        }
    }

//    fun onEvent(event: AddScreenEvent){
//        when(event){
//            is AddScreenEvent.OnTitleChanged ->{
//                Log.d("onTitleChanged", event.title)
//                titleState = event.title
//            }
//            is AddScreenEvent.OnNoteChanged ->{
//                noteState = event.note
//            }
//            is AddScreenEvent.OnBackButtonClicked ->{
//
//            }
//            is AddScreenEvent.OnSavedButtonClicked ->{
//
//            }
//            is AddScreenEvent.OnExpandedButtonClicked ->{
//                Log.d("expandedColorState", expandedColorState.toString())
//                expandedColorState = !expandedColorState
//            }
//            is AddScreenEvent.OnColorChanged ->{
//                noteColorState = event.color
//            }
//        }
//    }


    fun validateNote(): Boolean {
        return false
    }
}