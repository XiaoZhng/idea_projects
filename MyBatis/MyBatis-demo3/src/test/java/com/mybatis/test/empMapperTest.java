package com.mybatis.test;

import com.mybatis.bean.dept;
import com.mybatis.bean.emp;
import com.mybatis.mapper.deptMapper;
import com.mybatis.mapper.empMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Alonso
 */
public class empMapperTest {

    /**
     * 解决字段名和属性名不一致的情况
     * (1)为字段起别名，保持和属性名的一致
     * (2)设置全局配置，将 _ 自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * (3)通过resultMap设置自定义的映射关系
     * <resultMap id="resultEmp" type="emp">
     *    <id property="eid" column="eid"></id>
     *    <result property="empName" column="emp_name"></result>
     *    <result property="age" column="age"></result>
     *    <result property="sex" column="sex"></result>
     *    <result property="email" column="email"></result>
     * </resultMap>
     *
     * 处理多对一的映射关系：
     * (1)级联属性赋值
     * (2)association
     *
     * 处理一对多的映射关系
     * (1)collection
     * (2)分步查询
     */

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        List<emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }

    @Test
    public void testEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        emp emp = mapper.getEmpAndDept(3);
        System.out.println(emp);
    }

    @Test
    public void testEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        emp empAndDeptByStepOne = mapper.getEmpAndDeptByStepOne(3);
        System.out.println(empAndDeptByStepOne);
//        System.out.println(empAndDeptByStepOne.getEmpName());
        System.out.println("===================");
//        System.out.println(empAndDeptByStepOne.getDept());
    }

    @Test
    public void testDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        deptMapper mapper = sqlSession.getMapper(deptMapper.class);
        dept dept = mapper.getDeptAndEmpById(2);
        System.out.println(dept);
    }

    @Test
    public void testDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        deptMapper mapper = sqlSession.getMapper(deptMapper.class);
        dept dept = mapper.getDeptAndEmpByStepOne(2);
        System.out.println(dept);
    }

}
