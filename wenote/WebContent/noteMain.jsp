<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="layui-col-md9">
<c:choose>
<c:when test="${empty param.url}"><jsp:include page="/aboutWeNote.jsp"></jsp:include></c:when>
<c:otherwise><jsp:include page="${param.url}"></jsp:include></c:otherwise>
</c:choose>
</div>