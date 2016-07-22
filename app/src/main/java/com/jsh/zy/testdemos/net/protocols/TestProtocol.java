package com.jsh.zy.testdemos.net.protocols;

import com.jsh.zy.testdemos.net.base.BaseProtocol;
import com.jsh.zy.testdemos.net.base.ProtocolCallBack;

import java.util.Map;

/**
 * Created by zhangyang on 2016/7/22.
 */
public class TestProtocol extends BaseProtocol{

    public TestProtocol(String url, Map<String, String> params, ProtocolCallBack callBack, boolean isNeedToken) {
        super(url, params, callBack, isNeedToken);
    }
}
