<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/7
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>书籍信息修改</title>
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
                let res = confirm("确认修改?");
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
        <span class="tow_word">书库中ID:</span>${requestScope.needUpdateBook.id}<br />
        <input type="hidden" name="id" value="${requestScope.needUpdateBook.id}">
        <span class="tow_word">书本名称:</span><input type="text" name="name" value="${requestScope.needUpdateBook.name}" /><br />
        <span class="four_word">价格:</span><input type="text" name="price" value="${requestScope.needUpdateBook.price}" /><br />
        <span class="four_word">作者:</span><input type="text" name="author" value="${requestScope.needUpdateBook.author}" /><br />
        <span class="four_word">售出:</span><input type="text" name="sales" value="${requestScope.needUpdateBook.sales}" /><br />
        <span class="four_word">库存:</span><input type="text" name="stock" value="${requestScope.needUpdateBook.stock}" /><br />
        <input type="hidden" name="action" value="updateBook">
        <input type="submit" style="margin-left: 220px;" id="sub" />
    </form>
</div>
</body>
</html>
