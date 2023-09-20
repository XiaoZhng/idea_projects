<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改图书</title>
    <jsp:include page="/WEB-INF/include/base.jsp"></jsp:include>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">修改图书</span>
    <jsp:include page="/WEB-INF/include/manager_head.jsp"></jsp:include>
</div>

<div id="main">
    <form action="BookMangerServlet?method=updateBook" method="post">
        <input type="hidden" name="id" value="${requestScope.books.id}">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="title" type="text" value="${requestScope.books.title}"/></td>
                <td><input name="price" type="text" value="${requestScope.books.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.books.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.books.sales}"/></td>
                <td><input name="stock" type="text" value="${requestScope.books.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
</div>
</body>
</html>