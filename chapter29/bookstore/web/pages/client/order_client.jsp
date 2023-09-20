<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<jsp:include page="/WEB-INF/include/base.jsp"></jsp:include>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
			<jsp:include page="/WEB-INF/include/client_head.jsp"></jsp:include>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:forEach items="${requestScope.list}" var="order">
				<tr>
					<td style="width: 300px">${pageScope.order.createTime}</td>
					<td>${pageScope.order.totalAmount}</td>
					<td>
						<c:if test="${pageScope.order.status == 0}">未发货</c:if>
						<c:if test="${pageScope.order.status == 1}">
							<a href="OrderClientServlet?method=takeOrder&orderId=${pageScope.order.id}">点击收货</a>
						</c:if>
						<c:if test="${pageScope.order.status == 2}">交易完成</c:if>
					</td>
					<td><a href="OrderClientServlet?method=getOrderDetails&orderId=${pageScope.order.id}">查看详情</a></td>
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