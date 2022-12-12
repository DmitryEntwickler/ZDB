package com.example.probeui.modules.courseDetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.probeui.classes.Course
import com.example.probeui.core.commonComposables.CheckIcon
import com.example.probeui.core.navigation.EActivityScreens
import com.example.probeui.core.repo.Repositiry
import com.example.probeui.ui.theme.CircleButtonShape
import com.example.probeui.ui.theme.GreenZDB
import com.example.probeui.ui.theme.Typography

@Composable
fun CourseDetailsComposable(mNavController: NavController, mCourseId: String?) {

    val mScaffoldState = rememberScaffoldState()
    val mRepository = Repositiry()
    var mCourse: Course? = null

    mRepository.mListOfActualCourses.value?.forEach() {
        if (it.mId.toString() == mCourseId) mCourse = it
    }
    mRepository.mListOfFavouriteCourses.value?.forEach() {
        if (it.mId.toString() == mCourseId) mCourse = it
    }


    Scaffold(
        scaffoldState = mScaffoldState,

        topBar = {
            TopAppBar(
                title = { Text("Kursdetails") },
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
                },
                actions = {
                    IconButton(
                        onClick = { mNavController.navigate(EActivityScreens.PersonScreen.name) },
                        content = { Icon(Icons.Rounded.Person, contentDescription = "Person") }
                    )
                }
            )
        }
    ) {  // hier goes the content of BottomSheetScaffold

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {

            mCourse?.let { course ->
                Icon(
                    imageVector = course.mPicture,
                    contentDescription = null,
                    modifier = Modifier
                        .size(230.dp),
                    tint = GreenZDB
                )
                Text(
                    text = course.mName,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = mRepository.mDescription,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(vertical = 8.dp)
                )


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    CheckIcon(Icons.Rounded.Check)
                    Text(
                        text = "Dauer: ${course.mDuration} St.",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    CheckIcon(Icons.Rounded.Check)
                    Text(
                        text = "${course.mSections} Abschnitte",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    CheckIcon(Icons.Rounded.Check)
                    Text(
                        text = "${course.mLections} Lektionen",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                }

            }


            Button(
                onClick = { /*TODO*/ },
                shape = CircleButtonShape.small,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = GreenZDB,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Kurs starten",
                    style = Typography.button
                )
            }

        }

    } // end of the content of BottomSheetScaffold

}