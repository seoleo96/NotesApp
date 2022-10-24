package com.example.notesapp.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title : String,
    val note : String,
    val noteBackgroundColor : Int,
    val timestamp: Long
)