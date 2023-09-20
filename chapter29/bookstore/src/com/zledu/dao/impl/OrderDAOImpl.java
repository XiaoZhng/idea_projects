package com.zledu.dao.impl;

import com.zledu.bean.Order;
import com.zledu.dao.BasicDAO;
import com.zledu.dao.OrderDAO;

import java.util.List;

/**
 * @author Alonso
 */
public class OrderDAOImpl extends BasicDAO<Order> implements OrderDAO {
    @Override
    public void saveOrder(Order order) {
        String sql = "insert into `order` values(?, ?, ?, ?, ?, ?)";
        update(sql, order.getId(), order.getTotalCount(), order.getTotalAmount(), order.getStatus(), order.getCreateTime(), order.getUserId());
    }

    @Override
    public List<Order> getMyOrder(Integer userId) {
        String sql = "select * from `order` where userId = ?";
        return QueryMultiply(sql, Order.class, userId);
    }

    @Override
    public List<Order> getAllOrder() {
        String sql = "select * from `order`";
        return QueryMultiply(sql, Order.class);
    }

    @Override
    public void updateStatus(String orderId, Integer status) {
        String sql = "update `order` set status = ? where id = ?";
        update(sql, status, orderId);
    }
}
