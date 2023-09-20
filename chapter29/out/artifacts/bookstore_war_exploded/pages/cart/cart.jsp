<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <jsp:include page="/WEB-INF/include/base.jsp"></jsp:include>
    <script type="text/javascript">
        $(function (){
            $(".countInput").change(function (){
                var count = $(this).val();
                var bookId = $(this).attr("bookId")
                location = "CartServlet?method=updateCount&bookId=" + bookId + "&count=" + count;
            });
            $(".plusCount").click(function (){
                var count = parseInt($(this).next().val()) + 1;
                var bookId = $(this).next().attr("bookId");
                location = "CartServlet?method=updateCount&bookId=" + bookId + "&count=" + count;
            });
            $(".minusCount").click(function (){
                var count = parseInt($(this).prev().val()) - 1;
                var bookId = $(this).prev().attr("bookId");
                location = "CartServlet?method=updateCount&bookId=" + bookId + "&count=" + count;
            });
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <jsp:include page="/WEB-INF/include/client_head.jsp"></jsp:include>
</div>

<c:if test="${empty sessionScope.cart.map}">
    <div id="main">
        <br><br><br><br><br><br><br><br>
        <center>
            购物车空空如也 <a href="">去购物</a>
        </center>

    </div>
</c:if>
<c:if test="${not empty sessionScope.cart.map}">
    <div id="main">

        <table>
            <tr>
                <td>商品名称</td>
                <td>数量</td>
                <td>单价</td>
                <td>金额</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${sessionScope.cart.cartItemList}" var="cartItem">
                <tr>
                    <td>${pageScope.cartItem.book.title}</td>
                    <td>
                        <input type="button" value="+" class="plusCount">
                        <input type="text" value="${pageScope.cartItem.count}" class="countInput" bookId="${pageScope.cartItem.book.id}" style="width: 30px; text-align: center">
                        <input type="button" value="-" class="minusCount">
                    </td>
                    <td>${pageScope.cartItem.book.price}</td>
                    <td>${pageScope.cartItem.amount}</td>
                    <td><a href="CartServlet?method=deleteCartItem&bookId=${pageScope.cartItem.book.id}">删除</a></td>
                </tr>
            </c:forEach>


        </table>

        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalAmount}</span>元</span>
            <span class="cart_span"><a href="">继续购物</a></span>
            <span class="cart_span"><a href="CartServlet?method=clearCartItem">清空购物车</a></span>
            <span class="cart_span"><a href="OrderClientServlet?method=checkOut">去结账</a></span>
        </div>

    </div>
</c:if>


<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
</div>
</body>
</html>