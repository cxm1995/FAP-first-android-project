package com.example.myapplication.recyclerview;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/15 15:35
 */
public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.GridViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public GridRecyclerViewAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public GridRecyclerViewAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO 未理解
        GridViewHolder linearViewHolder = new GridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_recycler_item, parent, false));
        return linearViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GridRecyclerViewAdapter.GridViewHolder holder, int position) {
        holder.tvTitle.setText("" + position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 80;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
