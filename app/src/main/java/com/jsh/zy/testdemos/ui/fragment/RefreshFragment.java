package com.jsh.zy.testdemos.ui.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jsh.zy.testdemos.R;
import com.jsh.zy.testdemos.ui.base.BaseFragment;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyang on 2016/7/28.
 */
public class RefreshFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    @ViewInject(R.id.swrl_test)
    private SwipeRefreshLayout swipeRefreshLayout;

    @ViewInject(R.id.listview)
    private ListView listView;

    private ArrayAdapter<String> adapter;

    private List<String> datas = new ArrayList<String>();

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1){
                swipeRefreshLayout.setRefreshing(false);
            }
        }
    };

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_refresh,container,false);
    }

    @Override
    protected CharSequence getTitleAfter() {
        return "下拉刷新";
    }

    @Override
    protected void initViews() {
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,android.R.id.text1, datas);
        listView.setAdapter(adapter);
        for (int i = 0; i < 30; i++) {
            datas.add("item:"+i);
        }
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary,R.color.colorPrimaryDark,R.color.textColor_actionsheet_title);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void updateUI() {

    }

    @Override
    public void onRefresh() {
        handler.sendEmptyMessageDelayed(1,5000);
    }
}
