package com.mybatis;

import com.mybatis.bean.User;
import com.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Alonso
 */
public class MyBatisTest {

    /**
     * sqlSession默认不自动提交事务，若需要自动提交事务
     * 可以使用sqlSessionFactory.openSession(true);
     */

    @Test
    public void Test1() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        //获取 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取 mapper接口对象
        //getMapper()：底层使用的是 代理模式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用 userMapper接口的 InsertUser()
        int i = userMapper.InsertUser();
        //提交事务
//        sqlSession.commit();
        System.out.println(i);
    }

    @Test
    public void CRUD() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //mapper.UpdateUser();
        //mapper.DeleteUser();
        //User userById = mapper.getUserById();
        //System.out.println(userById);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
//        allUser.forEach(new Consumer<User>() {
//            @Override
//            public void accept(User user) {
//                System.out.println(user);
//            }
//        });
//        for (User user : allUser) {
//            System.out.println(user);
//        }
    }
}
