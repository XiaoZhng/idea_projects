package com.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.security.entity.Users;
import com.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")//起名，相当于注入此对象
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用 userMapper 根据用户名查询数据库
        QueryWrapper<Users> queryWrapper = new QueryWrapper();
        // where username = ?
        queryWrapper.eq("username", username);
        Users user = userMapper.selectOne(queryWrapper);
        //判断
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在...");
        }

        List<GrantedAuthority> authorityList =
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_admin, ROLE_manager, admin, ROLE_sale");
        //权限不能为 null，必须有值
        return new User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), authorityList);
    }
}
