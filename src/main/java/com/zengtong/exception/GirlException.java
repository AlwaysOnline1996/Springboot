package com.zengtong.exception;

/**
 * Created by znt on 17-7-1.
 */

/**
 * 自定义异常处理类
 * */
public class GirlException extends RuntimeException{
    /**错误码*/
    private Integer code;

    public GirlException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
