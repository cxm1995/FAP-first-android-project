package com.example.myapplication;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

/**
 * created by cxm1995
 * on 2021/4/21 15:58
 */
public class MyClickListener implements View.OnClickListener {

    private Activity mActivity;

    public MyClickListener(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public MyClickListener() {
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(mActivity, "外部类..", Toast.LENGTH_LONG).show();

    }
}
