package com.example.xuwanjin.broadcastdemo;

import android.content.Context;

/**
 * Created by xuwanjin on 7/1/17.
 */

public class BroadcastDemoConstants {

    public static final String PARALLEL_BROADCAST = "com.example.xuwanjin.broadcastdemo.parallelbroadcast";
    public static final String ORDERED_BROADCAST = "com.example.xuwanjin.broadcastdemo.orderedbroadcast";
    public static final String LOCAL_BROADCAST = "com.example.xuwanjin.broadcastdemo.localbroadcast";
    public static final String STICKY_BROADCAST = "com.example.xuwanjin.broadcastdemo.stickybroadcast";

    public static String getBroadcastType(Context context, int resId){
        return context.getResources().getString(resId).trim();
    }
}
