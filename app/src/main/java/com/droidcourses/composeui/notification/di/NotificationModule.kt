package com.droidcourses.composeui.notification.di

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.droidcourses.composeui.R
import com.droidcourses.composeui.notification.MessageReceiver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NotificationModule {

    @Provides
    @Singleton
    fun provideNotificationManager(@ApplicationContext context: Context): NotificationManagerCompat{
        val manager =  NotificationManagerCompat.from(context)
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
             val notificationChannel = NotificationChannel("Main Channel ID",  "Main Channel", NotificationManager.IMPORTANCE_DEFAULT)
             manager.createNotificationChannel(notificationChannel)
        }
        return  manager
    }

    @Provides
    @Singleton
    fun provideNotificationBuilder(@ApplicationContext context: Context): NotificationCompat.Builder {
        val intent = Intent(context, MessageReceiver::class.java).apply {
            putExtra("message","compose ui asking you something")
        }
        val flag = PendingIntent.FLAG_IMMUTABLE
        val pendingIntent = PendingIntent.getBroadcast(context,0,intent, flag)
        return NotificationCompat.Builder(context,"Main Channel ID")
            .setContentTitle("test")
            .setContentText("Compose UI APP")
            .setSmallIcon(R.drawable.baseline_notifications_none_24)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setVisibility(NotificationCompat.VISIBILITY_SECRET)
            .addAction(0,"Message", pendingIntent)

    }
}