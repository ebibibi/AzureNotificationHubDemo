package com.example.notificationhubdemo;

import android.content.Context;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;
import com.microsoft.windowsazure.messaging.notificationhubs.NotificationListener;

import java.util.Map;

public class CustomNotificationListener implements NotificationListener {

    @Override
    public void onPushNotificationReceived(Context context, RemoteMessage remoteMessage) {
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        String title = notification.getTitle();
        String body = notification.getBody();
        Map<String, String> data = remoteMessage.getData();

        if(remoteMessage != null) {
            Log.d("xxxxxxxxxxxx", "Message Notification Title: " + title);
            Log.d("xxxxxxxxxxxx", "Message Notification Body: " + remoteMessage);
        }

        if(data != null) {
            for(Map.Entry<String, String> entry : data.entrySet()) {
                Log.d("xxxxxxxxxxxx", "key, " + entry.getKey() + " value " + entry.getValue());
            }
        }
    }
}
