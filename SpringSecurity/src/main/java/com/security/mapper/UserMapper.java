package com.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<Users> {
}
