package com.mbplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mbplus.mapper.UserMapper;
import com.mbplus.pojo.User;
import com.mbplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Alonso
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
