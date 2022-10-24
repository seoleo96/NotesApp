package com.example.notesapp

import androidx.compose.ui.graphics.Color
import com.example.notesapp.ui.theme.*

enum class NoteColors {
    PurpleColor {
        override fun color(): Color = PurpleColorNote
        override fun title(): String = "Purple"
    },
    RedColor {
        override fun color(): Color = RedColorNote
        override fun title(): String = "Red"
    },
    GreenColor {
        override fun color(): Color = GreenColorNote
        override fun title(): String = "Green"
    },
    BlueColor {
        override fun color(): Color = BlueColorNote
        override fun title(): String = "Blue"
    },
    GreyColor {
        override fun color(): Color = GreyColorNote
        override fun title(): String = "Grey"
    };

    abstract fun color(): Color
    abstract fun title(): String
}