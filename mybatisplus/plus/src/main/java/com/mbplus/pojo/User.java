package com.mbplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.mbplus.enums.SexEnum;
import lombok.Data;

/**
 * @author Alonso
 */
@Data
//设置实体类所对应的表明
//@TableName("db_user")
public class User {

    //将属性所对应的字段指定为主键
    //@TableId注解的value属性用于指定主键的字段
    //@TableId注解的type属性设置主键生成策略
//    @TableId(value = "uid", type = IdType.AUTO)
    @TableId("uid")
    private Long id;

    //指定属性所对应的字段名
    @TableField("user_name")
    private String name;
    private Integer age;
    //性别
    private SexEnum sex;
    private String email;

    //逻辑删除
    @TableLogic
    private Integer isDeleted;
}
