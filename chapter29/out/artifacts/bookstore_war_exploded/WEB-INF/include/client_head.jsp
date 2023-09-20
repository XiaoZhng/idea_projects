<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: Alonso
  Describe:客户端的头部信息动态包含包含页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${empty sessionScope.user}">
    <%--未登录--%>
    <div>
        <a href="pages/user/login.jsp">登录</a> |
        <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</c:if>
<c:if test="${not empty sessionScope.user}">
    <%--已登录--%>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="OrderClientServlet?method=getMyOrder">我的订单</a>
        <a href="UserServlet?method=loginOut">注销</a>&nbsp;&nbsp;
        <a href="">返回</a>
    </div>
</c:if>

<%--<%--%>
<%--    User user = (User) session.getAttribute("user");--%>
<%--    if (user != null){--%>
<%--%>--%>
<%--&lt;%&ndash;已登录&ndash;%&gt;--%>
<%--<div>--%>
<%--    <span>欢迎<span class="um_span"><%= user.getUsername()%></span>光临尚硅谷书城</span>--%>
<%--    <a href="pages/order/order.jsp">我的订单</a>--%>
<%--    <a href="">注销</a>&nbsp;&nbsp;--%>
<%--    <a href="">返回</a>--%>
<%--</div>--%>
<%--<%--%>
<%--    }else {--%>
<%--%>--%>
<%--&lt;%&ndash;未登录&ndash;%&gt;--%>
<%--<div>--%>
<%--    <a href="pages/user/login.jsp">登录</a> |--%>
<%--    <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;--%>
<%--    <a href="pages/cart/cart.jsp">购物车</a>--%>
<%--    <a href="pages/manager/manager.jsp">后台管理</a>--%>
<%--</div>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>


