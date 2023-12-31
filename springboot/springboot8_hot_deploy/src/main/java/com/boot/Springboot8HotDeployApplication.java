package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot8HotDeployApplication {

	public static void main(String[] args) {
		//设置高优先级属性禁用热部署
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Springboot8HotDeployApplication.class, args);
	}

}
