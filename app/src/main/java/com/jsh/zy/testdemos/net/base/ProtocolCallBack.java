package com.jsh.zy.testdemos.net.base;

/**
 * Created by zhangyang on 2016/7/22.
 *
 * 协议回调接口
 */
public interface ProtocolCallBack {

    void onSuccessed(ProtocolBean bean);

    void onFailed(Throwable ex);

    void onCancelled();

}
