package com.mybatis.test;

import com.mybatis.bean.emp;
import com.mybatis.mapper.CacheMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Alonso
 */
public class CacheMapperTest {

    /**
     * 一级缓存失效的四种情况：
     * (1)不同的SqlSession对应不同的一级缓存
     * (2)同一个SqlSession但是查询条件不同
     * (3)同一个SqlSession两次查询期间执行了任何一次增删改操作
     * (4)同一个SqlSession两次查询期间手动清空了缓存
     */

    @Test
    public void OneCacheMapperTest(){
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        emp emp1 = mapper1.getEmpByEid(1);
        System.out.println(emp1);
//        mapper1.insertEmp(new emp(null, "aaa", 11, '男', "123@qq.com"));
        sqlSession1.clearCache();//清空缓存
        emp emp2 = mapper1.getEmpByEid(1);
        System.out.println(emp2);
//        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
//        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
//        emp emp2 = mapper2.getEmpByEid(1);
//        System.out.println(emp2);
    }

    @Test
    public void TwoCacheMapperTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession1 = sessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        System.out.println(mapper1.getEmpByEid(1));
        sqlSession1.close();
        SqlSession sqlSession2 = sessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        System.out.println(mapper2.getEmpByEid(1));
        sqlSession2.close();
    }
}
