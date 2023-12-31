package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//开启缓存
@EnableCaching
public class Springboot15CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot15CacheApplication.class, args);
	}

}
