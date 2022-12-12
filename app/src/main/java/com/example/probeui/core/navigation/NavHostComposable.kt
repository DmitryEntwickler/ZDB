package com.example.probeui.core.navigation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.probeui.modules.courseDetails.CourseDetailsComposable
import com.example.probeui.modules.dashboard.DashBoardComposable
import com.example.probeui.modules.login.LoginComposable
import com.example.probeui.modules.person.PersonComposable
import com.example.probeui.modules.probeUI.ProbeUIComposable
import com.example.probeui.modules.search.SearchComposable
import com.example.probeui.modules.search.s2.s2Composable
import com.example.probeui.modules.search.s3.s3Composable

@Composable
fun NavHostComposable() {
    val mNavController = rememberNavController()
    var mShowBottomNavigation by remember { mutableStateOf(true) }

    Scaffold(
        bottomBar = { if (mShowBottomNavigation) BottomNavBarComposable(mNavController = mNavController) },
        content = {

            NavHost(
                navController = mNavController,
                startDestination = EActivityScreens.LoginScreen.name,
                builder = {

                    // add composables to the NavGraphBuilder
                    composable(
                        route = EActivityScreens.LoginScreen.name,
                        content = {
                            mShowBottomNavigation = false
                            LoginComposable(mNavController = mNavController)
                        }
                    )

                    // 3 Elements for Bottom Navigation
                    composable(
                        route = EActivityScreens.DashboardScreen.name,
                        content = {
                            mShowBottomNavigation = true
                            DashBoardComposable(mNavController = mNavController)
                        }
                    )
                    composable(
                        route = EActivityScreens.SearchScreen.name,
                        content = {
                            mShowBottomNavigation = true
                            SearchComposable(mNavController = mNavController)
                        }
                    )
                    composable(
                        route = EActivityScreens.ProbeUIScreen.name,
                        content = {
                            mShowBottomNavigation = true
                            ProbeUIComposable(mNavController = mNavController)
                        }
                    )

                    // Elements for Button Click Navigation
                    composable(
                        route = EActivityScreens.PersonScreen.name,
                        content = {
                            mShowBottomNavigation = false
                            PersonComposable(mNavController = mNavController)
                        }
                    )
                    composable(
                        route = EActivityScreens.Search2Screen.name,
                        content = {
                            mShowBottomNavigation = false
                            s2Composable(mNavController = mNavController)
                        }
                    )
                    composable(
                        route = EActivityScreens.Search3Screen.name,
                        content = {
                            mShowBottomNavigation = false
                            s3Composable(mNavController = mNavController)
                        }
                    )
                    composable(
                        route = EActivityScreens.CourseDetailsScreen.name + "/{courseId}",
                        arguments = listOf(navArgument("courseId") { type = NavType.StringType }),
                        content = { navBackStackEntry ->
                            mShowBottomNavigation = false
                            CourseDetailsComposable(
                                mNavController = mNavController,
                                mCourseId = navBackStackEntry.arguments?.getString("courseId")
                            )
                        }
                    )
                }
            )
        }
    )
}
