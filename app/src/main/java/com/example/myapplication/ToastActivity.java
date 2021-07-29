package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.util.ToastUtil;

/**
 * created by cxm1995
 * on 2021/4/20 9:53
 */
public class ToastActivity extends AppCompatActivity {

    private Button mBtnToast1;
    private Button mBtnToast2;
    private Button mBtnToast3;
    private Button mBtnToast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        mBtnToast1 = findViewById(R.id.btn_1);
        mBtnToast2 = findViewById(R.id.btn_game_content);
        mBtnToast3 = findViewById(R.id.btn_3);
        mBtnToast4 = findViewById(R.id.btn_4);

        OnClick onClick = new OnClick();
        mBtnToast1.setOnClickListener(onClick);
        mBtnToast2.setOnClickListener(onClick);
        mBtnToast3.setOnClickListener(onClick);
        mBtnToast4.setOnClickListener(onClick);
    }

    public class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_1:
//                    Toast.makeText(ToastActivity.this, "默认形式", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "默认形式", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_game_content:
                    Toast toastCenter = Toast.makeText(getApplicationContext(), "居中", Toast.LENGTH_LONG);
                    //API30开始不能用在texttoast上了
//                    toastCenter.setGravity(Gravity.CENTER,0,0);
                    toastCenter.show();
                    break;
                case R.id.btn_3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    View view = LayoutInflater.from(ToastActivity.this).inflate(R.layout.layout_toast, null);
                    ImageView imageView = view.findViewById(R.id.iv_toast);
                    TextView textView = view.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.icon_nice);
                    textView.setText("点赞之交 ? ");
                    toastCustom.setView(view);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.btn_4:

                    ToastUtil.showMessage(ToastActivity.this, "包装过的Toast");
                    break;
            }
        }
    }
}