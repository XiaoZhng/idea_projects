<%--
  User: Alonso
  Describe:管理端头部信息动态包含包含页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <%--    要修改图书管理的路径，先跳转到servlet发送请求，book_manager.jsp才有数据--%>
    <a href="BookMangerServlet?method=getBookPage">图书管理</a>
    <a href="OrderManagerServlet?method=getAllOrder">订单管理</a>
    <a href="">返回商城</a>
</div>