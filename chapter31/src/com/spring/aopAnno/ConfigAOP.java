package com.spring.aopAnno;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Alonso
 */
@Configuration
@ComponentScan(basePackages = {"com.spring"})//开启注解扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)//开启Aspect生成代理对象
public class ConfigAOP {
}
