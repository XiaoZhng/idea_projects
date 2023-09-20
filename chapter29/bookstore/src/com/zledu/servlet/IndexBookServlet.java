package com.zledu.servlet;

import com.zledu.bean.Book;
import com.zledu.service.BookService;
import com.zledu.service.impl.BookServiceImpl;
import com.zledu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Alonso
 */
public class IndexBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void getBookByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String pageNoStr = request.getParameter("pageNo");//当前页
        String minStr = request.getParameter("min");
        String maxStr = request.getParameter("max");

        Integer min = 1;
        Integer max = Integer.MAX_VALUE;

        try {
            min = Integer.parseInt(minStr);
        } catch (NumberFormatException e) {
        }

        try {
            max = Integer.parseInt(maxStr);
        } catch (NumberFormatException e) {
        }

        Integer pageSize = 4;//每页的条数

        //调用 service获取到图书总计数
        Integer count = bookService.getBookCountByPrice(min, max);
        //如果总计数和每页显示的条数取余等于0
        Integer countPage = 0;//总页数
        if (count % pageSize == 0) {
            countPage = count / pageSize;
        } else {
            countPage = (count / pageSize) + 1;
        }

        Integer pageNo = 1;//当前页
        try {
            pageNo = Integer.parseInt(pageNoStr);
        } catch (NumberFormatException e) {
        }

        //如果输入的页数小于0，则跳转到第1页
        if (pageNo < 0) {
            pageNo = 1;
        }
        //如果输入的页数大于总页数，则跳转到总页数
        if (pageNo > countPage) {
            pageNo = countPage;
        }

        //动态获取当前的路径
        String path = WebUtils.getPath(request);

        //调用 service处理业务逻辑
        List<Book> bookList = bookService.getBookByPrice(min, max, pageNo, pageSize);
        //将数据存储在请求域 request中
        request.setAttribute("bookList", bookList);
        //把当前页数 pageNo存储在request请求域中
        request.setAttribute("pageNo", pageNo);
        //把总页数存储在请求域中
        request.setAttribute("countPage", countPage);
        //把总计数存储在请求域中
        request.setAttribute("count", count);
        //把动态获取当前的路径存储在请求域中
        request.setAttribute("path", path);
        //请求转发到  client.jsp
        request.getRequestDispatcher("/pages/client/client.jsp").forward(request, response);
    }

    protected void getBookPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String pageNoStr = request.getParameter("pageNo");//当前页

        Integer pageSize = 4;//每页的条数

        //调用 service获取到图书总计数
        Integer count = bookService.getCount();
        //如果总计数和每页显示的条数取余等于0
        Integer countPage = 0;//总页数
        if (count % pageSize == 0) {
            countPage = count / pageSize;
        } else {
            countPage = (count / pageSize) + 1;
        }
        Integer pageNo = 1;//当前页
        try {
            pageNo = Integer.parseInt(pageNoStr);
        } catch (NumberFormatException e) {
        }

        //如果输入的页数小于0，则跳转到第1页
        if (pageNo < 0) {
            pageNo = 1;
        }
        //如果输入的页数大于总页数，则跳转到总页数
        if (pageNo > countPage) {
            pageNo = countPage;
        }

        //动态获取当前的路径
        String path = WebUtils.getPath(request);

        //调用 service处理业务逻辑
        List<Book> bookList = bookService.getBookPage(pageNo, pageSize);
        //将数据存储在请求域 request中
        request.setAttribute("bookList", bookList);
        //把当前页数 pageNo存储在request请求域中
        request.setAttribute("pageNo", pageNo);
        //把总页数存储在请求域中
        request.setAttribute("countPage", countPage);
        //把总计数存储在请求域中
        request.setAttribute("count", count);
        //把动态获取当前的路径存储在请求域中
        request.setAttribute("path", path);
        //请求转发到  client.jsp
        request.getRequestDispatcher("/pages/client/client.jsp").forward(request, response);
    }
}
