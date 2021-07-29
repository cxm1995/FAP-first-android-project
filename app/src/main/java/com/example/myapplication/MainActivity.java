package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.broadcast.BroadastActivity;
import com.example.myapplication.datastorage.DataStorageActivity;

/**
 * created by cxm1995
 * on 2021/4/20 11:20
 */
public class MainActivity extends AppCompatActivity {

    private Button mBtnUi;
    private Button mBtnEvent;
    private Button mBtnDataStorage;
    private Button mBtnFun;
    private Button mBtnBroadcast;
    private Button mBtnAnimation;
    private Button mBtnRipple;
    private Button mBtnDatabase;
    private Button mBtnHongzha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnUi = findViewById(R.id.btn_ui);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnDataStorage = findViewById(R.id.btn_data_storage);
        mBtnFun = findViewById(R.id.btn_fun);
        mBtnBroadcast = findViewById(R.id.btn_broadcast);
        mBtnAnimation = findViewById(R.id.btn_animation);
        mBtnRipple = findViewById(R.id.btn_ripple);
        mBtnDatabase = findViewById(R.id.btn_database);
        mBtnHongzha = findViewById(R.id.btn_hongzha);

        setListener();
    }

    private void setListener() {
        OnClick onClick = new OnClick();

        mBtnUi.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnDataStorage.setOnClickListener(onClick);
        mBtnFun.setOnClickListener(onClick);
        mBtnBroadcast.setOnClickListener(onClick);
        mBtnAnimation.setOnClickListener(onClick);
        mBtnRipple.setOnClickListener(onClick);
        mBtnDatabase.setOnClickListener(onClick);
        mBtnHongzha.setOnClickListener(onClick);

    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UiActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_data_storage:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, BroadastActivity.class);
                    break;
                case R.id.btn_animation:
                    intent = new Intent(MainActivity.this, AnimationActivity.class);
                    break;
                case R.id.btn_ripple:
                    intent = new Intent(MainActivity.this, RippleActivity.class);
                    break;
                case R.id.btn_database:
                    intent = new Intent(MainActivity.this, DatabaseActivity.class);
                    break;
                case R.id.btn_fun:
                    intent = new Intent(MainActivity.this, Fun.class);
                    break;
                case R.id.btn_hongzha:
                    intent = new Intent(MainActivity.this, FunHongzhaActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}