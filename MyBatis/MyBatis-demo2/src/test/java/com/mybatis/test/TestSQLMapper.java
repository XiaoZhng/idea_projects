package com.mybatis.test;

import com.mybatis.bean.User;
import com.mybatis.mapper.SQLMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author Alonso
 */
public class TestSQLMapper {

    @Test
    public void testgetUserByLike() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);
    }

    @Test
    public void testdeleteMore() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int i = mapper.deleteMore("1, 2, 3");
        System.out.println(i);
    }

    @Test
    public void testgetUserByTable() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> user = mapper.getUserByTable("user");
        System.out.println(user);
    }

    @Test
    public void testinsertUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "lucy1", "123456", 30, '女', "aaa@163.com");
        //User{id=8, username='lucy', password='123456', age=30, sex=女, email='aaa@163.com'}

//        User user = new User(null, "jams", "123456", 30, '女', "aaa@163.com");
        mapper.insertUser(user);
        System.out.println(user);
        //User{id=null, username='jams', password='123456', age=30, sex=女, email='aaa@163.com'}
    }
}
