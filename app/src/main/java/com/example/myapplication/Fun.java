package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.myapplication.util.ToastUtil;

import java.util.Random;

/**
 * created by cxm1995
 * on 2021/4/22 15:56
 */
//TODO 重构下
public class Fun extends AppCompatActivity {

    private Button mbtnGameContent;
    private Button mbtnStart;
    private Button mbtnPhone;
    private Switch mSwitchLight;
    private CameraManager cameraManager;
    private Context context;
    private String mCameraId;

    private long startTime;
    private long endTime;
    private long initTime;
    private boolean gameBegin;
    private boolean colorChangeed;
    private boolean gameFailed;
    private boolean gameOver;
    private Handler mHandler;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun);

        context = getApplicationContext();

        mbtnGameContent = findViewById(R.id.btn_game_content);
        mbtnGameContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置游戏面板逻辑
                if (gameBegin) {
                    //游戏开始
                    if (colorChangeed) {
                        //颜色改变后点击
                        endTime = System.currentTimeMillis();
                        long cost = (endTime - startTime);
                        Toast.makeText(Fun.this, "耗时: " + cost + "毫秒", Toast.LENGTH_SHORT).show();
                        gameBegin = false;
                        gameOver = true;
                        mbtnGameContent.setText("游戏结束!");
                    } else {
                        //颜色还未变化就点击，判断游戏失败。
                        gameBegin = false;
                        gameFailed = true;
                        gameOver = true;
                        mbtnGameContent.setText("游戏失败!");
                    }
                }
            }
        });

        mbtnStart = findViewById(R.id.btn_start_game);
        mbtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动游戏
                if (gameBegin) {
                    Toast.makeText(Fun.this, "正在游戏中", Toast.LENGTH_SHORT).show();
                } else {
                    gameInit();

                    Thread thread = new Thread(() -> waiSeconds());
                    thread.start();
                }

            }
        });

        mHandler = new Handler(getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                // 过早点击，或完成游戏。就返回。
                if (gameOver || gameFailed) return;
                //如果是过期子线程的信息就抛弃。
                long threadCreateTime = (Long) msg.obj;
                if (threadCreateTime < initTime) {
//                    Log.d("过期子线程","thread");
                    return;
                }
                if (msg.arg1 == 1) {
                    //创建子线程的时间必定小于游戏开始时间。
                    Log.d("耗时子线程", "thread");
                    Log.d("threa " + threadCreateTime, "thread");
                    Log.d("start " + initTime, "thread");
                    gameChangeBackground();
                }
            }
        };

        flashLight();
        usePhone();

    }

    /**
     * 游戏背景、参数初始化。
     */
    private void gameInit() {
        initTime = System.currentTimeMillis();
        gameBegin = true;
        colorChangeed = false;
        gameFailed = false;
        gameOver = false;
        mbtnGameContent.setBackgroundColor(Color.parseColor("#BDBDBD"));
        mbtnGameContent.setText("颜色准备改变");
    }

    /**
     * 游戏背景改变，并计算反映时间
     */
    private void gameChangeBackground() {
        startTime = System.currentTimeMillis();
//        Log.d("start time", startTime + "");
        mbtnGameContent.setBackgroundColor(Color.parseColor("#FF0000"));
        mbtnGameContent.setText("点击！");
        colorChangeed = true;
    }

    /**
     * 子线程耗时操作,耗时结束给主线程发送消息。
     */
    private void waiSeconds() {
        long threadCreateTime = System.currentTimeMillis();

        // 设置随机变色时间
        Random random = new Random();
        int wait = 2000 + random.nextInt(3000);
        Log.d("wait time", wait + "");
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message msg = new Message();
        msg.arg1 = 1;
        msg.obj = (Long) threadCreateTime;
        mHandler.sendMessage(msg);
    }

    /**
     * 找到 摄像头id，存到 mCameraId 中
     */
    private void findCameraId() {

        try {
            //获取可用摄像头列表
            for (String cameraId : cameraManager.getCameraIdList()) {
                //获取相机的相关参数
                CameraCharacteristics characteristics = cameraManager.getCameraCharacteristics(cameraId);
                // 不使用前置摄像头。
                Integer facing = characteristics.get(CameraCharacteristics.LENS_FACING);
                if (facing != null && facing == CameraCharacteristics.LENS_FACING_FRONT) {
                    continue;
                }
                StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (map == null) {
                    continue;
                }
                // 检查闪光灯是否支持。
                Boolean available = characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                boolean mFlashSupported = (available == null ? false : available);

                //CameraID
                Log.d("camera id", cameraId.toString());
                mCameraId = (mFlashSupported ? cameraId : null);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            //不支持Camera2API
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 拨打电话（直接拨打电话）
     *
     * @param phoneNum 电话号码
     */
    public void callPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }

    /**
     * 闪光灯
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void flashLight() {
        cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        findCameraId();
        mSwitchLight = findViewById(R.id.sw_1);
        mSwitchLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                try {
                    if (isChecked) {
                        cameraManager.setTorchMode(mCameraId, true);
                    } else {
                        cameraManager.setTorchMode(mCameraId, false);
                    }
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 拨号功能-待整理
     */
    private void usePhone() {

        mbtnPhone = findViewById(R.id.btn_phone);
        mbtnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    callPhone("10010");
                } catch (Exception e) {
                    Log.d("Fun", "拨号权限不足");
                    ToastUtil.showMessage(Fun.this, "拨号权限不足");
                }
            }
        });
    }
}