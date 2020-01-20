package com.example.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import androidx.core.app.NotificationManagerCompat;

public class BroadcastRecieverExample extends BroadcastReceiver {



    private NotificationManagerCompat notificationManagerCompat;
    Context context;


    public BroadcastRecieverExample(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {

        boolean noConnectivity;

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
        {
            noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,
                    false
            );

            if (noConnectivity)
            {
                Toast.makeText(context,"Disconnect", Toast.LENGTH_SHORT).show();

            }
            else
            {
                Toast.makeText(context,"Connected",Toast.LENGTH_SHORT).show();
            }

        }


    }
}
