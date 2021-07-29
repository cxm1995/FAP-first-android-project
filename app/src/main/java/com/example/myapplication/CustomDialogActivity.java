package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.widget.CustomDialog;

/**
 * created by cxm1995
 * on 2021/4/20 22:32
 */
public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        mBtnCustomDialog = findViewById(R.id.btn_dialog);
        mBtnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this, R.style.CustomeDialog);
                customDialog.setCancelable(false);
                customDialog.setTitle("提示").setMessage("是否开始下载？")
                        .setCancle("取消", new CustomDialog.IOnCancelListener() {
                            @Override
                            public void onCancle(CustomDialog dialog) {
                                Toast.makeText(CustomDialogActivity.this, "取消了", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                            @Override
                            public void onConfirm(CustomDialog dialog) {
                                Toast.makeText(CustomDialogActivity.this, "确认了", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .show();
            }
        });
    }
}