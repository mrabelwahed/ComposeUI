package com.droidcourses.composeui.stopwatch

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class StopWatchService : Service() {
     val binder = StopWatchBinder()

    override fun onBind(intent: Intent): IBinder  = binder

    inner class StopWatchBinder: Binder() {
        fun getService(): StopWatchService = this@StopWatchService
    }
}