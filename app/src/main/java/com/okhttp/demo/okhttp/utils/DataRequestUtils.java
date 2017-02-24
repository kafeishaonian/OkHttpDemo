package com.okhttp.demo.okhttp.utils;


import com.okhttp.demo.okhttp.HttpTaskManager;
import com.okhttp.demo.okhttp.builder.GetParams;
import com.okhttp.demo.okhttp.builder.RequestCall;

/**
 * Created by hongmingwei on 2017/1/16 10:09
 */
public class DataRequestUtils {
    // api地址
    public static final String FORMAL_API_HOST = "http://www.baidu.com";
    //接口
    private static final String GET_NONFARM_INFO = "//getAllNonfarmInfo.do";


    private static String combineRequestUrl(String domain){
        String url = FORMAL_API_HOST + domain;
        return url;
    }

    //初始化拼接
    private static GetParams addBase(GetParams builder){
        return builder
                .addParams("appver", "1.0.0")
                .addParams("sysver", "5.1")
                .addParams("ua", "android");
    }

    //接口拼接
    public static RequestCall getTline(String tag, String environmentCode){
        String url = combineRequestUrl(GET_NONFARM_INFO);
        GetParams builder = HttpTaskManager.get()
                .url(url)
                .tag(tag)
                .addParams("environmentCode", environmentCode);
        return addBase(builder).build();
    }


}
