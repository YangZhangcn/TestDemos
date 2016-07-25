package com.jsh.zy.testdemos.net.bean;

import com.jsh.zy.testdemos.net.base.ProtocolBean;

/**
 * Created by zhangyang on 2016/7/22.
 * {"success":"0","msgid":"1000501","msg":"请求接口不存在"}
 */
public class TestBean implements ProtocolBean{
    public String success;
    public String msgid;
    public String msg;

    public Result result;

    @Override
    public String toString() {
        return "TestBean{" +
                "success='" + success + '\'' +
                ", msgid='" + msgid + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

    class Result{
        public String areano;
        public String att;
        public String born;
        public String idcard;
        public String par;
        public String postno;
        public String sex;
        public String status;
        public String style_citynm;
        public String style_simcall;

        @Override
        public String toString() {
            return "Result{" +
                    "areano='" + areano + '\'' +
                    ", att='" + att + '\'' +
                    ", born='" + born + '\'' +
                    ", idcard='" + idcard + '\'' +
                    ", par='" + par + '\'' +
                    ", postno='" + postno + '\'' +
                    ", sex='" + sex + '\'' +
                    ", status='" + status + '\'' +
                    ", style_citynm='" + style_citynm + '\'' +
                    ", style_simcall='" + style_simcall + '\'' +
                    '}';
        }
    }
}
