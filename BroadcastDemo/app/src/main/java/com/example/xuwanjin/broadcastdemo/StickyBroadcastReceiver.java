package com.example.xuwanjin.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by xuwanjin on 7/2/17.
 */

public class StickyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(BroadcastDemoConstants.STICKY_BROADCAST)){
            Toast.makeText(context, "we got a sticky broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
