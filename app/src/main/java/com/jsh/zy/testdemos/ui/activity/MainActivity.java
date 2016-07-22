package com.jsh.zy.testdemos.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Window;

import com.jsh.zy.testdemos.R;
import com.jsh.zy.testdemos.ui.base.BaseActivity;
import com.jsh.zy.testdemos.ui.fragment.MainFragment;

import org.xutils.view.annotation.ContentView;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(R.id.main_content,new MainFragment()).commit();
        actionBar = getSupportActionBar();
    }

}
