package com.example.probeui.modules.person

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.probeui.ui.theme.GreenZDB

@Composable
fun PersonComposable(mNavController: NavController){

    val mScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = mScaffoldState,

        topBar = {
            TopAppBar(
                title = { Text("Person") },
                backgroundColor = GreenZDB,
                contentColor = Color.White,
                elevation = 32.dp,
                navigationIcon = {
                    if (mNavController.previousBackStackEntry != null) {
                        IconButton(
                            onClick = { mNavController.navigateUp()},
                            content = {Icon(Icons.Rounded.ArrowBack, contentDescription = "back")}
                        )
                    } else {null}
                },
                actions = {
                    /*
                    IconButton(
                        onClick = { println("-> Person") },
                        content = { Icon(Icons.Rounded.Person, contentDescription = "Person") }
                    )

                     */
                }
            )
        }
    ){  // hier goes the content of BottomSheetScaffold

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Persönlicher Bereich",
                style = MaterialTheme.typography.h3,
                color = GreenZDB,
                textAlign = TextAlign.Center
            )
        }

    } // end of the content of Scaffold

}