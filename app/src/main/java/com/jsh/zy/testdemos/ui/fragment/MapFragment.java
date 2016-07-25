package com.jsh.zy.testdemos.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.amap.api.maps.MapView;
import com.amap.api.maps.model.MarkerOptions;
import com.jsh.zy.testdemos.R;
import com.jsh.zy.testdemos.ui.base.BaseFragment;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by zhangyang on 2016/7/25.
 */
public class MapFragment extends BaseFragment{
    @Override
    protected View getContentView() {
        return View.inflate(getActivity(), R.layout.fragment_map,null);
    }

    @ViewInject(R.id.map)
    MapView mMapView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (rootView !=null){
            mMapView = (MapView) rootView.findViewById(R.id.map);
            mMapView.onCreate(savedInstanceState);
        }
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void updateUI() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，实现地图生命周期管理
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    protected CharSequence getTitleAfter() {
        return "地图";
    }

}
