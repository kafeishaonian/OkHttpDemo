package com.okhttp.demo.okhttp.utils;

import com.okhttp.demo.okhttp.builder.RequestCall;
import com.okhttp.demo.okhttp.callback.Callback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by hongmingwei on 2017/1/11 11:27
 */
public class OkHttpUtils<T> {

    public static final long DEFAULT_MILLISECONDS = 10_000L;//延时10秒
    private volatile static OkHttpUtils mInstance;
    private static OkHttpClient mOkHttpClient;
    private Platform mPlatform;

    public OkHttpUtils(OkHttpClient okHttpClient){
        if (okHttpClient == null){
            mOkHttpClient = new OkHttpClient();
        } else {
            mOkHttpClient = okHttpClient;
        }
        mPlatform = Platform.get();
    }

    public static OkHttpUtils initClient(OkHttpClient okHttpClient){
        if (mInstance == null){
            synchronized (OkHttpUtils.class){
                if (mInstance == null){
                    mInstance = new OkHttpUtils(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public static OkHttpUtils getInstance(){
        return initClient(null);
    }

    public OkHttpClient getOkHttpClient(){
        return mOkHttpClient;
    }

    public void execute(RequestCall requestCall, Callback callback, final Class<T> cls){
        if (callback == null){
            callback = Callback.CALLBACK_DEFAULT;
        }
        final Callback finalCallback = callback;
        final int id = requestCall.getOkHttpRequest().getId();

        requestCall.getCall().enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                sendFailResultCallback(call, e, finalCallback, id);
            }

            @Override
            public void onResponse(final Call call, final Response response){
                try {
                    if (call.isCanceled()){
                        sendFailResultCallback(call, new IOException("取消请求!"), finalCallback, id);
                        return;
                    }
                    if (!finalCallback.validateReponse(response, id)){
                        sendFailResultCallback(call, new IOException("请求失败,响应的代码 ：" + response.code()), finalCallback, id);
                        return;
                    }

                    Object o = finalCallback.parseNetworkResponse(response, id, cls);
                    sendSuccessResultCallback(o, finalCallback, id);
                } catch (Exception e){
                    sendFailResultCallback(call, e, finalCallback, id);
                } finally {
                    if (response.body() != null){
                        response.body().close();
                    }
                }
            }
        });
    }

    /**
     * 发送失败的返回结果
     * @param call
     * @param e
     * @param callback
     * @param id
     */
    public void sendFailResultCallback(final Call call, final Exception e, final Callback callback, final int id){
        if (callback == null){
            return;
        }

        mPlatform.execute(new Runnable() {
            @Override
            public void run() {
                callback.onError(call, e, id);
                callback.onAfrer(id);
            }
        });
    }

    /**
     * 发送成功的返回结果
     * @param object
     * @param callback
     * @param resultCode
     */
    public void sendSuccessResultCallback(final Object object, final Callback callback, final int resultCode){
        if (callback == null) {
            return;
        }
        mPlatform.execute(new Runnable() {
            @Override
            public void run() {
                callback.onResponse(object, resultCode);
                callback.onAfrer(resultCode);
            }
        });
    }

    /**
     * 根据类tag关闭请求
     * @param tag
     */
    public static void cancelTag(Object tag){
        for (Call call : mOkHttpClient.dispatcher().queuedCalls()){
            if (tag.equals(call.request().tag())){
                call.cancel();
            }
        }
        for (Call call : mOkHttpClient.dispatcher().runningCalls()){
            if (tag.equals(call.request().tag())){
                call.cancel();
            }
        }
    }

}
