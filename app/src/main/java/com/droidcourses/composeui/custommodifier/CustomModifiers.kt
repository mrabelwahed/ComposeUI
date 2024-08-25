package com.droidcourses.composeui.custommodifier

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout

@SuppressLint("ModifierFactoryUnreferencedReceiver", "UnnecessaryComposedModifier")
fun Modifier.gradientBackground(colors: List<Color>) = composed {
    drawWithContent {
        drawRect(
            brush = Brush.verticalGradient(colors),
            size = size
        )
        drawContent()
    }
}

fun Modifier.myaspectRatio(ratio:Float) = composed {
    layout { measurable, constraints ->  
        val width = constraints.maxWidth
        val height = (width/ratio).toInt()
         val placeable = measurable.measure(
            constraints.copy(minHeight = height, maxHeight = height)
        )
        layout(width,height) {
            placeable.place(0,0)
        }
    }
}