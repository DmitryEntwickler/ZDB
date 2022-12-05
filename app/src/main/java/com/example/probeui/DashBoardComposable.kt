package com.example.probeui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun DashBoardComposable(){

    Scaffold(
        topBar = {TopAppBar(
            title = { Text("ZUDUBI Dashboard") },
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
                    onClick = { println("-> Add") },
                    content = { Icon(Icons.Rounded.Person, contentDescription = "Add") }
                )
            }
        )
        }
    ) {
        // Screen content
        Column {
            Text(
                text = "ZUDUBI Dashboard",
                modifier = Modifier.padding(16.dp)
            )

        }

    }
}