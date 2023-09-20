package com.mbplus.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mbplus.mybatisx.pojo.User;
import com.mbplus.mybatisx.service.UserService;
import com.mbplus.mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Alonso
* @description 针对表【db_user】的数据库操作Service实现
* @createDate 2022-10-16 17:16:26
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




