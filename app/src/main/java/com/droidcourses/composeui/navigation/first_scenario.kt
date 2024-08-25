package com.droidcourses.composeui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun Page1(navHostController: NavHostController , modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center){
        Button(onClick = {
            navHostController.navigate("page2")
        }) {
            Text(text ="click me")
        }
    }

}

@Composable
fun Page2(navHostController: NavHostController, modifier: Modifier = Modifier) {
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