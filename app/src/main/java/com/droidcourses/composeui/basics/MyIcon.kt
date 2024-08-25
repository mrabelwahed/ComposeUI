package com.droidcourses.composeui.basics

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.droidcourses.composeui.R

@Composable
fun MyIcon(modifier: Modifier = Modifier) {
    Icon(imageVector = Icons.Default.Email, contentDescription = "email")
}

@Composable
fun MyIcon2(modifier: Modifier = Modifier) {
    Icon(painter = painterResource(R.drawable.outline_back_hand_24), contentDescription = "hand")
}

@Composable
fun MyIconBtn(modifier: Modifier = Modifier) {
    IconButton(onClick = {}) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "email",
            tint = Color.Green
        )
    }
}

