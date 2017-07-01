package com.example.xuwanjin.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by xuwanjin on 7/1/17.
 */

public class ParallelBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(BroadcastDemoConstants.PARALLEL_BROADCAST)){
            Toast.makeText(context, "we just got a ParallelBroadcastReceiver", Toast.LENGTH_LONG).show();
        }
    }
}
