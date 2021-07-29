package com.example.myapplication.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.util.ToastUtil;

import java.io.File;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * created by cxm1995
 * on 2021/4/22 10:22
 */
public class SharedPreferencesActivity extends AppCompatActivity  {

    @BindView(R.id.et_input)
    EditText mEtInput;
    @BindView(R.id.btn_save)
    Button mBtnSave;
    @BindView(R.id.btn_show)
    Button mBtnShow;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        ButterKnife.bind(this);

        mSharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }


    @OnClick({R.id.btn_save, R.id.btn_show})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                ToastUtil.showMessage(SharedPreferencesActivity.this, "save.....");
                mEditor.putString("name", mEtInput.getText().toString());
                mEditor.apply();
                break;
            case R.id.btn_show:
                ToastUtil.showMessage(SharedPreferencesActivity.this, "show...");
                String content = mSharedPreferences.getString("name", "空");
                mTvContent.setText(content);
                break;
        }
    }
}