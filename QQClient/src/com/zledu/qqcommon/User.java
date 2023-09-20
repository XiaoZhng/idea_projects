package com.zledu.qqcommon;

import java.io.Serializable;

/**
 * @author Alonso
 * 表示一个用户/客户信息
 */
public class User implements Serializable {//因为要作为对象流传递，所以要序列化

    private static final long serialVersionUID = 1L;//增强兼容性

    private String userId;//用户id/用户名
    private String passwd;//密码

    public User() {
    }

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
