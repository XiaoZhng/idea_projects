package com.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Alonso
 */
public class SqlSessionUtil {

    //获取 SqlSession
    public static SqlSession getSqlSession(){

        SqlSession sqlSession = null;
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = sessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
