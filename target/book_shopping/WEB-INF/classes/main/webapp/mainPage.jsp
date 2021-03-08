<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/8
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <style>
        body {
            margin: 0;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
            position: fixed;
            top: 0;
            width: 100%;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #111;
        }

        .active {
            background-color: #40d6ff;
        }
    </style>
</head>
<body>

<ul>
    <li><a class="active" href="#">${sessionScope.user.username}</a></li>
    <li><a href="#">首页</a></li>
    <li><a href="#">商城</a></li>
    <li><a href="#">客服</a></li>
    <li style="float: right;"><a href="userServlet?action=cancellation">注销</a></li>
</ul>

<div style="padding:20px;margin-top:30px;height:1500px;">
    <h1>用户购物车</h1>
    <div style="border-style: double;height: 300px;">
        <p style="text-align:center;line-height: 300px;"><a href="#">商城选购物品!</a></p>
    </div>
</div>
</body>
</html>

