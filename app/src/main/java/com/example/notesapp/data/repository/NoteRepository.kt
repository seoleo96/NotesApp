package com.example.notesapp.data.repository

import com.example.notesapp.data.cache.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun notes(): Flow<List<NoteEntity>>

    suspend fun insert(noteEntity: NoteEntity)

    suspend fun delete(noteEntity: NoteEntity)

    suspend fun clear()

    suspend fun update(noteEntity: NoteEntity)
}