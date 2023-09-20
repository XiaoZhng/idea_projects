<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="layui-card-header">
	<i class='layui-icon layui-icon-friends'></i>登录
</div>
<div class="layui-card-body">
<form class="layui-form" method="post" action="${pageContext.request.contextPath}/LoginServlet.tran">
	<input name="userName" lay-verify="required" placeholder="用户名" class="layui-input" 
		value='${cookie.userName.value}'/>
	<input type="password" name="password" lay-verify="required" placeholder="密码" class="layui-input" 
		value='${cookie.password.value}'/>
	<div class="layui-form-item">
		<input type="checkbox" name="autoLogin" lay-skin="switch" lay-text="记住我|忘掉我" checked>
	</div>
	<button lay-submit class="layui-btn layui-btn-radius layui-btn-sm layui-bg-cyan">
		<i class='layui-icon layui-icon-auz'>登录</i>
	</button>
	<button type="reset" class="layui-btn layui-btn-radius layui-btn-sm layui-bg-cyan">
		<i class='layui-icon layui-icon-fonts-clear'>重置</i>
	</button>
</form>
</div>
<script>
layui.use('form', function() {});
</script>