package com.passershowe.blogdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by PassersHowe on 2017/4/14.
 */

public class DialogActivity extends AppCompatActivity {

    private Button finishDialogBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_activity);

        finishDialogBtn = (Button)findViewById(R.id.dialog_finish_btn);
        finishDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
