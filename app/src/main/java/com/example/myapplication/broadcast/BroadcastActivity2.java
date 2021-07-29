package com.example.myapplication.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BroadcastActivity2 extends AppCompatActivity {

    @BindView(R.id.btn_send_broadcast)
    Button mBtnBroastcast;

    @BindView(R.id.btn_send_broadcast_2)
    Button mBtnBroastcast2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_send_broadcast, R.id.btn_send_broadcast_2})
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_send_broadcast:
                intent = new Intent("com.skypan.update");
                getApplicationContext().sendBroadcast(intent);
                break;
            case R.id.btn_send_broadcast_2:
                intent = new Intent("com.skypan.delete");
                getApplicationContext().sendBroadcast(intent);
                break;
        }
    }
}