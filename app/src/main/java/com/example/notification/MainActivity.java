package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btndisplaynoti, btndisplaynoti2;
    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        Createchannel channel = new Createchannel(this);
        channel.createChannel();

        btndisplaynoti = findViewById(R.id.btndisplaynoti);
        btndisplaynoti2 = findViewById(R.id.btndisplaynoti2);

        btndisplaynoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayNotification();
            }
        });

        btndisplaynoti2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayNotification2();
            }
        });

    }

    private void DisplayNotification()
    {
        Notification notification = new NotificationCompat.Builder(this, Createchannel.CHANNEL_1 )
                .setSmallIcon(R.drawable.message)
                .setContentTitle("First Message")
                .setContentTitle("First Message Body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1, notification);
    }

    private void DisplayNotification2()
    {
        Notification notification = new NotificationCompat.Builder(this,Createchannel.CHANNEL_2)
                .setSmallIcon(R.drawable.call)
                .setContentTitle("First call")
                .setContentTitle("First call body")
                .setCategory(NotificationCompat.CATEGORY_CALL)
                .build();
        notificationManagerCompat.notify(2, notification);
    }
}
