<%--
  User: Alonso
  Describe:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试$.post()</title>
    <script type="text/javascript" src="${path}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                <%--$.post(--%>
                <%--    "${path}/TestAjaxServlet",//请求地址--%>
                <%--    {username:$("[name='username']").val(), password: $("[name='password']").val()},//请求参数--%>
                <%--    function (obj) {--%>
                <%--        alert(obj)--%>
                <%--    },//请求成功要执行的回调函数--%>
                <%--    "text"//预期服务器返回的结果类型--%>
                <%--);--%>
                $.get(
                    "${path}/TestAjaxServlet",//请求地址
                    {username:$("[name='username']").val(), password: $("[name='password']").val()},//请求参数
                    function (obj) {
                        alert(obj)
                    },//请求成功要执行的回调函数
                    "text"//预期服务器返回的结果类型
                );
            });
        });
    </script>
</head>
<body>
用户名:<input type="text" name="username"><br>
密码:<input type="text" name="password"><br>
<input type="button" value="提交" id="btn">
</body>
</html>
