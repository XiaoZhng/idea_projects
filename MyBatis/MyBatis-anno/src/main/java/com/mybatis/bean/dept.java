package com.mybatis.bean;

import java.util.List;

/**
 * @author Alonso
 */
public class dept {
    private Integer did;
    private String deptName;
    private List<emp> emps;

    public dept() {
    }

    public dept(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public List<emp> getEmps() {
        return emps;
    }

    public void setEmps(List<emp> emps) {
        this.emps = emps;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
