package com.pharmacy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pharmacy.domain.User;
import com.pharmacy.mapper.UserMapper;
import com.pharmacy.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Alonso
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-12-16 19:31:26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUser(String username, String password) {
        //校验
        if (username == null || password == null) {
            return null;
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", username);
        queryWrapper.eq("user_password", password);
        User user = userMapper.selectOne(queryWrapper);
        //用户不存在
        if (user == null) {
            return null;
        }
        return user;
    }
}




