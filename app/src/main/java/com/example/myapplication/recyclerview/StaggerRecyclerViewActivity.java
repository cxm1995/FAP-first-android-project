package com.example.myapplication.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/15 16:09
 */
public class StaggerRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewStagger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger_recycler_view);

        mRecyclerViewStagger = findViewById(R.id.rv_stagger);
        mRecyclerViewStagger.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerViewStagger.addItemDecoration(new MyDecoration());
        mRecyclerViewStagger.setAdapter(new StaggerGridRecyclerViewAdapter(StaggerRecyclerViewActivity.this, new StaggerGridRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(StaggerRecyclerViewActivity.this, "瀑布视图点击 " + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int divider = getResources().getDimensionPixelOffset(R.dimen.dividerHeight2);
            outRect.set(divider, divider, divider, divider);
        }
    }
}