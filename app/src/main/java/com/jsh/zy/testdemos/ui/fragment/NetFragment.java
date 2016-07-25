package com.jsh.zy.testdemos.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jsh.zy.testdemos.R;
import com.jsh.zy.testdemos.net.base.BaseProtocol;
import com.jsh.zy.testdemos.net.base.ProtocolBean;
import com.jsh.zy.testdemos.net.base.ProtocolCallBack;
import com.jsh.zy.testdemos.net.bean.TestBean;
import com.jsh.zy.testdemos.ui.base.BaseFragment;

import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyang on 2016/7/22.
 */
public class NetFragment extends BaseFragment implements View.OnClickListener,ProtocolCallBack{

    @ViewInject(R.id.btn_frag_net_get)
    private Button get;

    @ViewInject(R.id.btn_frag_net_post)
    private Button post;

    @ViewInject(R.id.tv_frag_net_result)
    private TextView result;

    private BaseProtocol protocol;

    @Override
    protected View getContentView() {
        return View.inflate(getActivity(), R.layout.fragment_net,null);
    }

    @Override
    protected CharSequence getTitleAfter() {
        return "XUtils封装";
    }

    @Override
    protected void initViews() {
        get.setOnClickListener(this);
        post.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        protocol = new BaseProtocol("",null,this,false);
    }

    @Override
    protected void updateUI() {

    }

    @Override
    public void onClick(View view) {
        if (view == get){
            Map<String,String> params = new HashMap<>();
            params.put("appkey", "10003");
            params.put("sign", "b59bc3ef6191eb9f747dd4e83c99f2a4");
            params.put("format", "json");
            params.put("idcard", "110101199001011114");
            protocol.setParams(params);
            protocol.get();
        }else if(view == post){
            protocol.post();
        }
    }

    @Override
    public void onSuccessed(String resultStr) {
//        if(bean instanceof TestBean){
//            TestBean resultBean =(TestBean) bean;
//            if (!TextUtils.isEmpty(resultBean.msg))
//                result.setText(resultBean.msg);
//        }
        if (!TextUtils.isEmpty(resultStr))
               result.setText(resultStr);

        new AlertDialog.Builder(getActivity()).setTitle("提示")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setNegativeButton("QUIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }

    @Override
    public void onFailed(Throwable ex) {

    }

    @Override
    public void onCancelled() {

    }
}
