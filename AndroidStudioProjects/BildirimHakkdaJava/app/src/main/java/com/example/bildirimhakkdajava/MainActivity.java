package com.example.bildirimhakkdajava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

    }

    public void bildir(View v)
    {
        String id = "iiiddd";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(id,"Kanaladı",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);


            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,id)
                    .setSmallIcon(R.drawable.ic_baseline_add_alert_24)
                    .setContentTitle("Bidrim  dikkat !!")
                    .setContentText("Bidririm içerigi mesajı");
            manager.notify(1234,builder.build());
        }



    }
}