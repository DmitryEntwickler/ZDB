package com.example.probeui.classes

data class Lection(
    val mId: Int,
    val mCourseId: Int,
    val mLectionName: String,
    val mType: ELectionType,
    val mSection: Int,
    val mPositionInSection: Short,
    val mDuration: String,
    val mUrl: String?,
)
