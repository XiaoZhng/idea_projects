<%--
  User: Alonso
  Describe:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>记住密码</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null){
        for (Cookie cookie : cookies) {
            //如果 cookie中的键等于 username，则对应的值就是 username
            if (cookie.getName().equals("username")){
                String username = cookie.getValue();
                request.setAttribute("username", username);
            }
            //如果 cookie中的键等于 password，则对应的值就是 password
            if (cookie.getName().equals("password")){
                String password = cookie.getValue();
                request.setAttribute("password", password);
            }
        }
    }
%>
<form action="${pageContext.request.contextPath}/RememberServlet" method="post">
    用户名：<input type="text" name="username" value="${cookie.username.value}"><br>
    密码：<input type="text" name="password" value="${requestScope.password}"><br>
<%--    复选框可以不用设置 value，null就是没有选中--%>
    <input type="checkbox" name="isOk">记住用户名密码<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
