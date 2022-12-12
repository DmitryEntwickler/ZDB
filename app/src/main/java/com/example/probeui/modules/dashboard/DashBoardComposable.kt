package com.example.probeui.modules.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.probeui.core.commonComposables.CardRowComposable
import com.example.probeui.core.navigation.EActivityScreens
import com.example.probeui.ui.theme.GreenZDB

@Composable
fun DashBoardComposable(
    mDahBoardViewModel: DashBoardViewModel = viewModel(),
    mNavController: NavController
) {

    val mListOfActualCourses by mDahBoardViewModel.mListOfActualCourses.observeAsState()
    val mListOfFavouriteCourses by mDahBoardViewModel.mListOfFavouriteCourses.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ZUDUBI Dashboard") },
                backgroundColor = GreenZDB,
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
                        onClick = { mNavController.navigate(EActivityScreens.PersonScreen.name) },
                        content = { Icon(Icons.Rounded.Person, contentDescription = "Person") }
                    )
                }
            )
        }
    ) {
        // Screen content
        Column() {

            Text(
                text = "Aktuelle Kurse",
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h6
            )

            mListOfActualCourses?.let { listOfActualCourses ->
                CardRowComposable(
                    mListOfCourses = listOfActualCourses,
                    mShowProgress = true,
                    mNavController = mNavController
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Beliebte Kurse",
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h6
            )

            mListOfFavouriteCourses?.let { listOfFavouriteCourses ->
                CardRowComposable(
                    mListOfCourses = listOfFavouriteCourses,
                    mShowProgress = false,
                    mNavController = mNavController
                )
            }
        }

    }
}