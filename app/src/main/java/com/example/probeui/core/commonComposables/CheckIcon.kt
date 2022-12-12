package com.example.probeui.core.commonComposables

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.probeui.ui.theme.GreenZDB

@Composable
fun CheckIcon(icon: ImageVector) {

    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = GreenZDB,
        modifier = Modifier.size(18.dp)
    )
}