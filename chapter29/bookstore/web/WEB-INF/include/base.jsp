<%--
  Created by IntelliJ IDEA.
  User: Alonso
  Date: 2022/7/20
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="<%= request.getScheme()%>://<%= request.getServerName()%>:<%= request.getServerPort()%><%= request.getContextPath()%>/">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<%--协议：<%= request.getScheme()%>--%>
<%--ip:<%= request.getServerName()%>--%>
<%--端口：<%= request.getServerPort()%>--%>
<%--工程名：<%= request.getContextPath()%>--%>
