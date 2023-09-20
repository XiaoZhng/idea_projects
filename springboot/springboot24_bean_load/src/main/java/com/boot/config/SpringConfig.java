package com.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.boot.bean.Cat;
import com.boot.bean.Mouse;
import com.boot.bean.MyImportSelector;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;

/**
 * @author Alonso
 */
//@Import(MyImportSelector.class)
public class SpringConfig {

//    @Bean
//    @ConditionalOnClass(name = "com.boot.bean.wolf")
//    public Cat cat(){
//        return new Cat();
//    }


    @Bean
    @ConditionalOnClass(name = "com.mysql.jdbc.Driver")
    //有mysql去掉才加载 DruidDataSource
    public DruidDataSource dataSource(){
        return new DruidDataSource();
    }
}
