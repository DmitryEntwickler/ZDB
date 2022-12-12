package com.example.probeui.core.repo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.lifecycle.MutableLiveData
import com.example.probeui.classes.Course

class Repositiry {

    val mListOfActualCourses = MutableLiveData(
        listOf(
            Course(1, Icons.Default.Person, "Bauhelfer", 0F, 5.0, 8, 35),
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
}