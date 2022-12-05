package com.example.probeui

import androidx.compose.runtime.Composable

enum class ActivityScreens (
    val body: @Composable ((String) -> Unit) -> Unit) {

    DashboardScreen(
        body = { DashBoardComposable() }
    ),
    SearchScreen(
        body = { SearchComposable() }
    ),
    ProbeUIScreen(
        body = { ProbeUIComposable() }
    ),
    PersonScreen(
        body = { PersonComposable() }
    )
}
