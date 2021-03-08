<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //显示消息
            let message = "${requestScope.msg}";
            if (message == ""){

            }
            else{
                alert(message);
                <%
                    request.setAttribute("msg","");
                %>
            }

            //验证码单击事件
            $("#code_img").click(function () {
                //加上事件随机数,防止浏览器直接从缓存中取已经缓存好的图片
                this.src = "kaptcha.jpg?d=" + new Date();
            });

            $("#sub").click(function(){
                var username_re = /^[a-zA-Z][a-zA-Z0-9_]{5,20}$/;
                var username = $("#username").val();
                var password = $("#password").val();
                var againPassword = $("#againPassword").val();
                if(username != ""){
                    if(!username_re.test(username)){
                        alert("用户名请以字母开头在加上数字.")
                        return false;
                    }
                    if(password != ""){
                        if(password == againPassword){
                            return true;
                        }
                        else{
                            alert("两次输入的密码不一致!")
                            return false;
                        }
                    }
                    else{
                        alert("请输入密码!");
                        return false;
                    }
                }
                else{
                    alert("请输入账号!");
                    return false;
                }
            });
        });
    </script>
</head>
<body>
<div>
    <form action="userServlet" method="post" style="margin: 0 auto;width: 250px;">
        <input type="hidden" name="action" value="register"/>
<%--        <%=request.getAttribute("msg") == null?"":request.getAttribute("msg")%><br/>--%>
        ${requestScope.msg}<br/>
        昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:<input type="text" name="nickname"/><br/>
        账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:<input type="text" name="username" id="username"/><br/>
        密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" id="password" /><br/>
        确认密码:<input type="password" name="againPassword" id="againPassword" /><br />
        验&nbsp;&nbsp;证&nbsp;&nbsp;码:<input type="text" name="code" style="width:60px"><img id="code_img" src="kaptcha.jpg" style="width: 100px;;"><br />
        <input type="submit" value="提交" id="sub"/>
        <input type="button" value="取消" style="float:right;">
    </form>
    <a href="userServlet?action="></a>
</div>
</body>
</html>

