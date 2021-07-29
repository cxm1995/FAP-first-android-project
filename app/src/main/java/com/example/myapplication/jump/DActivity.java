package com.example.myapplication.jump;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/19 14:31
 */
public class DActivity extends AppCompatActivity {

    private Button mBtn_jump;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_activity);

        mBtn_jump = findViewById(R.id.btn_jump);
        mBtn_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示跳转 1
                Intent intent = new Intent(DActivity.this, AActivity.class);
                startActivity(intent);
            }
        });

        Log.d("D LifeCycle", "------onCreate------");
        Log.d("D LaunchMode", "taskid: " + getTaskId() + ", " + "hashcode: " + hashCode());
        logTaskName();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("D LifeCycle", "------onStart------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("D LifeCycle", "------onResume------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("D LifeCycle", "------onRestart------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("D LifeCycle", "------onPause------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("D LifeCycle", "------onStop------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("D LifeCycle", "------onDestroy------");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("D LaunchMode", "------onNewIntent------");
        Log.d("D LaunchMode", "taskid: " + getTaskId() + ", " + "hashcode: " + hashCode());
        logTaskName();
    }

    private void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("D LaunchMode", "taskAffinity: " + info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
