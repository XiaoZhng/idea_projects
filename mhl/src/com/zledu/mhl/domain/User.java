package com.zledu.mhl.domain;

/**
 * @author Alonso
 * 扩展功能，增加用户管理，显示餐厅的成员和职位
 */
public class User {
    private Integer id;
    private String name;
    private String job;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return id +"\t\t\t" + name + "\t\t" + job;
    }
}
