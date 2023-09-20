package com.spring.aopAnno;

import org.springframework.stereotype.Component;

/**
 * @author Alonso
 */
//被增强类
@Component
public class User {
    public void say(){
        //int i = 10/0;
        System.out.println("say...");
    }
}
