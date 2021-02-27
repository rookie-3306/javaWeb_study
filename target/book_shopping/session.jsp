<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/2/27
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Session测试</title>
</head>
<body>
<div style="width: 500px;height: 250px;display: inline-block;border-style: solid;border-width: 5px;border-color: #DCDCDC;">
    <a>${requestScope.sessionMsg}</a>
</div>
<div style="width: 250px;display: inline-block;border-style: solid;border-width: 5px;border-color: #7FFFD4;">
    <ul style="list-style: none;">
        <li style="list-style: none;"><a href="sessionServlet?action=getSession">Session的获取or创建</a></li>
        <li style="list-style: none;"><a href="sessionServlet?action=setAttribute">Session的数据存储</a></li>\
        <li style="list-style: none;"><a href="sessionServlet?action=getAttribute">获取Session中存储的数据</a></li>
        <li style="list-style: none;"><a href="sessionServlet?action=setMaxInactiveInterval">设置Session的超时时长</a></li>
        <li style="list-style: none;"><a href="sessionServlet?action=getMaxInactiveInterval">获取Session的超时时长</a></li>
    </ul>
</div>
</body>
</html>

