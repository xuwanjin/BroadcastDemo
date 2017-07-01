package com.example.xuwanjin.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by xuwanjin on 7/1/17.
 */

public class OrderedBroadcastReceiverLowPriority extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Constants.ORDERED_BROADCAST)) {
            Toast.makeText(context, "this is Low priority broadcast", Toast.LENGTH_LONG).show();
        }
    }
}
