/*
 * LeduBuyerApiException.java
 * classes : com.ledu.ledubuyer.http.exception.LeduBuyerApiException
 * @author xiangyutian
 * V 4.5.0
 * Create at 2014-5-28 下午5:24:34
 */
package com.okhttp.demo.okhttp.utils;

/**
 * Created by hongmingwei on 2017/1/11 12:08
 */
public class HttpClientApiException extends Exception {
    /**
     * 序列号ID
     */
    private static final long serialVersionUID = -1460894893738016580L;

    /**
     * 错误代码
     */
    private int code;
    private String message;

    public HttpClientApiException(int errorCode, String errorMessage) {
        super(errorMessage);
        code = errorCode;
        message = errorMessage;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("code = ");
        sb.append(code);
        sb.append(" ");
        sb.append("message = ");
        sb.append(message);
        sb.append(super.getMessage());
        return sb.toString();
    }
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}
