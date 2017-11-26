package com.example.xuwanjin.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.xuwanjin.broadcastdemo.BroadcastDemoConstants.LOCAL_BROADCAST;
import static com.example.xuwanjin.broadcastdemo.BroadcastDemoConstants.ORDERED_BROADCAST;
import static com.example.xuwanjin.broadcastdemo.BroadcastDemoConstants.PARALLEL_BROADCAST;
import static com.example.xuwanjin.broadcastdemo.BroadcastDemoConstants.STICKY_BROADCAST;

public class BroadcastDemoActivity extends AppCompatActivity {

    Button sendParallelBroadcast = null;
    Button sendOrderedBroadcast = null;
    Button sendLocalBroadcast = null;
    Button sendStickyBroadcast = null;
    Button registerBroadcast = null;
    LocalBroadcastManager localBroadcastManager = null;
    BroadcastReceiver localBroadcastReceiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendParallelBroadcast = (Button) findViewById(R.id.send_parallel_broadcast_intent);
        sendParallelBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent parallelBroadcastSendIntent = new Intent();
                parallelBroadcastSendIntent.setAction(PARALLEL_BROADCAST);
                sendBroadcast(parallelBroadcastSendIntent);
            }
        });

        sendOrderedBroadcast = (Button) findViewById(R.id.send_ordered_broadcast);
        sendOrderedBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendOrderedBroadcastIntent = new Intent();
                sendOrderedBroadcastIntent.setAction(ORDERED_BROADCAST);
                sendOrderedBroadcast(sendOrderedBroadcastIntent, null);
            }
        });

        sendStickyBroadcast = (Button) findViewById(R.id.send_sticky_broadcast);
        sendStickyBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stickyBroadcastIntent = new Intent();
                stickyBroadcastIntent.setAction(STICKY_BROADCAST);
                sendStickyBroadcast(stickyBroadcastIntent);
            }
        });

        localBroadcastReceiverRegister();
        sendLocalBroadcast = (Button) findViewById(R.id.send_local_broadcast);
        sendLocalBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent localBroadcastIntent = new Intent();
                localBroadcastIntent.setAction(LOCAL_BROADCAST);
                localBroadcastManager.sendBroadcast(localBroadcastIntent);
            }
        });

        registerBroadcast = (Button) findViewById(R.id.register_broadcast);
        registerBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
                registerReceiver(new RegisterBroadcastReceiver(), intentFilter);
            }
        });

    }

    public void localBroadcastReceiverRegister() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LOCAL_BROADCAST);
        localBroadcastManager = LocalBroadcastManager.getInstance(getApplicationContext());
        localBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(LOCAL_BROADCAST)) {
                    Toast.makeText(context, "Local Broadcast", Toast.LENGTH_SHORT).show();
                }
            }
        };
        localBroadcastManager.registerReceiver(localBroadcastReceiver , intentFilter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(localBroadcastManager != null){
            localBroadcastManager.unregisterReceiver(localBroadcastReceiver);
        }
    }
}
