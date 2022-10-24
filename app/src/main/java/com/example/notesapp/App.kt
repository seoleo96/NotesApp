package com.example.notesapp

import android.app.Application
import androidx.room.Room
import com.example.notesapp.data.cache.NoteDao
import com.example.notesapp.data.cache.NoteDatabase
import com.example.notesapp.data.repository.NoteRepository
import com.example.notesapp.data.repository.NoteRepositoryImpl
import com.example.notesapp.screens.add.AddScreenViewModel
import com.example.notesapp.screens.main.MainScreenViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            androidLogger(level = Level.DEBUG)
            modules(listOf(appModule))
        }
    }
}

private val appModule = module {

    single<NoteDao> {
        val noteDatabase = Room.databaseBuilder(
            androidApplication(),
            NoteDatabase::class.java,
            "note_db"
        ).build()
        noteDatabase.noteDao()
    }

    single<NoteRepository> {
        NoteRepositoryImpl(get())
    }

    single<AddScreenViewModel> {
        AddScreenViewModel(get())
    }

    single<MainScreenViewModel> {
        MainScreenViewModel(get())
    }
}