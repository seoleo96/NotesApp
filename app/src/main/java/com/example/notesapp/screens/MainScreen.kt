package com.example.notesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.R
import com.example.notesapp.ui.theme.BackgroundColor
import com.example.notesapp.ui.theme.ShapeBackgroundColor


@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = BackgroundColor,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = ShapeBackgroundColor,
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
        NoteContent()
    }
}

@Composable
fun NoteContent(){
    Column(
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(fraction = 0.1f)
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Notes",
                    color = Color.White,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(0.5f)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
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
                    Box(modifier = Modifier.width(24.dp))
                    Box(
                        modifier = Modifier
                            .size(40.dp)
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
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NoteItem()
            NoteItem2()
            NoteItem()
            NoteItem2()
            NoteItem()
        }
    }
}

@Composable
fun EmptyContent(){
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
fun NoteItem(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp)
        .clip(shape = RoundedCornerShape(25))
        .clickable {

        },
    ) {
        Text(
            text = "First Title",
            maxLines = 2,
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.padding(24.dp)
        )
    }
    Box(modifier = Modifier.height(16.dp))
}

@Composable
fun NoteItem2(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp)
        .clip(shape = RoundedCornerShape(25))
    ) {
        Text(
            text = "First Title,\nSecond Titleasdhjas",
            maxLines = 2,
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.padding(24.dp)
        )
    }
    Box(modifier = Modifier.height(16.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewMain() {
    MaterialTheme {
        MainScreen(navController = rememberNavController())
    }
}