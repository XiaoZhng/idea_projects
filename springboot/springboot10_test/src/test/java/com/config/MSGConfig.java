package com.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author Alonso
 */
@SpringBootConfiguration
public class MSGConfig {

    @Bean
    public String msg(){
        return "msg...";
    }
}
