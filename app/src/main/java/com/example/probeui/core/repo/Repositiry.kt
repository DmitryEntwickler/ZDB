package com.example.probeui.core.repo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.lifecycle.MutableLiveData
import com.example.probeui.classes.Course
import com.example.probeui.classes.ELectionType
import com.example.probeui.classes.Lection

class Repositiry {

    val mListOfCourses = MutableLiveData(
        listOf(
            Course(1, Icons.Default.Person, "Bauhelfer", 0F, 5.0, 3, 10, 1),
            Course(2, Icons.Default.Person, "allseitsstaatlichgeprüfter Fliesenleger", 0.55F, 2.5, 2, 4, 1),
            Course(3, Icons.Default.Person, "Maler", 0.10F, 4.0, 3, 9, 5),
            Course(4, Icons.Default.Person, "Koch", 0F, 14.0, 2, 8, 7),
        )
    )

    val mDescription = "dieser text hat eigentlich gar keinen wirklichen inhalt. aber er hat auch keine relevanz, und deswegen ist das egal. er dient lediglich als platzhalter."

    val mListOfLections = MutableLiveData(
        listOf(
            // Bauhelfer 10 Lections in 3 Sections
                Lection(1, 1, mLectionName = "Einleitung", mType = ELectionType.TEXT, mSection = 1, mPositionInSection = 1, mDuration = "3:24", mUrl = "www.kurs1.com"),
                Lection(2, 1, mLectionName = "Grundlagen", mType = ELectionType.VIDEO, mSection = 1, mPositionInSection = 2, mDuration = "4:19", mUrl = "www.kurs2.com"),
                Lection(3, 1, mLectionName = "Arbeitsschutz", mType = ELectionType.AUDIO, mSection = 1, mPositionInSection = 3, mDuration = "1:01", mUrl = "www.kurs3.com"),
                Lection(4, 1, mLectionName = "Was ist eine Baustelle", mType = ELectionType.TEXT, mSection = 2, mPositionInSection = 1, mDuration = "5:11", mUrl = "www.kurs4.com"),
                Lection(5, 1, mLectionName = "Winterbaustelle", mType = ELectionType.VIDEO, mSection = 2, mPositionInSection = 2, mDuration = "4:18", mUrl = "www.kurs5.com"),
                Lection(6, 1, mLectionName = "Sommerbaustelle", mType = ELectionType.VIDEO, mSection = 2, mPositionInSection = 3, mDuration = "1:05", mUrl = "www.kurs6.com"),
                Lection(7, 1, mLectionName = "Jahresbaustelle", mType = ELectionType.VIDEO, mSection = 2, mPositionInSection = 4, mDuration = "3:23", mUrl = "www.kurs7.com"),
                Lection(8, 1, mLectionName = "Beton mischen", mType = ELectionType.VIDEO, mSection = 3, mPositionInSection = 1, mDuration = "25:11", mUrl = "www.kurs8.com"),
                Lection(9, 1, mLectionName = "Beton tragen", mType = ELectionType.VIDEO, mSection = 3, mPositionInSection = 2, mDuration = "14:18", mUrl = "www.kurs9.com"),
                Lection(10, 1, mLectionName = "Beton schneiden", mType = ELectionType.VIDEO, mSection = 3, mPositionInSection = 3, mDuration = "11:05", mUrl = "www.kurs10.com"),
            // Fliesenleger 4 Lections in 2 Sections
                Lection(1, 2, mLectionName = "Fliesen tragen", mType = ELectionType.TEXT, mSection = 1, mPositionInSection = 1, mDuration = "3:24", mUrl = "www.kurs1.com"),
                Lection(2, 2, mLectionName = "Fliesen schneiden", mType = ELectionType.VIDEO, mSection = 1, mPositionInSection = 2, mDuration = "4:19", mUrl = "www.kurs2.com"),
                Lection(3, 2, mLectionName = "Fliesen kleben", mType = ELectionType.AUDIO, mSection = 2, mPositionInSection = 1, mDuration = "1:01", mUrl = "www.kurs3.com"),
                Lection(4, 2, mLectionName = "Fliesen schlagen", mType = ELectionType.TEXT, mSection = 2, mPositionInSection = 2, mDuration = "5:11", mUrl = "www.kurs4.com"),
            // Maler 9 Lections in 3 Sections
                Lection(1, 3, mLectionName = "Regenbogen", mType = ELectionType.TEXT, mSection = 1, mPositionInSection = 1, mDuration = "3:24", mUrl = "www.kurs1.com"),
                Lection(2, 3, mLectionName = "Grundlagen", mType = ELectionType.VIDEO, mSection = 1, mPositionInSection = 2, mDuration = "4:19", mUrl = "www.kurs2.com"),
                Lection(3, 3, mLectionName = "Was ist Farbe", mType = ELectionType.TEXT, mSection = 2, mPositionInSection = 1, mDuration = "5:11", mUrl = "www.kurs4.com"),
                Lection(4, 3, mLectionName = "Farbetypen", mType = ELectionType.VIDEO, mSection = 2, mPositionInSection = 2, mDuration = "4:18", mUrl = "www.kurs5.com"),
                Lection(5, 3, mLectionName = "Gelbe Farbe", mType = ELectionType.VIDEO, mSection = 2, mPositionInSection = 3, mDuration = "1:05", mUrl = "www.kurs6.com"),
                Lection(6, 3, mLectionName = "Blaue Farbe", mType = ELectionType.VIDEO, mSection = 2, mPositionInSection = 4, mDuration = "3:23", mUrl = "www.kurs7.com"),
                Lection(7, 3, mLectionName = "Farbe mischen", mType = ELectionType.VIDEO, mSection = 3, mPositionInSection = 1, mDuration = "25:11", mUrl = "www.kurs8.com"),
                Lection(8, 3, mLectionName = "Farbe tragen", mType = ELectionType.VIDEO, mSection = 3, mPositionInSection = 2, mDuration = "14:18", mUrl = "www.kurs9.com"),
                Lection(9, 3, mLectionName = "Farbe streichen", mType = ELectionType.VIDEO, mSection = 3, mPositionInSection = 3, mDuration = "11:05", mUrl = "www.kurs10.com"),
            // Koch 8 Lections in 2 Sections
                Lection(1, 4, mLectionName = "Kartoffeln", mType = ELectionType.TEXT, mSection = 1, mPositionInSection = 1, mDuration = "3:24", mUrl = "www.kurs1.com"),
                Lection(2, 4, mLectionName = "Mörchen", mType = ELectionType.VIDEO, mSection = 1, mPositionInSection = 2, mDuration = "4:19", mUrl = "www.kurs2.com"),
                Lection(3, 4, mLectionName = "Zwiebeln", mType = ELectionType.AUDIO, mSection = 1, mPositionInSection = 3, mDuration = "1:01", mUrl = "www.kurs3.com"),
                Lection(4, 4, mLectionName = "Nudeln", mType = ELectionType.TEXT, mSection = 1, mPositionInSection = 4, mDuration = "5:11", mUrl = "www.kurs4.com"),
                Lection(5, 4, mLectionName = "Salz", mType = ELectionType.TEXT, mSection = 1, mPositionInSection = 5, mDuration = "3:24", mUrl = "www.kurs1.com"),
                Lection(6, 4, mLectionName = "Kochen", mType = ELectionType.VIDEO, mSection = 2, mPositionInSection = 1, mDuration = "4:19", mUrl = "www.kurs2.com"),
                Lection(7, 4, mLectionName = "Schmoren", mType = ELectionType.AUDIO, mSection = 2, mPositionInSection = 2, mDuration = "1:01", mUrl = "www.kurs3.com"),
                Lection(8, 4, mLectionName = "Braten", mType = ELectionType.TEXT, mSection = 2, mPositionInSection = 3, mDuration = "5:11", mUrl = "www.kurs4.com"),
            )
    )

    fun fetchLections(): MutableLiveData<List<Lection>> {
        return mListOfLections
    }

    fun fetchCourses(): MutableLiveData<List<Course>> {
        return mListOfCourses
    }

    fun fetchCourseById(courseId: String?): Course? {
        return mListOfCourses.value?.filterNot { it.mId.toString() != courseId }?.first() ?: mListOfCourses.value?.get(0)
    }

    fun fetchPopularCourses(): List<Course>? {
        return mListOfCourses.value?.filterNot { it.mPopularity < 3 }
    }

}