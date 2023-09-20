package com.mbplus;

import com.mbplus.enums.SexEnum;
import com.mbplus.mapper.UserMapper;
import com.mbplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Alonso
 */
@SpringBootTest
public class PlusEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void enumTest(){
        User user = new User();
        user.setName("admin");
        user.setAge(20);
        user.setSex(SexEnum.MALE);
        userMapper.insert(user);
    }
}
