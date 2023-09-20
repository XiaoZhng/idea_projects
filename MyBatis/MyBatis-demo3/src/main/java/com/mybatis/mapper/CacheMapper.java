package com.mybatis.mapper;

import com.mybatis.bean.emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author Alonso
 */
public interface CacheMapper {

    /**
     * 测试一级缓存
     */
    emp getEmpByEid(@Param("eid") Integer eid);

    /**
     * 添加用户
     */
    int insertEmp(emp emp);
}
