package com.example.probeui.classes

data class Lection(
    val mId: Int,
    val mLectionName: String,
    val mType: ELectionType,
    val mCourseName: String,
    val mSection: Short,
    val mPositionInSection: Short,
    val mDuration: String,
    val mUrl: String?,
)
