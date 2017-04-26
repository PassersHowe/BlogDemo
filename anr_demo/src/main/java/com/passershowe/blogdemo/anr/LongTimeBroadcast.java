package com.passershowe.blogdemo.anr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by PassersHowe on 2017/4/19.
 */

public class LongTimeBroadcast extends BroadcastReceiver {
    private static final String TAG = "LongTimeBroadcast";

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            Log.i(TAG,"广播耗时操作模拟");
            Thread.sleep(12000);

        } catch (Exception e) {


        }

    }

}
