package com.boot;

import com.boot.dao.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot19MailApplicationTests {

	@Autowired
	private SendMailService sendMailService;

	@Test
	void contextLoads() {
		sendMailService.sendMail();
	}

}
