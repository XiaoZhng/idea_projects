package com.mybatis.bean;

import java.io.Serializable;

/**
 * @author Alonso
 */
public class emp implements Serializable {
    private Integer eid;
    private String empName;
    private Integer age;
    private Character sex;
    private String email;
    private dept dept;

    public emp() {
    }

    public emp(Integer eid, String empName, Integer age, Character sex, String email) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public com.mybatis.bean.dept getDept() {
        return dept;
    }

    public void setDept(com.mybatis.bean.dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "emp{" +
                "eid=" + eid +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                '}';
    }
}
