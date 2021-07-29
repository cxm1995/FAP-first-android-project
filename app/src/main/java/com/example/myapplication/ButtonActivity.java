package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ButtonActivity extends AppCompatActivity {

    private Button mbtn3;
    private TextView tv_8;
    private ToggleButton mTb_1;
    private Switch mSwitch_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        mbtn3 = findViewById(R.id.btn_3);
        mbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "button 3 被点击啦", Toast.LENGTH_LONG).show();
            }
        });

        tv_8 = findViewById(R.id.tv_8);
        tv_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "文本 被点击啦", Toast.LENGTH_SHORT).show();
            }
        });

        mTb_1 = findViewById(R.id.tb_1);
        mTb_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ButtonActivity.this, "togglebutton " + (isChecked ? "打开了" : "关闭了"), Toast.LENGTH_SHORT).show();
            }
        });
        mSwitch_1 = findViewById(R.id.sw_1);
        mSwitch_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ButtonActivity.this, "switch  " + (isChecked ? "打开了" : "关闭了"), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void showToast(View view) {
        System.out.println("showToast方法执行了");
        Toast.makeText(this, "button 4 被点击啦", Toast.LENGTH_SHORT).show();
    }
}