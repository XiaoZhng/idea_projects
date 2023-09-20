package com.mybatis.mapper;

import com.mybatis.bean.emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Alonso
 */
public interface DynamicSQLMapper {

    /**
     * 多条件查询
     */
    List<emp> getEmpByCondition(emp emp);

    /**
     * 测试 choose、when、otherwise
     */
    List<emp> getEmpByChoose(emp emp);

    /**
     * 通过 foreach实现批量删除(根据eid删除)
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过 foreach实现批量添加
     */
    int insertMoreByList(@Param("empList") List<emp> empList);
}
