package com.example.probeui

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PersonComposable(){

    val mBottomSheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed))
    val mCoroutineScopeForSnackBar = rememberCoroutineScope()
    val mCoroutineScopeBottomSheet = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = mBottomSheetScaffoldState,
        sheetContent =  {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(colorResource(id = R.color.green))) {
                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Persönlicher Bereich")
                }
            }
        },
        sheetPeekHeight = 10.dp,
        topBar = {
            TopAppBar(
                title = { Text("ZUDUBI Person") },
                backgroundColor = colorResource(id = R.color.green),
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
                        onClick = { println("-> Person") },
                        content = { Icon(Icons.Rounded.Person, contentDescription = "Person") }
                    )
                }
            )
        }
    ){  // hier goes the content of BottomSheetScaffold

        Column {
            Text(
                text = "Persönlicher Bereich",
                modifier = Modifier.padding(16.dp)
            )

        }

    } // end of the content of BottomSheetScaffold

}