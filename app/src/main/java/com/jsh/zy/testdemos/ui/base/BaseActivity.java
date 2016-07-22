package com.jsh.zy.testdemos.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jsh.zy.testdemos.application.MyApp;
import com.jsh.zy.testdemos.utils.AppStorageManager;

import org.xutils.x;

/**
 * 所有页面的基类
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * 标题栏
     */
    protected android.support.v7.app.ActionBar actionBar;

    /**
     * 内存数据管理工具
     */
    protected AppStorageManager appStorageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);//xutil视图注入
        actionBar = getSupportActionBar();
        appStorageManager  = AppStorageManager.getInstance((MyApp) getApplicationContext());
    }

    public CharSequence getActTitle(){
        return actionBar.getTitle();
    }

    public void setActTitle(CharSequence title){
        actionBar.setTitle(title);
    }


}
