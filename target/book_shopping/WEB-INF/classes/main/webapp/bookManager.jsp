<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="main.com.zgh.pojo.Page" %>
<%@ page import="main.com.zgh.entity.BookEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/1
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>书籍管理</title>
    <script type="text/javascript">
        window.onload = function () {
            let turn_page_value = document.getElementById("pn_input");
            let turn_page_button = document.getElementById("turn_page_button");
            let add_Book_But = document.getElementById("add_Book_But");
            turn_page_button.onclick = function(){
                let href = "${pageContext.request.contextPath}" + "/bookServlet?action=page&pageNo=" + turn_page_value.value + "&pageSize=${requestScope.pageSize}";
                window.location.href = href;
            }
            add_Book_But.onclick = function(){
                let href = "${pageContext.request.contextPath}" + "/addBook.jsp";
                window.location.href = href;
            }
            //显示消息
            let message = "${requestScope.bookMsg}";
            if (message == ""){

            }
            else{
                alert(message);
                <%
                    request.setAttribute("bookMsg","");
                %>
            }
        }
    </script>
</head>
<body>
<div>
    <div style="margin: 0 auto;">
        <table border="1" style="margin: 0 auto;background-color: bisque;">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>PRICE(单价)</th>
                <th>AUTHOR(作者)</th>
                <th>SALES(售出)</th>
                <th>STOCK(库存)</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${requestScope.page.items}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.author}</td>
                    <td>${item.sales}</td>
                    <td>${item.stock}</td>
                    <td><a href="${pageContext.request.contextPath}/bookServlet?action=forwardUpdateBookJsp&bookId=${item.id}">修改</a></td>
                    <td><a href="${pageContext.request.contextPath}/bookServlet?action=deleteBookById&bookId=${item.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div style="margin: 0 auto;width: 495px;">
        <a href="${pageContext.request.contextPath}/bookServlet?action=page&pageNo=1&pageSize=${requestScope.pageSize}">首页</a>
        <span style="display: inline;">
            <c:if test="${requestScope.page.pageNo == 1}">上一页</c:if>
            <c:if test="${requestScope.page.pageNo != 1}"><a href="${pageContext.request.contextPath}/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}&pageSize=${requestScope.pageSize}">上一页</a></c:if>
        </span>
        <a href="${pageContext.request.contextPath}/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}&pageSize=${requestScope.pageSize}" style="display:
        <c:if test="${requestScope.page.pageNo == 1}">none</c:if>
        <c:if test="${requestScope.page.pageNo != 1}">inline</c:if>;">
            ${requestScope.page.pageNo-1}
        </a>
        【${requestScope.page.pageNo}】
        <a href="${pageContext.request.contextPath}/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}&pageSize=${requestScope.pageSize}" style="display:
        <c:if test="${requestScope.page.pageNo == requestScope.page.pageTotal}">none</c:if>
        <c:if test="${requestScope.page.pageNo != requestScope.page.pageTotal}">inline</c:if>;">
            ${requestScope.page.pageNo + 1}
        </a>
        <span style="display: inline;">
            <c:if test="${requestScope.page.pageNo == requestScope.page.pageTotal}">下一页</c:if>
            <c:if test="${requestScope.page.pageNo != requestScope.page.pageTotal}"><a href="${pageContext.request.contextPath}/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}&pageSize=${requestScope.pageSize}">下一页</a></c:if>
        </span>
        <a href="${pageContext.request.contextPath}/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}&pageSize=${requestScope.pageSize}">末页</a>
        共${requestScope.page.pageTotal}页,${requestScope.page.pageTotalCount}条记录 到第<input style="width: 20px;" value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
        <input type="button" value="确定" id="turn_page_button">
        <button type="button" style="width: 470px;margin-top: 20px;" id="add_Book_But">新增图书</button>
    </div>
</div>
</body>
</html>
