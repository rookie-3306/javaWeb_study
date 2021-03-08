<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/index_css.css" type="text/css" />
    <title>回家网</title>
    <script type="text/javascript" src="js/index_js.js"></script>
</head>
<body>
<div id="top_bg">
    <div id="top">
        <ul class="left">
            <li><a href="userServlet?action=forwardLogon">登录</a></li>
            <li><a href="#">免费注册</a></li>
        </ul>
        <ul class="right">
            <li class="list">
                <span>个人中心</span>
                <div class="list_cur">
                    <a href="#">已完成的订单</a>
                    <a href="#">未完成的订单</a>
                    <a href="#">我的保险</a>
                    <a href="#">账户安全</a>
                    <a href="#">个人信息</a>
                    <a href="#">常用联系人</a>
                </div>
            </li>
            <li class="line">|</li>
            <li class="list">
                <span>使用需知</span>
                <div class="list_cur">
                    <a href="#">xxxxxxxx</a>
                    <a href="#">xxxxx</a>
                    <a href="#">xxxxxx</a>
                    <a href="#">xxxxxxx</a>
                    <a href="#">xxxxx</a>
                    <a href="#">xxxxxxxx</a>
                </div>
            </li>
            <li class="line">|</li>
            <li class="list">
                <span>收藏夹</span>
                <div class="list_cur">
                    <a href="#">xxx</a>
                    <a href="#">xxxx</a>
                    <a href="#">xxxxxxx</a>
                    <a href="#">xxxxx</a>
                    <a href="#">xxxx</a>
                    <a href="#">xxxxxxx</a>
                </div>
            </li>
            <li class="line">|</li>
            <li class="list">
                <span>货物快运</span>
                <div class="list_cur" id="list_cur">
                    <a href="#">xxxxx</a>
                    <a href="#">xxx</a>
                    <a href="#">xxx</a>
                    <a href="#">xxxxx</a>
                    <a href="#">xxx</a>
                    <a href="#">xxxxxx</a>
                </div>
            </li>
            <li class="line">|</li>
            <li class="list">
                <span>联系我们</span>
                <div class="list_cur">
                    <a href="#">xxx</a>
                    <a href="#">xxxx</a>
                    <a href="#">xxx</a>
                    <a href="#">xxxxxxx</a>
                    <a href="#">xxx</a>
                    <a href="#">xx</a>
                </div>
            </li>
        </ul>
    </div>
</div>
<div id="nav_bg">
    <div class="nav">
        <h2><img src="images/logo.jpg" /></h2>
        <ul>
            <li><a href="#">汽车表</a></li>
            <li><a href="#">时刻表</a></li>
            <li><a href="#">汽车站</a></li>
            <li><a href="#">酒店预订</a></li>
            <li><a href="#">旅客回答</a></li>
        </ul>
    </div>
</div>
<div id="banner"><img src="images/banner.jpg" /> </div>
<ul id="week">
    <li><a href="#">01月27日<br/>周三</a></li>
    <li><a href="#" class="next">01月28日<br/>周四</a></li>
    <li><a href="#" class="next">01月29日<br/>周五</a></li>
    <li><a href="#" class="next">01月30日<br/>周六</a></li>
    <li><a href="#" class="next">01月31日<br/>周日</a></li>
    <li><a href="#" class="next">02月01日<br/>周一</a></li>
    <li><a href="#" class="next">02月02日<br/>周二</a></li>
</ul>
<table id="tb1" class="table">
    <tr class="title">
        <th>出发时间</th>
        <th>始发站/首发站</th>
        <th>计划车型</th>
        <th>票价</th>
        <th>购票</th>
    </tr>
    <tr>
        <td class="txt1">06:30</td>
        <td class="txt2"><span class="red">始</span>省汽车客运站<br/><span class="blue">终</span>阳江</td>
        <td>空调坐席</td>
        <td>¥<span class="colors">100</span></td>
        <td><a href="#" class="buy">购票</a></td>
    </tr>
    <tr>
        <td class="txt1">07:30</td>
        <td class="txt2"><span class="red">始</span>省汽车客运站<br/><span class="blue">终</span>阳江</td>
        <td>空调坐席</td>
        <td>¥<span class="colors">100</span></td>
        <td><a href="#" class="buy">购票</a></td>
    </tr>
    <tr>
        <td class="txt1">08:30</td>
        <td class="txt2"><span class="red">始</span>省汽车客运站<br/><span class="blue">终</span>阳江</td>
        <td>空调坐席</td>
        <td>¥<span class="colors">100</span></td>
        <td><a href="#" class="buy">购票</a></td>
    </tr>
    <tr>
        <td class="txt1">09:30</td>
        <td class="txt2"><span class="red">始</span>省汽车客运站<br/><span class="blue">终</span>阳江</td>
        <td>空调坐席</td>
        <td>¥<span class="colors">100</span></td>
        <td><a href="#" class="buy">购票</a></td>
    </tr>
</table>

<div id="footer">
    赶快回家版权所有2000-2016京ICP备08001421号&nbsp;&nbsp;京公网安备110108007702
</div>
</body>
</html>

