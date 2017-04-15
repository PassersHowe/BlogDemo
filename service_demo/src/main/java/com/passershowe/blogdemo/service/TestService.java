package com.passershowe.blogdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import android.support.annotation.Nullable;

/**
 * Created by PassersHowe on 2017/4/13.
 */

public class TestService extends Service {

    int mStartMode;       // 指示如果服务被杀死，该如何操作
    IBinder mBinder;      // 客户端绑定接口
    boolean mAllowRebind; // 指示是否应使用onRebind

    @Override
    public void onCreate() {
        //服务正在创建中
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //调用了startService()，服务正在启动
        return mStartMode;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //客户端绑定到具有bindService()的服务
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        //所有客户端都使用unbindService()取消绑定
        return mAllowRebind;
    }

    @Override
    public void onRebind(Intent intent) {
        //客户端绑定到具有bindService()的服务，
        //onUnbind()已经被调用
    }

    @Override
    public void onDestroy() {
        //该服务已不再使用并被销毁
    }
}
