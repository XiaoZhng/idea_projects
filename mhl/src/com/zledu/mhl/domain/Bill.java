package com.zledu.mhl.domain;

import java.util.Date;

/**
 * @author Alonso
 * 这是 javabean 与 bill对应
 *  id INT PRIMARY KEY auto_increment,
 * 	billId VARCHAR(50) NOT NULL DEFAULT '',
 * 	menuId INT NOT NULL,
 * 	num INT NOT NULL DEFAULT 0,
 * 	price INT NOT NULL DEFAULT 0,
 * 	diningTableId INT NOT NULL DEFAULT 0,
 * 	billDate Datetime NOT null,
 * 	payState VARCHAR(32) NOT NULL DEFAULT ''
 */
public class Bill {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer num;
    private Integer price;
    private Integer diningTableId;
    private Date billDate;
    private String payState;

    public Bill() {
    }

    public Bill(Integer id, String billId, Integer menuId, Integer num, Integer price, Integer diningTableId, Date billDate, String payState) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.num = num;
        this.price = price;
        this.diningTableId = diningTableId;
        this.billDate = billDate;
        this.payState = payState;
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
                "\t\t" + payState;
    }
}
