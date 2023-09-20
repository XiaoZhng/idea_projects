package com;

import com.boot.Springboot2JunitApplication;
import com.boot.dao.impl.BookDAOImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

//测试类如果存在与引导类所在包或子包中无需指定引导类
//测试类如果不存在于引导类所在的包或子包中需要通过classes属性指定引导类
@SpringBootTest(classes = Springboot2JunitApplication.class)
//@ContextConfiguration(classes = Springboot2JunitApplication.class)
class Springboot2JunitApplicationTests {

	//1.注入要测试的对象
	@Autowired
	private BookDAOImpl bookDAO;

	@Test
	void contextLoads() {
		//2.执行要测试对象的对应方法
		bookDAO.save();
		System.out.println("two...");
		String s = "好!";
		System.out.println(s.length());
	}

}
