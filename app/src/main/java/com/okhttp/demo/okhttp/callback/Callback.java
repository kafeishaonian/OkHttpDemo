package com.okhttp.demo.okhttp.callback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 获取到数据
 * Created by hongmingwei on 2017/1/11 12:16
 */
public abstract class Callback<T> {
    /**
     * UI Thread
     * @param request
     * @param id
     */
    public void onBefore(Request request, int id){

    }

    /**
     * UI Thread
     * @param id
     */
    public void onAfrer(int id){

    }

    /**
     * 用PareNetworkResponse解析响应代码。需要返回true
     * @param response
     * @param id
     * @return true
     */
    public boolean validateReponse(Response response, int id){
        return response.isSuccessful();
    }

    /**
     * 解析网络响应
     * @param request
     * @param id
     * @param cls
     * @return
     * @throws Exception
     */
    public abstract T parseNetworkResponse(Response request, int id, Class<T> cls) throws Exception;

    /**
     * 返回错误
     * @param call
     * @param e
     * @param id
     */
    public abstract void onError(Call call, Exception e, int id);

    /**
     * 正确解析
     * @param responst
     * @param resultCode
     */
    public abstract void onResponse(T responst, int resultCode);


    public static Callback CALLBACK_DEFAULT = new Callback() {
        @Override
        public Object parseNetworkResponse(Response request, int id, Class cls) throws Exception {
            return null;
        }

        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(Object responst, int id) {

        }
    };

}
