<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="main.com.zgh.pojo.Page" %>
<%@ page import="main.com.zgh.entity.UserEntity" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/2/16
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>用户管理器</title>
</head>
<body>
<div>
    <div style="margin: 0 auto;width: 330px;background-color: bisque;">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>USERNAME</th>
                <th>PASSWORD</th>
                <th>NICKNAME</th>
            </tr>
            <c:forEach items="${requestScope.page.items}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.username}</td>
                    <td>${item.password}</td>
                    <td>${item.nickname}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div style="margin: 0 auto;width: 495px;">
        <a href="${pageContext.request.contextPath}/userServlet?action=page&pageNo=1&pageSize=${requestScope.pageSize}">首页</a>
        <span style="display: inline;">
            <c:if test="${requestScope.page.pageNo == 1}">上一页</c:if>
            <c:if test="${requestScope.page.pageNo != 1}"><a href="${pageContext.request.contextPath}/userServlet?action=page&pageNo=${requestScope.page.pageNo-1}&pageSize=${requestScope.pageSize}">上一页</a></c:if>
        </span>
        <a href="${pageContext.request.contextPath}/userServlet?action=page&pageNo=${requestScope.page.pageNo-1}&pageSize=${requestScope.pageSize}" style="display:
        <c:if test="${requestScope.page.pageNo == 1}">none</c:if>
        <c:if test="${requestScope.page.pageNo != 1}">inline</c:if>;">
            ${requestScope.page.pageNo-1}
        </a>
        【${requestScope.page.pageNo}】
        <a href="${pageContext.request.contextPath}/userServlet?action=page&pageNo=${requestScope.page.pageNo+1}&pageSize=${requestScope.pageSize}" style="display:
        <c:if test="${requestScope.page.pageNo == requestScope.page.pageTotal}">none</c:if>
        <c:if test="${requestScope.page.pageNo != requestScope.page.pageTotal}">inline</c:if>;">
            ${requestScope.page.pageNo + 1}
        </a>
        <span style="display: inline;">
            <c:if test="${requestScope.page.pageNo == requestScope.page.pageTotal}">下一页</c:if>
            <c:if test="${requestScope.page.pageNo != requestScope.page.pageTotal}"><a href="${pageContext.request.contextPath}/userServlet?action=page&pageNo=${requestScope.page.pageNo+1}&pageSize=${requestScope.pageSize}">下一页</a></c:if>
        </span>
        <a href="${pageContext.request.contextPath}/userServlet?action=page&pageNo=${requestScope.page.pageTotal}&pageSize=${requestScope.pageSize}">末页</a>
        共${requestScope.page.pageTotal}页,${requestScope.page.pageTotalCount}条记录 到第<input style="width: 20px;" value="4" name="pn" id="pn_input"/>页
        <input type="button" value="确定">
    </div>
</div>
</body>
</html>
