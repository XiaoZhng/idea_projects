package com.spring.bean;

/**
 * @author Alonso
 * 部门类
 */
public class dept {
    private String dname;
    public void setDname(String dname) {
        this.dname = dname;
    }
    @Override
    public String toString() {
        return "dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
