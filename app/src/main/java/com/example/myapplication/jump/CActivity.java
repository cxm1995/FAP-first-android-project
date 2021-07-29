package com.example.myapplication.jump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * created by cxm1995
 * on 2021/4/19 11:36
 */
public class CActivity extends AppCompatActivity {

    private Button mBtn_jump;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_activity);

        mBtn_jump = findViewById(R.id.btn_jump);
        mBtn_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示跳转 1
                Intent intent = new Intent(CActivity.this, DActivity.class);
                startActivity(intent);
            }
        });

        Log.d("C LifeCycle", "------onCreate------");
        Log.d("C LaunchMode", "taskid: " + getTaskId() + ", " + "hashcode: " + hashCode());
        logTaskName();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("C LifeCycle", "------onStart------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("C LifeCycle", "------onResume------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("C LifeCycle", "------onRestart------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("C LifeCycle", "------onPause------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("C LifeCycle", "------onStop------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("C LifeCycle", "------onDestroy------");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("C LaunchMode", "------onNewIntent------");
        Log.d("C LaunchMode", "taskid: " + getTaskId() + ", " + "hashcode: " + hashCode());
        logTaskName();
    }

    private void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("C LaunchMode", "taskAffinity: " + info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
