package com.example.notesapp.data.repository

import com.example.notesapp.data.cache.NoteDao
import com.example.notesapp.data.cache.NoteEntity
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) : NoteRepository {
    override fun notes(): Flow<List<NoteEntity>> {
        return noteDao.notes()
    }

    override suspend fun insert(noteEntity: NoteEntity) {
        println("note - repo insert")
        noteDao.insert(noteEntity)
    }

    override suspend fun delete(noteEntity: NoteEntity) {
        noteDao.delete(noteEntity)
    }

    override suspend fun clear() {
        noteDao.clear()
    }

    override suspend fun update(noteEntity: NoteEntity) {
        noteDao.update(noteEntity)
    }

}