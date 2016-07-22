package com.jsh.zy.testdemos.ui.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.jsh.zy.testdemos.R;
import com.jsh.zy.testdemos.ui.activity.MainActivity;
import com.jsh.zy.testdemos.ui.base.BaseFragment;

/**
 * Created by zhangyang on 2016/7/21.
 * 主界面的fragment
 */
public class MainFragment extends BaseFragment implements View.OnClickListener{

    private Button btnCardView;

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
        btnCardView = (Button) rootView.findViewById(R.id.cardview_demo);
        btnCardView.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void updateData() {

    }

    @Override
    public void onClick(View view) {
        if(view==btnCardView){
            openFragment(new CardViewFragment());
        }
    }

    private void openFragment(Fragment fragment){
        FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
        transaction.addToBackStack(fragment.getClass().toString());
        transaction.add(R.id.main_content,fragment,fragment.getClass().toString()).commit();
    }
}
