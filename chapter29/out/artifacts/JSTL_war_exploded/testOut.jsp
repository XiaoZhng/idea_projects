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
    String test = "abc";
    request.setAttribute("test", test);
%>
<c:out value="${requestScope.test}"></c:out>
<c:out value="${requestScope.test}" default="<h1>200</h1>" escapeXml="falst"></c:out>
</body>
</html>
