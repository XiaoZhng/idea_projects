package com.security.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //有参构造
@NoArgsConstructor //无参构造
@TableName("users")
public class Users {
    @TableId
    private Integer id;
    private String username;
    private String password;
}
