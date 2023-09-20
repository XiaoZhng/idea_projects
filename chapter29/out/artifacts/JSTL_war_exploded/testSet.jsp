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
<c:set var="set" value="测试set"></c:set>
${pageScope.set}<br>
<c:set var="testset" value="测试testset" scope="request"></c:set>
${requestScope.testset}
</body>
</html>
