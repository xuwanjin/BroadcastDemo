package com.example.xuwanjin.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by xuwanjin on 11/26/17.
 */

public class RegisterBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){
            Toast.makeText(context, "Receiver the Registered Broadcast", Toast.LENGTH_LONG).show();
        }
    }
}
