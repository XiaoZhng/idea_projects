package com.boot.config;

import com.boot.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Alonso
 */
@ComponentScan("com.boot")
public class SpringConfig1 {

    @Bean
    public DogFactoryBean dog(){
        return new DogFactoryBean();
    }
}
