<%--
  User: Alonso
  Describe:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  jsp表达式--%>
  <a href="<%= request.getContextPath()%>/test/test.jsp">test.jsp</a><br>
<%--  el表达式--%>
<a href="${pageContext.request.contextPath}/test/test.jsp">test.jsp</a>
  </body>
</html>
