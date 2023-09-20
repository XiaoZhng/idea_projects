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
使用jsp表达式获取请求参数：<br>
username:<%= request.getParameter("username")%>
password:<%= request.getParameter("password")%>
hobby:<%= request.getParameterValues("hobby")[0]%><br>
使用EL获取请求参数：<br>
username:${param.username}
password:${param.password}
hobby:${paramValues.hobby[1]}
</body>
</html>
