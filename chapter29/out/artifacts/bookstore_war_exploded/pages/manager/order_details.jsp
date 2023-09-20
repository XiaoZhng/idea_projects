<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情</title>
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
			<span class="wel_word">订单详情</span>
		<jsp:include page="/WEB-INF/include/manager_head.jsp"></jsp:include>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>图片</td>
				<td>名称</td>
				<td>作者</td>
				<td>数量</td>
				<td>价格</td>
			</tr>
			<c:forEach items="${requestScope.list}" var="order">
				<tr>
					<td>
						<img src="${pageScope.order.imgPath}" style="width: 100px;height: 100px;">
					</td>
					<td>${pageScope.order.title}</td>
					<td>${pageScope.order.author}</td>
					<td>${pageScope.order.count}</td>
					<td>${pageScope.order.amount}</td>
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