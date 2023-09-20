<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="layui-card">
	<div class="layui-card-header">
	<i class="layui-icon layui-icon-set"></i>后台管理</div>
	<div class="layui-card-body layui-btn-container">
		<a class='layui-btn layui-bg-gray' 
			href='${pageContext.request.contextPath}/author/AddNoteServlet.tran'>
		添加笔记</a>
		<a class='layui-btn layui-bg-gray' 
			href='${pageContext.request.contextPath}/author/FetchAllCategoryNameServlet.tran'>
		类别管理</a>
		<a class='layui-btn layui-bg-gray' 
		    href='${pageContext.request.contextPath}/author/FetchAllTagNameServlet.tran'>
		    标签管理</a>
		<a class='layui-btn layui-bg-gray' href=''>正在升级</a>
	</div>
</div>