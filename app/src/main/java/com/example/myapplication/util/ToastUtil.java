package com.example.myapplication.util;

import android.content.Context;
import android.widget.Toast;

/**
 * created by cxm1995
 * on 2021/4/20 10:42
 */
public class ToastUtil {
    public static Toast mToast;

    public static void showMessage(Context context, String message) {
        if (null == mToast) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
