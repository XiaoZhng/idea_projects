<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>个人笔记系统WeNote</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/layui/css/layui.css">
  <script src="${pageContext.request.contextPath }/resources/layui/layui.js"></script>
</head>
<body bgcolor="#FCFCFC">
<div class="layui-row layui-bg-gray">
	<jsp:include page="noteHeader.jsp"></jsp:include>
</div>
<div class="layui-container" style="padding: 10px;">
	<div class="layui-row layui-col-space10">
		<div class="layui-col-md9">
			<jsp:include page="noteMain.jsp"></jsp:include>
		</div>
		<div class="layui-col-md3 layui-bg-gray">
			<jsp:include page="noteCard.jsp"></jsp:include>
		</div>
	</div>
</div>
<hr class="layui-bg-cyan" style="height: 5px">
<div class="layui-row layui-bg-cyan" style="text-align: center;">
	<jsp:include page="noteFooter.jsp"></jsp:include>
</div>
<hr class="layui-bg-cyan" style="height: 10px">
</body>
<script>
layui.use(['util','layer'], function() {
  var layer = layui.layer;
  var flashMsgs = "";
  <c:forEach items="${flashMsgs}" var="msg">
    flashMsgs =  flashMsgs + "${msg}<br/>";
  </c:forEach>
  if(flashMsgs !== ""){
    layer.msg(flashMsgs,{time:0,closeBtn:2});
  }
  var util = layui.util;
  util.fixbar({
    bar1 : '赏',
    bar2 : '赞',
    click : function(type) {
      if (type === 'bar1') {
        layer.open({
          type: 1, 
          offset: '120px',
          title:['打赏', 'font-size:18px;'],
          content: '<img src="${pageContext.request.contextPath}/ShowUserPhotoServlet?fileName=z.jpg" width="300" />'
        });
      }
      if (type === 'bar2') {
        layer.open({
          type: 1, 
          offset: '120px',
          title: ['点赞', 'font-size:18px;'],
          content: '<img src="${pageContext.request.contextPath}/ShowUserPhotoServlet?fileName=s.jpg" width="300" />'
        });
      }
      if (type === 'top') {
        layer.msg('你咋不上天？');
      }
    }
  });
});
</script>
<c:remove var="flashMsgs"/>
</html>