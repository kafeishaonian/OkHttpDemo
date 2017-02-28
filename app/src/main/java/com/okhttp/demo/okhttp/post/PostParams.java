package com.okhttp.demo.okhttp.post;

import com.okhttp.demo.okhttp.request.OkHttpRequestBuilder;
import com.okhttp.demo.okhttp.request.Params;
import com.okhttp.demo.okhttp.request.RequestCall;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hongmingwei on 2017/2/28 10:42
 */
public class PostParams extends OkHttpRequestBuilder<PostParams> implements Params {

    @Override
    public RequestCall build() {
        return new PostRequest(url, tag, params, headers, id).build();
    }

    @Override
    public PostParams params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    @Override
    public PostParams addParams(String key, String val) {
        if (this.params == null){
            params = new LinkedHashMap<>();
        }
        params.put(key, val);
        return this;
    }
}
