package com.okhttp.demo.model;

import java.util.ArrayList;

/**
 * Created by hongmingwei on 2017/1/16 14:58
 */
public class AbstractBaseModel {

    private int code;
    private String msg;
    private int startIndex;
    private int total;
    private int pageSize;
    private int curPage;
    private ArrayList<Object> items;
    private int totalPage;

    public int getCode() {
        return code;
    }

    public void setCode(int mCode) {
        code = mCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String mMsg) {
        msg = mMsg;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int mStartIndex) {
        startIndex = mStartIndex;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int mTotal) {
        total = mTotal;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int mPageSize) {
        pageSize = mPageSize;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int mCurPage) {
        curPage = mCurPage;
    }

    public ArrayList<Object> getItems() {
        return items;
    }

    public void setItems(ArrayList<Object> mItems) {
        items = mItems;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int mTotalPage) {
        totalPage = mTotalPage;
    }
}
