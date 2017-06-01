package com.luox.handle;

import com.luox.constant.Result;
import com.luox.utils.ExceptionUtil;
import com.luox.utils.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by luox on 2017/6/1.
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger log = Logger.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof ExceptionUtil){
            ExceptionUtil exceptionUtil = (ExceptionUtil) e;
            return ResultUtil.result(exceptionUtil.getCode(),exceptionUtil.getMessage(),null);
        }else{
            log.info("系统异常=>"+e);
            return ResultUtil.result(-1,e.getMessage(),null);
        }
    }
}
