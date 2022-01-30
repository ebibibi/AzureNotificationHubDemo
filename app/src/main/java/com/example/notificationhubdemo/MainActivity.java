package com.example.notificationhubdemo;

import androidx.appcompat.app.AppCompatActivity;

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

        Log.d("xxxxxxxxxxxx", "Test");


        String hubName = "jbs-notificationHub";
        String connectionString = "Endpoint=sb://jbs-notificationHub-namespace.servicebus.windows.net/;SharedAccessKeyName=DefaultFullSharedAccessSignature;SharedAccessKey=PBH1OJ6tCr3WxrNkX1PkknIhJPsaHi0lFxGs2/N6I3U=";

        NotificationHub.start(this.getApplication(), hubName, connectionString);

    }
}