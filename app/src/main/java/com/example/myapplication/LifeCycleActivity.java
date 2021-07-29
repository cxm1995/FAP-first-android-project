package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * created by cxm1995
 * on 2021/4/16 15:50
 */
public class LifeCycleActivity extends AppCompatActivity {

    Button mBtn_test1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("LifeCycle", "------onCreate------");
        mBtn_test1 = findViewById(R.id.btn_test1);
        mBtn_test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleActivity.this, Fun.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "------onStart------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "------onResume------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "------onRestart------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "------onPause------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "------onStop------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "------onDestroy------");
    }

}
