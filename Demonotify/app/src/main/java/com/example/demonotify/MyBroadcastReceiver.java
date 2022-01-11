package com.example.demonotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"recieved",Toast.LENGTH_SHORT).show();

        String action=intent.getStringExtra("action");
        if(action.equals("action1")){
            Toast.makeText(context.getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();        }
        else if(action.equals("action2")){
           // performAction2();

        }
        //This is used to close the notification tray

    }
    }
