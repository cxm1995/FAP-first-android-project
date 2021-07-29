package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * created by cxm1995
 * on 2021/4/23 15:57
 */
public class AnimationActivity extends AppCompatActivity {

    private TextView mBtnTv1;
    private TextView mBtnTvValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        mBtnTv1 = findViewById(R.id.tv_1);
        mBtnTvValue = findViewById(R.id.tv_value);
        //平移
//        mBtnTv1.animate().translationX(50).setDuration(2000).start();
//        mBtnTv1.animate().translationY(-200).setDuration(2000).start();
//        mBtnTv1.animate().translationZ(200).setDuration(2000).start();
        //透明度
//        mBtnTv1.animate().alpha(0.5f).setDuration(2000).start();

        //旋转
//        mBtnTv1.animate().rotation(90).setDuration(2000).start();
//        mBtnTv1.animate().rotationX(45).setDuration(2000).start();
//        mBtnTv1.animate().rotationY(45).setDuration(2000).start();

        //放缩
//        mBtnTv1.animate().scaleX(2).setDuration(2000).start();
//        mBtnTv1.animate().scaleY(0.5f).setDuration(2000).start();

        //进度条
//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                //真实值
//                Object animatedValue = animation.getAnimatedValue();
//                float animatedFraction = animation.getAnimatedFraction();
//                //进度 0-1
//                mBtnTvValue.setText("" + animatedValue + " " + animatedFraction);
//            }
//        });
//        valueAnimator.start();

        //指定系列动画
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mBtnTv1, "translationY", 0,-100, 200, -300, 400, -500);
        objectAnimator.setDuration(10000);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //真实值
                Object animatedValue = animation.getAnimatedValue();
                float animatedFraction = animation.getAnimatedFraction();
                //进度 0-1
                mBtnTvValue.setText("" + animatedValue + " " + animatedFraction);
            }
        });
        objectAnimator.start();
    }
}