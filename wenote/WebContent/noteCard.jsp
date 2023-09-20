<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="layui-card">
	<c:choose>
		<c:when test="${empty sessionScope.user }">
			<jsp:include page="login.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="/user/profile.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
</div>
<c:if test="${sessionScope.user.isAuthor=='Y'}">
	<jsp:include page="/author/author.jsp"></jsp:include>
</c:if>
<div class="layui-card">
	<div class="layui-card-header"><i class="layui-icon layui-icon-table"></i>笔记类别</div>
	<div class="layui-card-body layui-btn-container">
		<c:forEach items='${categoryNameMap}' var='category'>
		<a class='layui-btn layui-bg-gray' 
		href="${pageContext.request.contextPath}/FetchAllNoteByCategoryNameServlet.tran?categoryName=${category.key}">
			${category.key}
			<span class="layui-badge">${category.value}</span>
		</a>
		</c:forEach>
	</div>
</div>
<div class="layui-card">
	<div class="layui-card-header"><i class="layui-icon layui-icon-note"></i>笔记标签</div>
	<div class="layui-card-body layui-btn-container">
		<c:forEach items='${tagNameMap}' var='tag'>
		<a class='layui-btn layui-bg-gray'
			href="${pageContext.request.contextPath}/FetchAllNoteByTagNameServlet.tran?tagName=${tag.key}">
			${tag.key}
			<span class="layui-badge">${tag.value}</span>
		</a>
		</c:forEach>
	</div>
</div>
<div class="layui-card">
	<div class="layui-card-header"><i class="layui-icon layui-icon-link"></i>资源分享</div>
	<div class="layui-card-body layui-btn-container">
		<a class='layui-btn layui-bg-gray' href=''>资源分享1</a>
		<a class='layui-btn layui-bg-gray' href=''>资源分享2</a>
	</div>
</div>