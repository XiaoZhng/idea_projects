package com.spring.aopAnno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Alonso
 */
//增强类
@Component
@Aspect //生成代理对象
@Order(2)//设置优先级
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* com.spring.aopAnno.User.say(..))")
    public void point(){}

    //@Before注解表示作为前置通知
    @Before(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void beFore(){
        System.out.println("beFore...");
    }
    //后置通知(返回通知)
    @AfterReturning(value = "execution(* com.spring.aopAnno.User.say(..))")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }
    //最终通知
    @After(value = "execution(* com.spring.aopAnno.User.say(..))")
    public void after(){
        System.out.println("after...");
    }
    //异常通知
    @AfterThrowing(value = "execution(* com.spring.aopAnno.User.say(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }
    //环绕通知
    @Around(value = "execution(* com.spring.aopAnno.User.say(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知前...");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知后...");
    }
}
