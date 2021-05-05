package com.example.bildirimlerhaknda

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity()
{
    lateinit var manager : NotificationManager
    lateinit var chanel : NotificationChannel
    lateinit var builder: Notification.Builder
    private val chanelId = "com.example.bildirimlerhaknda"
    private val deme = "deme Bildirim1"
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    }

    fun bildir( v: View)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            chanel = NotificationChannel(chanelId,deme,NotificationManager.IMPORTANCE_HIGH)
            chanel.enableLights(true)
            chanel.lightColor = Color.MAGENTA
            chanel.enableVibration(true)
            chanel.audioAttributes
            manager.createNotificationChannel(chanel)

            builder = Notification.Builder(this,chanelId)
                .setContentTitle("Title")
                .setContentText("Texxxtt")
                .setSmallIcon(R.drawable.ic_baseline_add_alert_24)
        }else{

            builder = Notification.Builder(this)
                .setContentTitle("Title")
                .setContentText("Texxxtt")
                .setSmallIcon(R.drawable.ic_baseline_add_alert_24)



        }
        manager.notify(1234,builder.build())


    }
}