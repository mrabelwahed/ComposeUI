package com.droidcourses.composeui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun DPage1(navHostController: NavHostController , modifier: Modifier = Modifier) {
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navHostController.navigate("d_page2")
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center){
        CircularProgressIndicator()
    }

}

@Composable
fun DPage2(navHostController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(Color.Magenta),
        contentAlignment = Alignment.Center){
        Button(onClick = {
            navHostController.navigateUp()
        }) {
            Text(text ="back me")
        }
    }
}