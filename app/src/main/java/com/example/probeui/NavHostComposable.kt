package com.example.probeui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavHostComposable() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            myBottomNavBar(navController = navController)
        }
    )
    { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ActivityScreens.DashboardScreen.name,
            modifier = Modifier.padding(innerPadding)
        )
        {
            composable(ActivityScreens.DashboardScreen.name) {
                DashBoardComposable()
            }
            composable(ActivityScreens.SearchScreen.name) {
                SearchComposable()
            }
            composable(ActivityScreens.PersonScreen.name) {
                PersonComposable()
            }
            composable(ActivityScreens.ProbeUIScreen.name) {
                ProbeUIComposable()
            }
        }
    }
}
