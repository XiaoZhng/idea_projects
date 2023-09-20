package com.boot;

import com.boot.dao.UserDAO;
import net.bytebuddy.asm.Advice.Unused;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot4MbMbpDruidApplicationTests {

	@Autowired
	private UserDAO userDAO;

	/**
	 * 整合第三方技术通用方式：
	 * 1.导入对应的 starter
	 * 2.根据提供的配置格式，配置非默认值对应的配置项
	 */

	@Test
	void contextLoads() {
		System.out.println(userDAO.getUserById(2));
	}

}
