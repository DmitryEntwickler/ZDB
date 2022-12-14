package com.example.probeui.core.repo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.lifecycle.MutableLiveData
import com.example.probeui.classes.Course
import com.example.probeui.classes.ELectionType
import com.example.probeui.classes.Lection

class Repositiry {

    val mListOfActualCourses = MutableLiveData(
        listOf(
            Course(1, Icons.Default.Person, "Bauhelfer", 0F, 5.0, 3, 10),
            Course(2, Icons.Default.Person, "allseitsstaatlichgeprüfter Fliesenleger", 0.55F, 2.5, 2, 12),
            Course(3, Icons.Default.Person, "Maler", 0.10F, 4.0, 4, 22),
            Course(4, Icons.Default.Person, "Frieseur", 0.20F, 10.0, 14, 38),
            Course(5, Icons.Default.Person, "Koch", 0F, 14.0, 24, 93),
        )
    )

    val mListOfFavouriteCourses = MutableLiveData(
        listOf(
            Course(11, Icons.Default.Person, "allseitsstaatlichgeprüfter Fliesenleger", 0.55F, 2.5, 2, 12),
            Course(6, Icons.Default.Person, "Chef", 0F, 1.5, 1, 3),
            Course(7, Icons.Default.Person, "Kleiner Chef", 0F, 1.0, 1, 2),
            Course(8, Icons.Default.Person, "Chefhelfer", 0F, 0.5, 1, 1),
            Course(9, Icons.Default.Person, "Top Manager", 0F, 13.0, 5, 29),
            Course(10, Icons.Default.Person, "Bauhelfer", 0F, 5.0, 8, 35),
        )
    )

    val mDescription = "dieser text hat eigentlich gar keinen wirklichen inhalt. aber er hat auch keine relevanz, und deswegen ist das egal. er dient lediglich als platzhalter. um mal zu zeigen, wie diese stelle der seite aussieht, wenn ein paar zeilen vorhanden sind. ob sich der text dabei gut fühlt, weiß ich nicht. ich schätze, eher nicht, denn wer fühlt sich schon gut als platzhalter. aber irgendwer muss diesen job ja machen und deshalb kann ich es nicht ändern."

    val mCourseSections1 = MutableLiveData(
        listOf(
            listOf(
                Lection(1, mLectionName = "Einleitung", mType = ELectionType.TEXT, mCourseName = "Bauhelfer", mSection = 1, mPositionInSection = 1, mDuration = "3:24", mUrl = "www.kurs1.com"),
                Lection(2, mLectionName = "Grundlagen", mType = ELectionType.VIDEO, mCourseName = "Bauhelfer", mSection = 1, mPositionInSection = 2, mDuration = "4:19", mUrl = "www.kurs2.com"),
                Lection(3, mLectionName = "Arbeitsschutz", mType = ELectionType.AUDIO, mCourseName = "Bauhelfer", mSection = 1, mPositionInSection = 3, mDuration = "1:01", mUrl = "www.kurs3.com")
            ),
            listOf(
                Lection(4, mLectionName = "Was ist eine Baustelle", mType = ELectionType.TEXT, mCourseName = "Bauhelfer", mSection = 2, mPositionInSection = 1, mDuration = "5:11", mUrl = "www.kurs4.com"),
                Lection(5, mLectionName = "Winterbaustelle", mType = ELectionType.VIDEO, mCourseName = "Bauhelfer", mSection = 2, mPositionInSection = 2, mDuration = "4:18", mUrl = "www.kurs5.com"),
                Lection(6, mLectionName = "Sommerbaustelle", mType = ELectionType.VIDEO, mCourseName = "Bauhelfer", mSection = 2, mPositionInSection = 3, mDuration = "1:05", mUrl = "www.kurs6.com"),
                Lection(7, mLectionName = "Jahresbaustelle", mType = ELectionType.VIDEO, mCourseName = "Bauhelfer", mSection = 2, mPositionInSection = 4, mDuration = "3:23", mUrl = "www.kurs7.com"),
            ),
            listOf(
                Lection(8, mLectionName = "Beton mischen", mType = ELectionType.VIDEO, mCourseName = "Bauhelfer", mSection = 3, mPositionInSection = 1, mDuration = "25:11", mUrl = "www.kurs8.com"),
                Lection(9, mLectionName = "Beton tragen", mType = ELectionType.VIDEO, mCourseName = "Bauhelfer", mSection = 3, mPositionInSection = 2, mDuration = "14:18", mUrl = "www.kurs9.com"),
                Lection(10, mLectionName = "Beton schneiden", mType = ELectionType.VIDEO, mCourseName = "Bauhelfer", mSection = 3, mPositionInSection = 3, mDuration = "11:05", mUrl = "www.kurs10.com"),
            )
        )
    )
    val mCourseSections2 = MutableLiveData(
        listOf(
            listOf(
                Lection(1, mLectionName = "Einleitung", mType = ELectionType.TEXT, mCourseName = "Maler", mSection = 1, mPositionInSection = 1, mDuration = "3:24", mUrl = "www.kurs1.com"),
                Lection(2, mLectionName = "Grundlagen", mType = ELectionType.VIDEO, mCourseName = "Maler", mSection = 1, mPositionInSection = 2, mDuration = "4:19", mUrl = "www.kurs2.com"),
            ),
            listOf(
                Lection(3, mLectionName = "Was ist Farbe", mType = ELectionType.TEXT, mCourseName = "Maler", mSection = 2, mPositionInSection = 1, mDuration = "5:11", mUrl = "www.kurs4.com"),
                Lection(4, mLectionName = "Farbetypen", mType = ELectionType.VIDEO, mCourseName = "Maler", mSection = 2, mPositionInSection = 2, mDuration = "4:18", mUrl = "www.kurs5.com"),
                Lection(5, mLectionName = "Gelbe Farbe", mType = ELectionType.VIDEO, mCourseName = "Maler", mSection = 2, mPositionInSection = 3, mDuration = "1:05", mUrl = "www.kurs6.com"),
                Lection(6, mLectionName = "Blaue Farbe", mType = ELectionType.VIDEO, mCourseName = "Maler", mSection = 2, mPositionInSection = 4, mDuration = "3:23", mUrl = "www.kurs7.com"),
            ),
            listOf(
                Lection(7, mLectionName = "Farbe mischen", mType = ELectionType.VIDEO, mCourseName = "Maler", mSection = 3, mPositionInSection = 1, mDuration = "25:11", mUrl = "www.kurs8.com"),
                Lection(8, mLectionName = "Farbe tragen", mType = ELectionType.VIDEO, mCourseName = "Maler", mSection = 3, mPositionInSection = 2, mDuration = "14:18", mUrl = "www.kurs9.com"),
                Lection(9, mLectionName = "Farbe streichen", mType = ELectionType.VIDEO, mCourseName = "Maler", mSection = 3, mPositionInSection = 3, mDuration = "11:05", mUrl = "www.kurs10.com"),
            )
        )
    )

    private fun fetschFromRemote(courseId: String): MutableLiveData<List<List<Lection>>>{
        return when (courseId) {
            "1" -> mCourseSections1
            else -> mCourseSections2
        }
    }
}