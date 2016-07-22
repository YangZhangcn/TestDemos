package com.jsh.zy.testdemos.net.base;

import com.google.gson.Gson;

import org.json.JSONObject;
import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;

/**
 * Created by zhangyang on 2016/7/22.
 */
public class NetParser implements ResponseParser{
    @Override
    public void checkResponse(UriRequest request) throws Throwable {
        
    }

    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        return new Gson().fromJson(result,resultClass);
    }
}
