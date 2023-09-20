package com.spring.annotation;

import org.springframework.stereotype.Repository;

/**
 * @author Alonso
 */
@Repository(value = "bb")
public class BB {
    public void say(){
        System.out.println("BB...");
    }
}
