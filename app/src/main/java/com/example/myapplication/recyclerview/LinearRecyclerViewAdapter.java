package com.example.myapplication.recyclerview;

import android.content.Context;
import android.print.PageRange;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/15 11:06
 */
public class LinearRecyclerViewAdapter extends RecyclerView.Adapter<LinearRecyclerViewAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public LinearRecyclerViewAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public LinearRecyclerViewAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO 未理解
        if (viewType == 0){
            LinearViewHolder linearViewHolder = new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent, false));
            return linearViewHolder;
        }else{
            LinearViewHolder2 linearViewHolder = new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item2, parent, false));
            return linearViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull LinearRecyclerViewAdapter.LinearViewHolder holder, int position) {
        if (getItemViewType(position) == 0){
            holder.tvTitle.setText("Hello 样式一");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(position);
                }
            });
        }else{
            holder.tvTitle.setText("Hello 样式二");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick2(position);
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        //按照实际需求写。此处简略。
        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
//        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

    class LinearViewHolder2 extends LinearViewHolder {

        private ImageView imageView;

        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
        void onClick2(int position);
    }
}
