<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<%--
	未登录：
	登录的表单
	游客只能查看普通武功秘籍

	登录：
	欢迎xxx
	可以查看所有武功秘籍
--%>

<%--未登录--%>
<c:if test="${empty sessionScope.user}">
    <h1 align="center">欢迎光临武林秘籍管理系统</h1>
    <h2 align="center">游客您好，如果想查看武林秘籍请登录</h2>
    <form action="TestSessionServlet" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        <input type="submit" value="登录"><spen>${requestScope.errorMsg}</spen><br>
    </form>
</c:if>

<%--已登录--%>
<c:if test="${not empty sessionScope.user}">
    <h1 align="center">欢迎${sessionScope.user.username}武林秘籍管理系统</h1>
</c:if>

<hr>
<%--登不登录都显示--%>
<h3>普通武功秘籍</h3>
<ul>
    <li><a href="level1/1.jsp">罗汉拳</a></li>
    <li><a href="level1/2.jsp">武当长拳</a></li>
    <li><a href="level1/3.jsp">全真剑法</a></li>
</ul>

<%--已登录才显示--%>
<c:if test="${not empty sessionScope.user}">
    <h3>高级武功秘籍</h3>
    <ul>
        <li><a href="level2/1.jsp">太极拳</a></li>
        <li><a href="level2/2.jsp">七伤拳</a></li>
        <li><a href="level2/3.jsp">梯云纵</a></li>
    </ul>

    <h3>绝世武功秘籍</h3>
    <ul>
        <li><a href="level3/1.jsp">葵花宝典</a></li>
        <li><a href="level3/2.jsp">龟派气功</a></li>
        <li><a href="level3/3.jsp">独孤九剑</a></li>
    </ul>
</c:if>


</body>
</html>