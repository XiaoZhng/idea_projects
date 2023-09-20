package com.spring.test;

import com.spring.config.JdbcConfig;
import com.spring.dao.UserDao;
import com.spring.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AspectJTest {

    @Test
    void test(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JdbcConfig.class);
        UserDao bean = context.getBean(UserDao.class);
        User user = new User();
        user.setId(1);
        user.setUserName("jack");
        user.setPassword(123456);
        int result = bean.insert(user);
        Assertions.assertEquals(1, result);
    }
}
