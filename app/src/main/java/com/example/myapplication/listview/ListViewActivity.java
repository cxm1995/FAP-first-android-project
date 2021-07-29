package com.example.myapplication.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/14 10:15
 */
public class ListViewActivity extends AppCompatActivity {

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Mango", "Apple1", "Banana1", "Orange1", "Watermelon1", "Pear1", "Grape1", "Pineapple1", "Strawberry1", "Cherry1",
            "Mango1"};
    private ListView mListView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                ListViewActivity.this, android.R.layout.simple_list_item_1, data);

        mListView1 = (ListView) findViewById(R.id.listview);
        //TODO 为什么 context是 ListViewActivity.this？？
        //TODO Context 是 Activity的父类，学完教程总结下。

        MyListViewAdapter listViewAdapter = new MyListViewAdapter(ListViewActivity.this);
        mListView1.setAdapter(listViewAdapter);

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "点击 " + position, Toast.LENGTH_SHORT).show();
            }
        });

        mListView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "长按 " + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}