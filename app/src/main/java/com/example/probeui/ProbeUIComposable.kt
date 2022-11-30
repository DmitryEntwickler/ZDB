package com.example.probeui


import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProbeUIComposable(mMainScreenViewModel: MainScreenViewModel = viewModel() ) {

    val mBottomSheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed))

    val mInteractionSourceButton = remember { MutableInteractionSource() }
    val mIsButtonPressed by mInteractionSourceButton.collectIsPressedAsState()

    val mNumber = mMainScreenViewModel.mNumber.observeAsState()
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
                    Text(text = "Value is ${mNumber.value}")
                }
            }
        },
        sheetPeekHeight = 10.dp,
        topBar = {
            TopAppBar(
                title = { Text("ZUDUBI Dashboard") },
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
                        onClick = { println("-> Add") },
                        content = { Icon(Icons.Rounded.Person, contentDescription = "Add") }
                    )
                }
            )
        }
    ){
        // hier goes the content of BottomSheetScaffold
        Column {
            Text(
                text = "UI Probe hier",
                modifier = Modifier.padding(16.dp)
            )
            Button(
                onClick = {},
                interactionSource = mInteractionSourceButton,
                modifier = if (mIsButtonPressed) Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth() else Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = "press")
            }

            Button(
                onClick = {
                    mCoroutineScopeForSnackBar.launch{
                        val result = mBottomSheetScaffoldState.snackbarHostState.showSnackbar(
                                message = "alles Ok",
                                actionLabel = "Retry",
                                duration = SnackbarDuration.Short
                            )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                println("-> snackbar retry was pressed")
                            }
                            SnackbarResult.Dismissed -> {
                                println("-> snackbar self dismissed")
                            }
                        }
                    }
                },
                modifier =  Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = "check Snackbar")
            }

            Button(
                onClick = {
                    mCoroutineScopeBottomSheet.launch{
                        if (mBottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            mBottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            mBottomSheetScaffoldState.bottomSheetState.collapse()
                        }

                    }
                },
                modifier =  Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = "show BottomSheet")
            }

        }

    } // end of the content of BottomSheetScaffold

}