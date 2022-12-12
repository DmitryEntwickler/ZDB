package com.example.probeui.modules.search.s3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.probeui.core.navigation.EActivityScreens
import com.example.probeui.ui.theme.GreenZDB

@Composable
fun s3Composable(mNavController: NavController){

    val mScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = mScaffoldState,

        topBar = {
            TopAppBar(
                title = { Text("Search 3") },
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
                    IconButton(
                        onClick = { mNavController.navigate( EActivityScreens.PersonScreen.name) },
                        content = { Icon(Icons.Rounded.Person, contentDescription = "Person") }
                    )
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
                text = "Search 3. Letzte Ebene",
                style = MaterialTheme.typography.h3,
                color = GreenZDB,
                textAlign = TextAlign.Center
            )
        }

    } // end of the content of Scaffold

}