package com.droidcourses.composeui.camera.domain

import androidx.camera.view.LifecycleCameraController

interface CameraRepository {
  suspend fun takePhoto(controller: LifecycleCameraController)
  suspend fun recordVideo(controller: LifecycleCameraController)
}