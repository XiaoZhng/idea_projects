package com.mbplus;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mapper接口所在的包
//@MapperScan("com.mbplus.mapper")
public class Plus01Application {

	public static void main(String[] args) {
		SpringApplication.run(Plus01Application.class, args);
	}

}
