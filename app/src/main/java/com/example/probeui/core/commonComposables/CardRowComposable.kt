package com.example.probeui.core.commonComposables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.probeui.classes.Course

@Composable
fun CardRowComposable(
    mListOfCourses: List<Course>,
    mShowProgress: Boolean,
    mNavController: NavController
) {

    Column {

        LazyRow(){
            items(mListOfCourses) {
                CourseCardComposable(it, mShowProgress, mNavController)
            }
        }

    }


}