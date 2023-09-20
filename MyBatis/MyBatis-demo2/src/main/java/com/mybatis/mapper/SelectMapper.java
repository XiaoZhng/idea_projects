package com.mybatis.mapper;

import com.mybatis.bean.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Alonso
 */
public interface SelectMapper {

    /**
     * 根据id查询用户信息
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有用户信息
     */
    List<User> getAllUser();

    /**
     * 查询用户信息的总记录数
     */
    Integer getCountUser();

    /**
     * 根据id查询用户信息为map集合
     */
    Map<String, Object> getAllUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有用户信息为map集合
     */
    //List<Map<String, Object>> getAllUserToMap();
    @MapKey("id") //设置map集合的键，值是每条数据所对应的map集合
    Map<String, Object> getAllUserToMap();
}
