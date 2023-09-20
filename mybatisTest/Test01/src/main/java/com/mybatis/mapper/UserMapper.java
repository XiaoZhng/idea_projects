package com.mybatis.mapper;

import com.mybatis.pojo.Address;
import com.mybatis.pojo.Information;
import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Alonso
 */
public interface UserMapper {
    /**
     * 查询所有用户信息
     */
    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "information", //要封装的属性名称
                    column = "id", //根据哪个字段去查询 information表的数据
                    javaType = Information.class, //要封装的实体类型
                    //select属性：代表查询哪个接口的方法获得数据
                    one = @One(select = "com.mybatis.mapper.InformationMapper.getInformationByUserId")
            ),
            @Result(
                    property = "address",
                    column = "id",
                    many = @Many(select = "com.mybatis.mapper.AddressMapper.getAddressByUserId")
            )
    })
    List<User> getUser();
}
