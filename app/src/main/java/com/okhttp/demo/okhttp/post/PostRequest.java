package com.okhttp.demo.okhttp.post;

import com.okhttp.demo.okhttp.callback.Callback;
import com.okhttp.demo.okhttp.request.CountingRequestBody;
import com.okhttp.demo.okhttp.request.OKHttpRequest;
import com.okhttp.demo.okhttp.utils.OkHttpUtils;

import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by hongmingwei on 2017/2/28 11:00
 */
public class PostRequest extends OKHttpRequest {

    protected PostRequest(String url, Object tag, Map<String, String> params, Map<String, String> headers, int id) {
        super(url, tag, params, headers, id);
    }

    @Override
    protected RequestBody buildRequestBody() {
        FormBody.Builder builder = new FormBody.Builder();
        addParams(builder);
        FormBody formBody = builder.build();
        return formBody;
    }

    @Override
    protected RequestBody wrapRequestBody(RequestBody requestBody, final Callback callback) {
        if (callback == null){
            return requestBody;
        }
        CountingRequestBody countingRequestBody = new CountingRequestBody(requestBody, new CountingRequestBody.Listener() {
            @Override
            public void onRequestProgress(final long bytesWritten, final long contentLength) {
                OkHttpUtils.getInstance().getDelivery().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.inProgress(bytesWritten * 1.0f / contentLength, contentLength, id);
                    }
                });
            }
        });
        return countingRequestBody;
    }

    @Override
    protected Request buildRequest(RequestBody requestBody) {
        return builder.post(requestBody).build();
    }



    private void addParams(FormBody.Builder builder){
        if (params != null){
            for (String key : params.keySet()){
                builder.add(key, params.get(key));
            }
        }
    }
}
