package com.okhttp.demo.okhttp.utils;

import android.util.Log;

/**
 * Created by hongmingwei on 2017/1/11 11:49
 */
public class Loge {
    private static final String TAG = "OKHTTP";
    private static boolean debug = false;

    public static void e(String msg){
        if (debug){
            Log.e(TAG, msg);
        }
    }
}
