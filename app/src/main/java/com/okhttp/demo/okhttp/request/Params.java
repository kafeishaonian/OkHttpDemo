package com.okhttp.demo.okhttp.request;


import java.util.Map;

/**
 * Created by hongmingwei on 2017/1/11 15:28
 */
public interface Params {

    OkHttpRequestBuilder params(Map<String, String> params);

    OkHttpRequestBuilder addParams(String key, String val);
}
