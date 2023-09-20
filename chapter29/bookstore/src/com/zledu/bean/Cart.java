package com.zledu.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Alonso
 * 表示 购物车的类
 */
public class Cart implements Serializable {
    //表示购物车中所有的购物项，以购物项中图书的id为键，以购物项为值
    private Map<String, CartItem> map = new HashMap<>();
    //购物车中所有图书的总数量
    private Integer totalCount;
    //购物车中所有图书的总价格
    private Double totalAmount;

    public Map<String, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }

    public Integer getTotalCount() {
        //需要设置 初始化值
        totalCount = 0;
        //总数量 = 购物项数量相加
        for (CartItem cartItem : getCartItemList()) {
            totalCount += cartItem.getCount();
        }
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalAmount() {
        //通过 BigDecimal 来解决浮点数的失去精度问题
        BigDecimal bigDecimal1 = new BigDecimal("0.0");
        for (CartItem cartItem : getCartItemList()) {
            BigDecimal bigDecimal2 = new BigDecimal(cartItem.getAmount() + "");
            bigDecimal1 = bigDecimal1.add(bigDecimal2);
        }
        return bigDecimal1.doubleValue();
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    //获取所有购物项
    public List<CartItem> getCartItemList(){
        //map.values() 的类型是Collection接口类
        //可以用一个List的实现类来接收 Collection类型
        return new ArrayList<>(map.values());
    }

    //添加购物车
    public void addCartItem(Book book){
        //两种情况
        //一、购物车中没有要添加的图书
        //根据图书的id获取到map集合中对应的图书项信息
        CartItem cartItem = map.get(book.getId() + "");
        if (cartItem == null){
            cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setCount(1);//添加一本
            //因为图书项中的价格是通过 图书价格 * 数量，所以不用赋值
            //把赋值完的图书项信息存入 map集合
            map.put(book.getId() + "", cartItem);
        }else {
            //二、购物车中有要添加的图书，只需要在原有的图书数量上 +1
            cartItem.setCount(cartItem.getCount() + 1);
        }
    }

    //删除购物项
    public void deleteCartItem(String bookId){
        //根据图书id 删除对应的购物项
        map.remove(bookId);
    }

    //清空购物车
    public void clearCartItem(){
        map.clear();
    }

    //更新购物项的数量
    public void update(String bookId, String countStr){

        try {
            //把用户在输入框中输入的 countStr试着转换成数字
            int count = Integer.parseInt(countStr);
            //如果转换不成功，就不作处理
            //转换成功就判断
            // 大于0：修改购物项数量
            // 等于0：就删除所对应的图书
            if (count > 0){
                map.get(bookId).setCount(count);
            }
            if (count == 0){
                map.remove(bookId);
            }
        } catch (NumberFormatException e) {}
    }
}
