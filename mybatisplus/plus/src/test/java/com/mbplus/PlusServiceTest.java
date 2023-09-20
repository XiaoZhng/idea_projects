package com.mbplus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mbplus.pojo.User;
import com.mbplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @author Alonso
 */
@SpringBootTest
public class PlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void countTest(){
        //查询总记录数
        //SELECT COUNT( * ) FROM user
        System.out.println("总记录数= " + userService.count());
    }

    @Test
    public void insertMoreTest(){
        //批量添加
        //INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("ja" + i);
            user.setAge(2+i);
            list.add(user);
        }
        System.out.println(userService.saveBatch(list));
    }
}
