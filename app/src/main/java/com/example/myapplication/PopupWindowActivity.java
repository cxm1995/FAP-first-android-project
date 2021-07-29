package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * created by cxm1995
 * on 2021/4/21 10：59
 */
public class PopupWindowActivity extends AppCompatActivity {

    private Button mBtnPopupWindow;
    private PopupWindow mPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        mBtnPopupWindow = findViewById(R.id.btn_pop);
        mBtnPopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_pop, null);
                mPop = new PopupWindow(view, mBtnPopupWindow.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPop.setOutsideTouchable(true);
                mPop.setFocusable(true);
                mPop.setAnimationStyle(R.style.MyPopupAnimation);
                mPop.showAsDropDown(mBtnPopupWindow);
            }
        });
    }
}