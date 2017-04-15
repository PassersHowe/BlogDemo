package com.passershowe.blogdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {
    private static final String TAG = "MainActivity";
    private Button otherBtn;
    private Button dialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        writeLog("onCreate");
        initView();

    }


    @Override
    protected void onStart() {
        super.onStart();
        writeLog("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        writeLog("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        writeLog("onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        writeLog("onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        writeLog("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        writeLog("onDestroy");
    }


    private void initView() {
        otherBtn = (Button) findViewById(R.id.other_btn);
        dialogBtn = (Button) findViewById(R.id.dialog_btn);
        //打开其他Activity
        otherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),OtherActivity.class));
            }
        });
        //打开对话框Activity
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DialogActivity.class));
            }
        });

    }

    /**
     * 打印生命周期日志
     * @param text 内容
     */
    private void writeLog(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        Log.i(TAG, text);

    }

}
