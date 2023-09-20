package com.zledu.service;

import com.zledu.bean.Cart;
import com.zledu.bean.Order;
import com.zledu.bean.OrderItem;
import com.zledu.bean.User;

import java.util.List;

/**
 * @author Alonso
 */
public interface OrderService {

    /**
     * 结账
     */
    String checkOut(Cart cart, User user);

    /**
     * 查看我的订单
     */
    List<Order> getMyOrder(Integer userId);

    /**
     * 查看订单详情
     */
    List<OrderItem> getOrderDetails(String orderId);

    /**
     * 查看所有订单
     */
    List<Order> getAllOrder();

    /**
     * 收货
     */
    void takeOrder(String orderId);

    /**
     * 发货
     */
    void sendOrder(String orderId);
}
