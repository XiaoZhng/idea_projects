package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Alonso
 */

//使用注解创建bean对象
//注解里面value属性值可以省略不写
//默认是类名称首字母小写
@Service(value = "userService") //<bean id="userService" class="...">
public class UserService {
    //定义dao类型属性
    //不需要添加set方法
    //添加注入属性注解：
//    @Autowired
//    private BB b1;

    //定义dao类型属性：
    //不需要添加set方法
    //添加注入属性注解：
//    @Autowired
//    @Qualifier(value = "bb") //根据名称进行注入
//    private BB b1;

    //@Resource //根据类型进行注入
    @Resource(name = "bb") //根据名称进行注入
    private BB b1;

    @Value("111")
    private Integer age;
    public void add() {
        System.out.println("UserService.add()..." + age);
        b1.say();
    }
}
