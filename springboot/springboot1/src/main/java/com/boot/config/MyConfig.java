package com.boot.config;

import com.boot.bean.Cat;
import com.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.regex.Matcher;

/**
 * @author Alonso
 */

/**
 * 1.配置类里面十一@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods：代理bean的方法
 * Full(全配置)：proxyBeanMethods = true
 * Lite(轻量级配置)：proxyBeanMethods = false
 * 组件依赖
 */
//告诉SpringBoot这是一个配置类 -> 配置文件
@Configuration(proxyBeanMethods = true)
@Import({User.class, Matcher.class})
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次，获取的都是之前容器中的单实例对象
     * @return
     */
    //给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型，返回的值，就是组件在容器中的实例
    @Bean
    public User User01(){
        User jack = new User("jack", 20);
        jack.setCat(Cat01());
        return jack;
    }

    @Bean("tomcat")
    public Cat Cat01(){
        return new Cat("tom", "black");
    }
}
