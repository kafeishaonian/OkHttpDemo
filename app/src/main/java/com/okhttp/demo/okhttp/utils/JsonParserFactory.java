/*
 * JsonParserFactory.java
 * @author xiangyutian
 * V 4.5.0
 * Create at 2014-3-21 下午6:14:59
 */
package com.okhttp.demo.okhttp.utils;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.okhttp.demo.model.AbstractBaseModel;
import com.okhttp.demo.model.UserModel;
import com.okhttp.demo.okhttp.ServerErrorCode;

import org.json.JSONException;

import java.io.IOException;

/**
 * 数据解析器工厂
 *
 * @author xiangyutian <br/>
 *         create at 2014-3-21 下午6:14:59
 */
public class JsonParserFactory {
    /**
     * TAG
     */
    private static final String TAG = "JsonParserFactory";

    public static <T extends UserModel> T parseStringJson(Class<T> cls, Object context) throws JSONException,
            HttpClientApiException, IOException {
        final T response;
        try {
            response = new Gson().fromJson((String) context, cls);
        } catch (JsonSyntaxException e) {
            throw new JSONException(e.getMessage());
        } catch (JsonIOException e) {
            throw new IOException(e.getMessage());
        } catch (JsonParseException e) {
            throw new JSONException(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new JSONException(e.getMessage());
        }

        if (response == null) {
            throw new JSONException(TAG + " JsonParser is null.");
        }

//        if (response.getCode() != ServerErrorCode.STATUS_SUCCESS) {
//            throw new HttpClientApiException(response.getCode(), response.getMsg());
//        }

        return response;
    }
}
