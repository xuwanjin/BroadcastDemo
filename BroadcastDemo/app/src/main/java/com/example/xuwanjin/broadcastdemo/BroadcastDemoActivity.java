package com.example.xuwanjin.broadcastdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastDemoActivity extends AppCompatActivity {

    Button sendParallelBroadcast = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendParallelBroadcast = (Button) findViewById(R.id.send_parallel_broadcast_intent);
        sendParallelBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent parallelBroadcastSendIntent = new Intent();
                parallelBroadcastSendIntent.setAction("com.example.xuwanjin.broadcastdemo.BroadcastDemoActivity");
                sendBroadcast(parallelBroadcastSendIntent);
            }
        });
    }
}
