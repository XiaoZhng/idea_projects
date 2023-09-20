package com.boot.app;

import com.boot.bean.Dog;
import com.boot.config.SpringConfig1;
import com.boot.config.SpringConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Alonso
 */
public class App2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig2.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("=====================");
        System.out.println(context.getBean(Dog.class));
    }
}
