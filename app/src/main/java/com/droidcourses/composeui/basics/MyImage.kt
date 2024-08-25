package com.droidcourses.composeui.basics

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.droidcourses.composeui.R

@Composable
fun MyImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.business) ,
        contentDescription = null,
        modifier = modifier
            .padding(20.dp)
            .size(200.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Gray)
            .border(width = 5.dp, Color.Magenta, shape = CircleShape)
            .padding(20.dp)
            .clip(CircleShape)
        )
}
