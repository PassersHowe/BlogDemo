package com.passershowe.blogdemo.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by PassersHowe on 2017/4/12.
 */

public class DemoIntentService extends IntentService {
    private static final String TAG = "DemoIntentService";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public DemoIntentService(String name) {
        super(name);
    }

    public DemoIntentService() {
        super("DemoIntentService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //模拟耗时操作，线程沉睡5秒
        try {
            Log.i(TAG, "onHandleIntent：服务工作中");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        }
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this, "服务启动", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "服务启动");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "服务结束");
    }
}
