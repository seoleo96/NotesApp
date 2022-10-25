package com.example.notesapp.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.R
import com.example.notesapp.data.cache.NoteEntity
import com.example.notesapp.navigation.NavRoute
import com.example.notesapp.ui.theme.BackgroundColor
import com.example.notesapp.ui.theme.ShapeBackgroundColor
import com.example.notesapp.ui.theme.Typography
import com.example.notesapp.utils.NoteColors
import org.koin.androidx.compose.getViewModel


@Composable
fun MainScreen(navController: NavHostController, mainScreenViewModel: MainScreenViewModel, ) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = BackgroundColor,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          navController.navigate(NavRoute.Add.route)
                },
                backgroundColor = ShapeBackgroundColor,
                modifier = Modifier.padding(end = 16.dp, bottom = 16.dp)
            ) {
                Icon(
                    Icons.Filled.Add,
                    "",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    ) {
       NoteContent(navController, mainScreenViewModel)
    }
}

@Composable
fun NoteContent(navController: NavHostController,viewModel: MainScreenViewModel) {
    Column {
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
                Text(
                    "Notes",
                    color = Color.White,
                    textAlign = TextAlign.Start,
                    fontSize = Typography.h4.fontSize
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(shape = RoundedCornerShape(24))
                            .background(ShapeBackgroundColor)
                            .clickable {

                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Filled.Search, "",
                            tint = Color.White,
                        )
                    }
                    Spacer(modifier = Modifier.width(24.dp))
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(shape = RoundedCornerShape(24))
                            .background(color = ShapeBackgroundColor)
                            .clickable {

                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Filled.Info, "",
                            tint = Color.White,
                        )
                    }
                }
            }
        }

        val mainState: State<MainScreenState> = viewModel.mainState.collectAsState()
        when (val state = mainState.value) {
            is MainScreenState.Empty -> {
                EmptyContent()
            }
            is MainScreenState.Data -> {
                println("size - ${state.notes.size}")
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(state.notes.size) {note->
                        println("content - ${state.notes[note]}")

                        NoteItem(state.notes[note])
                    }
                }
            }
            else -> {
                CircularProgressIndicator()
            }
        }

    }
}

@Composable
fun EmptyContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.empty_image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
                .padding(20.dp)
        )
        Text(
            text = "Create your first note !",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            color = Color.Black,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun NoteItem(note: NoteEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .clip(shape = RoundedCornerShape(25))
            .clickable {

            },
        backgroundColor = NoteColors.values()[note.noteBackgroundColor].color()

    ) {
        Text(
            text = note.title,
            maxLines = 2,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(24.dp)
        )
    }
}
