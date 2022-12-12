package com.example.probeui.core.commonComposables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.probeui.R
import com.example.probeui.classes.Course
import com.example.probeui.core.navigation.EActivityScreens
import com.example.probeui.ui.theme.*
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CourseCardComposable(
    mCourse: Course,
    mShowProgress: Boolean,
    mNavController: NavController
) {

    Card(
        onClick = { mNavController.navigate(EActivityScreens.CourseDetailsScreen.name + "/${mCourse.mId}") },
        elevation = 8.dp,
        modifier = Modifier
            .padding(end = 16.dp)
            .height(200.dp)
            .offset(x = 8.dp),
        shape = CourseCardShape.large,
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(8.dp)
        ) {

            // Column for Picture and Course Name
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                //verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Box()
                {
                    Icon(
                        imageVector = mCourse.mPicture,
                        contentDescription = null,
                        modifier = Modifier
                            .size(130.dp)
                            .align(Alignment.Center),
                        tint = colorResource(id = R.color.green)
                    )
                    if (mShowProgress) {
                        Surface(
                            onClick = { },
                            modifier = Modifier
                                .size(30.dp)
                                .align(Alignment.TopEnd)
                                .offset(x = (-8).dp),
                            shape = CircleShape,
                            color = GreenZDB
                        )
                        {
                            Text(
                                text = "${(mCourse.mProgress * 100).roundToInt()}%",
                                modifier = Modifier.offset(y = 6.dp),
                                style = MaterialTheme.typography.caption,
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }

                Text(
                    text = mCourse.mName,
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(120.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
            }




            if (mShowProgress) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .height(12.dp)
                        .width(120.dp)
                        .clip(progressShape.small),
                    color = GreenZDB,
                    backgroundColor = ProgressBarGrey,
                    progress = mCourse.mProgress
                )

            }

        }

    }
}