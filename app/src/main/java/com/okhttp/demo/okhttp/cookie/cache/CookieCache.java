package com.okhttp.demo.okhttp.cookie.cache;

import java.util.Collection;

import okhttp3.Cookie;

/**
 * Created by Administrator on 2017/4/7 0007.
 */
public interface CookieCache extends Iterable<Cookie> {

    void addAll(Collection<Cookie> cookies);

    void clear();

}
