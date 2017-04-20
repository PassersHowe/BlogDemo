package com.passershowe.blogdemo.anr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button longTimeBtn;
    private Button receiverLongBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView(){
        longTimeBtn = (Button)findViewById(R.id.long_time_btn);
        receiverLongBtn = (Button)findViewById(R.id.receiver_long_btn);

        //未响应输入事件模拟(多次点击,等待一段时间)
        longTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Thread.sleep(20000);
                }catch( Exception e){

                }
            }
        });

        //广播耗时操作模拟(多次点击)
        receiverLongBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LongTimeBroadcast.class);
                intent.setAction("LONG_TIME");
                sendBroadcast(intent);
            }
        });


    }


}
