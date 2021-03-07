<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/7
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>增加图书</title>
    <style>
        *{
            font-size: 20px;
        }
        input{
            margin: 10px;
        }
        .four_word{
            margin-left: 80px;
        }
        .tow_word{
            margin-left: 40px;
        }
    </style>
    <script type="text/javascript">
        window.onload = function(){
            let subBut = document.getElementById("sub");
            subBut.onclick = function(){
                let res = confirm("确认操作?");
                if(res){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    </script>
</head>
<body>
<div style="width: 600px;margin: 0 auto;">
    <form action="${pageContext.request.contextPath}/bookServlet" method="post">
        <span class="tow_word">书本名称:</span><input type="text" name="name" /><br />
        <span class="four_word">价格:</span><input type="text" name="price" /><br />
        <span class="four_word">作者:</span><input type="text" name="author" /><br />
        <span class="four_word">售出:</span><input type="text" name="sales" /><br />
        <span class="four_word">库存:</span><input type="text" name="stock" /><br />
        <input type="hidden" name="action" value="addBook">
        <input type="submit" style="margin-left: 220px;" id="sub" />
    </form>
</div>
</body>
</html>
