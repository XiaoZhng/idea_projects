package com.mybatis.mapper;

import com.mybatis.bean.emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Alonso
 */
public interface empMapper {

    /**
     * 查询所有员工信息
     */
    List<emp> getAllEmp();

    /**
     * 查询员工以及所对应的部门信息
     */
    emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分布查询，查询员工以及员工所对应的部门信息
     * 分布查询第一步：通过eid查询员工信息
     */
    emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分布查询，查询部门以及部门的所有员工信息
     * 分布查询第二步：查询所有员工信息
     */
    List<emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
