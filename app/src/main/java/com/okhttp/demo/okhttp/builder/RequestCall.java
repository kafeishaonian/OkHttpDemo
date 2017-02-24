package com.okhttp.demo.okhttp.builder;

import com.okhttp.demo.okhttp.callback.Callback;
import com.okhttp.demo.okhttp.utils.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 *
 * 对OKHttpRequest的封装，对外提供更多的接口：cancel(), readTimeOut()...
 *
 * Created by hongmingwei on 2017/1/11 12:03
 */
public class RequestCall<T> {

    private OKHttpRequest okHttpRequest;
    private Request request;
    private Call call;

    private long readTimeOut;//读得时间
    private long writeTimeOut;//写
    private long connTimeOut;//完成

    private OkHttpClient clone;

    public RequestCall(OKHttpRequest okHttpRequest){
        this.okHttpRequest = okHttpRequest;
    }


    /**
     * 建立联系
     * @param callback
     * @return
     */
    public Call buildCall(Callback callback){
        request = generateRequest(callback);

        if (readTimeOut > 0 || writeTimeOut > 0 || connTimeOut > 0){
            readTimeOut = readTimeOut > 0 ? readTimeOut : OkHttpUtils.DEFAULT_MILLISECONDS;
            writeTimeOut = writeTimeOut > 0 ? writeTimeOut : OkHttpUtils.DEFAULT_MILLISECONDS;
            connTimeOut = connTimeOut > 0 ? connTimeOut : OkHttpUtils.DEFAULT_MILLISECONDS;

            clone = OkHttpUtils.getInstance().getOkHttpClient().newBuilder()
                    .readTimeout(readTimeOut, TimeUnit.MILLISECONDS)
                    .writeTimeout(writeTimeOut, TimeUnit.MILLISECONDS)
                    .connectTimeout(connTimeOut, TimeUnit.MILLISECONDS)
                    .build();

            call = clone.newCall(request);
        } else {
            call = OkHttpUtils.getInstance().getOkHttpClient().newCall(request);
        }
        return call;
    }

    /**
     * 生成请求
     * @param callback
     * @return
     */
    private Request generateRequest(Callback callback){
        return okHttpRequest.generateRequest(callback);
    }

    public void execute(Callback callback, Class<T> cls){
        buildCall(callback);

        if (callback != null){
            callback.onBefore(request, getOkHttpRequest().getId());
        }
        OkHttpUtils.getInstance().execute(this, callback, cls);
    }

    public Call getCall(){
        return call;
    }

    public OKHttpRequest getOkHttpRequest(){
        return okHttpRequest;
    }


}
