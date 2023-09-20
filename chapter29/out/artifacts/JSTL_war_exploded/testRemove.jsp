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
    request.setAttribute("test", "测试request");
    session.setAttribute("test1", "测试session");
%>
<c:remove var="test"></c:remove>
${requestScope.test}
${sessionScope.test1}
</body>
</html>
