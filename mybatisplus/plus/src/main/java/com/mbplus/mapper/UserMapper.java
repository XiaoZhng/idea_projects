package com.mbplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author Alonso
 */
//将UserMapper标记为持久层组件，可以将
@Repository
public interface UserMapper extends BaseMapper<User> {

    Map<String, Object> selectMapById(Long id);

    /**
     * 通过年龄查询用户信息并分页
     * @param page Mybatis-Plus所提供的分页对象，必须位于第一个参数的位置
     * @param age
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);
    
}
