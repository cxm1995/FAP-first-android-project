package com.example.myapplication.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.datastorage.SharedPreferencesActivity;
import com.example.myapplication.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BroadastActivity extends AppCompatActivity {

    @BindView(R.id.btn_1)
    Button mBtnJump;
    @BindView(R.id.tv_content)
    TextView mTvContent;

    private MyBroadcast mBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadast);
        ButterKnife.bind(this);

        mTvContent.setText("abcd");

        mBroadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.skypan.update");
        intentFilter.addAction("com.skypan.delete");
        getApplicationContext().registerReceiver(mBroadcast, intentFilter);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @OnClick({R.id.btn_1})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                Intent intent = new Intent(BroadastActivity.this, BroadcastActivity2.class);
                startActivity(intent);
                break;
        }
    }

    private class MyBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            System.out.println("context " + context.hashCode());
            switch (intent.getAction()) {
                case "com.skypan.update":
                    mTvContent.setText("1234");
                    Log.d("MyBroadcast ", "1234");
                    break;
                case "com.skypan.delete":
                    mTvContent.setText("-");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getApplicationContext().unregisterReceiver(mBroadcast);
    }
}