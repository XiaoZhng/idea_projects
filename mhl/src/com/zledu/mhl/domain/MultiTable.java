package com.zledu.mhl.domain;

import java.util.Date;

/**
 * @author Alonso
 * 这是javabean 与 MultiTable对应，是对表查询
 */
public class MultiTable {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer num;
    private Integer price;
    private Integer diningTableId;
    private Date billDate;
    private String payState;
    //增加 menu表中的name
    private String name;//属性名和表中的列名不一致，则为 null
    //增加 menu表中的price
    //多表查询，表与表之间的列名尽量不要重复
    //private double price;
    //属性名可以和表中的列名不一致。但是需要sql语句做出相应的修改，规范需要保持一致

    public MultiTable() {
        System.out.println("反射调用...");
    }

//    public MultiTable(Integer id, String billId, Integer menuId, Integer num, Integer price, Integer diningTableId, Date billDate, String payState, String name) {
//        this.id = id;
//        this.billId = billId;
//        this.menuId = menuId;
//        this.num = num;
//        this.price = price;
//        this.diningTableId = diningTableId;
//        this.billDate = billDate;
//        this.payState = payState;
//        this.name = name;
//    }

    //给name 生成 getter 和 setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    @Override
    public String toString() {
        return id +
                "\t\t" + menuId +
                "\t\t\t" + num +
                "\t\t\t" + price +
                "\t\t\t" + diningTableId +
                "\t\t\t" + billDate +
                "\t\t" + payState +
                "\t\t\t" + name;
    }
}
