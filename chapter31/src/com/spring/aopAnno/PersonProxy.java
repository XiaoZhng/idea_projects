package com.spring.aopAnno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Alonso
 */
//增强类
@Component
@Aspect
@Order(1)
public class PersonProxy {
    @Before(value = "execution(* com.spring.aopAnno.User.say(..))")
    public void hello(){
        System.out.println("hello word...");
    }
}
