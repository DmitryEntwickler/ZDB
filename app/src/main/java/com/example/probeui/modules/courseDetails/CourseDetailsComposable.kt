package com.example.probeui.modules.courseDetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.probeui.R
import com.example.probeui.classes.Course
import com.example.probeui.classes.ELectionType
import com.example.probeui.core.commonComposables.CheckIcon
import com.example.probeui.core.navigation.EActivityScreens
import com.example.probeui.core.repo.Repositiry
import com.example.probeui.ui.theme.GreenZDB
import com.example.probeui.ui.theme.Typography

@Composable
fun CourseDetailsComposable(mNavController: NavController, mCourseId: String?) {

    val mScaffoldState = rememberScaffoldState()
    val mRepository = Repositiry()

    val mCourse: Course? = mRepository.fetchCourseById(mCourseId)
    val mListOfAllLections by mRepository.fetchLections().observeAsState()
    val mThisCourseLections = mListOfAllLections?.filterNot { it.mCourseId.toString() != mCourseId }

    val mSections = mThisCourseLections?.maxWithOrNull(Comparator.comparingInt { it.mSection.toInt() })?.mSection
    val mListOfSections = listOf(1..mSections!!).flatMap { it }

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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            mCourse?.let { course ->
                Icon(
                    imageVector = course.mPicture,
                    contentDescription = null,
                    modifier = Modifier
                        .size(130.dp),
                    tint = GreenZDB
                )
                Text(
                    text = course.mName,
                    style = MaterialTheme.typography.h4,
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
                        text = "$mSections Abschnitte",
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
                        text = "${mThisCourseLections?.size} Lektionen",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            } // end of LET for Course Info

            // Lazy Column
            Text(
                text = "Inhalt",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            mThisCourseLections.let { lectionsList ->
                LazyColumn(){
                    items(mListOfSections) { section ->

                        Text(
                            text = "Abschnitt $section",
                            fontWeight = FontWeight.Bold,
                            style = Typography.h6
                        )

                        lectionsList.forEach {lection ->
                            if (lection.mSection == section) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable() { mNavController.navigate(EActivityScreens.LectionScreen.name + "/${lection.mId}/${mCourseId}") },
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column() {
                                        Row() {
                                            Text(
                                                text = "${lection.mPositionInSection}",
                                                modifier = Modifier.width(32.dp)
                                            )
                                            Column() {
                                                Text(
                                                    text = "${lection.mLectionName}",
                                                    fontWeight = FontWeight.Bold
                                                )
                                                Text("${lection.mType}  ${lection.mDuration}")
                                            }
                                        }
                                    }
                                    val icon = when (lection.mType) {
                                        ELectionType.VIDEO -> painterResource(id = R.drawable.play_circle)
                                        ELectionType.AUDIO -> painterResource(id = R.drawable.audio_ic)
                                        else -> painterResource(id = R.drawable.menu_book)
                                    }
                                    Icon(
                                        icon,
                                        contentDescription = null,
                                        modifier = Modifier.size(32.dp)
                                    )
                                } // end of Row
                                Divider()
                            }
                        }
                        Divider()
                    }
                }

            }


        } // end of Screen Column
    } // end of the content of BottomSheetScaffold
} // end of Composable






/* zweite Version: nur Lektionen, ohne Abschnitte

mThisCourseLections.let { lectionsList ->
    LazyColumn() {
        itemsIndexed(lectionsList) { index, lection ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable() { mNavController.navigate(EActivityScreens.LectionScreen.name + "/${lection.mId}/${mCourseId}") },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Row() {
                        Text(
                            text = "${lection.mPositionInSection}",
                            modifier = Modifier.width(32.dp)
                        )
                        Column() {
                            Text(
                                text = "${lection.mLectionName}",
                                fontWeight = FontWeight.Bold
                            )
                            Text("${lection.mType}  ${lection.mDuration}")
                        }
                    }
                }
                val icon = when (lection.mType) {
                    ELectionType.VIDEO -> painterResource(id = R.drawable.play_circle)
                    ELectionType.AUDIO -> painterResource(id = R.drawable.audio_ic)
                    else -> painterResource(id = R.drawable.menu_book)
                }
                Icon(
                    icon,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            } // end of Row

            Divider()

        } // end of ItemsIndexed
    } // end of Lazy Column
}
*/


/* alte Version: Liste von Listen

mCourseSections?.let{ section ->
    LazyColumn(){
        itemsIndexed(section) { index, sectionItem ->

            Column(){
                Text(
                    text = "Abschnitt ${index+1}",
                    fontWeight = FontWeight.Bold,
                    style = Typography.h6,
                )

                sectionItem.forEach(){ lection ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable() { mNavController.navigate(EActivityScreens.LectionScreen.name + "/${lection.mId}/${mCourseId}") },
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Column(){
                            Row(){
                                Text(
                                    text = "${lection.mPositionInSection}",
                                    modifier = Modifier.width(32.dp)
                                )
                                Column(){
                                    Text(
                                        text = "${lection.mLectionName}",
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text("${lection.mType}  ${lection.mDuration}")
                                }
                            }
                        }
                        val icon = when (lection.mType) {
                            ELectionType.VIDEO -> painterResource(id = R.drawable.play_circle)
                            ELectionType.AUDIO -> painterResource(id = R.drawable.audio_ic)
                            else -> painterResource(id = R.drawable.menu_book)
                        }
                        Icon(
                            icon,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                    }


                    Divider()
                }
            }

            Divider(Modifier.height(2.dp))


        }
    }
}
*/