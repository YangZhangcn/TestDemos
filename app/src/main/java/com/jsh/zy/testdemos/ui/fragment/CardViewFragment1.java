package com.jsh.zy.testdemos.ui.fragment;

import android.view.View;

import com.jsh.zy.testdemos.R;
import com.jsh.zy.testdemos.ui.base.BaseFragment;

/**
 * Created by zhangyang on 2016/7/21.
 */
public class CardViewFragment1 extends BaseFragment{
    @Override
    protected View getContentView() {
        return View.inflate(getActivity(), R.layout.fragment_cardview,null);
    }

    @Override
    protected CharSequence getTitleAfter() {
        return "cardView2";
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void updateData() {

    }
}
