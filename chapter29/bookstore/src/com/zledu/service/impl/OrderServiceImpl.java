package com.zledu.service.impl;

import com.zledu.bean.*;
import com.zledu.dao.BookDAO;
import com.zledu.dao.OrderDAO;
import com.zledu.dao.OrderItemDAO;
import com.zledu.dao.impl.BookDAOImpl;
import com.zledu.dao.impl.OrderDAOImpl;
import com.zledu.dao.impl.OrderItemDAOImpl;
import com.zledu.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Alonso
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public String checkOut(Cart cart, User user) {
        /**
         * 结账功能：
         * 1.保存订单
         * 2.保存订单项
         * 3.更改图书的销量和库存
         */
        //1.保存订单
        //将当前时间的时间戳作为订单id
        String orderId = System.currentTimeMillis() + "";
        //获取创建时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createDate = simpleDateFormat.format(date);
        //创建 Order对象
        Order order = new Order(orderId, cart.getTotalCount(), cart.getTotalAmount(), 1, createDate, user.getId());
        orderDAO.saveOrder(order);
        //获取购物车中的购物项
        List<CartItem> cartItemList = cart.getCartItemList();
        //将购物项进行循环，把其中每一个购物项转换为每一个订单项
        for (CartItem cartItem : cartItemList) {
            //将购物项转换为订单项
            //从购物项中获取到图书的信息
            Book book = cartItem.getBook();
            OrderItem orderItem = new OrderItem(null, book.getTitle(), book.getAuthor(), book.getPrice(), book.getImgPath(), cartItem.getCount(), cartItem.getAmount(), orderId);
            //2.保存订单项
            orderItemDAO.saveOrderItem(orderItem);
            //3.更改图书的销量和库存
            bookDAO.updateBookSalesAndStock(book.getId(), cartItem.getCount());
        }

        return orderId;
    }

    @Override
    public List<Order> getMyOrder(Integer userId) {
        return orderDAO.getMyOrder(userId);
    }

    @Override
    public List<OrderItem> getOrderDetails(String orderId) {
        return orderItemDAO.getOrderDetails(orderId);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDAO.getAllOrder();
    }

    @Override
    public void takeOrder(String orderId) {
        orderDAO.updateStatus(orderId, 2);
    }

    @Override
    public void sendOrder(String orderId) {
        orderDAO.updateStatus(orderId, 1);
    }
}
