package com.mybatis.test;

import com.mybatis.bean.User;
import com.mybatis.mapper.SelectMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Alonso
 */
public class TestSelectMapper {

    /**
     * mybatis的各种给查询功能:
     * 1、若查询出的数据只有一条
     * (1)可以通过实体类对象接收
     * (2)可以通过list集合接收
     * (3)可以通过map集合接收
     * 结果：{password=123456, sex=男, id=7, age=22, email=123@123.com, username=tom}
     * 2、若查询的数据有多条
     * (1)可以通过实体类型的list集合接收
     * (2)可以通过map类型的list集合接收
     * (3)可以在mapper接口的方法上添加 @MapKey注解，此时就可以将每条数据转换为map集合作为值，以某个字段的值作为键，放在同一个map集合中
     * 注意：一定不能通过实体类对象接收，此时会抛异常 TooManyResultsException
     *
     * mybatis设置了默认的类型别名：
     * java.lang.Integer --> int, integer
     * int --> _int, _integer
     * Map --> map
     * String --> string
     */

    @Test
    public void testgetUserById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
//        System.out.println(mapper);
        User userById = mapper.getUserById(4);
        System.out.println(userById);
    }

    @Test
    public void testgetAllUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
    }

    @Test
    public void testgetCountUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer countUser = mapper.getCountUser();
        System.out.println(countUser);
    }

    @Test
    public void testgetAllUserByIdToMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getAllUserByIdToMap(7);
        System.out.println(map);
    }

    @Test
    public void testgetAllUserToMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        //List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        //System.out.println(allUserToMap);

        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(map);
    }
}
