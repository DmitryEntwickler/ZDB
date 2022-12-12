package com.example.probeui.classes

import androidx.compose.ui.graphics.vector.ImageVector

data class Course(
    val mId: Int,
    val mPicture: ImageVector,
    val mName: String,
    val mProgress: Float,
    val mDuration: Double,
    val mSections: Short,
    val mLections: Short
)
