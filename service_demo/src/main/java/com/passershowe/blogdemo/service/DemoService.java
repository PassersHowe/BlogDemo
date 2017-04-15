package com.passershowe.blogdemo.service;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by PassersHowe on 2017/4/12.
 */

public class DemoService extends Service {
    private static final String TAG = "DemoService";
    private Looper mServiceLooper;
    private ServiceHandle mServiceHandle;

    private final int NOTIFICATION_ID = 0x0001;

    @Override
    public void onCreate() {
        //启动运行该服务的线程
        HandlerThread thread = new HandlerThread("ServiceStartArguments", Process
                .THREAD_PRIORITY_BACKGROUND);
        thread.start();

        //获取HandlerThread的Looper并将其用于自己的Handler
        mServiceLooper = thread.getLooper();
        mServiceHandle = new ServiceHandle(mServiceLooper);

        //去掉该前台通知栏显示，则与继承IntentService执行相同的工作。
        initNotification();


    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "服务启动");
        Toast.makeText(this, "服务启动", Toast.LENGTH_SHORT).show();

        //每一个启动请求，发送一个消息来启动一个工作并提交开始Id
        Message msg = mServiceHandle.obtainMessage();
        msg.arg1 = startId;
        mServiceHandle.sendMessage(msg);

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "服务销毁");
        Toast.makeText(this, "服务销毁", Toast.LENGTH_SHORT).show();
    }

    //从线程接收消息的处理程序
    private final class ServiceHandle extends Handler {
        public ServiceHandle(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            //模拟耗时操作,线程沉睡5秒
            try {
                Log.i(TAG, "服务工作中，模拟耗时操作");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            stopSelf(msg.arg1);
        }
    }

    //开启一个通知，使服务变为前台服务
    private void initNotification(){
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Notification title")
                .setContentText("Notification describe")
                .setSmallIcon(R.mipmap.ic_launcher);

        Intent notificationIntent = new Intent(this,DemoActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);

        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        startForeground(NOTIFICATION_ID,notification);
        Log.i(TAG, "显示状态栏通知");
    }
}
