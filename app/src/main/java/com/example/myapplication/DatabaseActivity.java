package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * created by cxm1995
 * on 2021/4/27 10:32
 */
//TODO 重构成UTIL工具包
public class DatabaseActivity extends AppCompatActivity {

    @BindView(R.id.et_insert)
    EditText mEtInsert;
    @BindView(R.id.btn_insert)
    Button mBtnInsert;

    @BindView(R.id.et_delete)
    EditText mEtDelete;
    @BindView(R.id.btn_delete)
    Button mBtnDelete;

    @BindView(R.id.et_update_before)
    EditText mEtUpdateBefore;
    @BindView(R.id.et_update_after)
    EditText mEtUpdateAfter;
    @BindView(R.id.btn_update)
    Button mBtnUpdate;

    @BindView(R.id.btn_select_all)
    Button mBtnSelectAll;

    @BindView(R.id.tv_conent)
    TextView mTvContent;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        ButterKnife.bind(this);
        //创建数据库，库名
        DatabaseHelper dbHelper = new DatabaseHelper(DatabaseActivity.this, "test_db", null, 1);
        db = dbHelper.getWritableDatabase();

    }

    @OnClick({R.id.btn_insert, R.id.btn_delete, R.id.btn_update, R.id.btn_select_all})
    public void onClick(View v) {
        switch (v.getId()) {
            //增加数据
            case R.id.btn_insert:
                String insert_data = mEtInsert.getText().toString();
                ContentValues values = new ContentValues();
                values.put("name", insert_data);
                db.insert("user", null, values);
                break;
            //删除数据
            case R.id.btn_delete:
                String delete_data = mEtDelete.getText().toString();
                db.delete("user", "name=?", new String[]{delete_data});
                break;
            //更新数据
            case R.id.btn_update:
                String update_before_data = mEtUpdateBefore.getText().toString();
                String update_after_data = mEtUpdateAfter.getText().toString();
                ContentValues values2 = new ContentValues();
                values2.put("name", update_after_data);
                db.update("user", values2, "name=?", new String[]{update_before_data});
                break;
            //查找所有数据
            case R.id.btn_select_all:
                //创建游标对象
                Cursor cursor = db.query("user", new String[]{"name"}, null, null, null, null, null);
                //利用游标对象遍历所有数据对象
                StringBuilder sb = new StringBuilder();
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    sb.append(name).append(" ");
                }
                mTvContent.setText(sb.toString());
                //关闭游标，释放资源
                cursor.close();
                break;
        }
    }

    class DatabaseHelper extends SQLiteOpenHelper {

        //TODO 带全部参数的构造函数，此构造函数必不可少
        public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //建表,表名 user, 字段名 name 类型varchar
            String sql = "create table user(name varchar(20))";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d("onUpgrade", oldVersion + " " + newVersion);
        }
    }

    //点击事件分发方法重写
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //如果是点击事件，获取点击的view，并判断是否要收起键盘
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            //获取目前得到焦点的view
            View v = getCurrentFocus();
            //判断是否要收起并进行处理
            if (isShouldHideKeyboard(v, ev)) {
                hideKeyboard(v.getWindowToken());
            }
        }
        //这个是activity的事件分发，一定要有，不然就不会有任何的点击事件了
        return super.dispatchTouchEvent(ev);
    }

    //判断是否要收起键盘。焦点在edittext内就不隐藏键盘；焦点不在edittext内就隐藏键盘
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        //如果目前得到焦点的这个view是editText的话进行判断点击的位置
        if (v instanceof EditText) {
            int[] l = {0, 0};
            //获取V的左上角坐标，并传给入参 l
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            // 点击EditText的事件，忽略它。
            return !(event.getX() > left) || !(event.getX() < right)
                    || !(event.getY() > top) || !(event.getY() < bottom);
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上
        return false;
    }

    //隐藏软键盘并让editText失去焦点
    private void hideKeyboard(IBinder token) {
        mEtInsert.clearFocus();
        mEtDelete.clearFocus();
        mEtUpdateBefore.clearFocus();
        mEtUpdateAfter.clearFocus();
        if (token != null) {
            //这里先获取InputMethodManager再调用他的方法来关闭软键盘
            //InputMethodManager就是一个管理窗口输入的manager
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (im != null) {
                im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
}