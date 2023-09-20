<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <jsp:include page="/WEB-INF/include/base.jsp"></jsp:include>
</head>
<script type="text/javascript">
    $(function () {
        //实现分页跳转页面功能
        $("#pageBtn").click(function () {
            var pageNo = $("#pn_input").val();
            location = "IndexBookServlet?method=getBookPage&pageNo=" + pageNo;
        });

        $("#searchBtn").click(function (){
            var min = $("[name='min']").val();
            var max = $("[name='max']").val();
            location = "IndexBookServlet?method=getBookByPrice&min="+min+"&max="+max;
        });

        $(".cartBtn").click(function (){
            var bookId = $(this).val();
            //alert(bookId);
            location = "CartServlet?method=addCartItem&bookId=" + bookId;
        });
    });
</script>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <jsp:include page="/WEB-INF/include/client_head.jsp"></jsp:include>
</div>

<div id="main">
    <div id="book">
        <div class="book_cond">
            <%--            <form action="IndexBookServlet" method="get">--%>
            <%--                <input type="hidden" name="method" value="getBookByPrice">--%>
            <%--                价格：<input type="text" name="min"> 元 - <input type="text" name="max"> 元--%>
            <%--                <button>查询</button>--%>
            <%--            </form>--%>
            价格：<input type="text" name="min"> 元 - <input type="text" name="max"> 元
            <button id="searchBtn">查询</button>
        </div>
        <div style="text-align: center">
            <c:if test="${empty sessionScope.cart.map}">
                <span>您的购物车中空空如也</span>
            </c:if>
            <c:if test="${not empty sessionScope.cart.map}">
                <span>您的购物车中有${sessionScope.cart.totalCount}件商品</span>
                <div>
                    您刚刚将<span style="color: red">${sessionScope.book.title}</span>加入到了购物车中
                </div>
            </c:if>
        </div>

        <c:forEach items="${requestScope.bookList}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${pageScope.book.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${pageScope.book.title}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${pageScope.book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${pageScope.book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${pageScope.book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${pageScope.book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button class="cartBtn" value="${pageScope.book.id}">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

    <div id="page_nav">
        <%--        当前页数不等于1时，就显示首页和上一页--%>
        <c:if test="${requestScope.pageNo != 1}">
            <a href="${requestScope.path}&pageNo=1">首页</a>
            <a href="${requestScope.path}&pageNo=${requestScope.pageNo -1}">上一页</a>
        </c:if>

        <c:choose>
            <%--如果总页数小于5，则开始页是1，结束页是总页数--%>
            <c:when test="${requestScope.countPath < 5}">
                <c:set var="begin" value="1"></c:set>
                <c:set var="end" value="${requestScope.countPath}"></c:set>
            </c:when>
            <%--如果当前页数小于3，则开始页是1，结束页是5--%>
            <c:when test="${requestScope.pageNo < 3}">
                <c:set var="begin" value="1"></c:set>
                <c:set var="end" value="5"></c:set>
            </c:when>
            <%--正常情况下，开始页是当前页-2，结束页是当前页+2--%>
            <c:otherwise>
                <c:set var="begin" value="${requestScope.pageNo - 2}"></c:set>
                <c:set var="end" value="${requestScope.pageNo + 2}"></c:set>
                <%--如果结束页+2大于总页数，则开始页是总页数-4，结束页是总页数--%>
                <c:if test="${pageScope.end > requestScope.countPage}">
                    <c:set var="begin" value="${requestScope.countPage - 4}"></c:set>
                    <c:set var="end" value="${requestScope.countPage}"></c:set>
                </c:if>
            </c:otherwise>
        </c:choose>

        <c:forEach begin="${pageScope.begin}" end="${pageScope.end}" var="i">
            <c:if test="${pageScope.i == requestScope.pageNo}">
                <a href="${requestScope.path}&pageNo=${pageScope.i}"
                   style="color: red">[${pageScope.i}]</a>
            </c:if>
            <c:if test="${pageScope.i != requestScope.pageNo}">
                <a href="${requestScope.path}&pageNo=${pageScope.i}">[${pageScope.i}]</a>
            </c:if>

        </c:forEach>

        <c:if test="${requestScope.pageNo != requestScope.countPage}">
            <a href="${requestScope.path}&pageNo=${requestScope.pageNo + 1}">下一页</a>
            <a href="${requestScope.path}&pageNo=${requestScope.countPage}">末页</a>
        </c:if>
        共${requestScope.countPage}页，${requestScope.count}条记录 到第<input name="pn" id="pn_input"/>页
        <input id="pageBtn" type="button" value="确定">
    </div>

</div>

<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
</div>
</body>
</html>