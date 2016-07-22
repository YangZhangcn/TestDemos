package com.jsh.zy.testdemos.application;

import android.app.Application;


import com.jsh.zy.testdemos.utils.AppStorageManager;
import com.jsh.zy.testdemos.utils.GlobalSwitch;

import org.xutils.x;

/**
 * Created by zhangyang on 2016/7/21.
 * 应用的application，初始化xUtil、友盟等数据
 */
public class MyApp extends Application implements GlobalSwitch{

    public AppStorageManager appStorageManager = AppStorageManager.getInstance(this);

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化
        x.Ext.init(this);
        // 设置是否输出debug
        x.Ext.setDebug(isNeedXUtilLog);
    }
}
