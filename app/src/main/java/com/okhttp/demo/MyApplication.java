package com.okhttp.demo;

import android.app.Application;


import com.okhttp.demo.okhttp.utils.LogInterceptor;
import com.okhttp.demo.okhttp.utils.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by hongmingwei on 2017/1/16 15:16
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
