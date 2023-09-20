package com.mybatis.mapper;

import com.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Alonso
 */
public interface ParameterMapper {

    /**
     * 获取所有员工信息
     */
    List<User> getAllUser();

    /**
     * 根据用户名获取用户信息
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录(map集合)
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息(参数是实体类)
     */
    int insertUser(User user);

    /**
     * 验证登录(使用 @Param)
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
