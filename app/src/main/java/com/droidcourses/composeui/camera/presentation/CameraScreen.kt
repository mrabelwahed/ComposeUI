package com.droidcourses.composeui.camera.presentation

import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.droidcourses.composeui.MainActivity
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun CameraScreen(modifier: Modifier = Modifier, activity: MainActivity) {
    val viewModel = hiltViewModel<CameraViewModel>()
    val isRecording = viewModel.isRecording.collectAsState()
    val controller = remember {
        LifecycleCameraController(activity.applicationContext).apply {
            setEnabledUseCases(CameraController.IMAGE_CAPTURE or CameraController.VIDEO_CAPTURE)
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)){
        val lifecycleOwner = LocalLifecycleOwner.current
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = {
                PreviewView(it).apply {
                    this.controller = controller
                    controller.bindToLifecycle(lifecycleOwner)
                }
            }
        )
    }
}