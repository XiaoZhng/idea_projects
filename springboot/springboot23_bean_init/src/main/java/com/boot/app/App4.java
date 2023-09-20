package com.boot.app;

import com.boot.bean.Cat;
import com.boot.bean.Dog;
import com.boot.config.SpringConfig3;
import com.boot.config.SpringConfig4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Alonso
 */
public class App4 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig4.class);

        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
