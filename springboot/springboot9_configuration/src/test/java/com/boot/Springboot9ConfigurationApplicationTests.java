package com.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot9ConfigurationApplicationTests {

	@Value("${server.ipAddress}")
	private String msg;

	@Value("${datasource.password}")
	private String password;

	@Test
	void contextLoads() {
		System.out.println(msg);
		System.out.println(password);
	}

}
