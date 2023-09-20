package com.boot;

import com.boot.bean.Cat;
import com.boot.bean.User;
import com.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.regex.Matcher;


/**
 * @author Alonso
 */
//主程序类：@SpringBootApplication 这是一个SpringBoot应用
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MyApplication.class, args);

        //2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //3.从容器中获取组件
        Cat tomcat01 = run.getBean("tomcat", Cat.class);
        Cat tomcat02 = run.getBean("tomcat", Cat.class);
        System.out.println("组件= " + (tomcat01 == tomcat02));

        //4.com.boot.config.MyConfig$$EnhancerBySpringCGLIB$$70a15a0b@29a23c3d
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot总会检查这个组件是否在容器中有
        //保持组件单实例
        User user1 = bean.User01();
        User user2 = bean.User01();
        System.out.println(user1 == user2);

        User user01 = run.getBean("User01", User.class);
        Cat cat = run.getBean("tomcat", Cat.class);
        System.out.println(user01.getCat());//Cat{name='tom', color='black'}
        System.out.println("用户的cat对象= " + (user01.getCat() == cat));

        //5.获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("===============");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        Matcher matcher = run.getBean(Matcher.class);
        System.out.println(matcher);
    }
}
