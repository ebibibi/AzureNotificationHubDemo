package com.example.notificationhubdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.microsoft.windowsazure.messaging.notificationhubs.NotificationHub;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationHub.setListener(new CustomNotificationListener());

        Log.d("Azure Notification Hub", "test6");

        createNotificationChannel();

        String hubName = "jbs-notificationHub";
        String connectionString = "Endpoint=sb://jbs-notificationHub-namespace.servicebus.windows.net/;SharedAccessKeyName=test;SharedAccessKey=b1MbWxukspIS0ic8Ch9XumdlN5rwzk9ig9YWZQ8MTOg=";

        NotificationHub.start(this.getApplication(), hubName, connectionString);

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Azure Notification Hub";
            String description = "Azure Notification Hub Sample";
            NotificationChannel channel = new NotificationChannel("Azure", name, NotificationManager.IMPORTANCE_MAX);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}