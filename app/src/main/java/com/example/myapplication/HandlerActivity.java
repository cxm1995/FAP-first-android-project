package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.example.myapplication.widget.MyButton;

/**
 * created by cxm1995
 * on 2021/4/21 17：11
 */
public class HandlerActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        handler = new Handler();
//        //3000毫秒后执行任务
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(HandlerActivity.this, ButtonActivity.class);
//                startActivity(intent);
//            }
//        }, 3000);

        // 线程间传数据
//        Looper looper = Looper.getMainLooper();
        handler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                System.out.println("thread name: " + Thread.currentThread().getName() + " receive");
                System.out.println("msg.what " + msg.what);
                System.out.println("msg.obj "+msg.obj);
                super.handleMessage(msg);
            }
        };

        new Thread() {
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 1111;
                message.obj = new MyButton(HandlerActivity.this);
//                handler.sendMessage(message);
                handler.sendMessageDelayed(message,3000);
                System.out.println("thread name: " + Thread.currentThread().getName() + " send ");
//                handler.sendEmptyMessageDelayed(1, 3000);
            }
        }.start();
    }
}