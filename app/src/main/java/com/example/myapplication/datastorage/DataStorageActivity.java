package com.example.myapplication.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;


/**
 * created by cxm1995
 * on 2021/4/22 10:14
 */
public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSharedPreferences;
    private Button mBtnFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        BindID();
    }

    private void BindID() {
        mBtnSharedPreferences = findViewById(R.id.btn_shared_preferences);
        mBtnFile = findViewById(R.id.btn_file);
        mBtnSharedPreferences.setOnClickListener(this::onClick);
        mBtnFile.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_shared_preferences:
                intent = new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this, FileActivity.class);
                break;
        }
        startActivity(intent);
    }
}