package com.okhttp.demo.okhttp.callback;

import com.okhttp.demo.model.AbstractBaseModel;
import com.okhttp.demo.okhttp.utils.JsonParserFactory;

import okhttp3.Response;

/**
 * Created by hongmingwei on 2017/1/16 10:34
 */
public abstract class UserCallBack<T extends AbstractBaseModel> extends Callback<T> {

    @Override
    public T parseNetworkResponse(Response request, int id, Class<T> cls) throws Exception {
        String string = request.body().string();
        return JsonParserFactory.parseStringJson(cls, string);
    }
}
