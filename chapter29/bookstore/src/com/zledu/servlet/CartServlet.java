package com.zledu.servlet;

import com.zledu.bean.Book;
import com.zledu.bean.Cart;
import com.zledu.service.BookService;
import com.zledu.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Alonso
 */
public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 添加购物车中的购物项
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String bookId = request.getParameter("bookId");
        //根据 bookId 获取所对应的图书信息
        Book book = bookService.getBookById(bookId);
        //因为用户加入的购物车都是同一个，所以要在session作用域中获取 购物车对象，有两种情况
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null){
            //一、第一次访问页面，没有购物车对象，则需要添加购物车
            cart = new Cart();
        }
        //二、之前访问过页面，购物车对象存在，只是里面的购物项为空
        cart.addCartItem(book);
        //将购物车对象存储在 session中共享
        session.setAttribute("cart", cart);
        //因为要在页面显示添加到购物车的图书的 title，所以要把 book对象存储在 session中共享
        session.setAttribute("book", book);
        //重定向跳转此操作的来源页面
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * 删除购物车中的购物项
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String bookId = request.getParameter("bookId");
        //获取 session对象
        HttpSession session = request.getSession();
        //获取 session中的 购物车对象
        Cart cart = (Cart) session.getAttribute("cart");
        cart.deleteCartItem(bookId);
        //重定向跳转此操作的来源页面
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * 清空购物车中的购物项
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void clearCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 session对象
        HttpSession session = request.getSession();
        //获取 session中的 购物车对象
        Cart cart = (Cart) session.getAttribute("cart");
        cart.clearCartItem();
        //重定向跳转此操作的来源页面
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String bookId = request.getParameter("bookId");
        String count = request.getParameter("count");
        //获取 session对象
        HttpSession session = request.getSession();
        //获取 session中的 购物车对象
        Cart cart = (Cart) session.getAttribute("cart");
        cart.update(bookId, count);
        //重定向跳转此操作的来源页面
        response.sendRedirect(request.getHeader("Referer"));
    }
}
