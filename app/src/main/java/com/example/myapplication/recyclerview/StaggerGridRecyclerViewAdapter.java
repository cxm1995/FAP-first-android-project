package com.example.myapplication.recyclerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/15 16:15
 */
public class StaggerGridRecyclerViewAdapter extends RecyclerView.Adapter<StaggerGridRecyclerViewAdapter.GridViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public StaggerGridRecyclerViewAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public StaggerGridRecyclerViewAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO 未理解
        GridViewHolder gridViewHolder = new GridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_stagger_grid_recycler_item, parent, false));
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaggerGridRecyclerViewAdapter.GridViewHolder holder, int position) {
        if (position % 2 == 1) {
            holder.imageView.setImageResource(R.drawable.image1);
        } else {
            holder.imageView.setImageResource(R.drawable.image2);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 31;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
