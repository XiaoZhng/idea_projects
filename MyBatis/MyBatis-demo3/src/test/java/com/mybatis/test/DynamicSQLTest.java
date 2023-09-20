package com.mybatis.test;

import com.mybatis.bean.emp;
import com.mybatis.mapper.DynamicSQLMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alonso
 */
public class DynamicSQLTest {

    /**
     * 动态SQL：
     * 1.if：根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
     * 2.where：
     *  当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and和or去掉
     *  当where标签中没有内容时，此时where标签没有任何效果
     *  注意：where标签不能将其中内容后面对于的and和or去掉
     * 3.trim：
     *  prefix|suffix：将trim标签中内容前面或后面添加指定内容
     *  prefixOverrides|suffixOverrides：将trim标签中内容前面或后面去掉指定内容
     *  若标签中没有内容时，trim标签页没有任何效果
     * 4.choose、when、otherwise，相当于 if...else if...else
     *  when至少有一个，otherwise最多只能有一个
     * 5.foreach
     *  collection：设置需要循环的数组或集合
     *  item：表示数组或集合中的每一个数据
     *  separator：循环体之间的分隔符
     *  open：foreach标签所循环的所有内容的开始符
     *  close：foreach标签所循环的所有内容的结束符
     * 6.sql标签
     *  设置SQL片段：<sql id="empColumns">eid, emp_name, age, sex, email</sql>
     *  引用SQL片段：<include refid="empColumns"></include>
     */

    @Test
    public void DynamicTest1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<emp> empByCondition = mapper.getEmpByCondition(new emp(null, "", null, null, ""));
        System.out.println(empByCondition);
    }

    @Test
    public void DynamicTest2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<emp> empByCondition = mapper.getEmpByChoose(new emp(null, "tom", 18, null, ""));
        System.out.println(empByCondition);
    }

    @Test
    public void DynamicTest3(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{10, 11});
        System.out.println(result);
    }

    @Test
    public void DynamicTest4(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        emp emp1 = new emp(null, "aa", 11, '男', "123@123.com");
        emp emp2 = new emp(null, "aa", 11, '男', "123@123.com");
        emp emp3 = new emp(null, "aa", 11, '男', "123@123.com");
        List<emp> list = Arrays.asList(emp1, emp2, emp3);
        System.out.println(mapper.insertMoreByList(list));
    }
}
