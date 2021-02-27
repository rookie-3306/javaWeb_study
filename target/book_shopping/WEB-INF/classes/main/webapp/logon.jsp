<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <link href="css/logon.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript">
        $(function() {
            $("#sub").click(function(){
                var username = $(":text").val();
                var password = $(":password").val();
                var username_re = /^[a-zA-Z][a-zA-Z0-9_]{5,20}$/;
                if(username_re.test(username) && password != ""){
                    return true;
                }
                else if(!username_re.test(username)){
                    alert("用户名请以字母开头在加上数字.")
                }
                else if(password == ""){
                    alert("密码为空!");
                }
                return false;
            });
            $("#register").click(function () {
                $(location).attr("href","register.jsp");
            });
        });
    </script>
</head>
<body>
<div class="logon_div">
    <div class="logon_body" style="margin: 0 auto;width: 250px;height: 120px;">
        <form action="userServlet" method="post">
            <input type="hidden" name="action" value="logon">
<%--            <%=request.getAttribute("msg")==null?"请输入账号密码!":request.getAttribute("msg")%><br/>--%>
            ${empty requestScope.msg == null?"请输入账号密码!":requestScope.msg}<br/>
            用户名:<input type="text" name="username" value="${cookie.username.value}"/><br />
            密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" /><br />
            <input type="submit" id="sub" value="登录" />
            <input type="button" id="register" value="注册" style="margin-left: 155px;"/>
        </form>
        <a href="userServlet?action=page">用户管理</a>
    </div>
</div>
</body>
</html>

