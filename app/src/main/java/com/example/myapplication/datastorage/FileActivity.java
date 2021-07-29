package com.example.myapplication.datastorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.util.ToastUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * created by cxm1995
 * on 2021/4/22 11:29
 */
public class FileActivity extends AppCompatActivity {

    @BindView(R.id.et_input)
    EditText mEtInput;
    @BindView(R.id.btn_save)
    Button mBtnSave;
    @BindView(R.id.btn_show)
    Button mBtnShow;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    private String mFileName = "text.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        ButterKnife.bind(this);

        System.out.println("FilesDir:" + getApplicationContext().getFilesDir().getAbsolutePath());
        System.out.println("CacheDir:" + getApplicationContext().getCacheDir().getAbsolutePath());
        System.out.println("ExternalStorageDirectory: 失效？" + Environment.getExternalStorageDirectory().getAbsolutePath());
        System.out.println("ExternalFilesDir" + getExternalFilesDir(null).getAbsolutePath());

    }

    @OnClick({R.id.btn_save, R.id.btn_show})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                ToastUtil.showMessage(FileActivity.this, "save.....");
                save(mEtInput.getText().toString());
                break;
            case R.id.btn_show:
                ToastUtil.showMessage(FileActivity.this, "show...");
                String content = read();
                mTvContent.setText(content);
                break;
        }
    }

    //保存数据
    private void save(String content) {
        FileOutputStream fileOutputStream = null;
        try {
            //内部存储
//            fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE);
            //外部存储
//            File dir = new File(Environment.getExternalStorageDirectory(), "cxmmm");//过时
            File dir = new File(getExternalFilesDir(null), "cxmmm");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, mFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            //写入内容
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //读取数据
    private String read() {
        FileInputStream fileInputStream = null;
        try {
            //内部存储
//            fileInputStream = openFileInput(mFileName);
            //外部存储
            File file = new File(getExternalFilesDir(null).getAbsolutePath() + File.separator + "cxmmm", mFileName);
            fileInputStream = new FileInputStream(file);
            //读入数据
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int len = 0;
            while ((len = fileInputStream.read(buff)) > 0) {
                sb.append(new String(buff, 0, len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}