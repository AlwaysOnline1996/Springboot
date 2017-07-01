package com.zengtong.handle;

import com.zengtong.Container.Girl;
import com.zengtong.Container.Result;
import com.zengtong.exception.GirlException;
import com.zengtong.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by znt on 17-7-1.
 */
@ControllerAdvice
@RestController
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)

    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException)e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.error("[系统异常]{}",e);// 报未知错误时，可通过日志来方便找错
            return ResultUtil.error(-1,"未知错误");
        }
    }

}
