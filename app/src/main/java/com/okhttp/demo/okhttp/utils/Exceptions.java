package com.okhttp.demo.okhttp.utils;

/**
 * Created by hongmingwei on 2017/1/11 12:08
 */
public class Exceptions {

    public static void illegalArgument(String msg, Object... params){
        throw new IllegalArgumentException(String.format(msg, params));
    }

}
