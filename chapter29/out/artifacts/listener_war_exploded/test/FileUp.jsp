<%--
  User: Alonso
  Describe:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="${path}/UpServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="phone"> <input type="submit" value="上传">
</form>

</body>
</html>
