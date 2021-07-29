package com.example.myapplication.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * created by cxm1995
 * on 2021/4/15 20:27
 */
public class XRecyclerViewActivity extends AppCompatActivity {

    private XRecyclerView xRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x_recycler_view);

        xRecyclerView = findViewById(R.id.xrv_1);
        xRecyclerView.setLayoutManager(new LinearLayoutManager(XRecyclerViewActivity.this));
        xRecyclerView.setAdapter(new LinearRecyclerViewAdapter(XRecyclerViewActivity.this, new LinearRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(XRecyclerViewActivity.this,"XRecycler 点击",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClick2(int position) {

            }
        }));

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(XRecyclerViewActivity.this,"XRecycler 刷新",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(XRecyclerViewActivity.this,"XRecycler 加载",Toast.LENGTH_SHORT).show();

            }
        });

    }
}