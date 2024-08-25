package com.droidcourses.composeui.basics

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyText(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        textDecoration = TextDecoration.Underline,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Cursive
        )
}

@Composable
fun MySpanText( modifier: Modifier = Modifier) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(
                color = Color.Red,
                fontStyle = FontStyle.Italic
            )){
                append("H")
            }

            append("ello")

            withStyle(style = SpanStyle(
                color = Color.Red,
                fontStyle = FontStyle.Italic
            )){
                append("A")
            }

            append("ndroid")

        }
    )
}

@Composable
fun SpecialText(modifier: Modifier = Modifier) {
    Text(
        text = "Hello man",
        modifier = modifier
            .padding(20.dp)
            .background(Color.Yellow)
            .border(width = 1.dp, color = Color.Black )
            .clickable {  }
            .padding(10.dp)
        )
}