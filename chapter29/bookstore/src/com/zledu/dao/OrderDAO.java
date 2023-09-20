package com.zledu.dao;

import com.zledu.bean.Order;

import java.util.List;

/**
 * @author Alonso
 */
public interface OrderDAO {

    /**
     *保存订单
     */
    void saveOrder(Order order);

    /**
     * 查看我的订单
     */
    List<Order> getMyOrder(Integer userId);

    /**
     * 查看所有订单
     */
    List<Order> getAllOrder();

    /**
     * 收货，发货
     */
    void updateStatus(String orderId, Integer status);
}
