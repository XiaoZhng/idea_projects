package com.pharmacy.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户表
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField("user_password")
    private String userPassword;

    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;

    /**
     * 所属部门
     */
    private String dept;

    /**
     * 是否启用
     */
    //添加逻辑删除 0 - 启用 1 - 不启用
    @TableLogic
    private String enable;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}