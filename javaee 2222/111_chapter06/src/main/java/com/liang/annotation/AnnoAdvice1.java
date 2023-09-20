package com.liang.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnoAdvice1 {

    @Pointcut("execution( * com.liang.dao.UserDao.*(..))")
    public void poincut1(){};

//    @Before("poincut1()")
    public void before(JoinPoint joinPoint){
        System.out.println("增强开始");
    }

    @Around("poincut1()")
    public Object ar(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        Object proceed = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("方法所耗费的时间："+(end-start));
        return proceed;
    }

//    @After("poincut1()")
    public void af(JoinPoint joinPoint){
        System.out.println("增强结束");
    }
}
