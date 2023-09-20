package com.zledu.servlet;

import com.zledu.bean.Cart;
import com.zledu.bean.Order;
import com.zledu.bean.OrderItem;
import com.zledu.bean.User;
import com.zledu.service.OrderService;
import com.zledu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Alonso
 */
public class OrderClientServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 结账
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 session对象
        HttpSession session = request.getSession();
        //获取 session对象中的 cart对象和 user对象
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        String orderId = orderService.checkOut(cart, user);
        //将 orderId存储在域对象中进行共享
        session.setAttribute("orderId", orderId);
        //重定向跳转到结账成功页面
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }

    /**
     * 查看我的订单
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getMyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //因为可以从 session中获取到 user，就可以知道用户信息，所以不用传参数
        //获取 session对象
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //调用 service处理业务逻辑
        List<Order> list = orderService.getMyOrder(user.getId());
        request.setAttribute("list", list);
        request.getRequestDispatcher("/pages/client/order_client.jsp").forward(request, response);
    }

    /**
     * 查看订单详情
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getOrderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 userId
        String orderId = request.getParameter("orderId");
        //调用 service处理业务逻辑
        List<OrderItem> list = orderService.getOrderDetails(orderId);
        //放入请求域中
        request.setAttribute("list", list);
        //请求转发跳转到订单详情页面
        request.getRequestDispatcher("/pages/client/order_details.jsp").forward(request, response);
    }

    /**
     * 收货
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void takeOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 orderId
        String orderId = request.getParameter("orderId");
        //调用 service处理业务逻辑
        orderService.takeOrder(orderId);
        //重定向到来源页面
        response.sendRedirect(request.getHeader("referer"));
    }
}
