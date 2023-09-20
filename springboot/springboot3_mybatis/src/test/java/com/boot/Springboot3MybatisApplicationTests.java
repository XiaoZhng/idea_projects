package com.boot;

import com.boot.bean.User;
import com.boot.dao.UserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest()
class Springboot3MybatisApplicationTests {

    /**
     * 1.第一种方法就是在dao层加入注解@Repository添加到spring容器中，
     * 虽然我使用springboot使用mapper已经将其添加到容器中了，但是idea仍然不解析
     * 2.第二种方法就是在测试类中不使用@Autowired注解改成@Resource注解，
     * 在dao层也不需要添加@Repository也不会报红
     */
    @Autowired
    private UserDAO userDAO;

    @Test
    void contextLoads() {
//        User userById = userDAO.getUserById(1);
//        System.out.println(userById);

        User user = userDAO.selectById(1);
        List<User> users = userDAO.selectList(null);
        System.out.println(user);
        users.forEach(User -> System.out.println(User));
    }

}
