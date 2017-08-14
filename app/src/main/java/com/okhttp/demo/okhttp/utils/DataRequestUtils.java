package com.okhttp.demo.okhttp.utils;


import com.okhttp.demo.okhttp.HttpTaskManager;
import com.okhttp.demo.okhttp.callback.FileCallBack;
import com.okhttp.demo.okhttp.get.GetParams;
import com.okhttp.demo.okhttp.post.PostParams;
import com.okhttp.demo.okhttp.request.OkHttpRequestBuilder;
import com.okhttp.demo.okhttp.request.Params;
import com.okhttp.demo.okhttp.request.RequestCall;

/**
 * Created by hongmingwei on 2017/1/16 10:09
 */
public class DataRequestUtils {
    // api地址
    public static final String FORMAL_API_HOST = "http://api.tudou.com";
    //接口
    private static final String GET_NONFARM_INFO = "/v3/gw";




    private static String combineRequestUrl(String domain){
        String url = FORMAL_API_HOST + domain;
        return url;
    }

    //初始化拼接
    private static OkHttpRequestBuilder addBase(OkHttpRequestBuilder builder){
        return builder
                .addParams("method", "item.info.get")
                .addParams("format", "json")
                .addParams("itemCodes", "yg8CVootoAc")
                .addParams("appKey", "myKey");
    }

    //接口拼接   20
    public static RequestCall getTline(String tag, String page, String limit){
        String url = combineRequestUrl(GET_NONFARM_INFO);
        GetParams builder = HttpTaskManager.get()
                .url(url)
                .tag(tag)
                .addParams("page", page)
                .addParams("limit", limit);
        return addBase(builder).build();
    }



    public static RequestCall getPost(String tag){
        String url = combineRequestUrl(GET_NONFARM_INFO);
        PostParams builder = HttpTaskManager.post()
                .url(url)
                .tag(tag);
        return addBase(builder).build();
    }

    public static RequestCall getFile(String tag){
        GetParams builder = HttpTaskManager.get()
                .url("")
                .tag(tag);
        return addBase(builder).build();
    }


}
