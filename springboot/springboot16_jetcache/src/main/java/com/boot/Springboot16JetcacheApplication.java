package com.boot;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//jetCache启用缓存的主开关
@EnableCreateCacheAnnotation
//开启方法缓存
@EnableMethodCache(basePackages = "com.boot")
public class Springboot16JetcacheApplication {
	public static void main(String[] args) {
		SpringApplication.run(Springboot16JetcacheApplication.class, args);
	}
}
