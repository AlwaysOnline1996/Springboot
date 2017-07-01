package com.zengtong.Container;

import com.zengtong.utils.ResultUtil;

/**
 * Created by znt on 17-7-1.
 */
public class Result<T> {
    /** 错误码*/
    private Integer code;

    /**错误提示消息*/
    private String msg;

    /**数据*/
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
