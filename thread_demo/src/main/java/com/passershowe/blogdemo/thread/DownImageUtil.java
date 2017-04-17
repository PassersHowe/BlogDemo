package com.passershowe.blogdemo.thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hao809395357 on 2017/4/17.
 */

public class DownImageUtil {

    private static class  DownImageInstance{
        private static DownImageUtil instance = new DownImageUtil();
    }

    private DownImageUtil() {

    }

    public static DownImageUtil getInstance() {
        return DownImageInstance.instance;
    }

    public Bitmap loadImageFromNetwork(String url) {
        HttpURLConnection httpURLConnection;
        URL mUrl;
        Bitmap mBitmap;
        InputStream inputStream = null;
        try {
            mUrl = new URL(url);
            httpURLConnection = (HttpURLConnection) mUrl.openConnection();

            //设置超时的时间，5000毫秒即5秒
            httpURLConnection.setConnectTimeout(5000);
            //设置获取图片的方式为GET
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                mBitmap = BitmapFactory.decodeStream(inputStream);
                return mBitmap;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {

            }
        }
    }
}
