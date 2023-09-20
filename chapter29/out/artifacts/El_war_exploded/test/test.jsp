<%@ page import="com.zledu.listener.student" %><%--
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
    student student = new student(001, "jack", 20);
    request.setAttribute("student", student);
%>
使用jsp表达式获取：<br>
id:<%= ((student)(request.getAttribute("student"))).getId()%>
name:<%= ((student)(request.getAttribute("student"))).getName()%>
age:<%= ((student)(request.getAttribute("student"))).getAge()%><br>
使用EL获取：<br>
id:${requestScope.student.id}
name:${requestScope.student.name}
age:${requestScope.student.age}<br>
使用[]获取属性值：<br>
name:${requestScope.student["name"]}
</body>
</html>
