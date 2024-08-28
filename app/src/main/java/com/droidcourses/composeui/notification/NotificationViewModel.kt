package com.droidcourses.composeui.notification

import android.annotation.SuppressLint
import android.app.NotificationManager
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    private val notificationManager: NotificationManagerCompat,
    private val notificationBuilder: NotificationCompat.Builder
): ViewModel() {

    @SuppressLint("MissingPermission")
    fun showNormalNotification() {
        notificationManager.notify(1, notificationBuilder.build())
    }

    @SuppressLint("MissingPermission")
    fun updateNotification() {
        notificationManager.notify(1, notificationBuilder.setContentText("play around updating ....").build())
    }


    @SuppressLint("MissingPermission")
    fun cancelNotification() {
        notificationManager.cancel(1)
    }

}