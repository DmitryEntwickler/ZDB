package com.example.probeui.modules.search.s2

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.probeui.core.navigation.EActivityScreens
import com.example.probeui.ui.theme.CircleButtonShape
import com.example.probeui.ui.theme.GreenZDB
import com.example.probeui.ui.theme.Typography

@Composable
fun s2Composable(mNavController: NavController){

    val mScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = mScaffoldState,

        topBar = {
            TopAppBar(
                title = { Text("Search 2") },
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
                text = "Search 2",
                style = MaterialTheme.typography.h3,
                color = GreenZDB
            )
            Button(
                onClick = { mNavController.navigate(EActivityScreens.Search3Screen.name) },
                shape = CircleButtonShape.small,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = GreenZDB,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "navigiere tiefer",
                    style = Typography.button
                )
            }

        }

    } // end of the content of BottomSheetScaffold

}