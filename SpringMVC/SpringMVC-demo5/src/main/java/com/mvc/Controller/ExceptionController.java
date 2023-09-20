package com.mvc.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Alonso
 * 基于注解的异常处理
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String testExceptionHandler(Exception e, Model model){
        model.addAttribute("exception", e);
        return "error";
    }

}
