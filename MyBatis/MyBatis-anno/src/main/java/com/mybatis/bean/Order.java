package com.mybatis.bean;

/**
 * @author Alonso
 */
public class Order {
    private Integer oId;
    private String orderName;
    private User user;

    public Order() {
    }

    public Order(Integer oId, String orderName) {
        this.oId = oId;
        this.orderName = orderName;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oId=" + oId +
                ", orderName='" + orderName + '\'' +
                ", user=" + user +
                '}';
    }
}
