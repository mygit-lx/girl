package com.luox.utils;

import com.luox.enums.ResultEnum;

/**
 * Created by luox on 2017/6/1.
 */
public class ExceptionUtil extends RuntimeException{

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ExceptionUtil(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
