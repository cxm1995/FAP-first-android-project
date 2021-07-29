package com.example.myapplication.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/14 16:55
 */
public class RecyclerViewActivity extends AppCompatActivity {

    private Button mRecyclerLinear;
    private Button mRecyclerHor;
    private Button mRecyclerGrid;
    private Button mRecyclerStagger;
    private Button mRecyclerX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRecyclerLinear = findViewById(R.id.btn_recycler_linear);
        mRecyclerHor = findViewById(R.id.btn_recycler_hor);
        mRecyclerGrid = findViewById(R.id.btn_recycler_grid);
        mRecyclerStagger = findViewById(R.id.btn_recycler_stagger);
        mRecyclerX = findViewById(R.id.btn_recycler_x);


        mRecyclerLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mRecyclerHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mRecyclerGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mRecyclerStagger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, StaggerRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mRecyclerX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, XRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}