package com.example.probeui

import androidx.compose.runtime.Composable

enum class ActivityScreens (
    val body: @Composable ((String) -> Unit) -> Unit) {

    DashboardScreen(
        body = { DashBoardComposable() }
    ),
    PersonScreen(
        body = { PersonComposable() }
    ),
    ProbeUIScreen(
        body = { ProbeUIComposable() }
    )
}
