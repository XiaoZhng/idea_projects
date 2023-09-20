<%--
  User: Alonso
  Describe:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试json</title>
    <script type="text/javascript" src="${path}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn").click(function (){
                $.ajax({
                    url:"${path}/TestJsonServlet",//请求地址
                    type:"post",//请求方式
                    dateType:"json",//预期服务器返回的结果类型
                    success:function (obj){
                        //当请求成功，服务器响应到浏览器的数据就会自动赋值给obj因此obj代表的是服务器响应到浏览器的结果
                        alert(obj);
                    }//请求成功要执行的回调函数
                });
            });
        });
    </script>
</head>
<body>
用户名：<input type="text" name="username"><br>
密码：<input type="text" name="password"><br>
<input type="button" value="提交" id="btn">
</body>
</html>
