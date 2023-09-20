package com.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alonso
 */

@Configuration //作为配置类，替代 xml配置文件
@ComponentScan(basePackages = {"com.spring"})
public class SpringConfig {
}
