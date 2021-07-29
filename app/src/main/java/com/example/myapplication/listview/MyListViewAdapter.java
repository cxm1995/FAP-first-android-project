package com.example.myapplication.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/14 10:15
 */
public class MyListViewAdapter extends BaseAdapter {

    private Context mContext;
    //TODO LayoutInflater是什么
    private LayoutInflater mLayoutInflater;

    //??
    public MyListViewAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView tv_title;
        TextView tv_time;
        TextView tv_content;
    }

    /**
     * 最重要的方法,这样写也是效率最高的方式
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.iv);
            viewHolder.tv_title = convertView.findViewById(R.id.tv_title);
            viewHolder.tv_time = convertView.findViewById(R.id.tv_time);
            viewHolder.tv_content = convertView.findViewById(R.id.tv_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_title.setText("这是标题。");
        viewHolder.tv_time.setText("这是时间。");
        viewHolder.tv_content.setText("这是内容。");
        String imaPath = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.juimg.com%2Ftuku%2Fyulantu%2F140703%2F330746-140F301555752.jpg&refer=http%3A%2F%2Fimg.juimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620463179&t=bf012fd777a0effa6e65525fb710e1ff";
        Glide.with(mContext).load(imaPath).into(viewHolder.imageView);
        return convertView;
    }
}
