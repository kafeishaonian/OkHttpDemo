package com.okhttp.demo;

import android.app.Application;


import com.okhttp.demo.okhttp.cookie.ClearableCookieJar;
import com.okhttp.demo.okhttp.cookie.PersistentCookieJar;
import com.okhttp.demo.okhttp.cookie.cache.SetCookieCache;
import com.okhttp.demo.okhttp.cookie.persistence.SharedPrefsCookiePersistor;
import com.okhttp.demo.okhttp.utils.HttpUtils;
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

        /**
         * 设置Https请求，
         * 证书的inputstream
         * 本地证书的inputstream
         * 本地证书的密码
         */
        HttpUtils.SSLParams sslParams = HttpUtils.getSslSocketFactory(null, null, null);
        /**
         * 持久化
         */
        ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor("TAG")) //log日志
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)//连接超时
                .writeTimeout(10000L, TimeUnit.MILLISECONDS) //读取超时
                .readTimeout(10000L, TimeUnit.MILLISECONDS)  //写入超时
                .pingInterval(10000L, TimeUnit.MILLISECONDS) //websocket 轮训间隔
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .cookieJar(cookieJar)
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
