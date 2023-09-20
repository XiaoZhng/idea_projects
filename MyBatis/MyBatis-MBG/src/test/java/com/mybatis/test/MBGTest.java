package com.mybatis.test;

import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Alonso
 */
public class MBGTest {

    @Test
    public void MBGTest1(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
//            List<Emp> emps = mapper.selectByExample(null);
//            emps.forEach(emp -> System.out.println(emp));
            //根据条件查询
//            EmpExample empExample = new EmpExample();
//            empExample.createCriteria().andEmpNameEqualTo("jack").andAgeGreaterThanOrEqualTo(5);
//            empExample.or().andSexEqualTo("男");
//            List<Emp> emps = mapper.selectByExample(empExample);
//            emps.forEach(emp -> System.out.println(emp));
            mapper.updateByPrimaryKeySelective(new Emp(1, "jack", 31, null, "987@qq.com", 3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
