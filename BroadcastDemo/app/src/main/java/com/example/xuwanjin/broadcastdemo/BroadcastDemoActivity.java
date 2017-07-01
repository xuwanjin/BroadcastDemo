package com.example.xuwanjin.broadcastdemo;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.xuwanjin.broadcastdemo.BroadcastDemoConstants.ORDERED_BROADCAST;
import static com.example.xuwanjin.broadcastdemo.BroadcastDemoConstants.PARALLEL_BROADCAST;

public class BroadcastDemoActivity extends AppCompatActivity {

    Button sendParallelBroadcast = null;
    Button sendOrderedBroadcast = null;

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
    }

}
