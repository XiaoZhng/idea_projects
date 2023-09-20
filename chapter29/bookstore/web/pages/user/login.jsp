<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <jsp:include page="/WEB-INF/include/base.jsp"></jsp:include>
    <script type="text/javascript">
        $(function () {
            //获取登录按钮并给它绑定单击响应函数
            $("#sub_btn").click(function () {
                //获取用户输入的用户名和密码
                var userName = $("#username").val();
                var password = $("#password").val();
                if (userName == "") {
                    alert("用户名不能为空！");
                    //取消默认行为
                    return false;
                }
                if (password == "") {
                    alert("密码不能为空！");
                    return false;
                }
            });
        });
    </script>
    <link rel="stylesheet" href="static/css/style.css">
</head>
<body>
<a href="pages/user/regist.jsp">立即注册</a> <br>
<%--<%--%>
<%--    String errorMsg = (String) request.getAttribute("errorMsg");--%>
<%--    if (errorMsg == null){--%>
<%--        errorMsg = "请输入用户名和密码";--%>
<%--    }--%>
<%--%>--%>
<div>
<%--    <span>${requestScope.errorMsg==null?"请输入用户名和密码" : requestScope.errorMsg}</span>--%>
    <span><c:out value="${requestScope.errorMsg}" default="请输入用户名和密码"></c:out></span>
</div>
<div class="form">
    <form action="UserServlet?method=login" method="post">
        <div>
            用户名称：<input type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"/><br/>
        </div>
        <div>
            用户密码：<input type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password"
                        id="password"/><br/>
        </div>
        <div>
            <input type="submit" value="登录" id="sub_btn" style="width: 260px"/>
        </div>
    </form>
</div>
</body>
</html>