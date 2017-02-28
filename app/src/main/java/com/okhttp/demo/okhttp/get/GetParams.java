package com.okhttp.demo.okhttp.get;

import android.net.Uri;

import com.okhttp.demo.okhttp.request.OkHttpRequestBuilder;
import com.okhttp.demo.okhttp.request.Params;
import com.okhttp.demo.okhttp.request.RequestCall;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * URl拼接
 * Created by hongmingwei on 2017/1/11 11:59
 */
public class GetParams extends OkHttpRequestBuilder<GetParams> {

    @Override
    public GetParams addParams(String key, String val) {
        if (this.params == null){
            params = new LinkedHashMap<>();
        }
        params.put(key, val);
        return this;
    }

    @Override
    public RequestCall build() {
        if (params != null){
            url = appendParams(url, params);
        }
        return new GetRequest(url, tag, params, headers, id).build();
    }


    protected String appendParams(String url, Map<String, String> params){
        if (url == null || params == null || params.isEmpty()){
            return url;
        }
        Uri.Builder builder = Uri.parse(url).buildUpon();
        Set<String> keys = params.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            builder.appendQueryParameter(key, params.get(key));
        }
        return builder.build().toString();
    }
}
