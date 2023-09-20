package com.mybatis.mapper;

import com.mybatis.pojo.Address;
import org.apache.ibatis.annotations.*;
public interface AddressMapper {

    @Select("select * from address where user_id = #{id}")
    Address getAddressByUserId(Integer id);
}
