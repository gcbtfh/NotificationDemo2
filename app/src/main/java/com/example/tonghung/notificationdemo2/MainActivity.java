package com.example.tonghung.notificationdemo2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button) findViewById(R.id.button);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChildActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int)
                        System
                        .currentTimeMillis(), intent, 0);

                Notification notification = new NotificationCompat.Builder(MainActivity.this)
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent)
                        .setContentText("I'm demonstrating how to create notification")
                        .setContentTitle("This is notification's title")
                        .setSmallIcon(android.R.drawable.ic_lock_idle_lock).build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0, notification);
            }
        });
    }
}
