package com.mybatis.mapper;

import com.mybatis.bean.dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author Alonso
 */
public interface deptMapper {

    /**
     * 通过分布查询，查询员工以及员工所对应的部门信息
     * 分布查询第二步：通过did查询员工所对应的部门
     */
    dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 查询部门以及部门的所有员工信息
     */
    dept getDeptAndEmpById(@Param("did") Integer did);

    /**
     * 通过分布查询，查询部门以及部门的所有员工信息
     * 分布查询第一步：查询部门信息
     */
    dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
