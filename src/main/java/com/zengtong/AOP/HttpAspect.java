package com.zengtong.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by znt on 17-7-1.
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.zengtong.Controller.Girlcontroller.*(..))")
    public void log(){
/**
 *写成log() ，避免重复写execution(..)
 *比如这里将 @Before(""execution(public * com.zengtong.controller.GirlController.*(..))"")写作 @Before("log()")
 *
 **/
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url = {}",request.getRequestURL());
        // method
        logger.info("method = {}",request.getMethod());
        //ip
        logger.info("ip = {}",request.getRemoteAddr());
        //类方法
        logger.info("class_method = {}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args = {}",joinPoint.getArgs());
    }
    @After("log( )")
    public void doAfer(){
//        System.out.println("log After");
        logger.info("do after");
    }

    @AfterReturning(returning = "object",pointcut = "log()")

    public void doAfterReturnning(Object object){
        //logger.info("response={}",object.toString());
    }
}