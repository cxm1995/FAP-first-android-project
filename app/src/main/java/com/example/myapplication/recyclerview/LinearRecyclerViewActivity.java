package com.example.myapplication.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/14 16:55
 */
public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);

        mRecyclerViewMain = findViewById(R.id.rv_main);
        mRecyclerViewMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        mRecyclerViewMain.setAdapter(new LinearRecyclerViewAdapter(LinearRecyclerViewActivity.this, new LinearRecyclerViewAdapter.OnItemClickListener() {
            @Override
            //回调实现点击事件
            public void onClick(int position) {
                Toast.makeText(LinearRecyclerViewActivity.this, "样式一：点击了 " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClick2(int position) {
                Toast.makeText(LinearRecyclerViewActivity.this, "样式二：点击了 " + position, Toast.LENGTH_SHORT).show();
            }
        }));
        //画分割线 法1
//        mRecyclerViewMain.addItemDecoration(new MyDecoration());
        //画分割线 法2
        mRecyclerViewMain.addItemDecoration(new DividerItemDecoration(LinearRecyclerViewActivity.this, DividerItemDecoration.VERTICAL));
    }

    //TODO ItemDecoration 有做好的封装轮子
    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}