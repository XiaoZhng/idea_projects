package com.zledu.servlet;

import com.zledu.bean.Order;
import com.zledu.bean.OrderItem;
import com.zledu.service.OrderService;
import com.zledu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Alonso
 */
public class OrderManagerServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 查看所有订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用 service处理业务逻辑
        List<Order> list = orderService.getAllOrder();
        request.setAttribute("list", list);
        //请求转发到 /pages/manager/order_manager.jsp
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
    }

    /**
     * 查看订单详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getOrderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 orderId
        String orderId = request.getParameter("orderId");
        //调用 service处理业务逻辑
        List<OrderItem> list = orderService.getOrderDetails(orderId);
        request.setAttribute("list", list);
        //请求转发到 /pages/manager/order_details.jsp
        request.getRequestDispatcher("/pages/manager/order_details.jsp").forward(request, response);
    }

    /**
     * 发货
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 userId
        String orderId = request.getParameter("orderId");
        //调用 service处理业务逻辑
        orderService.sendOrder(orderId);
        //重定向到来源页面
        response.sendRedirect(request.getHeader("referer"));
    }
}
