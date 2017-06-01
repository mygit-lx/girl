package com.luox.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by luox on 2017/6/1.
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger log = Logger.getLogger(HttpAspect.class);

//    @Before("execution(public * com.luox.controller.GirlController.*(..))")
//    public void log(){
//        System.out.println("方法执行之前已经拦截！");
//    }
//
//    @After("execution(public * com.luox.controller.GirlController.*(..))")
//    public void doAfter(){
//        System.out.println("方法执行之后！");
//    }

    //解决重复的代码问题
    @Pointcut("execution(public * com.luox.controller.GirlController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录url
        log.info("url=>"+ request.getRequestURI());
        //记录method
        log.info("method=>"+request.getMethod());
        //记录ip
        log.info("ip=>"+request.getRemoteAddr());
        //记录类方法
        log.info("class-method=>"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //记录参数
        log.info("args=>"+joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        log.info("方法执行之后!");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        log.info("response=>"+object);
    }

}
