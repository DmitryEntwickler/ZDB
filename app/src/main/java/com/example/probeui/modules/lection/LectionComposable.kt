package com.example.probeui.modules.lection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
fun LectionComposable(mNavController: NavController, mLectionId: String?, mCourseId: String?) {
    val mScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = mScaffoldState,

        topBar = {
            TopAppBar(
                title = { Text("Lektion") },
                backgroundColor = GreenZDB,
                contentColor = Color.White,
                elevation = 32.dp,
                navigationIcon = {
                    if (mNavController.previousBackStackEntry != null) {
                        IconButton(
                            onClick = { mNavController.navigateUp() },
                            content = { Icon(Icons.Rounded.ArrowBack, contentDescription = "back") }
                        )
                    } else {
                        null
                    }
                }
            )
        }
    ) {  // hier goes the content of BottomSheetScaffold

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Lektion",
                style = MaterialTheme.typography.h3,
                color = GreenZDB,
                textAlign = TextAlign.Center
            )
            Text(
                text = "CourseId: $mCourseId",
                style = MaterialTheme.typography.body1,
                color = GreenZDB,
                textAlign = TextAlign.Center
            )
            Text(
                text = "LectionId: $mLectionId",
                style = MaterialTheme.typography.body1,
                color = GreenZDB,
                textAlign = TextAlign.Center
            )
        }
    }
}
