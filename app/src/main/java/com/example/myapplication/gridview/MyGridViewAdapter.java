package com.example.myapplication.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

import java.time.temporal.Temporal;

/**
 * created by cxm1995
 * on 2021/4/14 15:59
 */
public class MyGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyGridViewAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 11;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class GridViewHolder {
        public ImageView imageView;
        private TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.layout_grid_item, null);
            holder = new GridViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv_1);
            holder.textView = convertView.findViewById(R.id.tv_1);
            convertView.setTag(holder);
        } else {
            holder = (GridViewHolder) convertView.getTag();
        }
        holder.textView.setText("我是皮卡丘");
        String imaPath = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbbsfiles.vivo.com.cn%2Fvivobbs%2Fattachment%2Fforum%2F201610%2F10%2F223520gj6otfv9t51t9oi9.jpg&refer=http%3A%2F%2Fbbsfiles.vivo.com.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620979979&t=0823c3169bc88ef026e33fe0f14d5868";
        Glide.with(mContext).load(imaPath).into(holder.imageView);
        return convertView;
    }
}
