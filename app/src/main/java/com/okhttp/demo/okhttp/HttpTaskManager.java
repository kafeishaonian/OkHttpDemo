package com.okhttp.demo.okhttp;

import com.okhttp.demo.okhttp.get.GetParams;
import com.okhttp.demo.okhttp.post.PostParams;
import com.okhttp.demo.okhttp.request.RequestCall;
import com.okhttp.demo.okhttp.callback.UserCallBack;

/**
 * Created by hongmingwei on 2017/1/17 10:45
 */
public class HttpTaskManager {
    /**
     * 对数据进行封装
     * @param call
     * @param parserObj
     * @param cls
     */
    public static void startStringRequest(RequestCall call, UserCallBack parserObj,Class cls){
        call.execute(parserObj, cls);
    }

    /**
     * get请求
     * @return
     */
    public static GetParams get(){
        return new GetParams();
    }

    /**
     * post请求
     * @return
     */
    public static PostParams post(){
        return new PostParams();
    }


}
