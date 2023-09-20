package com.mybatis.test;

import com.mybatis.bean.User;
import com.mybatis.mapper.ParameterMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alonso
 */
public class TestParameterMapper {

    /**
     * mybatis获取参数值的两种方式：${} 和 #{}
     * ${}：本质是字符串拼接
     * #{}：本质是占位符赋值
     * mybatis获取参数值的各种情况：
     * 1、mapper接口方法的参数为单个的字面量类型：
     * 可以通过${}和#{}以任意的名称获取参数值，但是需要注意${}的单引号问题
     * 2、mapper接口方法的参数为多个时：
     * 此时mybatis会将这些参数放在一个map集合中，以两种方式进行存储
     * (1)以arg0，arg1...为键，以参数为值
     * (2)以param1，param2...为键，以参数为值
     * 因此只需要通过#{},${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 3、若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
     * 只需要通过#{},${}，以键的方式访问值即可，但是需要注意${}的单引号问题
     * 4、mapper接口方法的参数是实体类型的参数
     * 只需要通过#{},${}，以键的方式访问值即可，但是需要注意${}的单引号问题
     * 5、使用 @Param注解命名参数
     * 此时mybatis会将这些参数放在一个map集合中，以两种方式进行存储
     * (1)以 @Param注解的值为键，以参数为值
     * (2)以param1，param2...为键，以参数为值
     * 因此只需要通过#{},${}以键的方式访问值即可，但是需要注意${}的单引号问题
     */

    @Test
    public void testgetAllUser() throws IOException {
        //把获取SqlSession方法封装到工具类
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper userMapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> userList = userMapper.getAllUser();
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void testgetUserByUsername() throws IOException {
        //把获取SqlSession方法封装到工具类
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper userMapper = sqlSession.getMapper(ParameterMapper.class);
        User jack = userMapper.getUserByUsername("jack");
        System.out.println(jack);
    }

    @Test
    public void testcheckLogin() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User jack = mapper.checkLogin("jack", "123456");
        System.out.println(jack);
    }

    @Test
    public void testcheckLoginByMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "jack");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testinsertUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int i = mapper.insertUser(new User(null, "tom", "123456", 22, '男', "123@123.com"));
        System.out.println(i);
    }

    @Test
    public void testcheckLoginByParam() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User jack = mapper.checkLoginByParam("jack", "123456");
        System.out.println(jack);
    }
}
