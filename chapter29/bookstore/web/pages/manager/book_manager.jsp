<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <jsp:include page="/WEB-INF/include/base.jsp"></jsp:include>
</head>
<script type="text/javascript">
    $(function () {
        //实现删除提示功能
        $(".deleteA").click(function () {
            if (!confirm("您确认要删除吗？")) {
                return false;
            }
        });

        //实现分页跳转页面功能
        $("#pageBtn").click(function (){
            var pageNo = $("#pn_input").val();
            location = "BookMangerServlet?method=getBookPage&pageNo=" + pageNo;
        })
    });
</script>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <jsp:include page="/WEB-INF/include/manager_head.jsp"></jsp:include>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.bookList}" var="book">
            <tr>
                <td>${pageScope.book.title}</td>
                <td>${pageScope.book.price}</td>
                <td>${pageScope.book.author}</td>
                <td>${pageScope.book.sales}</td>
                <td>${pageScope.book.stock}</td>
                <td><a href="BookMangerServlet?method=toUpdate&id=${pageScope.book.id}">修改</a></td>
                <td><a class="deleteA" href="BookMangerServlet?method=deleteBook&id=${pageScope.book.id}">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
        </tr>
    </table>
    <div id="page_nav">
        <%--        当前页数不等于1时，就显示首页和上一页--%>
        <c:if test="${requestScope.pageNo != 1}">
            <a href="BookMangerServlet?method=getBookPage&pageNo=1">首页</a>
            <a href="BookMangerServlet?method=getBookPage&pageNo=${requestScope.pageNo -1}">上一页</a>
        </c:if>

        <c:choose>
            <%--如果总页数大于5，则开始页是1，结束页是总页数--%>
            <c:when test="${requestScope.countPath > 5}">
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
                <a href="BookMangerServlet?method=getBookPage&pageNo=${pageScope.i}" style="color: red">[${pageScope.i}]</a>
            </c:if>
            <c:if test="${pageScope.i != requestScope.pageNo}">
                <a href="BookMangerServlet?method=getBookPage&pageNo=${pageScope.i}">[${pageScope.i}]</a>
            </c:if>

        </c:forEach>

        <c:if test="${requestScope.pageNo != requestScope.countPage}">
            <a href="BookMangerServlet?method=getBookPage&pageNo=${requestScope.pageNo + 1}">下一页</a>
            <a href="BookMangerServlet?method=getBookPage&pageNo=${requestScope.countPage}">末页</a>
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