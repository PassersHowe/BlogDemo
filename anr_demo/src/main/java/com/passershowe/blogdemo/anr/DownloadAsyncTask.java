package com.passershowe.blogdemo.anr;

import android.os.AsyncTask;
import android.util.Log;

import java.net.URL;

/**
 * Created by PassersHowe on 2017/4/19.
 */

public class DownloadAsyncTask extends AsyncTask<URL,Integer,Long> {

    //在这里做长时间的工作
    @Override
    protected Long doInBackground(URL... params) {
        return null;
    }

    //进度更新，每次调用publishProgress()时都会调用它
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    //当doInBackground()完成时调用
    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);

    }
}
