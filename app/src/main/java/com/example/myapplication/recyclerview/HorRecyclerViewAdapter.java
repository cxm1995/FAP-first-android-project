package com.example.myapplication.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/15 14:51
 */

public class HorRecyclerViewAdapter extends RecyclerView.Adapter<HorRecyclerViewAdapter.HorViewHolder> {

    private Context mContext;
    private OnItenClickListener mListener;

    public HorRecyclerViewAdapter(Context context, OnItenClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public HorRecyclerViewAdapter.HorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HorViewHolder holder = new HorViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hor_item, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HorRecyclerViewAdapter.HorViewHolder holder, int position) {
        holder.textView.setText("我的文字改变了。");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class HorViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public HorViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItenClickListener {
        public void onClick(int position);
    }
}
