package com.jsh.zy.testdemos.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;

/**
 * Created by zhangyang on 2016/7/21.
 * 所有fragment的基类
 */
public abstract class BaseFragment extends Fragment{


    protected View rootView;//根视图

    protected BaseActivity activity;//用于操作标题

    private CharSequence titleBefore;//添加此fragment前的标题

    private CharSequence titleAfter;//此fragment需要显示的标题

    public BaseFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (BaseActivity) context;
        titleBefore = activity.getActTitle();
        titleAfter = getTitleAfter();
        if(titleAfter!=null)
            activity.setActTitle(titleAfter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(titleBefore!=null){
            activity.setActTitle(titleBefore);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView==null)
            rootView = getContentView();

        x.view().inject(this,rootView);
        initViews();
        initData();
        updateData();
        return rootView;
    }

    /**
     * 设置根视图
     * @return
     */
    protected abstract View getContentView();

    /**
     * 初始化视图组件,点击事件等等
     */
    protected abstract void initViews();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 数据的填充
     */
    protected abstract void updateData();

    /**
     * 如果需要activity更新标题的话，重写此方法，返回需要显示的标题
     * @return
     */
    protected CharSequence getTitleAfter(){
        return null;
    }

}
