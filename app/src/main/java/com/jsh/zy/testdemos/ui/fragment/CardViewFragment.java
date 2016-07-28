package com.jsh.zy.testdemos.ui.fragment;

import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jsh.zy.testdemos.R;
import com.jsh.zy.testdemos.ui.base.BaseFragment;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by zhangyang on 2016/7/21.
 */
public class CardViewFragment extends BaseFragment implements View.OnClickListener{

    @ViewInject(R.id.add_new_frag)
    private Button addMore;

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate( R.layout.fragment_cardview, container,false);
    }

    @Override
    protected CharSequence getTitleAfter() {
        return "cardView";
    }

    @Override
    protected void initViews() {
        addMore.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void updateUI() {

    }

    @Override
    public void onClick(View view) {
        if (view == addMore){
            FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
            CardViewFragment1 fragment = new CardViewFragment1();
            transaction.addToBackStack(fragment.getClass().toString());
            transaction.add(R.id.main_content,fragment,fragment.getClass().toString()).commit();
        }
    }

}
