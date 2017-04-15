package com.passershowe.blogdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button staticBtn;
    private Button dynamicBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVIew();
        initDynamicBroadcast();

    }

    private void initVIew() {
        staticBtn = (Button)findViewById(R.id.static_broadcast_btn);
        dynamicBtn = (Button)findViewById(R.id.dynamic_broadcast_btn);

        staticBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendStaticBroadcast();
            }
        });

        dynamicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDynamicBroadcast();
            }
        });

    }

    //发送静态注册的广播
    private void sendStaticBroadcast(){
        String str = "我是静态广播";
        Intent intent = new Intent();
        intent.setAction("NOTIFICATION_DEMO");
        intent.putExtra("data",str);
        sendBroadcast(intent);

    }

    //发送动态注册的广播
    private void sendDynamicBroadcast(){
        String str = "我是动态广播";
        Intent intent = new Intent();
        intent.setAction("DYNAMIC");
        intent.putExtra("data",str);
        sendBroadcast(intent);
    }

    //动态注册广播
    private void initDynamicBroadcast(){
        BroadcastReceiver broadcastReceiver = new DemoBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("DYNAMIC");
        this.registerReceiver(broadcastReceiver,intentFilter);
    }

}
