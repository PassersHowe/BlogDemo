package com.passershowe.blogdemo.thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ImageView showImage;
    private Button errorDownImageBtn;
    private Button downImageBtn;
    private Button asyncDownImageBtn;
    private String url = "http://www.passershowe.com/img/head.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initOnClickListener();
    }


    private void initView() {
        showImage = (ImageView) findViewById(R.id.show_image);
        downImageBtn = (Button) findViewById(R.id.down_image_btn);
        errorDownImageBtn = (Button) findViewById(R.id.error_down_image_btn);
        asyncDownImageBtn = (Button) findViewById(R.id.async_down_image_btn);
    }


    private void initOnClickListener() {
        //下载网络图片，并显示(错误的演示示例)
        errorDownImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final Bitmap bitmap = DownImageUtil.getInstance().loadImageFromNetwork(url);

                        showImage.setImageBitmap(bitmap);
                    }
                }).start();
            }
        });

        //下载网络图片，并显示(解决上述问题)
        downImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final Bitmap bitmap = DownImageUtil.getInstance().loadImageFromNetwork(url);
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showImage.setImageBitmap(bitmap);
                            }
                        });

                    }
                }).start();
            }
        });
        //异步加载图片
        asyncDownImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadImageTask(showImage).execute(url);
            }
        });
    }




}
