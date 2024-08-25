package com.droidcourses.composeui

import BasicCircle
import BasicRadialCircle
import BasicRect
import BasicStrokeRect
import CarCanvas
import DrawLine1
import DrawLine2
import DrawMultipleLines
import DrawPieChart
import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.widget.GridLayout.Spec
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.droidcourses.composeui.basics.MyButton
import com.droidcourses.composeui.basics.MyIcon
import com.droidcourses.composeui.basics.MyIcon2
import com.droidcourses.composeui.basics.MyText
import com.droidcourses.composeui.canvas.InstagramLogo
import com.droidcourses.composeui.navigation.DPage1
import com.droidcourses.composeui.navigation.DPage2
import com.droidcourses.composeui.navigation.NPage1
import com.droidcourses.composeui.navigation.NPage2
import com.droidcourses.composeui.navigation.Page1
import com.droidcourses.composeui.navigation.Page2
import com.droidcourses.composeui.ui.theme.ComposeUITheme
import com.droidcourses.composeui.ui.themechanger.settings.UserSettings
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var userSettings: UserSettings

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

//            val theme = userSettings.themeStream.collectAsState()
//
//            val useDarkColors: Boolean = when (theme.value) {
//                AppThemMode.Mode_Light -> false
//                AppThemMode.Mode_Dark -> true
//                AppThemMode.Mode_Auto -> isSystemInDarkTheme()
//            }

            ComposeUITheme(darkTheme = false) {
                val navHostController = rememberNavController()
                NavHost(navHostController, "page1") {
                    composable("page1") {
                        NPage1(navHostController, modifier = Modifier.fillMaxSize())
                    }
                    composable("page2/{money}?bouns={bouns}", arguments = listOf(
                        navArgument("money") {
                            type = NavType.IntType
                        },
                        navArgument("bouns") {
                            type = NavType.IntType
                            defaultValue = 2407
                        }
                    )) { backStackEntry ->
                        NPage2(navHostController,
                            backStackEntry.arguments?.getInt("money"),
                            backStackEntry.arguments?.getInt("bouns"),
                            modifier = Modifier.fillMaxSize())
                    }
                }
            }
        }
    }


    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        MyText(name)
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        ComposeUITheme {
            CarCanvas()
        }
    }
}

