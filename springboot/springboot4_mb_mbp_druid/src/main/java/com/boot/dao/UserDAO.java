package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Alonso
 */
@Mapper
//@Repository
public interface UserDAO {
    @Select("select * from User where id = #{id}")
    User getUserById(Integer id);
}

