<%--
  Created by IntelliJ IDEA.
  User: Alonso
  Date: 2022/7/19
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jsp页面</title>
  </head>
  <body>
<%--  jsp脚本片段 --%>
  <%
    String str = "hello world";
    System.out.println(str);

  %>
<%--  jsp表达式--%>
  <%= str + i%>
<%--  jsp声明--%>
  <%!
    private int i = 100;
  %>
使用静态包含包含页面:
<%@include file="static.jsp"%>
使用动态包含包含页面:
<jsp:include page="static.jsp"></jsp:include>

<%--<jsp:forward page="/static.jsp"></jsp:forward>&lt;%&ndash;类似转发&ndash;%&gt;--%>
  </body>
</html>
