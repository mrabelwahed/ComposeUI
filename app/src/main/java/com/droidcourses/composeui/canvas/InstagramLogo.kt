package com.droidcourses.composeui.canvas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun InstagramLogo(modifier: Modifier = Modifier) {
    val colors = listOf(Color.Yellow, Color.Red, Color.Magenta)
    Canvas(modifier.size(100.dp).padding(10.dp)) {
        drawRoundRect(
            brush = Brush.linearGradient(colors),
            style = Stroke(width = 15f),
            cornerRadius = CornerRadius(x = 45f)
        )
        drawCircle(
            brush = Brush.linearGradient(colors),
            style = Stroke(width = 15f),
            radius = 45f
        )
        drawCircle(
            brush = Brush.linearGradient(colors),
            center = Offset(size.width * 0.8f, size.height * 0.2f),
            radius = 15f
        )
    }
}