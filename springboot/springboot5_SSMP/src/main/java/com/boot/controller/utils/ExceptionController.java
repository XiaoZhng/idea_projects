package com.boot.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Alonso
 */
//异常处理器
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public R doException(Exception e){
        //通过异常处理器拦截所有的异常信息
        //记录日志，或发消息给开发人员
        e.printStackTrace();
        return new R("系统错误，请稍后再试!");
    }
}
