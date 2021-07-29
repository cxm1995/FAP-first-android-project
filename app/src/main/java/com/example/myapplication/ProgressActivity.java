package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.util.ToastUtil;

/**
 * created by cxm1995
 * on 2021/4/20 16:29
 */
public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mPb3;
    private Button mBtnStart;
    private Button mBtnProgressDialog1;
    private Button mBtnProgressDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mPb3 = findViewById(R.id.pr_3);
        mPb3.setProgress(0);
        mBtnStart = findViewById(R.id.btn_start_game);
        mBtnProgressDialog1 = findViewById(R.id.btn_progress_dialog1);
        mBtnProgressDialog2 = findViewById(R.id.btn_progress_dialog2);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });
        mBtnProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog1 = new ProgressDialog(ProgressActivity.this);
                progressDialog1.setTitle("提示");
                progressDialog1.setMessage("正在下载");
                progressDialog1.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        System.out.println("onCancel");
                        Toast.makeText(ProgressActivity.this, "dia1 onCancel", Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog1.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        System.out.println("onDismiss");
                        Toast.makeText(ProgressActivity.this, "dia1 onDismiss", Toast.LENGTH_SHORT).show();

                    }
                });
                progressDialog1.setButton(DialogInterface.BUTTON_POSITIVE, "确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressActivity.this, "BUTTON_POSITIVE", Toast.LENGTH_SHORT).show();
                    }
                });
//                progressDialog1.setCancelable(false);
                progressDialog1.show();
            }
        });
        mBtnProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog2 = new ProgressDialog(ProgressActivity.this);
                progressDialog2.setTitle("提示");
                progressDialog2.setMessage("正在下载");
                progressDialog2.setIcon(R.drawable.icon_nice);
                progressDialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

                progressDialog2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        System.out.println("onCancel");
                        Toast.makeText(ProgressActivity.this, "dia2 onCancel", Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        System.out.println("onDismiss");
                        Toast.makeText(ProgressActivity.this, "dia2 onDismiss", Toast.LENGTH_SHORT).show();

                    }
                });
                progressDialog2.setButton(DialogInterface.BUTTON_POSITIVE, "确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressActivity.this, "BUTTON_POSITIVE", Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog2.setMax(100);
                progressDialog2.setIndeterminate(false);
                progressDialog2.setProgress(15);
                progressDialog2.setSecondaryProgress(50);
                progressDialog2.show();
            }
        });
    }

    //TODO 改构造函数已经被抛弃了，如何修改?
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (mPb3.getProgress() < 100) {
                handler.postDelayed(runnable, 500);
            } else {
                ToastUtil.showMessage(ProgressActivity.this, "进度加载完成");
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress() + 6);
            handler.sendEmptyMessage(0);
        }
    };
}