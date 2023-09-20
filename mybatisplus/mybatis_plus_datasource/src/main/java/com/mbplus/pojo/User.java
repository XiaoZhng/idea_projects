package com.mbplus.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Alonso
 */
@Data
@TableName("db_user")
public class User {
    @TableId
    private Long uid;
    private String userName;
    private Integer age;
    private Integer sex;
    private String email;
    private Integer isDeleted;
}
