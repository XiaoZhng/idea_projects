<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
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
    //等号右边也要赋泛型，否则报错
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("id", 100);
    map.put("name", "tom");
    map.put("sex", 21);
    pageContext.setAttribute("map", map);
%>
使用jsp表达式获取：<br>
id:${pageScope.map.id}
name:${pageScope.map.name}
sex:${pageScope.map.sex}
</body>
</html>
