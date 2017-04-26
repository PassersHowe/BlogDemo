package com.passershowe.blogdemo.thread;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * Created by PassersHowe on 2017/4/17.
 */

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView mImageView;
    public DownloadImageTask() {
    }

    public DownloadImageTask(ImageView imageView) {
        mImageView = imageView;
    }
    @Override
    protected Bitmap doInBackground(String... params) {
        return DownImageUtil.getInstance().loadImageFromNetwork(params[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (mImageView != null) {
            mImageView.setImageBitmap(bitmap);
        }
    }
}
