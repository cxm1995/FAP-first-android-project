package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.fragment.ContainerActivity;
import com.example.myapplication.gridview.GridViewActivity;
import com.example.myapplication.jump.AActivity;
import com.example.myapplication.listview.ListViewActivity;
import com.example.myapplication.recyclerview.RecyclerViewActivity;


/**
 * created by cxm1995
 * on 2021/4/7 12:00
 * 梦开始的地方
 */
public class UiActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditView;
    private Button mBtnRadio;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecyclerView;
    private Button mBtnWebView;
    private Button mBtnJump;
    private Button mBtnLifeCycle;
    private Button mBtnFragment;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;
    private Button mBtnCustomDialog;
    private Button mBtnPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_linear); //线性布局
//        setContentView(R.layout.activity_main_relative);//相对布局
        setContentView(R.layout.activity_ui);//展示各种控件

//        mBtnTextView = findViewById(R.id.btn_textview);
//        mBtnTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //跳转textview界面
//                Intent intent = new Intent(MainActivity.this, TextViewActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        mBtnButton = findViewById(R.id.btn_button);
//        mBtnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //跳转到button界面
//                Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        mBtnEditView = findViewById(R.id.btn_editview);
//        mBtnEditView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //跳转到editview界面
//                Intent intent = new Intent(MainActivity.this, EditViewActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        mBtnFun = findViewById(R.id.btn_fun);
//        mBtnFun.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Fun.class);
//                startActivity(intent);
//            }
//        });
//
//        mBtnRadio = findViewById(R.id.btn_radio);
//        mBtnRadio.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, RadioActivity.class);
//                startActivity(intent);
//            }
//        });

        //上面重复代码过多，重构下
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        mBtnEditView = findViewById(R.id.btn_editview);
        mBtnRadio = findViewById(R.id.btn_radio);
        mBtnCheckBox = findViewById(R.id.btn_checkbox);
        mBtnImageView = findViewById(R.id.btn_imageview);
        mBtnListView = findViewById(R.id.btn_listview);
        mBtnGridView = findViewById(R.id.btn_gridview);
        mBtnRecyclerView = findViewById(R.id.btn_recyclerview);
        mBtnWebView = findViewById(R.id.btn_webview);
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnLifeCycle = findViewById(R.id.btn_lifecycle);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnProgress = findViewById(R.id.btn_progress);
        mBtnCustomDialog = findViewById(R.id.btn_custome_dialog);
        mBtnPopupWindow = findViewById(R.id.btn_pop);
        setListener();
    }

    private void setListener() {
        Onclick onclick = new Onclick();

        mBtnTextView.setOnClickListener(onclick);
        mBtnButton.setOnClickListener(onclick);
        mBtnEditView.setOnClickListener(onclick);
        mBtnRadio.setOnClickListener(onclick);
        mBtnCheckBox.setOnClickListener(onclick);
        mBtnImageView.setOnClickListener(onclick);
        mBtnListView.setOnClickListener(onclick);
        mBtnGridView.setOnClickListener(onclick);
        mBtnRecyclerView.setOnClickListener(onclick);
        mBtnWebView.setOnClickListener(onclick);
        mBtnJump.setOnClickListener(onclick);
        mBtnLifeCycle.setOnClickListener(onclick);
        mBtnFragment.setOnClickListener(onclick);
        mBtnToast.setOnClickListener(onclick);
        mBtnDialog.setOnClickListener(onclick);
        mBtnProgress.setOnClickListener(onclick);
        mBtnCustomDialog.setOnClickListener(onclick);
        mBtnPopupWindow.setOnClickListener(onclick);
    }

    private class Onclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_textview:
                    intent = new Intent(UiActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(UiActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_editview:
                    intent = new Intent(UiActivity.this, EditViewActivity.class);
                    break;
                case R.id.btn_radio:
                    intent = new Intent(UiActivity.this, RadioActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent = new Intent(UiActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    intent = new Intent(UiActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    intent = new Intent(UiActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    intent = new Intent(UiActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    intent = new Intent(UiActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_webview:
                    intent = new Intent(UiActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_jump:
                    intent = new Intent(UiActivity.this, AActivity.class);
                    break;
                case R.id.btn_lifecycle:
                    intent = new Intent(UiActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(UiActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(UiActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent = new Intent(UiActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_progress:
                    intent = new Intent(UiActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_custome_dialog:
                    intent = new Intent(UiActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_pop:
                    intent = new Intent(UiActivity.this, PopupWindowActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }
}