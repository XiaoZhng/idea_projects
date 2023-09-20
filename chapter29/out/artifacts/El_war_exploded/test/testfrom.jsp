<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  User: Alonso
  Describe:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test/testparam.jsp" method="post">
    username:<input type="text" name="username">
    password:<input type="text" name="password">
    <input type="submit">
    <input type="checkbox" name="hobby" value="a">a
    <input type="checkbox" name="hobby" value="b">b
    <input type="checkbox" name="hobby" value="c">c

    <br>===========================================<br>
    <%
        List list = new ArrayList();
        request.setAttribute("list", list);

    %>
    ${empty 1}
    ${empty null}
    ${empty requestScope.list}
</form>
</body>
</html>
