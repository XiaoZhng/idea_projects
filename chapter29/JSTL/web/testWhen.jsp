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
    Integer score = 90;
    pageContext.setAttribute("score", score);
%>
<c:choose>
    <c:when test="${pageScope.score >= 90 && pageScope.score < 100}">
        优秀
    </c:when>
    <c:when test="${pageScope.score > 60 && pageScope.score < 90}">
        及格
    </c:when>
    <c:when test="${pageScope.score > 0 && pageScope.score < 60}">
        不及格
    </c:when>
    <c:otherwise>
        成绩有误
    </c:otherwise>
</c:choose>
</body>
</html>
