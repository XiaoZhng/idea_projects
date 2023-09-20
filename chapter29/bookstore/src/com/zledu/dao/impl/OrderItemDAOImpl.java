package com.zledu.dao.impl;

import com.zledu.bean.OrderItem;
import com.zledu.dao.BasicDAO;
import com.zledu.dao.OrderItemDAO;

import java.util.List;

/**
 * @author Alonso
 */
public class OrderItemDAOImpl extends BasicDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void saveOrderItem(OrderItem orderItem) {
        String sql = "insert into orderItems values(null, ?, ?, ?, ?, ?, ?, ?)";
        update(sql, orderItem.getTitle(), orderItem.getAuthor(), orderItem.getPrice(), orderItem.getImgPath(), orderItem.getCount(), orderItem.getAmount(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> getOrderDetails(String orderId) {
        String sql = "select * from orderItem where orderId = ?";
        return QueryMultiply(sql, OrderItem.class, orderId);
    }
}
