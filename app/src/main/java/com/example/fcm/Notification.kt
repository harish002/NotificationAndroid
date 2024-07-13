package com.example.fcm

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App:Application() {
      val channel_ID ="CHANNEL_1_ID"
     val channel_ID2 ="CHANNEL_2_ID"
    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel.
            val name = getString(R.string.notification_channel)
            val descriptionText = "getString(R.string.channel_description)"
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val mChannel = NotificationChannel(channel_ID, name, importance)
            mChannel.description = descriptionText

            val mChannel2 = NotificationChannel(channel_ID2, getString(R.string.notification_channel2),
                NotificationManager.IMPORTANCE_HIGH)
            mChannel2.description = descriptionText


            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(mChannel)
            notificationManager.createNotificationChannel(mChannel2)
        }

    }
}