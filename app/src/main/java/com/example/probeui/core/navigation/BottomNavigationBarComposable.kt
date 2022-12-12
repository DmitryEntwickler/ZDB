package com.example.probeui.core.navigation

import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.probeui.ui.theme.GreenZDB

@Composable
fun BottomNavBarComposable(mNavController: NavController) {

    val mActualRoute = mNavController.currentBackStackEntryAsState().value?.destination?.route

    BottomNavigation(
        elevation = 32.dp,
        backgroundColor = Color.White
    ) {

        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Home,"") },
            label = { Text(text = "Dashboard") },
            selected = (mActualRoute == EActivityScreens.DashboardScreen.name),
            onClick = { mNavController.navigate(EActivityScreens.DashboardScreen.name) },
            selectedContentColor = Color.White,
            unselectedContentColor = GreenZDB,
            modifier =
                if (mActualRoute == EActivityScreens.DashboardScreen.name)
                    Modifier.background(GreenZDB)
                else Modifier.background(Color.White)
        )

        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Search,"") },
            label = { Text(text = "Search") },
            selected = (mActualRoute == EActivityScreens.SearchScreen.name),
            onClick = { mNavController.navigate(EActivityScreens.SearchScreen.name) },
            selectedContentColor = Color.White,
            unselectedContentColor = GreenZDB,
            modifier =
                if (mActualRoute == EActivityScreens.SearchScreen.name)
                    Modifier.background(GreenZDB)
                else Modifier.background(Color.White)
        )

        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Edit,"") },
            label = { Text(text = "Probe") },
            selected = (mActualRoute == EActivityScreens.ProbeUIScreen.name),
            onClick = { mNavController.navigate(EActivityScreens.ProbeUIScreen.name) },
            selectedContentColor = Color.White,
            unselectedContentColor = GreenZDB,
            modifier =
                if (mActualRoute == EActivityScreens.ProbeUIScreen.name)
                    Modifier.background(GreenZDB)
                else Modifier.background(Color.White)
        )
    }
}
