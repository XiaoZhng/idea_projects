<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fieldset class="layui-elem-field">
<legend>标签管理（双击标签名称可编辑）</legend>
<div class="layui-field-box">
<c:forEach items="${tagNameList}" var="tagName">
<blockquote class="layui-elem-quote layui-quote-nm">
	<form action="${pageContext.request.contextPath}/author/ChangeTagNameServlet.tran"
		class="layui-form" name="${tagName}" method="post">
		<input type="hidden" name="oldTagName" value="${tagName}">
		<div class="layui-form-item layui-inline">
    	<div class="layui-input-inline">
			<input type="text" class="layui-input" name="tagName" lay-verify="required" 
			value="${tagName}" readonly="true" ondblclick="this.removeAttribute('readonly')" 
			onblur="this.setAttribute('readonly', 'true')">
		</div>
		<div class="layui-input-inline">
			<button class="layui-btn layui-btn-sm layui-bg-cyan" lay-submit>
			<i class="layui-icon layui-icon-edit"></i>更新
			</button>
		</div>
		</div>
    </form>
</blockquote>
</c:forEach>
</div>
</fieldset>