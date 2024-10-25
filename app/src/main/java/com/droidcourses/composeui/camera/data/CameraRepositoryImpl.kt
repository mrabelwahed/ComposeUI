package com.droidcourses.composeui.camera.data

import android.annotation.SuppressLint
import android.app.Application
import android.content.ContentResolver
import android.content.ContentValues
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.core.impl.utils.MatrixExt
import androidx.camera.core.impl.utils.MatrixExt.postRotate
import androidx.camera.view.LifecycleCameraController
import androidx.compose.ui.graphics.Matrix
import androidx.core.content.ContextCompat
import com.droidcourses.composeui.R
import com.droidcourses.composeui.camera.domain.CameraRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Appendable
import javax.inject.Inject

class CameraRepositoryImpl @Inject constructor(private val application: Application): CameraRepository {
    override suspend fun takePhoto(controller: LifecycleCameraController) {
       controller.takePicture(ContextCompat.getMainExecutor(application),
           object : ImageCapture.OnImageCapturedCallback(){
               @RequiresApi(Build.VERSION_CODES.Q)
               override fun onCaptureSuccess(image: ImageProxy) {
                   super.onCaptureSuccess(image)
//                   val matrix = Matrix().apply {
//                       postRotate(
//                           this,
//                           image.imageInfo.rotationDegrees.toFloat(),
//                           0f,0f
//                       )
//                   }
                   val imageBitmap = Bitmap.createBitmap(image.toBitmap())
                   CoroutineScope(Dispatchers.IO).launch {
                       savePhoto(imageBitmap)
                   }
               }

           })
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private suspend fun savePhoto(bitmap: Bitmap) {
        withContext(Dispatchers.IO) {
            val resolver: ContentResolver = application.contentResolver

            val imageCollection = MediaStore.Images.Media.getContentUri(
                MediaStore.VOLUME_EXTERNAL_PRIMARY
            )

            val appName = application.getString(R.string.app_name)
            val timeInMillis = System.currentTimeMillis()

            val imageContentValues: ContentValues = ContentValues().apply {
                put(
                    MediaStore.Images.Media.DISPLAY_NAME,
                    "${timeInMillis}_image" + ".jpg"
                )
                put(
                    MediaStore.MediaColumns.RELATIVE_PATH,
                    Environment.DIRECTORY_DCIM + "/$appName"
                )
                put(MediaStore.Images.Media.MIME_TYPE, "image/jpg")
                put(MediaStore.MediaColumns.DATE_TAKEN, timeInMillis)
                put(MediaStore.MediaColumns.IS_PENDING, 1)
            }

            val imageMediaStoreUri: Uri? = resolver.insert(
                imageCollection, imageContentValues
            )

            imageMediaStoreUri?.let { uri ->
                try {
                    resolver.openOutputStream(uri)?.let { outputStream ->
                        bitmap.compress(
                            Bitmap.CompressFormat.JPEG, 100, outputStream
                        )
                    }

                    imageContentValues.clear()
                    imageContentValues.put(
                        MediaStore.MediaColumns.IS_PENDING, 0
                    )
                    resolver.update(
                        uri, imageContentValues, null, null
                    )

                } catch (e: Exception) {
                    e.printStackTrace()
                    resolver.delete(uri, null, null)
                }
            }
        }
    }

    override suspend fun recordVideo(controller: LifecycleCameraController) {
    }
}