package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * @author Alonso
 */
@Mapper
//@Repository
//public interface UserDAO {
//    @Select("select * from User where id = #{id}")
//    User getUserById(Integer id);
//}

//使用mybatis-plus，继承BaseMapper类引入指定泛型即可，不需要写crud方法
public interface UserDAO extends BaseMapper<User> {

}
