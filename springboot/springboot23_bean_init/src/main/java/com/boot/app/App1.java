package com.boot.app;

import com.boot.config.SpringConfig1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Alonso
 */
public class App1 {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        Cat cat = context.getBean(Cat.class);
//        Dog dog = context.getBean(Dog.class);
//        System.out.println(cat);
//        System.out.println(dog);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig1.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(context.getBean("dog"));
        System.out.println(context.getBean("dog"));
        System.out.println(context.getBean("dog"));
    }
}
