package com.okhttp.demo.okhttp.builder;

import java.util.Map;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by hongmingwei on 2017/1/11 15:35
 */
public class GetRequest extends OKHttpRequest {
    public GetRequest(String url, Object tag, Map<String, String> params, Map<String, String> headers, int id) {
        super(url, tag, params, headers, id);
    }

    @Override
    protected RequestBody buildRequestBody() {
        return null;
    }

    @Override
    protected Request buildRequest(RequestBody requestBody) {
        return builder.get().build();
    }
}
