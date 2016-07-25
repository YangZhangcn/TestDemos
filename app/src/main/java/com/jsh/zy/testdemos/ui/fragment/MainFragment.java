package com.jsh.zy.testdemos.ui.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.jsh.zy.testdemos.R;
import com.jsh.zy.testdemos.ui.activity.MainActivity;
import com.jsh.zy.testdemos.ui.base.BaseFragment;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by zhangyang on 2016/7/21.
 * 主界面的fragment
 */
public class MainFragment extends BaseFragment implements View.OnClickListener{

    @ViewInject(R.id.cardview_demo)
    private Button btnCardView;

    @ViewInject(R.id.net_demo)
    private Button btnNetDemo;

    @ViewInject(R.id.map_demo)
    private Button btnMapDemo;

    @Override
    protected View getContentView() {
        return View.inflate(getActivity(),R.layout.fragment_main,null);
    }

    @Override
    protected CharSequence getTitleAfter() {
        return "主界面";
    }

    @Override
    protected void initViews() {
        btnCardView.setOnClickListener(this);
        btnNetDemo.setOnClickListener(this);
        btnMapDemo.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void updateUI() {

    }

    @Override
    public void onClick(View view) {
        if(view==btnCardView){
            openFragment(new CardViewFragment());
        }else if (view == btnNetDemo){
            openFragment(new NetFragment());
        }else if(view == btnMapDemo){
            openFragment(new MapFragment());
        }
    }

    private void openFragment(Fragment fragment){
        FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
        transaction.addToBackStack(fragment.getClass().toString());
        transaction.add(R.id.main_content,fragment,fragment.getClass().toString()).commit();
    }
}
