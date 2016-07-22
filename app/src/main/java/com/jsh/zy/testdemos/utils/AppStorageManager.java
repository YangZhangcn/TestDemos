package com.jsh.zy.testdemos.utils;

import com.jsh.zy.testdemos.application.MyApp;

/**
 * Created by zhangyang on 2016/7/21.
 * 操作application中的数据的工具类，单例
 */
public class AppStorageManager {

    private MyApp appStorage;

    private static AppStorageManager instance ;

    private AppStorageManager(MyApp appStorage){
        this.appStorage = appStorage;
    }

    public static AppStorageManager getInstance(MyApp appStorage){
        if (instance == null){
            synchronized (AppStorageManager.class){
                instance = new AppStorageManager(appStorage);
            }
        }
        return instance;
    }



}
