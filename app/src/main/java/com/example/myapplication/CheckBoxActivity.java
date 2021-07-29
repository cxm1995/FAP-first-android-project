package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    CheckBox mCb_5;
    CheckBox mCb_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        mCb_5 = findViewById(R.id.cb_5);
        mCb_6 = findViewById(R.id.cb_6);
        mCb_5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, buttonView.getText()+ (isChecked ? " 选中" : " 未选中"), Toast.LENGTH_SHORT).show();
            }
        });
        mCb_6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, buttonView.getText()+ (isChecked ? " 选中" : " 未选中"), Toast.LENGTH_SHORT).show();
            }
        });
    }
}