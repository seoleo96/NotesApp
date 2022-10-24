package com.example.notesapp.data.cache

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM NoteEntity")
    fun notes(): Flow<List<NoteEntity>>

    @Insert
    suspend fun insert(noteEntity: NoteEntity)

    @Delete
    suspend fun delete(noteEntity: NoteEntity)

    @Query("DELETE FROM NoteEntity")
    suspend fun clear()

    @Update
    suspend fun update(noteEntity: NoteEntity)

}