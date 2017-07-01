package com.zengtong.utils;

import com.zengtong.Container.Girl;
import com.zengtong.Container.Result;

/**
 * Created by znt on 17-7-1.
 */
public class ResultUtil{

    public static Result sucess(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    public static Result sucess(){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(null);
        return result;
    }
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
