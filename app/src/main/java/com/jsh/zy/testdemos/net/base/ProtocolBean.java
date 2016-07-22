package com.jsh.zy.testdemos.net.base;

import org.xutils.http.annotation.HttpResponse;

/**
 * Created by zhangyang on 2016/7/22.
 *
 * bean类需要实现的接口
 */
@HttpResponse(parser = NetParser.class)
public interface ProtocolBean{
}
