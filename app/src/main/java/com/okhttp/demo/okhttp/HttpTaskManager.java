package com.okhttp.demo.okhttp;

import com.okhttp.demo.okhttp.builder.GetParams;
import com.okhttp.demo.okhttp.builder.RequestCall;
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

    public static GetParams get(){
        return new GetParams();
    }

}
