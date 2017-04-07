package com.okhttp.demo.okhttp.cookie.persistence;

import java.util.Collection;
import java.util.List;

import okhttp3.Cookie;

/**
 * Cookie持久化存储
 * Created by Administrator on 2017/4/7 0007.
 */
public interface CookiePersistor {

    List<Cookie> loadAll();

    /**
     * 保存所有Cookie，以保存被覆盖
     * @param cookies
     */
    void saveAll(Collection<Cookie> cookies);

    /**
     * 移除所有Cookie
     * @param cookies
     */
    void removeAll(Collection<Cookie> cookies);

    /**
     * 清除所有cookie
     */
    void clear();

}
