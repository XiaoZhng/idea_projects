package com.mybatis.mapper;

import com.mybatis.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Alonso
 */
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getUser(Integer id);

    @Insert("insert into user values(null, #{username}, #{password}, #{age}, #{sex}, #{email})")
    Integer insertUser(User user);

    @Update("update user set username = #{username}, password = #{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(Integer id);

    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "age", column = "age"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "email", column = "email"),
            @Result(property = "oId", column = "o_id"),
            @Result(
                    property = "orderList",
                    column = "oId",
                    javaType = List.class,
                    many = @Many(select = "com.mybatis.mapper.OrderMapper.getOrderById")
            )
    })
    List<User> getUserAndOrderAll();

}
