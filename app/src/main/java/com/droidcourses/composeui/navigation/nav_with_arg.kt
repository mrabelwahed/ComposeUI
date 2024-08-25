package com.droidcourses.composeui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun NPage1(navHostController: NavHostController , modifier: Modifier = Modifier) {
    // get data return from previous screen
    val res = navHostController
        .currentBackStackEntry?.
        savedStateHandle?.getStateFlow<Int>("res",0)?.collectAsState()?.value

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center){
        Button(onClick = {
            navHostController.navigate("page2/123?bouns=30")
        }) {
            Text(text ="click me $res")
        }
    }

}

@Composable
fun NPage2(navHostController: NavHostController, money: Int?,bouns: Int?, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(Color.Magenta),
        contentAlignment = Alignment.Center){
        Button(onClick = {
            navHostController.previousBackStackEntry?.savedStateHandle?.set("res",100)
            navHostController.navigateUp()
        }) {
            Text(text ="back me .... ${money}...${bouns}")
        }
    }
}