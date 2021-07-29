package com.example.myapplication.jump;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * created by cxm1995
 * on 2021/4/15 23:49
 */
public class AActivity extends AppCompatActivity {

    private Button mBtn_jump;
    private Button mBtn_jump2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity);
        mBtn_jump = findViewById(R.id.btn_jump);
        mBtn_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, BActivity.class);

                // 跳转界面时带上数据。
                Bundle bundle = new Bundle();
                bundle.putString("name", "cxm");
                bundle.putInt("age", 100);
                ArrayList<String> list = new ArrayList<>();
                list.add("唱");
                list.add("跳");
                bundle.putStringArrayList("hobby", list);
                intent.putExtras(bundle);

                startActivity(intent);

//                int requestCode = 0;
//                startActivityForResult(intent, requestCode);
            }
        });

        mBtn_jump2 = findViewById(R.id.btn_game_content);
        mBtn_jump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, AActivity.class);
                startActivity(intent);
            }
        });

        Log.d("A LifeCycle", "------onCreate------");
        Log.d("A LaunchMode", "taskid: " + getTaskId() + ", " + "hashcode: " + hashCode());
        logTaskName();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("A LifeCycle", "------onStart------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("A LifeCycle", "------onResume------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("A LifeCycle", "------onRestart------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("A LifeCycle", "------onPause------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("A LifeCycle", "------onStop------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("A LifeCycle", "------onDestroy------");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("A LaunchMode", "------onNewIntent------");
        Log.d("A LaunchMode", "taskid: " + getTaskId() + ", " + "hashcode: " + hashCode());
        logTaskName();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this, data.getExtras().get("ret").toString(), Toast.LENGTH_LONG).show();
        Log.d("A LifeCycle", "------onActivityResult------");
    }

    private void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("A LaunchMode", "taskAffinity: " + info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
