package com.example.probeui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun SearchComposable(){

    val mScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = mScaffoldState,

        topBar = {
            TopAppBar(
                title = { Text("Search") },
                backgroundColor = colorResource(id = R.color.green),
                contentColor = Color.White,
                elevation = 32.dp,
                navigationIcon = {
                    /*
                    IconButton(
                    onClick = { println("-> Navigation Icon") },
                    content = {Icon(Icons.Rounded.Person, contentDescription = "Check")}
                    )
                     */
                },
                actions = {
                    IconButton(
                        onClick = { println("-> Person") },
                        content = { Icon(Icons.Rounded.Person, contentDescription = "Person") }
                    )
                }
            )
        }
    ){  // hier goes the content of BottomSheetScaffold

        Column {
            Text(
                text = "Search",
                modifier = Modifier.padding(16.dp)
            )

        }

    } // end of the content of BottomSheetScaffold

}