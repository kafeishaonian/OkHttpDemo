package com.okhttp.demo.okhttp.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by hongmingwei on 2017/1/11 11:35
 */
public class Platform {

    private static final Platform PLATFORM = findPlatform();

    public static Platform get(){
        Loge.e(PLATFORM.getClass().toString());
        return PLATFORM;
    }

    /**
     * 通过消息循环队列获取UI线程的Lopper
     * @return
     */
    private static Platform findPlatform(){
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0){
                return new Android();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Platform();
    }


    public Executor defaultCallbackExecutor(){
        return Executors.newCachedThreadPool();
    }

    public void execute(Runnable runnable){
        defaultCallbackExecutor().execute(runnable);
    }

    static class Android extends Platform{
        @Override
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        static class MainThreadExecutor implements Executor{

            private final Handler handler = new Handler(Looper.getMainLooper());

            @Override
            public void execute(Runnable command) {
                handler.post(command);
            }
        }
    }
}
