package com.example.myapplication.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/19 15:19
 */
public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {

    private Button mBtnFragment;
    private AFragment aFragment;
    private BFragment bFragment;

    private TextView mTv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_1, bFragment).commitAllowingStateLoss();
                }
            }
        });

        //实例化AFragment，并添加到activity指定位置。
//        aFragment = new AFragment("我是参数");
        aFragment = AFragment.newInstance("我也是参数");
//        getSupportFragmentManager().beginTransaction().add(R.id.fl_1, aFragment).commitAllowingStateLoss();
        //给Fragment加个tag，便于查找他
        getSupportFragmentManager().beginTransaction().add(R.id.fl_1, aFragment, "a_tag").commitAllowingStateLoss();

        mTv_content = findViewById(R.id.tv_content);
    }

    public void setData(String msg) {
        mTv_content.setText(msg);
    }


    @Override
    public void onClick(String message) {
        mTv_content.setText(message);
    }
}