package com.mybatis.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author Alonso
 */
@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String password;
    //额外信息
    private Information information;
    //地址
    private List<Address> address;

}

