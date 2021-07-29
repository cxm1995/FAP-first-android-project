package com.example.myapplication.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/20 22:53
 */
public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView mTvTitle, mTvMessage, mTvCancle, mTvConfirm;
    private String title, message, cancle, confirm;
    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancle(String cancle, IOnCancelListener listener) {
        this.cancle = cancle;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        //设置宽度
        WindowManager m = getWindow().getWindowManager();
        Display display = m.getDefaultDisplay();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        Point point = new Point();
        display.getSize(point);
        layoutParams.width = (int) (point.x * 0.8);
        getWindow().setAttributes(layoutParams);

        mTvTitle = findViewById(R.id.tv_title);
        mTvMessage = findViewById(R.id.tv_message);
        mTvCancle = findViewById(R.id.tv_cancle);
        mTvConfirm = findViewById(R.id.tv_confirm);

        if (!TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(message)) {
            mTvMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancle)) {
            mTvCancle.setText(cancle);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }
        //类比 UiActivity
        mTvCancle.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancle:
                if (cancelListener != null) {
                    cancelListener.onCancle(this);
                    dismiss();
                }
                break;
            case R.id.tv_confirm:
                if (confirmListener != null) {
                    confirmListener.onConfirm(this);
                    dismiss();
                }
                break;
        }
    }

    public interface IOnCancelListener {
        void onCancle(CustomDialog dialog);
    }

    public interface IOnConfirmListener {
        void onConfirm(CustomDialog dialog);
    }

}
