package com.zledu.bean;


import java.io.Serializable;

/**
 * @author Alonso
 * 表示 订单的类
 */
public class Order implements Serializable {
    private String id;
    private Integer totalCount;
    private Double totalAmount;
    private Integer status;
    private String createTime;
    private Integer userId;

    public Order() {
    }

    public Order(String id, Integer totalCount, Double totalAmount, Integer status, String createTime, Integer userId) {
        this.id = id;
        this.totalCount = totalCount;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createTime = createTime;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
