package com.example.notesapp.screens.add

import androidx.lifecycle.ViewModel

class AddScreenViewModel : ViewModel() {


    fun saveNote(){
        if(validateNote()){

        }
    }


    fun validateNote() : Boolean{
        return false
    }
}