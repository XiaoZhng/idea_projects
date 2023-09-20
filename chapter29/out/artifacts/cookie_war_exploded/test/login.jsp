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
<c:if test="${not empty requestScope.cookie.username and not empty requestScope.cookie.password}">
    <jsp:forward page="/RememberServlet?username=${cookie.username.value}&password=${cookie.password.value}"></jsp:forward>
</c:if>
<form action="${pageContext.request.contextPath}/RememberServlet" method="post">
    用户名：<input type="text" name="username" value="${requestScope.username}"><br>
    密码：<input type="text" name="password" value="${requestScope.password}"><br>
    <!--    复选框可以不用设置 value，null就是没有选中-->
    <input type="checkbox" name="isOk">七天免登录<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
