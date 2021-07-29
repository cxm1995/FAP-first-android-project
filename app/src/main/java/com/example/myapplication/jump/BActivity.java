package com.example.myapplication.jump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * created by cxm1995
 * on 2021/4/15 23:49
 */
public class BActivity extends AppCompatActivity {

    private Button mBtn_jump;
    private TextView mTv_show;
    private Button mBtn_finish;
    private Button mBtn_jump3;
    private Intent mIntentRet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_activity);
        mBtn_jump = findViewById(R.id.btn_jump);
        mBtn_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示跳转 1
                Intent intent = new Intent(BActivity.this, AActivity.class);
                startActivity(intent);
                //显示跳转 2
//                Intent intent = new Intent();
//                intent.setClass(BActivity.this,AActivity.class);
//                startActivity(intent);
                //显示跳转 3
//                Intent intent = new Intent();
//                intent.setClassName(BActivity.this,"com.example.myapplication.jump.AActivity");
//                startActivity(intent);
                //显示跳转 4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(BActivity.this,"com.example.myapplication.jump.AActivity"));
//                startActivity(intent);

                //隐式跳转
//                Intent intent = new Intent();
//                intent.setAction("com.example.myapplication.jump.AActivity.ActionName");
//                startActivity(intent);
            }
        });

        //跳转到C
        mBtn_jump3 = findViewById(R.id.btn_3);
        mBtn_jump3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, CActivity.class);
                startActivity(intent);
            }
        });

        getDateAndShow();

        mBtn_finish = findViewById(R.id.btn_finish);
        mBtn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setReturnResult();
                setReturnDate("--点击按钮--我从B界面回来啦");
                finish();
            }
        });


        Log.d("B LifeCycle", "------onCreate------");
        Log.d("B LaunchMode", "taskid: " + getTaskId() + ", " + "hashcode: " + hashCode());
        logTaskName();
    }

    //设置返回的数据
    private void setReturnResult() {
        setReturnDate("我从B界面回来啦");
    }

    //设置返回的数据
    private void setReturnDate(String ret) {
        Bundle bundle = new Bundle();
        bundle.putString("ret", ret);
        mIntentRet = new Intent();
        mIntentRet.putExtras(bundle);
        setResult(Activity.RESULT_OK, mIntentRet);
    }

    //接收上一个界面的数据
    private void getDateAndShow() {
        Bundle bundleReceive = getIntent().getExtras();

        String name = (String) bundleReceive.get("name");
        int age = (int) bundleReceive.get("age");
        ArrayList<String> hobbies = (ArrayList<String>) bundleReceive.get("hobby");
        String hobbiesStr = hobbies.get(0) + "," + hobbies.get(1);

        mTv_show = findViewById(R.id.tv_show);
        mTv_show.setText(name + "," + age + "\n" + "爱好：" + hobbiesStr);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("B LifeCycle", "------onStart------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("B LifeCycle", "------onResume------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("B LifeCycle", "------onRestart------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("B LifeCycle", "------onPause------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("B LifeCycle", "------onStop------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("B LifeCycle", "------onDestroy------");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("B LaunchMode", "------onNewIntent------");
        Log.d("B LaunchMode", "taskid: " + getTaskId() + ", " + "hashcode: " + hashCode());
        logTaskName();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //判断 是否采用点击返回的方式返回bundleRet。
            if (mIntentRet == null) {
//                setReturnResult();
                setReturnDate("--点击返回键--我从B界面回来啦");
            }
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    private void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("B LaunchMode", "taskAffinity: " + info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
