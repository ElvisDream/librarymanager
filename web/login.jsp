<%--
  Created by IntelliJ IDEA.
  User: Elivs
  Date: 2017/3/17
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理系统</title>
    <script type="text/javascript" src="js/jquery-1.11.2-min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mycss.css">
</head>
<body style="background: url('image/bj.jpg') round no-repeat">

    <div class="container-fluid" style="background: rgba(0,0,0,0.55);height: 638px">
        <div class="row" style="margin-top: 1%">
            <div class="col-md-12">
                <div id="loginDiv">
                    <form action="admin.do" method="post">
                        <b><span style="margin-left: 43%;font-size: 2em;color: #2a8cba;">欢 迎 登 陆!</span></b>
                        <input type="hidden" name="method" value="login"/>
                        <input type="text" name="adminName" style="margin-left: 16%;border-radius:2px" placeholder="账户"/>
                        <input type="password" style="border-radius: 2px" name="adminPwd" placeholder="密码"/>
                        <input type="submit" class="btn btn-success btn-sm" value="登陆"/>
                    </form>
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 6%;width: 1330px;margin-left: 2px">
            <div class="col-md-12" style="height: 300px;background: rgba(255, 255, 255, 0.73);padding-top: 6%;border-radius: 10px">
                <span style="font-size: 5em;margin-left: 32%;">图 书 管 理 系 统</span>
            </div>
        </div>
    </div>
</body>
</html>