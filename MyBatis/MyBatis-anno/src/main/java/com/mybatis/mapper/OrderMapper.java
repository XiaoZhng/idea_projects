package com.mybatis.mapper;

import com.mybatis.bean.Order;
import com.mybatis.bean.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Alonso
 */
public interface OrderMapper {

    @Select("select * from `order` where o_id = #{oid}")
    List<Order> getOrderById(Integer oid);

    //注解一对一
    @Select("select * from `order`")
    @Results({
            @Result(property = "orderName", column = "order_name"),
            @Result(
                    property = "user",
                    column = "o_id",
                    javaType = User.class,
                    one = @One(select = "com.mybatis.mapper.UserMapper.getUser")
            )
    })
    List<Order> selectAllOrder();


//    @Select("select * from user, `order` where user.o_id = order.o_id")
//    @Results({
//            @Result(property = "user.id", column = "id"),
//            @Result(property = "user.username", column = "username"),
//            @Result(property = "user.password", column = "password"),
//            @Result(property = "orderName", column = "order.order_name")
//    })
//    List<Order> selectAllOrder();
}
