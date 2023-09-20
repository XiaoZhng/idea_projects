package com.mybatis.mapper;

import com.mybatis.bean.User1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Alonso
 */
public interface UserMapper {

    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    User1 getUser(@Param("id") Integer id);

    /**
     * 获取所有用户信息
     */
    List<User1> getAllUser();
}
