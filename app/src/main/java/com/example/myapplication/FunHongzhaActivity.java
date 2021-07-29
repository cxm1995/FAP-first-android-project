package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.util.PostGetUtil;
import com.example.myapplication.util.ToastUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * created by cxm1995
 * on 2021/5/10 10:50
 */
public class FunHongzhaActivity extends AppCompatActivity {

    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.btn_start_hongzha)
    Button mBtnStartHongzha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_hongzha);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_start_hongzha})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_hongzha:
                String phoneStr = "";
                phoneStr = mEtPhone.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String ret = PostGetUtil.SendGetRequest("");
                        Log.d("FunHongzhaActivity", "ret:" + ret);
                    }
                }).start();
                ToastUtil.showMessage(FunHongzhaActivity.this, "开始轰炸....");

//                if (isMobile(phoneStr)) {
//                    Log.d("FunHongzhaActivity", phoneStr);
//                    String ret = PostGetUtil.SendGetRequest("");
//                    Log.d("FunHongzhaActivity", "ret:" + ret);
//                    ToastUtil.showMessage(FunHongzhaActivity.this, "开始轰炸....");
//                } else {
//                    ToastUtil.showMessage(FunHongzhaActivity.this, "号码输入有错....");
//                }
                break;
        }
    }

    /**
     * 手机号码验证
     *
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }
}