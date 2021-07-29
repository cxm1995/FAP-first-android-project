package com.example.myapplication.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.R;

/**
 * created by cxm1995
 * on 2021/4/19 15:22
 */
public class AFragment extends Fragment {

    private TextView mTv_title;
    private String mTitle;
    private Activity mActivity;
    private Button mBtn_swap;
    private Button mBtn_change_title;
    private Button mBtn_message;
    private BFragment bFragment;
    private IOnMessageClick listener;

    public static AFragment newInstance(String msg) {
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", msg);
        fragment.setArguments(bundle);
        return fragment;
    }

    public AFragment() {
    }

    public AFragment(String msg) {
        this.mTitle = msg;
    }

    /**
     * 类似activity的setContentView方法，由layout创建view
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Log.d("AFragment", "------onCreateView------");
        return view;
    }

    /**
     * 由view得到所有控件。
     *
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTv_title = view.findViewById(R.id.tv_title);
//        if (mTitle != null) {
//            mTv_title.setText(mTitle);
//        }
        if (getArguments() != null) {
            mTv_title.setText(getArguments().get("title").toString());
        }

        mBtn_swap = view.findViewById(R.id.btn_swap);
        mBtn_swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
                if (getActivity() != null) {
                    //通过tag查找 AFragment是否存在
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    Fragment fragment = fragmentManager.findFragmentByTag("a_tag");
                    if (fragment != null) {
                        //存在就先隐藏afragment。
                        fragmentManager.beginTransaction().hide(fragment).add(R.id.fl_1, bFragment).addToBackStack(null).commitAllowingStateLoss();
                    } else {
                        fragmentManager.beginTransaction().replace(R.id.fl_1, bFragment).addToBackStack(null).commitAllowingStateLoss();
                    }
                } else {
                    //
                }
            }
        });
        mBtn_change_title = view.findViewById(R.id.btn_change_title);
        mBtn_change_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv_title.setText("我是新文字！！！！");
            }
        });


        mBtn_message = view.findViewById(R.id.btn_message);
        mBtn_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    //Fragment向activity传输数据 方法1
                    ((ContainerActivity) getActivity()).setData("activity的新文字");

                    //Fragment向activity传输数据 方法2
                    listener.onClick("activity的新文字");
                }
            }
        });

    }

    public interface IOnMessageClick {
        void onClick(String message);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        mActivity = (Activity) context;//不建议,容易造成内存泄漏。
        try {
            listener = (IOnMessageClick) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity 必须实现 IOnMessageClick接口");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
