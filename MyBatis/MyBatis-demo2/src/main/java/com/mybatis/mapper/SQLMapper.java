package com.mybatis.mapper;

import com.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Alonso
 */
public interface SQLMapper {

    /**
     * 根据用户模糊查询，查询用户信息
     */
    List<User> getUserByLike(@Param("likeName") String likeName);

    /**
     * 批量删除
     */
    int deleteMore(@Param("id") String id);

    /**
     * 查询指定表的数据
     */
    List<User> getUserByTable(String tableName);

    /**
     * 添加用户的信息，获取用户自增的主键
     */
    void insertUser(User user);
}
