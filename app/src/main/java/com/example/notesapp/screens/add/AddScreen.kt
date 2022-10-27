package com.example.notesapp.screens.add

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.notesapp.data.cache.NoteEntity
import com.example.notesapp.ui.theme.BackgroundColor
import com.example.notesapp.ui.theme.ShapeBackgroundColor
import com.example.notesapp.utils.NoteColors
import org.koin.androidx.compose.getViewModel


@Composable
fun AddScreen(navController: NavHostController, addScreenViewModel: AddScreenViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = BackgroundColor,
    ) {
        val titleRemember = remember {
            mutableStateOf("")
        }
        val noteRemember = remember { mutableStateOf("") }
        val expanded = remember { mutableStateOf(false) }
        val noteColorRemember = remember { mutableStateOf(NoteColors.GreyColor) }
        Column(
            modifier = Modifier.background(noteColorRemember.value.color())
        ) {
            Box(
                modifier = Modifier
                    .size(Constraints.Infinity.dp, 72.dp)
                    .clickable {
                    },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(shape = RoundedCornerShape(24))
                            .background(ShapeBackgroundColor)
                            .clickable {
                                navController.popBackStack()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Filled.ArrowBack, "",
                            tint = Color.White,
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(shape = RoundedCornerShape(24))
                                .background(ShapeBackgroundColor)
                                .clickable {
                                    val note = NoteEntity(
                                        id = 0,
                                        title = titleRemember.value,
                                        note = noteRemember.value,
                                        noteBackgroundColor = noteColorRemember.value.ordinal,
                                        System.currentTimeMillis()
                                    )
                                    addScreenViewModel.saveNote(note)
                                    noteRemember.value = ""
                                    titleRemember.value = ""
                                    noteColorRemember.value = NoteColors.values()[0]
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Filled.Done, "",
                                tint = Color.White,
                            )
                        }
                        Spacer(modifier = Modifier.width(24.dp))
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(shape = RoundedCornerShape(24))
                                .background(ShapeBackgroundColor)
                                .clickable {
                                    expanded.value = !expanded.value
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Filled.List, "",
                                tint = Color.White,
                            )
                            DropdownMenu(
                                expanded = expanded.value,
                                onDismissRequest = { expanded.value = false },
                                modifier = Modifier
                                    .background(color = ShapeBackgroundColor)
                                    .clip(shape = RoundedCornerShape(48)),
                                offset = DpOffset(x = (16).dp, y = (16).dp)
                            ) {
                                NoteColors.values().forEach { noteColor ->
                                    DropdownMenuItem(onClick = {
                                        noteColorRemember.value = noteColor
                                        expanded.value = false
                                    }) {
                                        Row(
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(24.dp)
                                                    .clip(shape = CircleShape)
                                                    .background(color = noteColor.color())
                                            )
                                            Spacer(modifier = Modifier.width(24.dp))
                                            Text(noteColor.title(), color = Color.White)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(noteColorRemember.value.color())
            ) {
                TextField(
                    value = titleRemember.value,
                    onValueChange = { title ->
                        titleRemember.value = title
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(noteColorRemember.value.color()),
                    maxLines = 10,
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 32.sp,
                    ),
                    keyboardOptions = KeyboardOptions(KeyboardCapitalization.Words),
                    placeholder = {
                        Text(
                            titleRemember.value.ifEmpty { "Title" },
                            fontSize = 32.sp,
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = noteColorRemember.value.color(),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        placeholderColor = Color.White,
                        cursorColor = Color.White
                    )
                )
                TextField(
                    value = noteRemember.value,
                    onValueChange = { title ->
                        noteRemember.value = title
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(noteColorRemember.value.color()),
                    maxLines = 10,
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 24.sp,
                    ),
                    keyboardOptions = KeyboardOptions(KeyboardCapitalization.Words),
                    placeholder = {
                        Text(
                            noteRemember.value.ifEmpty { "Type something..." },
                            fontSize = 24.sp,
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = noteColorRemember.value.color(),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        placeholderColor = Color.White,
                        cursorColor = Color.White
                    )
                )
            }
        }

    }
}

