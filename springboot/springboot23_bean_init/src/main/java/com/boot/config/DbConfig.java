package com.boot.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alonso
 */
@Configuration
public class DbConfig {

    @Bean
    public DruidDataSource dataSource(){
        return new DruidDataSource();
    }
}
