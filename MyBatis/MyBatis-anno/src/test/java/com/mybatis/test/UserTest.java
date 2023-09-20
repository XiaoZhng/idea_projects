package com.mybatis.test;

import com.mybatis.bean.Order;
import com.mybatis.bean.User;
import com.mybatis.mapper.OrderMapper;
import com.mybatis.mapper.UserMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Alonso
 */
public class UserTest {

    @Test
    public void UserTest01(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.getUser(5));
    }

    @Test
    public void UserTest02(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("Sam");
        user.setAge(10);
        user.setPassword("09876");
        user.setEmail("sam.com");
        Integer integer = mapper.insertUser(user);
        System.out.println(integer);
    }

    @Test
    public void UserTest03(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("sammmm");
        user.setPassword("8888");
        user.setId(17);
        int i = mapper.updateUser(user);
        System.out.println(i);
    }

    @Test
    public void UserTest04(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(17);
        System.out.println(i);
    }

    @Test
    public void UserTest05(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = mapper.selectAllOrder();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void UserTest06(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUserAndOrderAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
