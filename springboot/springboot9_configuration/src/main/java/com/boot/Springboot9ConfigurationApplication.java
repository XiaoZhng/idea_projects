package com.boot;

import com.alibaba.druid.pool.DruidDataSource;
import com.boot.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//@EnableConfigurationProperties：自动将 ServerConfig做成Bean，所以 ServerConfig类中不用定义Bean
@EnableConfigurationProperties(ServerConfig.class)
public class Springboot9ConfigurationApplication {

	@Bean
//	@ConfigurationProperties(prefix = "datasource")
	public DruidDataSource getDruidDataSource(){
		DruidDataSource druidDataSource = new DruidDataSource();
//		druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return druidDataSource;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Springboot9ConfigurationApplication.class, args);
		ServerConfig bean = run.getBean(ServerConfig.class);
		System.out.println(bean);

		DruidDataSource dataSource = run.getBean(DruidDataSource.class);
		System.out.println(dataSource.getDriverClassName());
	}

}
