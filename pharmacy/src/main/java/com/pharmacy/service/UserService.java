package com.pharmacy.service;

import com.pharmacy.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* @author Alonso
* @description 针对表【user】的数据库操作Service
* @createDate 2022-12-16 19:31:26
*/
public interface UserService extends IService<User> {
    User selectUser(@Param("username") String username, @Param("password") String password);
}
