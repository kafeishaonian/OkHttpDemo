package com.okhttp.demo.okhttp.utils;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * Created by hongmingwei on 2017/1/12 15:25
 */
public class LogInterceptor implements Interceptor {

    private long mStartTime;
    private long mEndTime;

    public static final String TAG = "OkHttpUtils";
    private String tag;
    private boolean showResponse;

    public LogInterceptor(String tag, boolean showResponse){
        if (TextUtils.isEmpty(tag)){
            tag = TAG;
        }
        this.showResponse = showResponse;
        this.tag = tag;
    }

    public LogInterceptor(String tag){
        this(tag, false);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        logForRequest(request);
        Response response = chain.proceed(request);
        return logForResponse(response);
    }

    /**
     * 日志响应
     * @param response
     * @return
     */
    private Response logForResponse(Response response){
        try{
            Log.e(tag, "========response'log=======");
            Response.Builder builder = response.newBuilder();
            Response clone = builder.build();
            mEndTime = System.currentTimeMillis();
            Log.e(tag, "url :(time: "+(mEndTime - mStartTime)+"  ms [ ]) " + clone.request().url());
            Log.e(tag, "code : " + clone.code());
            Log.e(tag, "protocol : " + clone.protocol());
            if (!TextUtils.isEmpty(clone.message()))
                Log.e(tag, "message : " + clone.message());

            if (showResponse)
            {
                ResponseBody body = clone.body();
                if (body != null)
                {
                    MediaType mediaType = body.contentType();
                    if (mediaType != null)
                    {
                        Log.e(tag, "responseBody's contentType : " + mediaType.toString());
                        if (isText(mediaType))
                        {
                            String resp = body.string();
                            Log.e(tag, "responseBody's content : " + resp);

                            body = ResponseBody.create(mediaType, resp);
                            return response.newBuilder().body(body).build();
                        } else
                        {
                            Log.e(tag, "responseBody's content : " + " maybe [file part] , too large too print , ignored!");
                        }
                    }
                }
            }

            Log.e(tag, "========response'log=======end");

            Log.e(tag, "网络请求耗时:   " + (mEndTime - mStartTime) + "ms");
        } catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 日志请求
     * @param request
     */
    private void logForRequest(Request request){
        try {
            mStartTime = System.currentTimeMillis();
            String url = request.toString();
            Headers headers = request.headers();

            Log.e(tag, "========request log ==========");
            Log.e(tag, "method:" + request.method());
            Log.e(tag, "url :" + url);
            if (headers != null && headers.size() > 0){
                Log.e(tag, "headers :" + headers.toString());
            }
            RequestBody requestBody = request.body();
            if (requestBody != null){
                MediaType mediaType = requestBody.contentType();
                if (mediaType != null){
                    Log.e(tag, "requestBody contentType :" + mediaType.toString());
                    if (isText(mediaType)){
                        Log.e(tag, "requestBody content :" + bodyToString(request));
                    } else {
                        Log.e(tag, "requestBody content :" + "maybe [file part], too large too pring, ignored!");
                    }
                }
            }
            Log.e(tag, "===========request log=================");
        } catch (Exception e){

        }
    }

    private boolean isText(MediaType mediaType){
        if (mediaType.type() != null && mediaType.type().equals("text")){
            return true;
        }
        if (mediaType.subtype() != null){
            if (mediaType.subtype().equals("json") ||
                    mediaType.subtype().equals("xml") ||
                    mediaType.subtype().equals("html") ||
                    mediaType.subtype().equals("webviewhtml")){
                return true;
            }
        }
        return false;
    }

    private String bodyToString(Request request){
        try {
            Request copy = request.newBuilder().build();
            Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (IOException e) {
            return "当requestBody显示错误";
        }
    }

}
