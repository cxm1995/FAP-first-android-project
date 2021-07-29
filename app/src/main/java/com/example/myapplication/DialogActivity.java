package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.util.StringUtil;
import com.example.myapplication.util.ToastUtil;

import java.util.Arrays;

/**
 * created by cxm1995
 * on 2021/4/20 11:24
 */
public class DialogActivity extends AppCompatActivity {

    private Button mBtn_dialog1;
    private Button mBtn_dialog2;
    private Button mBtn_dialog3;
    private Button mBtn_dialog4;
    private Button mBtn_dialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        mBtn_dialog1 = findViewById(R.id.btn_dialog1);
        mBtn_dialog2 = findViewById(R.id.btn_dialog2);
        mBtn_dialog3 = findViewById(R.id.btn_dialog3);
        mBtn_dialog4 = findViewById(R.id.btn_dialog4);
        mBtn_dialog5 = findViewById(R.id.btn_dialog5);

        setListener();
    }

    private void setListener() {
        OnClick onClick = new OnClick();

        mBtn_dialog1.setOnClickListener(onClick);
        mBtn_dialog2.setOnClickListener(onClick);
        mBtn_dialog3.setOnClickListener(onClick);
        mBtn_dialog4.setOnClickListener(onClick);
        mBtn_dialog5.setOnClickListener(onClick);

    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答 ")
                            .setMessage("你觉得课程怎么样?")
                            .setIcon(R.drawable.icon_nice)
                            .setPositiveButton("很棒", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMessage(DialogActivity.this, "诚实的孩子! ");
                                }
                            })
                            .setNeutralButton("一般", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMessage(DialogActivity.this, "孩子你再瞅瞅! ");
                                }
                            })
                            .setNegativeButton("很差", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMessage(DialogActivity.this, "睁眼说瞎话! ");
                                }
                            })
                            .show();
                    break;
                case R.id.btn_dialog2:
                    String[] strings2 = new String[]{"男", "女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别")
                            .setItems(strings2, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMessage(DialogActivity.this, strings2[which]);
                                }
                            })
                            .show();
                    break;
                case R.id.btn_dialog3:
                    String[] strings3 = new String[]{"男", "女", "中性"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("选择性别")
                            .setSingleChoiceItems(strings3, 1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMessage(DialogActivity.this, strings3[which]);
                                    dialog.dismiss();
                                }
                            })
                            .setCancelable(false)
                            .show();
                    break;
                case R.id.btn_dialog4:
                    String[] strings4 = new String[]{"唱", "跳", "rap"};
                    boolean[] flags4 = new boolean[]{false, false, true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择你的兴趣")
                            .setMultiChoiceItems(strings4, flags4, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    ToastUtil.showMessage(DialogActivity.this, strings4[which] + ":" + isChecked);
                                    System.out.println(Arrays.toString(flags4));
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String msg = "你的兴趣包括: ";
                                    for (int i = 0; i < strings4.length; i++) {
                                        if (flags4[i]) {
                                            msg += strings4[i] + " ";
                                        }
                                    }
//                                    ToastUtil.showMessage(DialogActivity.this, msg);
                                    Toast.makeText(DialogActivity.this, msg, Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMessage(DialogActivity.this, "你取消了!");
                                }
                            })
                            .show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog, null);
                    EditText etUsername = view.findViewById(R.id.et_username);
                    EditText etPassword = view.findViewById(R.id.et_password);
                    Button btnLogin = view.findViewById(R.id.btn_login);
                    btnLogin.setText("确认登录 按钮2");

                    AlertDialog dialog = builder5.setTitle("请登录")
                            //方式1 使用dialog自带的 setPositiveButton() 来关闭dialog窗口
                            .setPositiveButton("确认登录 按钮1", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.out.println(which);
                                    String username = etUsername.getText().toString();
                                    String password = etPassword.getText().toString();
                                    Toast.makeText(DialogActivity.this, "username: " + username + "\n" + "password: " + password, Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setView(view)
                            .setCancelable(false).create();
                    dialog.show();

                    //方式2 使用dismiss() 来关闭dialog窗口
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String username = etUsername.getText().toString();
                            String password = etPassword.getText().toString();
                            if (StringUtil.isNotEmpty(username) && StringUtil.isNotEmpty(password)){
                                Toast.makeText(DialogActivity.this, "username: " + username + "\n" + "password: " + password, Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }else{
                                Toast.makeText(DialogActivity.this, "输入不完整", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    break;
            }
        }
    }
}