package com.zledu.fwcz.domain;

/**
 * house.java[数据层](domain类)
 * 1.存储一个房屋的基本信息
 * 2.一个house对象表示一个房屋信息
 */
public class house {
    //编号 房主 电话 地址 月租 状态(未出租/已出租)
    private int id;
    private String name;
    private String phone;
    private String address;
    private int rent;
    private String state;

    //构造器，getter,setter方法
    public house(int id, String name, String phone, String address, int rent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id +
                "\t\t" + name +
                "\t" + phone +
                "\t\t" + address +
                "\t" + rent +
                "\t" + state;
    }
}