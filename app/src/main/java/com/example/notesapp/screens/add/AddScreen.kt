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
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.NoteColors
import com.example.notesapp.ui.theme.*


@Composable
fun AddScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = BackgroundColor,
    ) {
        NoteAddContent(navController)
    }
}


@Composable
fun NoteAddContent(
    navController: NavHostController,
    viewModel: AddScreenViewModel = viewModel()
) {
    val titleRemember = remember { mutableStateOf("") }
    val noteRemember = remember { mutableStateOf("") }
    val expanded = remember { mutableStateOf(false) }
    Column(
    ) {
        Box(
            modifier = Modifier
                .size(Constraints.Infinity.dp, 72.dp),
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
                                viewModel.saveNote()
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
                                println("expanded click - ${expanded.value}")
                                expanded.value = !expanded.value
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Filled.List, "",
                            tint = Color.White,
                        )
                        ColorMenu(expanded) { noteColor ->
                            println("noteColor - ${noteColor.name}")
                            println("expanded.value - ${expanded.value}")
                            expanded.value = false
                        }
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = BackgroundColor)
        ) {
            TextField(
                value = titleRemember.value,
                onValueChange = { title ->
                    titleRemember.value = title
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = ShapeBackgroundColor),
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
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = BackgroundColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    placeholderColor = Color.Gray,
                    cursorColor = Color.Gray

                )
            )
            TextField(
                value = noteRemember.value,
                onValueChange = { title ->
                    noteRemember.value = title
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = ShapeBackgroundColor),
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
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = BackgroundColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    placeholderColor = Color.Gray,
                    cursorColor = Color.Gray
                )
            )
        }
    }
}

@Composable
fun ColorMenu(
    expanded: MutableState<Boolean>,
    noteColorCallBack: (NoteColors) -> Unit
) {
    println("call dropdown menu")
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
                noteColorCallBack(noteColor)
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

@Preview
@Composable
fun PreviewAddNote() {
    MaterialTheme(colors = MaterialTheme.colors) {
        AddScreen(navController = rememberNavController())
    }
}

