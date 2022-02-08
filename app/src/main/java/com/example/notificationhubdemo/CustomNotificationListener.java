package com.example.notificationhubdemo;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.RemoteMessage;
import com.microsoft.windowsazure.messaging.notificationhubs.NotificationListener;

import java.util.Map;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;



public class CustomNotificationListener implements NotificationListener {

    @Override
    public void onPushNotificationReceived(Context context, RemoteMessage remoteMessage) {
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        String title = notification.getTitle();
        String body = notification.getBody();
        String tag = "Azure Notification Hub";
        Map<String, String> data = remoteMessage.getData();
        Log.d("test3", "test3");
        Log.d(tag, "Message Notification Title: " + title);
        Log.d(tag, "Message Notification Body: " + remoteMessage);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Azure")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle(title)
                .setContentText(body)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, builder.build());




    }



}
