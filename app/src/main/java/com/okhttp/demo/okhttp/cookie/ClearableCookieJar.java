package com.okhttp.demo.okhttp.cookie;

import okhttp3.CookieJar;

/**
 * 用来扩展和补充来清除cookies
 * Created by Administrator on 2017/4/7 0007.
 */
public interface ClearableCookieJar extends CookieJar {
    /**
     * 清除所有cookie,保持持久化
     */
    void clearSession();

    /**
     * 清除所有cookie持久化和缓存
     */
    void clear();
}
