package com.mbplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mbplus.mapper.UserMapper;
import com.mbplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author Alonso
 * 测试 条件构造器
 */
@SpringBootTest
public class PlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        //查询用户名包含d，年龄20~30，邮箱不为null
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM db_user WHERE is_deleted=0
        // AND (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("user_name", "d").between("age", 20, 30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //查询，按年龄降序排序，年龄相同，按id升序排序
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM db_user
        // WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age").orderByAsc("uid");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03(){
        //删除邮箱地址为null的用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNull("email");
        int delete = userMapper.delete(wrapper);
        System.out.println(delete);
    }

    @Test
    public void test04(){
        //将（年龄大于20并且用户名中包含有d）或邮箱为null的用户信息修改
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20).like("user_name", "d")
                .or().isNull("email");
        User user = new User();
        user.setName("小明");
        user.setEmail("xiao@123.com");
        System.out.println(userMapper.update(user, wrapper));
    }

    //条件的优先级
    @Test
    public void test05(){
        //将用户名中含有t并且（年龄大于20或邮箱为null）的用户信息修改
        //UPDATE db_user SET user_name=?, email=? WHERE is_deleted=0
        // AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("user_name", "t")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setName("小李");
        user.setEmail("li@123.com");
        System.out.println(userMapper.update(user, wrapper));
    }

    @Test
    public void test06(){
        //查询用户的用户名、年龄、邮箱
        //SELECT user_name,age,email FROM db_user WHERE is_deleted=0
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("user_name", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    //子查询
    @Test
    public void test07(){
        //查询id小于等于100的用户
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM db_user WHERE is_deleted=0
        // AND (uid IN (select uid from db_user where uid <= 100))
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("uid", "select uid from db_user where uid <= 100");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test08(){
        //将用户名中含有t并且（年龄大于20或邮箱为null）的用户信息修改
        //UPDATE db_user SET user_name=?,email=? WHERE is_deleted=0 AND (user_name LIKE ?
        // AND (age > ?) OR email IS NULL)
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.like("user_name", "t").and(i -> i.gt("age", 20))
                .or().isNull("email");
        wrapper.set("user_name", "小黑").set("email", "black.com");
        int result = userMapper.update(null, wrapper);
        System.out.println(result);
    }

    //动态组装条件
    @Test
    public void test09(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM db_user
        // WHERE is_deleted=0 AND (user_name LIKE ? AND age < ?)
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //isNotBlank判断某个字符是否不为空字符串，不为null，不为空白符
        wrapper.like(StringUtils.isNotBlank(username), "user_name", username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    //使用LambdaQueryWrapper
    @Test
    public void test10(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM db_user
        // WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ?)
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    //使用LambdaUpdateWrapper
    @Test
    public void test11(){
        //将用户名中含有t并且（年龄大于20或邮箱为null）的用户信息修改
        //UPDATE db_user SET user_name=?,email=? WHERE is_deleted=0
        // AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.like(User::getName, "t").and(i -> i.gt(User::getAge, 20)
        .or().isNull(User::getEmail));
        wrapper.set(User::getName, "小黑").set(User::getEmail, "black.com");
        int update = userMapper.update(null, wrapper);
        System.out.println(update);
    }
}
