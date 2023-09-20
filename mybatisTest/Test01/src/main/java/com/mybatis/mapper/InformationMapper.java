package com.mybatis.mapper;

import com.mybatis.pojo.Information;
import org.apache.ibatis.annotations.Select;

public interface InformationMapper {

    @Select("select * from information where user_id = #{id}")
    Information getInformationByUserId(Integer id);
}
