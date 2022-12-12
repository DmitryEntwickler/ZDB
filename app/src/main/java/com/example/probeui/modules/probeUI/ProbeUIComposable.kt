package com.example.probeui.modules.probeUI


import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.probeui.R
import com.example.probeui.core.navigation.EActivityScreens
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProbeUIComposable(mNavController: NavController) {

    val mBottomSheetScaffoldState =
        rememberBottomSheetScaffoldState(bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed))

    val mInteractionSourceButton = remember { MutableInteractionSource() }
    val mIsButtonPressed by mInteractionSourceButton.collectIsPressedAsState()

    val mCoroutineScopeSnackBar = rememberCoroutineScope()
    val mCoroutineScopeBottomSheet = rememberCoroutineScope()

    val mList = listOf("a", "b", "c")
    var mIndex by remember { mutableStateOf(0) }

    BottomSheetScaffold(
        scaffoldState = mBottomSheetScaffoldState,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(colorResource(id = R.color.green))
            ) {
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "BottomSheet hier")
                }
            }
        },
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetPeekHeight = 70.dp,
        topBar = {
            TopAppBar(
                title = { Text("UI Probe") },
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
                        onClick = { mNavController.navigate( EActivityScreens.PersonScreen.name) },
                        content = { Icon(Icons.Rounded.Person, contentDescription = "Person") }
                    )
                }
            )
        }
    ) {
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
                Text(text = "long press")
            }

            Button(
                onClick = {
                    mCoroutineScopeSnackBar.launch {
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
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = "check Snackbar")
            }

            Button(
                onClick = {
                    mCoroutineScopeBottomSheet.launch {
                        if (mBottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            mBottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            mBottomSheetScaffoldState.bottomSheetState.collapse()
                        }

                    }
                },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = "show BottomSheet")
            }


            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { if (mIndex > 0) mIndex -= 1 else mIndex = mList.size - 1 },
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "")
                }
                Text(text = mList.get(mIndex))
                Button(
                    onClick = { if (mIndex < mList.size - 1) mIndex += 1 else mIndex = 0 },
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Icon(Icons.Default.ArrowForward, contentDescription = "")
                }
            }

        } // end of Column

    } // end of the content of BottomSheetScaffold

}