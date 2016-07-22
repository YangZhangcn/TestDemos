package com.jsh.zy.testdemos.net.base;

import android.text.TextUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * Created by zhangyang on 2016/7/22.
 *
 * 所有网络请求的基类，基于xutil3封装
 */
public class BaseProtocol implements Addresses,Callback.CommonCallback<ProtocolBean>{

    /**
     * 地址，根据不同接口生成
     */
    protected String url;

    /**
     * 请求参数
     */
    private Map<String,String> params;

    /**
     * 可能会需要传的登陆标识
     */
    private String token;

    /**
     * 返回的bean对象
     */
    protected ProtocolBean responesBean;

    /**
     * 回调接口
     */
    protected ProtocolCallBack callBack;

    /**
     * 网络协议的基类
     * @param url 地址，不需要公共部分
     * @param params 参数
     * @param isNeedToken 是否需要传token
     */
    public BaseProtocol(String url, Map<String, String> params,ProtocolCallBack callBack,boolean isNeedToken) {
        this.url = ADDRESS_BASE+url;
        this.params = params;
        this.callBack = callBack;
        if (isNeedToken)
            token = "";
    }

    public BaseProtocol(String url,ProtocolCallBack callBack,boolean isNeedToken) {
        this(url,null,callBack,isNeedToken);
    }

    /**
     * get请求
     */
    public void get(){
        RequestParams xParams = new RequestParams(url);
        if (!TextUtils.isEmpty(token))
            xParams.addQueryStringParameter("token",token);
        for (String key : params.keySet()) {
            xParams.addQueryStringParameter(key,params.get(key));
        }
        x.http().get(xParams, this);
    }

    public void post(){
        RequestParams xParams = new RequestParams(url);
        if (TextUtils.isEmpty(token))
            xParams.addQueryStringParameter("token",token);
        for (String key : params.keySet()) {
            xParams.addBodyParameter(key,params.get(key));
        }
        x.http().post(xParams,this);
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public void onSuccess(ProtocolBean result) {
        this.responesBean = result;
        callBack.onSuccessed(result);
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        callBack.onFailed(ex);
    }

    @Override
    public void onCancelled(CancelledException cex) {
        callBack.onCancelled();
    }

    @Override
    public void onFinished() {

    }

}
