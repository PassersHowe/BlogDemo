package com.passershowe.blogdemo.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button startedServiceBtn;
    private Button startedIntentServiceBtn;
    private Button boundServiceBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView(){
        startedServiceBtn = (Button)findViewById(R.id.open_started_service_btn);
        startedIntentServiceBtn = (Button)findViewById(R.id.open_started_intent_service_btn);
        boundServiceBtn = (Button)findViewById(R.id.open_bound_service_btn);

        //启动服务，继承Service
        startedServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toStartService(DemoService.class);
            }
        });

        //启动服务，继承IntentService
        startedIntentServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toStartService(DemoIntentService.class);
            }
        });

        //绑定服务
        boundServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void toStartService(Class claxx){

        Intent intent = new Intent(this,claxx );

        startService(intent);

    }

}
