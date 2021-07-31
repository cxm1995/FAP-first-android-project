package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * created by cxm1995
 * on 2021/7/29 23:19
 * 学习下viewpager控件
 */
public class ViewPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        ViewPager2 page = findViewById(R.id.vg_1);
        page.setOrientation(ViewPager2.ORIENTATION_VERTICAL);//垂直方向
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.DKGRAY);
        colors.add(Color.RED);
        page.setAdapter(new ViewAdapter(colors));
    }

    /**
     * 简单view
     */
    class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewPagerHolder> {

        List<Integer> datas;

        public ViewAdapter(List<Integer> datas) {
            this.datas = datas;
        }

        @NonNull
        @Override
        public ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_viewpager2_item, parent, false);
            return new ViewPagerHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewPagerHolder holder, int position) {
            holder.textView.setText("页面" + position);
            holder.textView.setBackgroundColor(datas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class ViewPagerHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public ViewPagerHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv_content);
            }
        }
    }

}