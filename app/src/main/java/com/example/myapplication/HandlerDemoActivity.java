package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.util.ToastUtil;

/**
 * created by cxm1995
 * on 2021/4/21 23:00
 */
public class HandlerDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtInput;
    private TextView mTvShow;
    private Button mBtnStart;
    private Button mBtnStop;
    private Handler handler;
    private static TimeThread timeThread;
    private static boolean stop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_demo);
        BindID();

        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                int curCount = Math.max(msg.arg1, 0);
                mTvShow.setText("剩余时间: " + curCount + " 秒");
            }
        };
    }

    private void BindID() {

        mEtInput = findViewById(R.id.et_input);
        mTvShow = findViewById(R.id.tv_show);
        mBtnStart = findViewById(R.id.btn_start_game);
        mBtnStop = findViewById(R.id.btn_stop);

        mBtnStart.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_game:
                //判断是否正在倒计时
                if (!stop) {
                    ToastUtil.showMessage(HandlerDemoActivity.this, "正在倒计时中");
                } else {
                    //获取输入，并传给子线程。
                    Editable input = mEtInput.getText();
                    if (!TextUtils.isEmpty(input)) {
                        String input1 = input.toString();
                        if (input1.length() >= 6) {
                            //输入数字应当小于 100000
                            Toast.makeText(HandlerDemoActivity.this, "输入数字过长", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        int countTime = Integer.parseInt(input.toString());
                        timeThread = new TimeThread(countTime);
                        timeThread.start();
                        stop = false;
                    }
                }
                break;
            case R.id.btn_stop:
                //暂停倒计时
                stop = true;
                break;
        }
    }

    //倒计时子线程
    class TimeThread extends Thread {
        private int count;

        public TimeThread() {
        }

        public TimeThread(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            super.run();
            while (count >= 0 && !stop) {
                Message message = new Message();
                message.arg1 = count;
                handler.sendMessage(message);
                count--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stop = true;
        }
    }
}