package com.mybatis.mapper;

import com.mybatis.bean.User;

import java.util.List;

/**
 * @author Alonso
 */
public interface UserMapper {

    /**
     *MyBatis面向接口编程的两个一致：
     * 1、映射文件的 namespace要和 mapper接口的全类名保持一致
     * 2、映射文件中 sql语句的 id要和 mapper接口中的方法名一致
     *
     * 表 -- 实体类 -- mapper接口 -- 映射文件
     */

    //添加用户信息
    int InsertUser();

    //修改用户信息
    void UpdateUser();

    //删除用户信息
    void DeleteUser();

    //根据id查询用户信息
    User getUserById();

    //查询所有用户信息
    List<User> getAllUser();
}
