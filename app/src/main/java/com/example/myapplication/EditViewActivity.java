package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditViewActivity extends AppCompatActivity {

    Button mBtnCheck;
    EditText mEtUsername;
    EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_view);

        //确认按钮
        mBtnCheck = findViewById(R.id.btn_check);
        mBtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditViewActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
            }
        });

        //用户名输入
        mEtUsername = findViewById(R.id.et_username);
        mEtUsername.addTextChangedListener(new TextWatcher() {

            /**
             * 字符串s还未发生改变，s 从start开始的count个字符将被长度为after的字符串替换。请勿对字符串s进行修改。
             * @param s
             * @param start
             * @param count
             * @param after
             */
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("beforeTextChanged", s.toString());
                Log.d("beforeTextChanged", "start " + start);
                Log.d("beforeTextChanged", "count " + count);
                Log.d("beforeTextChanged", "after " + after);

            }

            /**
             * 字符串s已发生改变，s从start开始的count个字符，已经替换了原先start开始的before个字符。请勿对字符串s进行修改。
             * @param s
             * @param start
             * @param before
             * @param count
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("onTextChanged", s.toString());
                Log.d("onTextChanged", "start " + start);
                Log.d("onTextChanged", "before " + before);
                Log.d("onTextChanged", "count " + count);
            }

            /**
             * 查看修改后的字符串s，允许修改s，每次修改s都会再次调用该方法afterTextChanged，应避免死循环。
             * @param s
             */
            @Override
            public void afterTextChanged(Editable s) {
                Log.d("afterTextChanged", s.toString());
            }
        });

        //密码输入
        mEtPassword = findViewById(R.id.et_password);
    }

    //点击事件分发方法重写
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //如果是点击事件，获取点击的view，并判断是否要收起键盘
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            //获取目前得到焦点的view
            View v = getCurrentFocus();
            //判断是否要收起并进行处理
            if (isShouldHideKeyboard(v, ev)) {
                hideKeyboard(v.getWindowToken());
            }
        }
        //这个是activity的事件分发，一定要有，不然就不会有任何的点击事件了
        return super.dispatchTouchEvent(ev);
    }

    //判断是否要收起键盘。焦点在edittext内就不隐藏键盘；焦点不在edittext内就隐藏键盘
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        //如果目前得到焦点的这个view是editText的话进行判断点击的位置
        if (v instanceof EditText) {
            int[] l = {0, 0};
            //获取V的左上角坐标，并传给入参 l
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            // 点击EditText的事件，忽略它。
            return !(event.getX() > left) || !(event.getX() < right)
                    || !(event.getY() > top) || !(event.getY() < bottom);
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上
        return false;
    }

    //隐藏软键盘并让editText失去焦点
    private void hideKeyboard(IBinder token) {
        mEtUsername.clearFocus();
        mEtPassword.clearFocus();
        if (token != null) {
            //这里先获取InputMethodManager再调用他的方法来关闭软键盘
            //InputMethodManager就是一个管理窗口输入的manager
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (im != null) {
                im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
}