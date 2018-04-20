package com.a99zan.qhcourse.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.a99zan.qhcourse.app.MyApp;
import com.a99zan.qhcourse.utils.ToastUtil;

import butterknife.ButterKnife;

/**
 * Created by 99zan on 2018/4/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        MyApp.getInstance().addActivity(this);
        init(savedInstanceState);
    }

    protected abstract @LayoutRes
    int getLayoutId();

    protected abstract void init(Bundle savedInstanceState);

    protected void showToast(String msg){
        ToastUtil.showShort(this, msg);
    }

}
