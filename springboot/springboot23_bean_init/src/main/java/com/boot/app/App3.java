package com.boot.app;

import com.boot.bean.Cat;
import com.boot.bean.Dog;
import com.boot.config.SpringConfig3;
import com.sun.corba.se.impl.orbutil.CacheTable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Alonso
 */
public class App3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig3.class);
        //上下文容器对象已经初始化完毕后，手工加载 Bean
        //加载多个相同的bean，会被覆盖
        context.registerBean("cat", Cat.class, 0);
        context.registerBean("cat", Cat.class, 1);
        context.registerBean("cat", Cat.class, 2);
        context.register(Dog.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("===================");
        System.out.println(context.getBean(Cat.class));
    }
}
