package com.zledu.dao;

import com.zledu.bean.OrderItem;

import java.util.List;

/**
 * @author Alonso
 */
public interface OrderItemDAO {

    /**
     * 保存订单项
     */
    void saveOrderItem(OrderItem orderItem);

    /**
     * 查看订单详情
     */
    List<OrderItem> getOrderDetails(String orderId);
}
