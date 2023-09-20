<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <jsp:include page="/WEB-INF/include/base.jsp"></jsp:include>
    <script type="text/javascript">
        $(function () {
            // 	//获取注册按钮并给它绑定单击响应函数
            // 	$("#sub_btn").click(function(){
            // 		//获取用户名、密码、确认密码、邮箱、验证码
            // 		var userName = $("#username").val();
            // 		var password = $("#password").val();
            // 		var repwd = $("#repwd").val();
            // 		var email = $("#email").val();
            // 		var code = $("#code").val();
            // 		//使用正则表达式对用户名、密码、邮箱进行验证
            // 		var userReg = /^\w{6,15}$/;
            // 		if(!userReg.test(userName)){
            // 			alert("用户名应该为6-15位的数字字母下划线");
            // 			return false;
            // 		};
            // 		var pwdReg =/^[a-zA-Z_]\w{5,14}$/;
            // 		if(!pwdReg.test(password)){
            // 			alert("密码6-15位的数字字母下划线，不能以数字开头");
            // 			return false;
            // 		};
            // 		if(repwd != password){
            // 			alert("两次输入的密码不一致！");
            // 			return false;
            // 		}
            //
            // 		var emailReg = /^\w+@\w+\.(com|cn)$/;
            // 		if(!emailReg.test(email)){
            // 			alert("邮箱格式不正确！");
            // 			return false;
            // 		}
            // 		if(code == ""){
            // 			alert("验证码不能为空！");
            // 			return false;
            // 		}
            //
            // 	});
            $("#codeImg").click(function () {
                $(this).prop("src", "code.jpg?x=" + Math.random());
            });

            $("#sub_btn").click(function (){
                $.ajax({
                    url:"${pageContext.request.contextPath}/UserServlet?method=regist_Ajax",
                    type:"post",
                    data:{
                        username:$("[name='username']").val(),
                        password:$("[name='password']").val(),
                        email:$("[name='email']").val(),
                        code:$("[name='code']").val(),
                    },
                    dataType:"text",
                    success:function (obj){
                        if (obj == "code"){
                            $(".errorMsg").html("验证码错误");
                        }
                        if (obj == "user"){
                            $(".errorMsg").html("用户名已注册");
                        }
                        if (obj == "success"){
                            location = "${pageContext.request.contextPath}/pages/user/regist_success.jsp";
                        }
                    }
                });
            });
        });


    </script>
    <link rel="stylesheet" href="static/css/style.css">
</head>
<body>
<form action="UserServlet?method=regist" method="post">
    <div>
        <div>
            注册尚硅谷会员
            <span class="errorMsg">${requestScope.errorMsg}</span>
        </div>
        <div>
            用户名称：<input type="text" value="${param.username}" name="username" id="username" placeholder="请输入用户名"> <br>
        </div>
        <div>
            用户密码：<input type="password" name="password" id="password" placeholder="请输入密码"> <br>
        </div>
        <div>
            确认密码：<input type="password" name="repwd" id="repwd" placeholder="确认密码"> <br>
        </div>
        <div>
            电子邮箱：<input type="text" value="${param.email}" name="email" id="email"> <br>
        </div>
        <div>
            验证码：<input type="text" style="width: 130px;" name="code">
            <img id="codeImg" alt="" src="code.jpg" style="margin-right: 40px;width: 98px; height: 30px;">
        </div>
        <div>
            <input type="button" value="注册" id="sub_btn" style="width: 260px">
        </div>
    </div>
</form>
</body>
</html>