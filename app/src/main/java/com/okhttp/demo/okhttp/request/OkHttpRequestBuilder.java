package com.okhttp.demo.okhttp.request;

import java.util.Map;

/**
 * Created by hongmingwei on 2017/1/11 12:00
 */
public abstract class OkHttpRequestBuilder<T extends OkHttpRequestBuilder> implements Params {

    protected String url;
    protected Object tag;
    protected Map<String, String> headers;
    protected Map<String, String> params;
    protected int id;

    public T id(int id){
        this.id = id;
        return (T)this;
    }

    public T url(String url){
        this.url = url;
        return (T) this;
    }

    public T tag(Object tag)
    {
        this.tag = tag;
        return (T) this;
    }


    public abstract RequestCall build();
}
