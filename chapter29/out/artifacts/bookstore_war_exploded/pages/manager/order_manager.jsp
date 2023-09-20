<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <jsp:include page="/WEB-INF/include/base.jsp"></jsp:include>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">订单管理系统</span>
    <jsp:include page="/WEB-INF/include/manager_head.jsp"></jsp:include>
</div>

<div id="main">
    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>详情</td>
            <td>发货</td>

        </tr>
        <c:forEach items="${requestScope.list}" var="order">
            <tr>
                <td>${pageScope.order.createTime}</td>
                <td>${pageScope.order.totalAmount}</td>
                <td><a href="OrderManagerServlet?method=getOrderDetails&orderId=${pageScope.order.id}">查看详情</a></td>
                <td>
                    <c:if test="${pageScope.order.status == 0}">
                        <a href="OrderManagerServlet?method=sendOrder&orderId=${pageScope.order.id}">点击发货</a>
                    </c:if>
                <c:if test="${pageScope.order.status == 1}">等待收货</c:if>
                <c:if test="${pageScope.order.status == 2}">交易完成</c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
</div>
</body>
</html>