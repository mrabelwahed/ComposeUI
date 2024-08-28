package com.droidcourses.composeui.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MessageReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val msg = intent?.getStringExtra("message")
        msg?.let {
            Toast.makeText(context,"hello $msg", Toast.LENGTH_SHORT).show()
        }
    }
}