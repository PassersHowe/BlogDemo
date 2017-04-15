package com.passershowe.blogdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;



/**
 * Created by PassersHowe on 2017/4/14.
 */

public class DemoBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "DemoBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Action: " + intent.getAction() + "\n");
        sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
        sb.append("Data: " + intent.getStringExtra("data") + "\n");
        String log = sb.toString();
        Log.d(TAG, log);
        Toast.makeText(context, log, Toast.LENGTH_LONG).show();
    }


}
