<%@ page import="com.zledu.listener.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
<%--第一种用法：自定义循环的条件--%>
<%--<c:forEach begin="0" end="5" step="1" var="i">--%>
<%--    ${pageScope.i}--%>
<%--</c:forEach>--%>
<%--${pageScope.i}--%>

<%--第二种用法：循环一个数组或集合--%>
<%
    List<Book> list = new ArrayList<Book>();
    list.add(new Book(1, "三体1", 30.1));
    list.add(new Book(2, "三体2", 30.2));
    list.add(new Book(3, "三体3", 30.3));
    pageContext.setAttribute("list", list);
%>
<c:forEach items="${pageScope.list}" var="book">
    id:${pageScope.book.id} name:${pageScope.book.name} price:${pageScope.book.price}<br>
</c:forEach>

<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
    </tr>
    <c:forEach items="${pageScope.list}" var="book" varStatus="status">
        <tr>
            <td>${pageScope.status.count}</td>
            <td>${pageScope.book.name}</td>
            <td>${pageScope.book.price}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
