<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: Alonso
  Describe:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("username", null);
%>
<c:if test="${empty pageScope.username}" var="flag">
    未登录
</c:if>
<c:if test="${empty pageScope.flag}">
    已登录
</c:if>
</body>
</html>
