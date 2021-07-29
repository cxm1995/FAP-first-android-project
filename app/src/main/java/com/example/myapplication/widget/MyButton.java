package com.example.myapplication.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

/**
 * created by cxm1995
 * on 2021/4/21 16:14
 */
public class MyButton extends AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("MyButton", "---dispatchTouchEvent---");
        return super.dispatchTouchEvent(event);
    }

    //可以回调的方法：onTouchEvent,onKeyUp,onKeyDown,onKeyLongPress等等
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton", "---onTouchEvent---ACTION_DOWN---");
//            case MotionEvent.ACTION_UP:
//                Log.d("MyButton", "---onTouchEvent---ACTION_UP---");
                break;
        }
        return super.onTouchEvent(event);
    }

//    //TODO 为什么日志没有打印这个方法
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        Log.d("MyButton", "---onKeyDown---");
//        return super.onKeyDown(keyCode, event);
//    }
}
