package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.widget.MyButton;

/**
 * created by cxm1995
 * on 2021/4/20 11:24
 */
public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEvent;
    private Button mBtnHandler;
    private Button mBtnHandlerDemo;
    private MyButton mBtnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnHandler = findViewById(R.id.btn_handler);
        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });
        mBtnHandlerDemo = findViewById(R.id.btn_handler_demo);
        mBtnHandlerDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, HandlerDemoActivity.class);
                startActivity(intent);
            }
        });
        mBtnMy = findViewById(R.id.btn_my_button);
//        //内部类
//        mBtnEvent.setOnClickListener(new OnClick());
//        //匿名类
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(EventActivity.this, "匿名内部类..", Toast.LENGTH_LONG).show();
//                Log.d("click","匿名内部类..");
//
//            }
//        });
//        //事件源所在类
//        mBtnEvent.setOnClickListener(EventActivity.this);
//        mBtnEvent.setOnClickListener(this);
//        mBtnEvent.setOnClickListener(this::onClick);//TODO 方法引用
//        //外部类
//        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));
//        //布局文件onClick属性

        mBtnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "---onTouch---");
                        break;
                }
                return false;
            }
        });

        mBtnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Listener", "---onClick---");
            }
        });

        mBtnMy.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("Listener", "---onLongClick---");
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                Toast.makeText(EventActivity.this, "事件源所在类..", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_event:
                    Toast.makeText(EventActivity.this, "内部类..", Toast.LENGTH_LONG).show();
                    Log.d("click", "内部类..");
                    break;
            }
        }
    }

//    //XML实现
//    public void show(View v) {
//        switch (v.getId()) {
//            case R.id.btn_event:
//                Toast.makeText(EventActivity.this, "XML实现..", Toast.LENGTH_LONG).show();
//                break;
//        }
//    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity", "---onTouchEvent---");
                break;
        }
        return super.onTouchEvent(event);
    }
}