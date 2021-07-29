package com.example.myapplication.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/15 14:51
 */
public class HorRecyclerViewActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycler_view);

        mRecyclerViewHor = findViewById(R.id.rv_hor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorRecyclerViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewHor.setLayoutManager(linearLayoutManager);
        mRecyclerViewHor.addItemDecoration(new MyDecoration());
        mRecyclerViewHor.setAdapter(new HorRecyclerViewAdapter(HorRecyclerViewActivity.this, new HorRecyclerViewAdapter.OnItenClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(HorRecyclerViewActivity.this, "水平滑动界面,点击了 " + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, getResources().getDimensionPixelOffset(R.dimen.dividerHeight2), 0);
        }
    }
}