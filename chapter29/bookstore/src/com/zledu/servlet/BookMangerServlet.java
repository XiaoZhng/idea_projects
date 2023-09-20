package com.zledu.servlet;

import com.zledu.bean.Book;
import com.zledu.service.BookService;
import com.zledu.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Alonso
 */
public class BookMangerServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 获取图书分页信息的请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getBookPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String pageNoStr = request.getParameter("pageNo");

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
        } catch (NumberFormatException e) {}

        //如果输入的页数小于0，则跳转到第1页
        if (pageNo < 0){
            pageNo = 1;
        }
        //如果输入的页数大于总页数，则跳转到总页数
        if (pageNo > countPage){
            pageNo = countPage;
        }

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
        //请求转发到  book_manager.jsp
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    /**
     * 获取所有图书的请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用 service处理业务逻辑
        List<Book> bookList = bookService.getBookList();
        //将图书信息在请求域 request中进行共享
        request.setAttribute("bookList", bookList);
        //请求转发到图书列表页面 book_manager.jsp
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    /**
     * 添加图书的请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String sales = request.getParameter("sales");
        String stock = request.getParameter("stock");
        Book book = new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
        //调用 service处理业务逻辑
        bookService.addBook(book);
        //使用重定向跳转到列表功能（而不是列表页面，是从servlet -> book_manager.jsp的过程）
        response.sendRedirect(request.getContextPath() + "/BookMangerServlet?method=getBookList");
    }

    /**
     * 删除图书的请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String id = request.getParameter("id");
        //调用 service处理业务逻辑
        bookService.deleteBook(id);
        //使用重定向跳转到列表功能（而不是列表页面，是从servlet -> book_manager.jsp的过程）
        response.sendRedirect(request.getContextPath() + "/BookMangerServlet?method=getBookList");
    }

    /**
     * 通过id获取修改的图书信息，并实现回显
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String id = request.getParameter("id");
        //调用 service处理业务逻辑
        Book books = bookService.getBookById(id);
        //把获取到的 Book对象放入请求域中进行共享
        request.setAttribute("books", books);
        //通过转发跳转页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    /**
     * 修改图书的请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String sales = request.getParameter("sales");
        String stock = request.getParameter("stock");
        Book book = new Book(Integer.parseInt(id), title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
        //调用 service处理业务逻辑
        bookService.updateBook(book);
//        System.out.println("111");
        //使用重定向跳转到列表功能（而不是列表页面，是从servlet -> book_manager.jsp的过程）
        response.sendRedirect(request.getContextPath() + "/BookMangerServlet?method=getBookList");

    }

    /**
     * 添加和修改功能合并
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String sales = request.getParameter("sales");
        String stock = request.getParameter("stock");
        //通过判断id是否为null来确定是添加还是修改
        if (id == null) {
            //添加
            Book book = new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
            //调用 service处理业务逻辑
            bookService.addBook(book);
        } else {
            //修改
            Book book = new Book(Integer.parseInt(id), title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
            //调用 service处理业务逻辑
            bookService.updateBook(book);
        }
        //使用重定向跳转到列表功能（而不是列表页面，是从servlet -> book_manager.jsp的过程）
        response.sendRedirect(request.getContextPath() + "/BookMangerServlet?method=getBookList");
    }
}
